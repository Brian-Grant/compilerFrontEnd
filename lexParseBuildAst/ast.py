#!/usr/bin/env python3

import io
import xml.etree.ElementTree as ET

class Ast:
    def __init__(self, tag, kids=[], **attr):
        self.tag = tag
        self.kids = kids
        for (k, v) in attr.items():
            setattr(self, k, v)

    _NO_PP_ATTRS = {
        'tag',
        'kids',
        '_NO_PP_ATTRS',
    }

    def is_out_attr(self, name):
        return ( not name.startswith('_') and
                 not callable(getattr(self, name)) and
                 not name in Ast._NO_PP_ATTRS
        )

    def __str__(self):
        return _PrettyPrintVisitor().visit(self)

    def xml(self):
        xml_node = _XmlVisitor().visit(self)
        with io.StringIO() as out:
            ET.ElementTree(xml_node).write(out, 'unicode', True)
            xml = out.getvalue()
        return xml

    def dot(self):
        header = """
          graph G {
            node [shape=none];
            /* rankdir=LR; */
          %s
          }
        """
        visit_text = _DotVisitor().visit(self)
        return header % visit_text


class _DotVisitor:

    def visit(self, ast):
        (str, _) = self._visit(ast)
        return str

    def _visit(self, ast, count=0):
        text = ''
        kids = []
        for kid in ast.kids:
            if isinstance(kid, Ast): #ignore invalid ast's
                (s, count) = self._visit(kid, count)
                text += s
                kids += [count]
        n = count + 1
        label = ast.tag + '\\n'
        for a in ast.__dict__:
            if ast.is_out_attr(a):
                v = str(getattr(ast, a))
                v = v.replace('\\', '\\\\').replace('\"', '\\\"')
                label += '%s=%s\\n' % (a, v)
        text += 'n%d [label="%s"];\n' % (n, label)
        for k in kids: text += 'n%d -- n%d\n' % (n, k)
        return (text, n)


class _PrettyPrintVisitor:

    def visit(self, ast, depth=0):
        s = ' '*depth*_PrettyPrintVisitor._INDENT_INC + ast.tag
        for a in sorted(ast.__dict__):
            if ast.is_out_attr(a):
                s += ' %s=%s' % (a, getattr(ast, a))
        s += '\n'
        for kid in ast.kids:
            if isinstance(kid, Ast): #ignore invalid ast's
                s += self.visit(kid, depth+1)
        return s

    _INDENT_INC = 2

class _XmlVisitor:
    def visit(self, ast):
        elem = ET.Element(ast.tag)
        for a in sorted(ast.__dict__):
            if ast.is_out_attr(a):
                elem.set(a, str(getattr(ast, a)))
        for kid in ast.kids:
            if isinstance(kid, Ast): #ignore invalid ast's
                elem.append(self.visit(kid))
        return elem

if __name__ == '__main__':
    import sys
    a = Ast('NAME', name='a')
    b = Ast('NAME', name='b')
    ten = Ast('INT', value=10)
    two = Ast('NAME', value=2)
    a_add_b = Ast('BIN_OP', [a, b], op='ADD')               #a + b
    neg = Ast('UNARY_OP', [a_add_b], op='UMINUS')           #-(a + b)
    a_mul_2 = Ast('BIN_OP', [two, a], op='MUL')             #2 * a
    ten_div_neg_b = Ast('BIN_OP', [ten, neg], op='DIV')     #10/-(a + b)
    ast = Ast('BIN_OP', [a_mul_2, ten_div_neg_b], op='SUB') #2*a - 10/-(a + b)
    print(ast)
