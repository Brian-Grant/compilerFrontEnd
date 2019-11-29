from checker import checker

from functiontype import FunctionType

# simple struct for constructor, static and instance functions.  No
# behavior.

class FunctionInfo:
    def __init__(self, ast, class_name=None):
        assert(ast.tag == 'DEFN')
        self.name = ast.name
        self.coord = ast.coord
        self.class_name = class_name
        if ast.kind == 'constructor':
            kind = ast.kind
        elif class_name == None or ast.isStatic:
            kind = 'fn'
        else:
            kind = 'method'
        self.kind = kind
        self.type = FunctionType(ast, class_name if kind == 'method' else None)
