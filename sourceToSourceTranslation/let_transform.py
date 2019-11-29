import copy
import pprint  #use for debugging

from ast import Ast
import sys
class LetTransform:

    def __init__(self):
        self.aux_defs = []
        self.fnName = 0
        self.argName = 0 # not currently in use
        self.fnParams = [set()] # a list of lists of strings which contains the list 
                          # of args for corresponding fnName number

    def transform(self, ast):
        if ast.tag == 'LET':
            return self.let_transform(ast)
        xkids = [self.transform(k) for k in ast.kids]
        if ast.tag == 'PROGRAM':
            return Ast('PROGRAM', xkids + self.aux_defs)
        else:
            new_ast = copy.copy(ast)
            new_ast.kids = xkids
            return new_ast
        
    
    def let_transform(self, ast):
        idexp = ast.kids[0] 
        bodyexp = ast.kids[1]
        ids = []
        exps = []
        for x in range(len(idexp.kids)): # separate IDs from EXPRs
            if x%2==0:
                ids.append(idexp.kids[x])
            elif x%2==1:
                exps.append(idexp.kids[x])
        params = [] 
        
        for y in range(len(ids)): # populate a list of param asts with IDs
            params.append(Ast('PARAM', name=ids[y].name, coord=ids[y].coord))
        transformed_exps = [self.transform(k) for k in exps]
        
        transformed_body = self.transform(bodyexp)
        scope = ids[0].scope
        globs = self.get_globals(bodyexp, scope)
        params += globs
        params_ast = Ast('PARAMS', params, coord=ast.coord, arity=len(params))
        newName = f'_{self.fnName}'
        self.fnName+=1
        self.fnParams.append(set())
        self.aux_defs+=[Ast('DEFN', [params_ast, transformed_body], name=newName, coord = ast.coord)]
        globsAsArgs = self.param_to_arg(globs)
        appParams = []
        appParams += transformed_exps
        appParams += globsAsArgs
        args_ast = Ast('ARGS', appParams, coord=ast.coord, arity=len(appParams), offset=ast.coord)
        return Ast('APP', [args_ast], name=newName, coord = ast.coord)

    def get_globals(self, ast, scope):
        if type(ast) is Ast: 
            retVal = []
            potential_param = self.global_to_param(ast, scope)
            retVal += potential_param
            if len(ast.kids) > 0:
                for i in range(len(ast.kids)):
                    aNewGlobal = self.get_globals(ast.kids[i], scope)
                    already = False
                    if len(aNewGlobal) != 0:
                        for i in range(len(retVal)):
                            if aNewGlobal[0].name == retVal[i].name:
                                already = True
                    if not already:
                        retVal += aNewGlobal
            return retVal

    def global_to_param(self, ast, scope):
        retVal = []
        if ast.tag == 'REF':
            if ast.scope == scope:
                pass
            elif ast.scope < scope:
                if ast.name in self.fnParams[self.fnName]:
                    pass
                else:
                    retVal.append(Ast("PARAM", name=ast.name, coord=ast.coord, offset=ast.offset))
                    self.fnParams[self.fnName].add(ast.name)
        return retVal

    def param_to_arg(self, glob):
        retVal = []
        for i in range(len(glob)):
            retVal += [Ast("REF", name=glob[i].name, coord=glob[i].coord, offset=glob[i].offset)]
        return retVal



