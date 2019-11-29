INDENT = '  '

class Linearizer:
    def __init__(self, ast):
        self.ast = ast

    def linearize(self):
        return do_linearize(self.ast)

def do_linearize(ast):
    frags = []
    rec(ast, frags, d=0)
    return ''.join(frags)

def rec(ast, frags, **opts):
    tag = ast.tag
    fn_name = tag.lower() + '_ast'
    fn = globals().get(fn_name, None)
    if not fn:
        raise RuntimeError('AST tag %s not implemented for linearization' % tag)
    fn(ast, frags, **opts)


def program_ast(ast, frags, **opts):
    list(ast.kids, frags, opts)

def class_ast(ast, frags, **opts):
    frags.extend([indent(opts['d']), 'class ',
                  ast.type_name, ' : ', ast.super_name, '{\n'])
    list(ast.kids, frags, {'d': opts['d']+1})
    frags.extend([indent(opts['d']), '}\n'])

def decls_ast(ast, frags, **opts):
    static = 'static ' if ast.isStatic else ''
    frags.extend([indent(opts['d']), static])
    rec(ast.kids[0], frags, **opts)
    frags.append(' ')
    list(ast.kids[1:], frags, opts, ', ')
    frags.append(';\n')

def decl_ast(ast, frags, **opts):
    frags.append(ast.name)

def init_decl_ast(ast, frags, **opts):
    frags.extend([ast.name, '='])
    rec(ast.kids[0], frags, **opts)

def type_ast(ast, frags, **opts):
    frags.append(ast.type_name + '[]'*ast.rank)

def type_id_ast(ast, frags, **opts):
    frags.append('TYPE_ID(' + ast.type_name + '[]'*ast.rank + ')')

def params_ast(ast, frags, **opts):
    frags.append('(')
    list(ast.kids, frags, opts, ', ')
    frags.append(')')

def param_ast(ast, frags, **opts):
    rec(ast.kids[0], frags, **opts)
    frags.extend([' ', ast.name])

def init_param_ast(ast, frags, **opts):
    param_ast(ast, frags, **opts)
    frags.extend(['='])
    rec(ast.kids[1], frags, **opts)

def defn_ast(ast, frags, **opts):
    frags.extend([indent(opts['d'])])
    rec(ast.kids[0], frags, **opts)
    frags.extend([' ', ast.name])
    rec(ast.kids[1], frags, **opts)
    frags.extend([' '])
    rec(ast.kids[2], frags, **opts)

def block_ast(ast, frags, **opts):
    frags.extend([indent(opts['d']), '{\n'])
    list(ast.kids, frags, {'d': opts['d']+1})
    frags.extend([indent(opts['d']), '}\n'])

def while_ast(ast, frags, **opts):
    frags.extend([indent(opts['d']), 'while', ' ('])
    rec(ast.kids[0], frags, min_prec=0)
    frags.extend([')\n'])
    force_block(ast.kids[1], frags, opts)

def if_ast(ast, frags, **opts):
    frags.extend([indent(opts['d']), 'if', ' ('])
    rec(ast.kids[0], frags, min_prec=0)
    frags.extend([')\n'])
    force_block(ast.kids[1], frags, opts)
    frags.extend([indent(opts['d']), 'else\n'])
    force_block(ast.kids[2], frags, opts)

def return_ast(ast, frags, **opts):
    frags.extend([indent(opts['d']), 'return'])
    if ast.kids[0].tag != 'VOID':
        frags.extend([' '])
        rec(ast.kids[0], frags, **opts)
    frags.extend([';\n'])

def id_ast(ast, frags, **opts):
    min_prec = opts.get('min_prec', -1)
    if min_prec < 0: indent(opts['d'])
    frags.extend([ast.name])
    if min_prec < 0: frags.extend(';\n')

def literal_ast(ast, frags, **opts):
    min_prec = opts.get('min_prec', -1)
    if min_prec < 0: indent(opts['d'])
    frags.extend([ast.value])
    if min_prec < 0: frags.extend(';\n')

int_ast = real_ast = string_ast = nil_ast = literal_ast

OPS = { #as per walnut grammar
    'ASSIGN': (1, '%s = %s', True),
    'COND': (2, '%s? %s : %s', True ),
    'OR': (3, '%s || %s'),
    'AND': ( 4, '%s && %s'),
    'NOT': ( 5, '!%s'),
    'EQ': ( 6, '%s == %s'),
    'NE': ( 6, '%s != %s'),
    'LT': ( 6, '%s < %s'),
    'LE': ( 6, '%s <= %s'),
    'GT': ( 6, '%s > %s'),
    'GE': ( 6, '%s >= %s'),
    'ADD': ( 7, '%s + %s'),
    'SUB': ( 7, '%s - %s'),
    'MUL': ( 8, '%s * %s'),
    'DIV': ( 8, '%s / %s'),
    'REM': ( 9, '%s % %s'),
    'NEG': ( 9, '- %s'),
    'CAST': ( 10, ),
    'APP': ( 11, ),
    'STATIC_ACCESS': ( 12, ),
    'ACCESS': ( 13, ),
    'INDEX': ( 14, '%s[%s]'),
    'DEREF': (15, '*%s'),
}

def expr(ast, frags, **opts):
    tag = ast.tag
    op = ast.op if tag == 'OP2' or tag == 'OP1' else tag
    info = OPS[op]
    min_prec = opts.get('min_prec', -1)
    if min_prec < 0: frags.extend([indent(opts['d'])])
    prec = info[0]
    fmt = info[1]
    is_right = info[2] if len(info) > 2 else False
    do_paren = prec < min_prec
    if do_paren: frags.extend(['('])
    if is_right:
        p1 = prec + 1
        p2 = prec
    else:
        p1 = prec
        p2 = prec + 1
    seps = fmt.split('%s')
    if fmt.startswith('%s'):
        seps.pop(0)
    else:
        frags.extend([seps.pop(0)])
    p = p1
    for kid in ast.kids:
        rec(kid, frags, min_prec = p)
        frags.extend([seps.pop(0)])
        p = p2
    frags.extend(seps)
    if do_paren: frags.extend([')'])
    if min_prec < 0: frags.extend(';\n')

index_ast = access_ast = op1_ast = op2_ast = expr
cond_ast = assign_ast = deref_ast = expr


def new_obj_ast(ast, frags, **opts):
    min_prec = opts.get('min_prec', -1)
    if min_prec < 0: frags.extend([indent(opts['d'])])
    frags.extend([ast.type_name, '('])
    list(ast.kids, frags, opts, ', ')
    frags.extend([')'])
    if min_prec < 0: frags.extend(';\n')


def new_array_ast(ast, frags, **opts):
    min_prec = opts.get('min_prec', -1)
    if min_prec < 0: frags.extend([indent(opts['d'])])
    frags.extend([ast.type_name])
    for k in ast.kids:
        frags.extend(['['])
        rec(k, frags, min_prec=0)
        frags.extend([']'])
    if min_prec < 0: frags.extend(';\n')

def static_access_ast(ast, frags, **opts):
    min_prec = opts.get('min_prec', -1)
    if min_prec < 0: frags.extend([indent(opts['d'])])
    prec = OPS[ast.tag][0]
    do_paren = prec < min_prec
    if do_paren: frags.extend(['('])
    frags.extend([ast.type_name, '.', ast.name])
    if do_paren: frags.extend([')'])
    if min_prec < 0: frags.extend(';\n')

def access_ast(ast, frags, **opts):
    min_prec = opts.get('min_prec', -1)
    if min_prec < 0: frags.extend([indent(opts['d'])])
    prec = OPS[ast.tag][0]
    do_paren = prec < min_prec
    if do_paren: frags.extend(['('])
    rec(ast.kids[0], frags, min_prec=OPS['ACCESS'][0])
    frags.extend(['.', ast.name])
    if do_paren: frags.extend([')'])
    if min_prec < 0: frags.extend(';\n')

def app_ast(ast, frags, **opts):
    min_prec = opts.get('min_prec', -1)
    if min_prec < 0: frags.extend([indent(opts['d'])])
    prec = OPS[ast.tag][0]
    do_paren = prec < min_prec
    if do_paren: frags.extend(['('])
    rec(ast.kids[0], frags, min_prec=OPS['APP'][0])
    frags.extend(['('])
    list(ast.kids[1:], frags, {'min_prec': 0}, ', ')
    frags.extend([')'])
    if do_paren: frags.extend([')'])
    if min_prec < 0: frags.extend(';\n')

def cast_ast(ast, frags, **opts):
    min_prec = opts.get('min_prec', -1)
    if min_prec < 0: frags.extend([indent(opts['d'])])
    prec = OPS[ast.tag][0]
    do_paren = prec < min_prec
    if do_paren: frags.extend(['('])
    frags.extend(['('])
    rec(ast.kids[0], frags, **opts)
    frags.extend([')'])
    rec(ast.kids[1], frags, min_prec=OPS['CAST'][0])
    if do_paren: frags.extend([')'])
    if min_prec < 0: frags.extend(';\n')

def indent(d): return d * INDENT
def list(asts, frags, opts, sep=None):
    for (i, k) in enumerate(asts):
        rec(k, frags, **opts)
        if sep and i < len(asts) - 1: frags.append(sep)

def force_block(ast, frags, opts):
    if ast.tag == 'BLOCK':
        rec(ast, frags, **opts)
    else:
        frags.extend([ indent(opts['d']), '{\n'])
        rec(ast, frags, d=opts['d']+1)
        frags.extend([ indent(opts['d']), '}\n'])
