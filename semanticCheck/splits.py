class Splits:
    """Given PROGRAM or CLASS ast's split their kids out into classes,
       constructors, static functions (fns), methods and static
       declarations, instance declarations and statements.
    """

    def __init__(self, ast):
        assert(ast.tag == 'PROGRAM' or ast.tag == 'CLASS')
        isTop = ast.tag == 'PROGRAM'
        self.classes = []
        self.constructors = []
        self.fns = []
        self.methods = []
        self.static_decls = []
        self.instance_decls = []
        self.stmts = []
        for k in ast.kids:
            if k.tag == 'CLASS':
                self.classes.append(k)
            elif k.tag == 'DEFN':
                if k.kind == 'constructor':
                    self.constructors.append(k)
                else:
                    if isTop: k.isStatic = True
                    if k.isStatic:
                        self.fns.append(k)
                    else:
                        self.methods.append(k)
            elif not isTop and k.tag == 'DECLS':
                if k.isStatic:
                    self.static_decls.append(k)
                else:
                    self.instance_decls.append(k)
            else:
                if k.tag == 'DECLS' and k.isStatic: k.isStatic = False
                self.stmts.append(k)
