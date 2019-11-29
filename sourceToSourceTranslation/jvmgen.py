#!/usr/bin/env python3.7
import sys
class JvmOps:
    """Accumulate jasmin instructions and directives.  Label generator.

       pseudo-directives .comment and .label for generating labels/comments"""
    def __init__(self):
        self._ops = [];
        self._nextLabel = 1;

    def new_label(self):
        """generate and return a new label"""
        label = f'L{self._nextLabel}'
        self._nextLabel += 1
        return label

    def add(self, op, *rands):
        """add jasmin directive or instruction op with operands rands"""
        self._ops.append((op, rands))

    def __str__(self):
        """generate jasmin string for accumulated program"""
        txt = ''
        for op in self._ops:
            if op[0] == '.label':
                txt += f'{op[1][0]}:\n'
            elif op[0] == '.comment':
                rands = [str(rand) for rand in op[1]]
                txt += f';;; {" ".join(rands)}\n'
            else:
                rands = [str(rand) for rand in op[1]]
                txt += f'\t{op[0]}\t{" ".join(rands)}\n'
        return txt

class JvmGen:

    PKG = 'cs572'                       #package for all generated code
    CLS = f'{PKG}/Tl0'                  #class name for generated class
    MAIN = 'main([Ljava/lang/String;)V' #signature for main()
    SUPER = 'java/lang/Object'          #superclass of generated class
    OUT = f'{PKG}/Util/out(I)V'         #utility method used to output int

    def __init__(self):
        self._ops = JvmOps()

    def gen(self, ast):
        """generate jasmin code for program ast"""
        assert ast.tag == 'PROGRAM'
        self._header_gen()
        self._defns_gen([kid for kid in ast.kids if kid.tag == 'DEFN'])
        self._main_gen([kid for kid in ast.kids if kid.tag != 'DEFN'])
        return self._ops

    def _defns_gen(self, defns):
        """generate code for top-level function definitions defns"""
        for defn in defns:
            assert defn.tag == 'DEFN'
            name, arity = defn.name, defn.kids[0].arity
            sig = f'{name}({"I"*arity})I'
            self._ops.add('.comment', f'{name}/{arity}')
            self._ops.add('.method', 'static', sig)
            self._ops.add('.limit', 'locals', arity)
            expr = defn.kids[1]
            self._ops.add('.limit', 'stack', 4*self._max_stack(expr))
            self._expr_gen(expr)
            self._ops.add('ireturn')
            self._ops.add('.end', 'method', f';; {name}/{arity}')
            self._ops.add('.comment')

    def _main_gen(self, exprs):
        """generate code to print out top-level expressions exprs in main()"""
        self._ops.add('.comment', 'main/0')
        self._ops.add('.method', 'public',  'static', f'{JvmGen.MAIN}')
        if len(exprs) > 0:
            stack = max([self._max_stack(expr) for expr in exprs])
            self._ops.add('.limit', 'stack', 4*stack)
            for expr in exprs:
                self._expr_gen(expr)
                self._ops.add('invokestatic', JvmGen.OUT)
        self._ops.add('return')
        self._ops.add('.end', 'method', ';;main/0')
        self._ops.add('.comment')


    def _header_gen(self):
        """generate overall header for program code"""
        self._ops.add('.class', 'public',JvmGen.CLS)
        self._ops.add('.super', JvmGen.SUPER)

    """translate arith AST tags to JVM instruction"""
    ARITH_OPS = {
        'ADD': 'iadd',
        'SUB': 'isub',
        'MUL': 'imul',
        'DIV': 'idiv',
        'REM': 'irem',
    };

    """translate comparison AST tags to JVM instruction"""
    CMP_OPS = {
        'LT': 'if_icmplt',
        'GT': 'if_icmpgt',
        'LE': 'if_icmple',
        'GE': 'if_icmpge',
        'EQ': 'if_icmpeq',
        'NE': 'if_icmpne',
    };

    def _expr_gen(self, expr):
        tag = expr.tag
        if tag == 'REF':
            self._ops.add('iload', expr.offset)
        elif tag == 'INT':
            self._ops.add('ldc', expr.value)
        elif tag == 'IF':
            elseLabel, endLabel = self._ops.new_label(), self._ops.new_label()
            self._expr_gen(expr.kids[0])
            self._ops.add('ifeq', elseLabel)
            self._expr_gen(expr.kids[1])
            self._ops.add('goto', endLabel)
            self._ops.add('.label', elseLabel)
            self._expr_gen(expr.kids[2])
            self._ops.add('.label', endLabel)
        elif tag == 'APP':
            for kid in expr.kids[0].kids: self._expr_gen(kid)
            name, arity = expr.name, expr.kids[0].arity
            sig = f'{JvmGen.CLS}/{name}({"I"*arity})I'
            self._ops.add('invokestatic', sig)
        elif JvmGen.ARITH_OPS.get(tag, None):
            self._expr_gen(expr.kids[0])
            self._expr_gen(expr.kids[1])
            self._ops.add(JvmGen.ARITH_OPS[tag])
        elif JvmGen.CMP_OPS.get(tag, None):
            thenLabel, endLabel = self._ops.new_label(), self._ops.new_label()
            self._expr_gen(expr.kids[0])
            self._expr_gen(expr.kids[1])
            self._ops.add(JvmGen.CMP_OPS[tag], thenLabel)
            self._ops.add('iconst_0')
            self._ops.add('goto', endLabel)
            self._ops.add('.label', thenLabel)
            self._ops.add('iconst_1')
            self._ops.add('.label', endLabel)
        else:
            raise TypeError(f'unknown AST tag {tag}')

    def _max_stack(self, expr_ast):
        """Return max # of stack words needed to evaluate expr_ast"""

        if len(expr_ast.kids) == 0:
            return 1
        else:
            maxes = [self._max_stack(kid) for kid in expr_ast.kids]
            lo, hi = min(maxes), max(maxes)
            tag = expr_ast.tag
            return hi + 1 if lo == hi and tag != 'IF' else hi
