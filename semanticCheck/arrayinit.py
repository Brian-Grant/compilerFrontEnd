from walnut.ast import Ast

from checker import checker
from template import Template

# Intended to support array initializer expressions.
# Externally callable function is new_array()
# Currently supports only Type[expr] for rank 1.


def new_array(lhs_ast, new_ast):
    """ Generates code for lhs_ast = new_ast, where new_ast is an
        array initializer of either Type[expr1][expr2]...[exprN]
        or { { { ... } } }.
        Currently on supports Type[expr1]
    """
    assert(new_ast.tag == 'NEW_ARRAY')
    rank = new_ast.rank
    assert(rank > 0)
    type_name = new_ast.type_name
    array_var = checker.new_temp()
    env = {}
    template = '{\n'
    template += 'var %s%s %s;\n' % (type_name, '[]'*rank, array_var)
    if rank == 1:
        template += new_array1(new_ast, array_var, env)
    # elif rank == 2:
    #     template += new_array2(new_ast, array_var)
    else:
        checker.errors.add(new_ast.coord, 'UNINMP',
                           'array initialization for rank > 1 not implemented')
        return Ast('BLOCK', coord=new_ast.coord)
    env['$lhs'] = lhs_ast
    template += '$lhs = %s;\n' % array_var
    template += '}\n'
    return Template.substitute('block', template, env)

def new_array1(new_ast, array_var, env):
    type_name = new_ast.type_name
    env['$type_id0'] = Ast('TYPE_ID', type_name=type_name, rank=0)
    env['$type_id1'] = Ast('TYPE_ID', type_name=type_name, rank=1)
    env['$dim1'] = new_ast.kids[0]
    return '%s = Sys.allocArray($type_id1, $type_id0, $dim1);\n' % array_var

# def new_array2(new_ast, array_var):
#     type_name = new_ast.type_name
#     env['$type_id0'] = Ast('TYPE_ID', type_name=type_name, rank=0)
#     env['$type_id1'] = Ast('TYPE_ID', type_name=type_name, rank=1)
#     env['$type_id2'] = Ast('TYPE_ID', type_name=type_name, rank=1)
#     env['$dim1'] = new_ast.kids[0]
#     dim2_var = checker.new_temp()



# def new_array(ast, base_type, rank, acc):
#     coord = ast.coord
#     tmp_name = checker.new_temp()
#     ast.tmp_name = tmp_name
#     sys_ref = Ast('ID', name='Sys', coord=coord)
#     type_id = Ast('TYPE_ID', type_name=base_type, rank=rank, coord=coord)
#     newArray = Ast('ACCESS', [sys_ref], name='newArray', coord=coord)
#     n = Ast('INT', value=len(ast.kids), coord=coord)
#     app_ast = Ast('APP', [newArray, type_id, n], coord=coord)
#     decl = Ast('INIT_DECL', [app_ast], name=tmp_name, coord=coord)
#     type = Ast('TYPE', type_name=base_type, rank=rank, coord=coord)
#     decls = Ast('DECLS', [type, decl],
#                 kind='const', isStatic=false, coord=coord)
#     acc.append(decls)
#     return tmp_name

# def array_init(ast, base_type, acc):
#     """accumulate a list of asts which linearizes the INITS ast for
#        array with base_type and rank.  Will report gross
#        (inconsistent depth),
#        relegates type errors to subsequent code."""
#     rank = 0
#     if ast.tag == 'INITS':
#         rank = max([array_init(k, base_type, acc) for k in ast.kids])
#         tmp_name = new_array(ast, base_type, rank, acc)
#         for (i, k) in enumerate(ast.kids):
#             tmp_ast = Ast('ID', name=tmp_name, coord=ast.coord)
#             i_ast = Ast('INT', value=i, coord=k.coord)
#             index_ast = Ast('INDEX', [tmp_ast, i_ast], coord=k.coord)
#             k_ast = k
#             k_name = k.getattr('tmp_name')
#             if k_name: k_ast = Ast('ID', name=k_name, coord=k.coord)
#             assgn_ast = Ast('ASSIGN', [index_ast, k_ast], coord=k.coord)
#             acc.append(assgn_ast)
#     return rank

# Int[][][] a = Int[n1][n2][n3]
#
# is equivalent to:
# Int[][][] a
# a = Int[n1][][]
# should become:
# Int[][][] a;
# a = Sys.allocArray(TYPE_ID(Int[][][]), TYPE_ID(Int[][]), n1)
# Int $loop0, $loop1, $loop2;
# $loop0 = 0;
# while ($loop0 < n1) {
#
# }
#

# def new_array_init(lhsAst, new_ast):
#     assert(new_ast.tag == 'NEW_ARRAY')
#     for
#     type_name = new_ast.type_name
#     rank = new_ast.rank
#     assert(rank > 0)
#     assert(len(new_ast.kids) == rank)

#     template_dict = {}
#     arrayTempVar = new_array_rec(
#     for i in range(rank):
#         type = type_name + '[]' * (rank - i)
#         type_id = '$typeId' + i
#         template_dict[type_id] = type_id_ast
#         loopVars.append(checker.new_temp())
#         template += """
#           const %s %s = Sys.allocArray($
