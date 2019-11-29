from walnut.ast import Ast

from checker import checker
import constants
from constructor import Constructor
from varinfo import InstanceFieldInfo, StaticFieldInfo
from functioninfo import FunctionInfo
from util import is_multi_def
from functiontype import FunctionType


class ClassChecker:

    def __init__(self, classtype):
        self.klass = classtype

    def check_and_xform(self):
        """check for semantic errors and mutate asts"""
        constr = Constructor(self.klass, self.klass.constructors)
        constr.check_and_xform()
        instance_inits = self.rm_initializers(self.klass.instance_decls, 'self')
        constr.add_instance_inits(instance_inits)
        is_main = self.klass.name == constants.MAIN_CLASS
        if not is_main: self.klass.fns.append(constr.malloc())
        if not is_main: self.klass.methods.append(constr.instance_init())
        #self.add_explicit_self(self.klass.methods)
        self.klass.fns.append(self.class_inits())
        for ast in self.klass.fns:
            self.fn_method_check(ast, 'fn')
        for ast in self.klass.methods:
            self.fn_method_check(ast, 'method')
        for ast in self.klass.static_decls:
            self.decls_check(ast, True)
        for ast in self.klass.instance_decls:
            self.decls_check(ast, False)

    def add_explicit_self(self, asts):
        for ast in asts:
            assert(ast.tag == 'DEFN')
            assert(ast.kind == 'function' or ast.kind == 'constructor')
            params = ast.kids[1]
            coord = params.coord
            type_ast = Ast('TYPE', type_name=self.klass.name, rank=0,
                           coord=coord)
            param = Ast('PARAM', [type_ast], name='self', coord=coord)
            params.kids.insert(0, param)

    def class_inits(self):
        coord = self.klass.coord
        static_inits = self.rm_initializers(self.klass.static_decls,
                                            self.klass.name)
        void_type = Ast('TYPE', [], type_name='Void', rank=0, coord=coord)
        empty_params = Ast('PARAMS', [], coord=coord)
        block = Ast('BLOCK', static_inits, coord=coord)
        return Ast('DEFN', [void_type, empty_params, block],
                   name=constants.STATIC_INIT, isStatic=True,
                   kind='function', coord=coord)



    def rm_initializers(self, decls_asts, accessor):
        """remove all initializers from all DECLS decls_asts, replacing
           INIT_DECL name, init with DECL name.  Return list of ASSIGN
           ast's for accessor.name = init.
        """
        is_static = accessor != 'self'
        init_assign_asts = []
        for decls_ast in decls_asts:
            assert(decls_ast.tag == 'DECLS')
            type_ast = decls_ast.kids[0]
            for i in range(1, len(decls_ast.kids)):
                decl_ast = decls_ast.kids[i]
                assert(decl_ast.tag == 'DECL' or decl_ast.tag == 'INIT_DECL')
                if decl_ast.tag == 'INIT_DECL':
                    coord, name = decl_ast.coord, decl_ast.name
                    init_ast = decl_ast.kids[0]
                    decls_ast.kids[i] = (
                        Ast('DECL', [], name=name, coord=coord)
                    )
                    if is_static:
                        access_ast = Ast('STATIC_ACCESS', type_name=accessor,
                                         name=name, coord=coord)
                    else:
                        accessor_ast = Ast('ID', [], name=accessor, coord=coord)
                        access_ast = Ast('ACCESS', [accessor_ast],
                                         name=name, coord=coord)
                    assign_ast = Ast('ASSIGN', [access_ast, init_ast],
                                     coord=coord)
                    init_assign_asts.append(assign_ast)
        return init_assign_asts

    def fn_method_check(self, ast, kind):
        assert(ast.tag == 'DEFN')
        class_name = self.klass.name if kind == 'method' else None
        name, info = ast.name, FunctionInfo(ast, class_name)
        if not is_multi_def(self.klass.env, name, ast.coord):
            super_x = self.klass.get(name)
            if super_x:
                if super_x.kind != kind:
                    msg = ('cannot overload %s as %s; previously ' +
                           'declared as %s at %s')
                    msg = msg % (name, kind, super_x.kind, super_x.coord)
                    checker.errors.add(ast.coord, 'OVERLOAD', msg)
                elif (kind == 'method' and
                      not info.type.is_override(super_x.type)):
                    msg = ('method of type %s cannot override type %s' %
                           (info.type, super_x.type))
                    checker.errors.add(ast.coord, 'OVERRIDE', msg)
        self.klass.put(name, info) #enter in regardless of errors

    def decls_check(self, ast, isStatic):
        assert(ast.tag == 'DECLS')
        isConst = ast.kind == 'const'
        coord = ast.coord
        type_ast = ast.kids[0]
        type_name, rank = type_ast.type_name, type_ast.rank
        if type_name == constants.INFERRED:
            checker.errors.add(coord, 'UNIMP', 'type inference not implemented')
            type_name = constants.ERROR
        for decl in ast.kids[1:]:
            name = decl.name
            if not is_multi_def(self.klass.env, name, ast.coord):
                super_x = self.klass.get(name)
                if super_x:
                    msg = (
                        '%s defined in super-class as %s' % (name, super_x.kind)
                    )
                    checker.errors.add(coord, 'SUPER_DEF', msg)
                else:
                    type = checker.types.get(type_name, rank)
                    coord, info = decl.coord, None
                    if isConst:
                        checker.errors.add(coord, 'UNIMP',
                                           'const is not implemented')
                    if isStatic:
                        info = StaticFieldInfo(name, isConst, type, coord)
                    else:
                        info = InstanceFieldInfo(name, isConst, type, coord)
                    self.klass.put(name, info)
