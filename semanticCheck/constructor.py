import copy

from walnut.ast import Ast

from checker import checker
import constants
from template import Template
from walnutsys import sys_coord

# code for checking and transforming walnut constructors

class Constructor:

    def __init__(self, klass, constr_asts):
        self.constr_asts = constr_asts
        self.class_name = klass.name
        self.klass = klass

    def default_constructor_ast(self):
        return (
            Ast('DEFN', [
                Ast('TYPE', coord=sys_coord(), type_name=self.class_name, rank=0),
                Ast('PARAMS', [], coord=sys_coord()),
                Ast('BLOCK', [], coord=sys_coord())
                ], name=self.class_name, kind='constructor',
                isStatic=True, coord=sys_coord())
        )

    def ensure_super(self, ast):
        assert(ast.tag == 'DEFN' and ast.kind == 'constructor')
        block = ast.kids[2]
        needs_super = (
            len(block.kids) == 0 or
            block.kids[0].tag != 'APP' or
            block.kids[0].kids[0].tag != 'ID' or
            block.kids[0].kids[0].name != 'super'
        )
        if needs_super:
            super_call = (
                Ast('APP', [Ast('ID', [], name='super', coord=sys_coord())],
                    coord=sys_coord())
            )
            block.kids.insert(0, super_call)
        return ast

    def add_instance_inits(self, inits):
        block = self.constr_asts[0].kids[2]
        if self.klass.parent == constants.OBJECT:
            #super call was excised
            block.kids = inits + block.kids
        else:
            block.kids = [block.kids[0]] + inits + block.kids[1:]

    def check_and_xform(self):
        if len(self.constr_asts) > 1:
            names = [ast.name for ast in constructors]
            msg = (
                'multiple constructors %s for %s' %
                (', '.join(names), self.name)
            )
            checker.errors(constructors[0].coord, 'MULTI_CONSTR', msg)
            #ValueError on index() failure may be pythonic but
            #doesn't make sense to me
            try:
                i = names.index(self.class_name)
            except ValueError:
                i = -1
            constr_ast = self.constr_asts[0] if i < 0 else self.constr_asts[i]
            self.constr_asts[0] = constr_ast
            self.constr_asts[1:] = []
        if len(self.constr_asts) == 0:
            self.constr_asts.append(self.default_constructor_ast())
        constr = self.constr_asts[0]
        if constr.name != self.class_name:
            msg = 'invalid constructor name %s for class %s'
            checker.errors.add(constr.coord, 'CONSTR_NAME',
                               msg % (constr.name, self.class_name))
            constr.name = self.class_name
        constr.kids[0].type_name = self.class_name
        constr.isStatic = True
        self.ensure_super(constr)
        self.xform_super(constr)

    def xform_super(self, constr):
        """take super(...) call in constr (by the time it is called,
           it must have one) and replace it with super.INSTANCE_INIT(...)
        """
        assert(constr.tag == 'DEFN' and constr.kind == 'constructor')
        super_klass = checker.types.get(self.klass.parent)
        assert(super_klass)
        block = constr.kids[2]
        super_call = block.kids[0]
        assert(super_call.tag == 'APP')
        assert(super_call.kids[0].tag == 'ID')
        assert(super_call.kids[0].name == 'super')
        if super_klass.name != constants.OBJECT:
            super_id = Ast('ID', name='super', coord=sys_coord())
            super_init_name = super_klass.instance_init_name()
            access = Ast('ACCESS', [super_id], name=super_init_name,
                         coord=sys_coord())
            params = [access] + copy.deepcopy(super_call.kids[1:])
            block.kids[0] = Ast('APP', params, coord=sys_coord())
        else:
            block.kids.pop(0) #excise super call as super is Object

    #code to create constructor malloc

    MALLOC_BLOCK_TEMPLATE = """
    {
      var $C self = ($C) Sys.allocObject($typeId);
      $initCall;
      return self;
    }
    """

    def malloc(self):
        assert(len(self.constr_asts) == 1)
        constr = self.constr_asts[0]
        assert(constr.tag == 'DEFN')
        assert(constr.kind == 'constructor')
        name = self.class_name
        constr_params = constr.kids[1]
        assert(constr_params.tag == 'PARAMS')
        actuals = [
            Ast('ID', name=param.name, coord=sys_coord())
            for param in constr_params.kids
        ]
        self_ref = Ast('ID', name='self', coord=sys_coord())
        access_ast = Ast('ACCESS', [self_ref], coord=sys_coord(),
                         name=self.klass.instance_init_name())
        app_ast = Ast('APP', [access_ast] + actuals, coord=sys_coord())
        type_id = Ast('TYPE_ID', type_name=name, rank=0, coord=sys_coord())
        template = Constructor.MALLOC_BLOCK_TEMPLATE.replace('$C', name)
        template_dict = {
            "$typeId": type_id,
            "$initCall": app_ast,
        }
        block = Template.substitute('block', template, template_dict)
        ret_type = Ast('TYPE', type_name=name, rank=0, coord=sys_coord())
        params = copy.deepcopy(constr_params)
        ast = Ast('DEFN', [ret_type, params, block], name=name,
                   kind='function', isStatic=True, coord=sys_coord())
        return ast

    def instance_init(self):
        """return copy of constr_asts[0] with name changed to SELF_INIT and
           kind set to function
        """
        assert(len(self.constr_asts) == 1)
        constr = self.constr_asts[0]
        assert(constr.tag == 'DEFN')
        assert(constr.kind == 'constructor')
        init = copy.deepcopy(constr)
        init.name = self.klass.instance_init_name()
        init.kind = 'function'
        init.isStatic = False
        self_ast = Ast('ID', name='self', coord=sys_coord())
        return_ast = Ast('RETURN', [self_ast], coord=sys_coord())
        block = init.kids[2];
        assert(block.tag == 'BLOCK')
        block.kids.append(return_ast)
        return init
