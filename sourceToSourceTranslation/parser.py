#!/usr/bin/env python3.7

from ast import Ast

# AST built by parser described by following "tree grammar".  Notation
# is an extension of yacc-like CFG grammar with following changes:
#
#   Parentheses are used for grouping.
#   '*' used for indicating 0-or-more repetitions of previous construct.
#   AST nodes denoted using all upper-case tags, following immediately
#   by node attributes within angle-brackets followed by node
#   children.
#
# program
#   : PROGRAM<coord> ( defn | expr )*
#   ;
# defn
#   : DEFN<coord, name> params expr
#   ;
# params
#   : PARAMS<coord, arity> param*
# param
#   : PARAM<coord, name>
#   ;
# expr
#   : INT<coord, value>
#   | REF<coord, name>
#   | app
#   | (ADD|SUB|MUL|DIV|REM|LT|GT|LE|GE|EQ|NE)<coord> expr expr
#   | IF<coord> expr expr expr
#   ;
# app
#   : APP<coord, name> args
#   ;
# args
#   : ARGS<coord, arity> expr*
#   ;

import sys

class Parser:
    def __init__(self, lexer):
        self.lexer = lexer
        self.tokens = lexer.tokens()
        self.lookahead = next(self.tokens)

    def parse(self):
        """Return pair (program-ast, errors)"""
        coord = self.lookahead.coord
        errors = []
        program_asts = self.program(errors)
        return (Ast('PROGRAM', program_asts, coord = coord), errors)

    def program(self, errors):
        """Return list of top-level AST's; if error, then add to errors"""
        try:
            if self.look('FN'):
                defn = self.defn()
                asts = self.program(errors)
                asts.insert(0, defn)
                return asts
            elif self.look('EOI'):
                return []
            else:
                expr0 = self.expr0()
                asts = self.program(errors)
                asts.insert(0, expr0)
                return asts
        except SyntaxError as err:
            errors.append((err.args[0], self.lookahead.coord))
            self.recover_from_error()
            return self.program(errors)

    def defn(self):
        """Return AST for a defn"""
        defn_coord = self.lookahead.coord
        self.match('FN')
        self.match('PAREN', '(')
        name = self.lookahead.lexeme
        self.match('ID')
        params_coord = self.lookahead.coord
        params = self.params()
        params_ast = Ast('PARAMS', params, coord = params_coord,
                         arity=len(params))
        self.match('PAREN', ')')
        expr = self.expr() 
        self.match('SEMI')       
        return Ast('DEFN', [params_ast, expr], name = name, coord = defn_coord)

    def params(self):
        """Return list of ASTs for formal parameters"""
        if self.look('ID'):
            coord = self.lookahead.coord
            param_ast = Ast('PARAM', name=self.lookahead.lexeme, coord=coord)
            self.match('ID')
            params = self.params()
            params.insert(0, param_ast)
            return params
        else:
            return []

    def expr0(self):
        """Match a top-level expression followed by a semi. """
        expr = self.expr()
        self.match('SEMI')
        return expr

    BINARY_OPS = {
        '+': 'ADD',
        '-': 'SUB',
        '*': 'MUL',
        '/': 'DIV',
        '%': 'REM',
        '<': 'LT',
        '>': 'GT',
        '<=': 'LE',
        '>=': 'GE',
        '==': 'EQ',
        '!=': 'NE',
    }

    @classmethod
    def tag_to_op_map(cls):
        map = { v: k for k, v in cls.BINARY_OPS.items() }
        map['IF'] = '?'
        return map

    def expr(self):
        "Return expr AST"
        coord = self.lookahead.coord
        if self.look('INT'):
            value = int(self.lookahead.lexeme)
            self.match('INT')
            return Ast('INT', value=value, coord=coord)
        elif self.look('ID'):
            name = self.lookahead.lexeme
            self.match('ID')
            return Ast('REF', name=name, coord=coord)
        elif self.look('PAREN', '('):
            self.match('PAREN', '(')
            fn_coord = self.lookahead.coord
            name = self.lookahead.lexeme
            if self.look('ID'):
                self.match('ID')
                args_coord = self.lookahead.coord
                args = self.args()
                args_ast = Ast('ARGS', args, coord=args_coord, arity=len(args))
                self.match('PAREN', ')')
                return Ast('APP', [args_ast], name=name, coord=fn_coord)
            elif self.look("LET", "let"):
                self.match('LET')
                idExp_coord = self.lookahead.coord
                idExpList = self.idExp(0)
                idExpList_ast = Ast("LETIDEXPR", idExpList, coord=idExp_coord, arity=(len(idExpList)/2))
                self.match('IN')              
                bodyExp_ast = self.expr();
                self.match("PAREN", ")")                
                return Ast('LET', [idExpList_ast, bodyExp_ast], coord=fn_coord)
                
        
        elif (self.look('OP') and
              Parser.BINARY_OPS.get(self.lookahead.lexeme, None)):
            op = Parser.BINARY_OPS[self.lookahead.lexeme]
            self.match('OP')
            return Ast(op, [ self.expr(), self.expr() ], coord=coord)
        elif self.look('OP', '?'):
            self.match('OP')
            return Ast('IF', [ self.expr(), self.expr(), self.expr()],
                       coord=coord)
        else:
            raise SyntaxError("Expression expected")

    def args(self):
        "Return list of ASTs for args to function call"
        if not self.look('PAREN', ')'):
            arg = (self.expr())
            args = self.args()
            args.insert(0, arg)
            return args
        else:
            return []
               
    def idExp(self, i):
        if not self.look('IN', 'in'):
            letComponent = self.expr()
            idExpList = self.idExp((i+1))
            idExpList.insert(0, letComponent)
            return idExpList
        else:
            if i < 2:
                msg = f"Let statements need at least one id exp pair"
                raise SyntaxError(msg)
            return [] 


    #parsing utilities

    def look(self, kind, lexeme=''):
        """Return true iff lookahead matches kind and lexeme (if non-empty)"""
        return (self.lookahead.kind == kind and
                (not lexeme or self.lookahead.lexeme == lexeme))

    def advance(self):
        """Set lookahead to next token from lexer"""
        self.lookahead = next(self.tokens)

    def match(self, kind, lexeme=''):
        """If lookahead matches kind and lexeme, then next token, else error"""
        if self.look(kind, lexeme):
            if not self.look('EOI'): self.advance()
        else:
            msg = f"syntax error: expecting '{lexeme if lexeme else kind}'"
            raise SyntaxError(msg)

    def recover_from_error(self):
        """Skip tokens until lookahead is a top-level token"""
        while (self.lookahead.kind != 'SEMI' and
               self.lookahead.kind != 'FN' and
               self.lookahead.kind != 'EOI'):
            self.advance()
        if self.lookahead.kind == 'SEMI': self.advance()

class SrcBuilder:
    _TAGS_MAP = Parser.tag_to_op_map()
    _INDENT = 2

    def src(self, ast):
        assert ast.tag == 'PROGRAM'
        text = ''
        for top in ast.kids:
            if top.tag == 'DEFN':
                text += self._defn_src(top)
            else:
                text += self._expr_src(top)
            text += ';\n';
        return text

    def _defn_src(self, defn):
        text = f'fn ({defn.name} '
        text += ' '.join([param.name for param in defn.kids[0].kids])
        text += ')\n'
        text += self._expr_src(defn.kids[1], 1)
        return text

    def _expr_src(self, expr, depth=0):
        indent = ' ' * (depth * SrcBuilder._INDENT)
        text = indent
        if expr.tag == 'APP':
            kids_text = (
                [self._expr_src(e, depth + 1) for e in expr.kids[0].kids]
            )
            text += f'( {expr.name}\n{"".join(kids_text)}{indent})\n'
        elif expr.tag == 'REF':
            text += f'{expr.name}\n'
        elif expr.tag == 'INT':
            text += f'{expr.value}\n'
        elif SrcBuilder._TAGS_MAP.get(expr.tag, None):
            kids_text = [self._expr_src(e, depth + 1) for e in expr.kids]
            text += f'{SrcBuilder._TAGS_MAP[expr.tag]}\n{"".join(kids_text)}'
        else:
            assert False, f'unhandled tag {expr.tag}'
        return text

if __name__ == '__main__':
    import sys
    from lexer import Lexer
    lexer = Lexer(sys.argv[1:])
    parser = Parser(lexer)
    ast, errors = parser.parse()
    print(ast, errors)
