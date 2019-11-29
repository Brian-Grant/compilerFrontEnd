import copy

from walnut.ast import Ast

from checker import checker
import constants
from walnutsys import sys_coord

from classtype import ClassType

# creates $Main wrapper class for top-level code

class MainClass(ClassType):
    """A synthesized $Main class for all top-level code. """

    def __init__(self, splits):
        super().__init__(constants.MAIN_CLASS, constants.OBJECT,
                         sys_coord(), splits)
        main_ast = self.make_main(splits)
        splits.fns.append(main_ast)

    def make_main(self, splits):
        code = [ self.static_init_app_ast(constants.MAIN_CLASS) ]
        for ast in splits.classes:
            assert(ast.tag == 'CLASS')
            code.append(self.static_init_app_ast(ast.type_name));
        code += splits.static_decls
        ret_type = Ast('TYPE', [], type_name='Void',  rank=0, coord=sys_coord())
        params = Ast('PARAMS', [], coord=sys_coord())
        block = Ast('BLOCK', code + splits.stmts, coord=sys_coord())
        return Ast('DEFN', [ret_type, params, block], isStatic=True,
                   kind='function', name=constants.MAIN_FN, coord=sys_coord())

    def static_init_app_ast(self, name):
        """Generate an APP to call static initializer for class name"""
        accessAst = Ast('STATIC_ACCESS', [], type_name=name,
                            name=constants.STATIC_INIT, coord=sys_coord())
        app_ast = Ast('APP', [accessAst],  coord=sys_coord())
        return app_ast

    def check_and_xform(self):
        assert(len(self.methods) == 0)
        assert(len(self.static_decls) == 0)
        assert(len(self.instance_decls) == 0)
        assert(len(self.methods) == 0)
        for ast in self.constructors:
            assert(ast.tag == 'DEFN' and ast.kind == 'constructor')
            msg = 'invalid top level constructor %s' % ast.name
            checker.errors.add(ast.coord, 'TOP_CONSTR', msg)
        super().check_and_xform()
        for ast in self.fns: self.xform_raw_calls(ast)

    def xform_raw_calls(self, ast):
        for kid in ast.kids: self.xform_raw_calls(kid)
        if ast.tag == 'APP' and ast.kids[0].tag == 'ID':
            name, coord = ast.kids[0].name, ast.kids[0].coord
            access = Ast('STATIC_ACCESS', type_name=self.name, name=name,
                         coord=coord)
            ast.kids[0] = access
