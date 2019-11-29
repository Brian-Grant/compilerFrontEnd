from checker import checker

# Creates a function signature (args)->ret from a DEFN ast.  Instance
# provides is_args_assignable_from() and is_override() functionality.

class FunctionType:
    def __init__(self, ast, class_name=None):
        assert(ast.tag == 'DEFN')
        args = []
        for param in ast.kids[1].kids:
            assert(param.tag == 'PARAM' or param.tag == 'INIT_PARAM')
            type = param.kids[0]
            assert(type.tag == 'TYPE')
            name, rank = type.type_name, type.rank
            info = checker.types.get(name, rank)
            assert(info != None)
            args.append(info)
        self.kind = 'fn_type'
        self.arg_types = args
        ret_type_ast = ast.kids[0]
        name, rank = ret_type_ast.type_name, ret_type_ast.rank
        info = checker.types.get(name, rank)
        self.ret_type = info

    def __str__(self):
        arg_types = [ str(t) for t in self.arg_types ]
        return '(%s)->%s' % (','.join(arg_types), str(self.ret_type))

    def is_args_assignable_from(self, arg_types):
        """return True iff arg_types can be assigned to self.arg_types"""
        if (len(self.arg_types) != len(arg_types)): return False
        for i in range(len(self.arg_types)):
            arg_type = arg_types[i]
            if not arg_type.is_subtype_of(self.arg_types[i]):
                return False
        return True

    def is_override(self, other_fn_type):
        """return True iff self can override other_fn_type"""
        if (len(self.arg_types) != len(other_fn_type.arg_types)): return False
        return (
            #ignore introduced self param
            self.is_args_assignable_from(other_fn_type.arg_types) and
            self.ret_type.is_subtype_of(other_fn_type.ret_type)
        )
