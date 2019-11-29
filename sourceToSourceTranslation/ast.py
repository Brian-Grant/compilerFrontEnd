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

class _PrettyPrintVisitor:

    def visit(self, ast, depth=0):
        s = ' '*depth*_PrettyPrintVisitor._INDENT_INC + ast.tag
        for a in dir(ast):
            if ast.is_out_attr(a):
                s += f' {a}={getattr(ast, a)}'
        s += '\n'
        for kid in ast.kids:
            s += self.visit(kid, depth+1)
        return s

    _INDENT_INC = 2

class _XmlVisitor:
    def visit(self, ast):
        elem = ET.Element(ast.tag)
        for a in dir(ast):
            if ast.is_out_attr(a):
                elem.set(a, str(getattr(ast, a)))
        for kid in ast.kids:
            elem.append(self.visit(kid))
        return elem
