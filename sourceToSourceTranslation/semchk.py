#!/usr/bin/env python3.7

import sys

class _Env:
    """Track a single environment; does not enforce any policy.

       Simply wraps a dict"""
    def __init__(self):
        self._env = {}

    def get(self, id):
        """return info for id; if not found, return None"""
        return self._env.get(id, None)

    def put(self, id, info={}):
        """add info for id, replacing previous info if already present"""
        self._env[id] = info

class _Symtab:
    """"Stack of environments.

        Lookup traverses down the stack; addition adds only to topmost
        environment.  No semantic policy enforcement"""

    def __init__(self):
        "Create a symbol table containing a single global env"
        self._envs = [_Env()]
        self.scope = 1

    def push(self):
        "Push a new env onto this symtab"
        self._envs.append(_Env());
        self.scope += 1

    def pop(self):
        "Pop the topmost env"
        self._envs.pop()

    def get(self, id):
        """Traverse stack of environments looking for info dict for id.
           Returns None if not found."""
        for i in range(len(self._envs), 0, -1):
            info = self._envs[i - 1].get(id)
            if info: return info
        return None

    def put(self, id, info={}):
        "Add info for id in topmost env; replace previous info if present"
        self._envs[-1].put(id, info)

    def top(self):
        """Return top-most environment"""
        return self._envs[-1]

    def add_check(self, name, coord, errors):
        """Return true iff name not in top env; else add error to errors."""
        info = self.top().get(name)
        if info:
            msg = ( f'multiple definition for "{name}."\n' +
                    f'previous definition at {info["coord"]}.' )
            errors.append((msg, coord))
        return not info

    def look_check(self, name, coord, errors):
        """Return symtab's info for name; if not found, add error to errors"""
        info = self.get(name)
        if not info:
            errors.append((f'undefined identifier {name}', coord))
        return info

class _TopVisitor:
    """Visit top-level definitions looking for multiple defs of same function"""

    def visit(self, ast, symtab, errors):
        assert ast.tag == 'PROGRAM'
        offset = 0
        for kid in ast.kids:
            if kid.tag == 'DEFN':
                name, arity = kid.name, kid.kids[0].arity
                if symtab.add_check(name, kid.coord, errors):
                    info = {
                        'name': name,
                        'type': 'FN',
                        'arity': arity,
                        'coord': ast.coord,
                        'scope': symtab.scope,
                        'offset': offset,
                    }
                    symtab.put(name, info)
                    kid.scope = info['scope']
                    kid.offset = info['offset']
                    offset += 1


class _DetailVisitor:

    def _defn_visit(self, ast, symtab, errors):
        """ Set ast.type to VOID; visit each param verifying unique
            and entering param into symtab; finally visit expr kid."""
        assert ast.tag == 'DEFN'
        symtab.push()
        ast.type = 'VOID'
        ast.kids[0].type = 'VOID' #PARAMS
        for index, param in enumerate(ast.kids[0].kids):
            name = param.name
            if symtab.add_check(name, param.coord, errors):
                info = {
                    'name': name,
                    'type': 'INT',
                    'offset': index,
                    'scope': symtab.scope,
                    'coord': param.coord,
                }
                param.offset = index; param.scope = symtab.scope
                param.type = 'INT'
                symtab.put(name, info)
        self.visit(ast.kids[1], symtab, errors)
        symtab.pop()

    def _app_visit(self, ast, symtab, errors):
        """ Set ast.type to INT; verify function id is defined and
            has type 'FN' and that arities of call and defn match;
            finally visit args."""
        assert ast.tag == 'APP'
        ast.type = 'INT'
        fn_name = ast.name
        fn_info = symtab.look_check(fn_name, ast.coord, errors)
        if fn_info:
            if fn_info['type'] != 'FN':
                errors.append((f'{fn_name} is not a function', ast.coord))
            elif fn_info['arity'] != ast.kids[0].arity:
                expected = fn_info['arity']
                actual = ast.kids[0].arity
                msg = ( f'incorrect number {actual} of arguments ' +
                        f'for {fn_name}; expected {expected}')
                errors.append((msg, ast.coord))
            ast.offset = fn_info['offset']
            ast.scope = fn_info['scope']
            self.visit(ast.kids[0], symtab, errors)

    def _ref_visit(self, ast, symtab, errors):
        """Used for a ref to a non-fn; set ast.type to INT, check defined,
           verify type is INT."""
        ast.type = 'INT'
        name = ast.name
        info = symtab.look_check(name, ast.coord, errors)
        if info:
            if info['type'] != 'INT':
                errors.append((f'INT type expected for {name}', ast.coord))
            else:
                ast.type = info['type']
                ast.offset = info['offset']
                ast.scope = info['scope'] # THIS

    def _let_visit(self, ast, symtab, errors):
        ast.type = "LET"
        idExp = ast.kids[0]
        assert idExp.tag == 'LETIDEXPR'
        for x in range(len(idExp.kids)):
            if x%2==1:
                self.visit(idExp.kids[x], symtab, errors)
        symtab.push()
        for y in range(len(idExp.kids)):
            if y%2==0:
                name = idExp.kids[y].name
                coord = idExp.kids[y].coord
                if symtab.add_check(name, coord, errors):
                    info = {
                        'name': name,
                        'type': 'INT',
                        'offset': y,
                        'scope': symtab.scope,
                        'coord': coord,
                    }
                    idExp.kids[y].offset = y; idExp.kids[y].scope = symtab.scope
                    idExp.kids[y].type = 'INT'
                    symtab.put(name, info)
        bodyExp = ast.kids[1] 
        self.visit(bodyExp, symtab, errors)
        symtab.pop()

    def visit(self, ast, symtab, errors):
        if ast.tag == 'DEFN':
            self._defn_visit(ast, symtab, errors)
        elif ast.tag == 'APP':
            self._app_visit(ast, symtab, errors)
        elif ast.tag == 'REF':
            self._ref_visit(ast, symtab, errors)
        elif ast.tag == 'LET':
            self._let_visit(ast, symtab, errors)
        else:
            ast.type = (
                'VOID' if ast.tag in ('PROGRAM', 'ARGS', 'PARAMS') else 'INT'
            )
            for kid in ast.kids: self.visit(kid, symtab, errors)

class SemanticChecker:
    """Check semantics for list of AST's, annotating ASTs.

       Errors detected include:
         Undeclared id's, multiple id's declared in same scope.
         Type errors: since functions are not first class, the
         use of a function in any context other than a APP AST
         is a type error as is the use of a non-function id as
         a function in a function call.

       Each AST node is annotated with a type: either FN, VOID or INT.
       Additionally, each REF node is annotated with an offset
       attribute giving its index in the formal parameter list.

    """
    def check_and_annotate(self, program_ast):
        errors, symtab = [], _Symtab()
        for visitor in [_TopVisitor(), _DetailVisitor()]:
            visitor.visit(program_ast, symtab, errors)
        return errors
