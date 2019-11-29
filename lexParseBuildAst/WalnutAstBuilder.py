#!/usr/bin/env python3

import os, sys, pdb, re
from collections import namedtuple

from antlr4 import *

from ast import Ast

COURSE_LIB = os.environ['HOME'] + '/cs572/lib'
ANTLR_GEN_LIB = './gen/python'
sys.path.extend([ANTLR_GEN_LIB, COURSE_LIB])

from WalnutLexer import WalnutLexer
from WalnutParser import WalnutParser
from WalnutVisitor import WalnutVisitor

import cs572util as util
from WalnutVisitor import WalnutVisitor


class WalnutAstBuilder(ParseTreeVisitor):

    def __init__(self, path, tokens):
        super().__init__()
        self._path = path
        self._tokens = tokens
    #---------------------------------------------------------------------------
    def visitClassDefinition(self, ctx):
        classBody = self._visit_kids(ctx)
        coord = self._ctx_coord(ctx)
        return Ast('CLASS', classBody, type_name=ctx.typeName.text, 
                   super_name = "Object" if ctx.superName == None else ctx.superName.text,
                   coord=coord)
    
    def visitVarDec(self, ctx):
        isStatic = ctx.isStatic != None
        kind = ctx.kind.text
        coord = self._ctx_coord(ctx)
        type_name = ""
        rank = 0
        if ctx.typeSp:
            typeInfo = self.visit(ctx.typeSp)
            type_name = typeInfo.name
            rank = typeInfo.rank
        else:
            type_name = "$inferred"
        type_ast = Ast("TYPE", type_name=type_name, rank=rank, coord=coord) 
        rest = self._visit_kids(ctx) 
        children = [type_ast]
        children.extend(rest)
        return Ast('DECLS', children, isStatic=isStatic, kind=kind, coord=coord)

    TypeProto = namedtuple('TypeProto', 'name rank coord')
    
    def visitPrimType(self, ctx):
        coord = self._ctx_coord(ctx)
        primType = ctx.primitiveType().getText()
        rank = len(ctx.brackets)
        return WalnutAstBuilder.TypeProto(name=primType, rank=rank, coord=coord)
        

    def visitNamedType(self, ctx):
        coord = self._ctx_coord(ctx)
        namedType = ctx.TYPE_ID().getText()
        rank = len(ctx.brackets)
        return WalnutAstBuilder.TypeProto(name=namedType, rank=rank, coord=coord)
    
    def visitDecl(self, ctx):
        name = ctx.name.text
        coord = self._ctx_coord(ctx)
        return Ast('DECL', name=name, coord=coord)
    
    def visitExprInit(self, ctx):
        name = ctx.name.text
        coord = self._ctx_coord(ctx)
        expr = self.visit(ctx.expr())
        children = [expr]
        return Ast("INIT_DECL", children, name=name, coord=coord)

    def visitArrayInit(self, ctx):
        name = ctx.name.text
        coord = self._ctx_coord(ctx)
        expr = self.visit(ctx.array())
        children = [expr]
        return Ast("INIT_DECL", children, name=name, coord=coord)
    
    def visitArray(self, ctx):
        coord = self._ctx_coord(ctx)
        if ctx.elements:
            elements = [ self.visit(element) for element in ctx.elements ]
        else:
            elements = [ self.visit(element) for element in ctx.nested ]
        return Ast("INITS", elements, coord=coord)

    def visitIntLit(self, ctx):
        coord = self._ctx_coord(ctx)
        return Ast('INT', value=int(ctx.INT().getText()), coord=coord)

    def visitStringLit(self, ctx):
        coord = self._ctx_coord(ctx)
        return Ast('STRING', value=(ctx.STRING().getText()), coord=coord)

    def visitRealLit(self, ctx):
        coord = self._ctx_coord(ctx)
        return Ast('REAL', value=float(ctx.REAL().getText()), coord=coord)
    
    def visitNilLit(self, ctx):
        coord = self._ctx_coord(ctx)
        return Ast('NIL', value="NIL", coord=coord) 

    def visitBlock(self, ctx):
        blockBody = self._visit_kids(ctx)
        coord = self._ctx_coord(ctx)
        return Ast("BLOCK", blockBody, coord=coord)

    def visitStWhile(self, ctx):
        coord = self._ctx_coord(ctx)
        expr = self.visit(ctx.expr())
        stmnt = self.visit(ctx.statement())
        kids = [expr]
        kids.append(stmnt)
        return Ast("WHILE", kids, coord=coord )

    def visitStIf(self, ctx):
        coord = self._ctx_coord(ctx)
        ifExpr = self.visit(ctx.ifExpr)
        ifStmnt = self.visit(ctx.ifStmnt)
        if ctx.elseStmnt:
            elseStmnt = self.visit(ctx.elseStmnt)
        else:
            elseStmnt = Ast("BLOCK", coord=coord)
        kids = [ifExpr]
        kids.append(ifStmnt)
        kids.append(elseStmnt)
        return Ast("IF", kids, coord=coord)

    def visitStReturn(self, ctx):
        coord = self._ctx_coord(ctx)
        if ctx.ret:
            kid = self.visit(ctx.expr())
        else:
            kid = Ast("VOID", coord=coord)
        return Ast("RETURN", [kid], coord=coord)

    def visitStBlock(self, ctx):
        return self.visit(ctx.block())
 
    def visitStExpr(self, ctx):
        return self.visit(ctx.expr())

    def visitStEmpty(self, ctx):
        coord = self._ctx_coord(ctx)
        return Ast("BLOCK", coord=coord)


    def visitEParen(self, ctx):
        return self.visit(ctx.expr())

    def visitEID(self, ctx):
        return self.visit(ctx.anId())

    def visitELiteral(self, ctx):
        return self.visit(ctx.literal())

    def visitEArrIndex(self, ctx):
        coord = self._ctx_coord(ctx)
        array = self.visit(ctx.arr)
        idx = self.visit(ctx.index)
        return Ast("INDEX", [array, idx], coord=coord)
        
    def visitEFnCall(self, ctx):
        coord = self._ctx_coord(ctx)
        fnName = self.visit(ctx.expr())
        params = self.visit(ctx.actualParams()) 
        kids = [fnName]
        kids.extend(params)
        return Ast("APP", kids, coord=coord)
  
    def visitActualParams(self, ctx):
        coord = self._ctx_coord(ctx)
        if ctx.exprParams:
            params = [ self.visit(expP) for expP in ctx.exprParams ]
        else:
            params = []
        params += [ self.visit(keyP) for keyP in ctx.keyParams ]
        return params

    def visitKeywordParam(self, ctx):
        coord = self._ctx_coord(ctx)
        name = ctx.ID().getText()
        kid = self.visit(ctx.expr())
        return Ast('KWARG', [kid], name=name, coord=coord)

    def visitEStaticAccess(self, ctx):
        coord = self._ctx_coord(ctx)
        typeName = ctx.TYPE_ID().getText()
        name = ctx.ID().getText()
        return Ast("STATIC_ACCESS", type_name=typeName, name=name, coord=coord)

  
    def visitObjConstruction(self, ctx):
        coord = self._ctx_coord(ctx)
        typeName = ctx.TYPE_ID().getText()
        params = self.visit(ctx.actualParams()) 
        return Ast("NEW_OBJ", params, type_name=typeName, coord=coord)

    def visitArrConstruction(self, ctx):
        coord = self._ctx_coord(ctx)
        if ctx.prim:
            typeName = ctx.primitiveType().getText()
        else:
            typeName = ctx.TYPE_ID().getText()
        rank = 0
        if ctx.idxs:
            idxs = [ self.visit(exp) for exp in ctx.idxs ]
            rank = len(ctx.idxs)
        else:
            idxs = []
        return Ast("NEW_ARRAY", idxs, type_name=typeName, rank=rank, coord=coord)
        
        

    def visitEAccess(self, ctx):
        coord = self._ctx_coord(ctx)
        name = ctx.name.text
        leftExpr= self.visit(ctx.expr())
        return Ast("ACCESS", [leftExpr], name=name, coord=coord)

    def visitECast(self, ctx):
        coord = self._ctx_coord(ctx)
        typeSpec = self.visit(ctx.typeSpec())
        tName = typeSpec.name
        tRank = typeSpec.rank
        tCoord = typeSpec.coord
        typeCastTo = Ast("TYPE", type_name=tName, rank=tRank, coord=tCoord)
        exprToCast = self.visit(ctx.expr())
        return Ast("CAST", [typeCastTo, exprToCast], coord=coord)

    def visitEMinus(self, ctx):
        coord = self._ctx_coord(ctx)
        op = "NEG"
        kid = self.visit(ctx.expr())
        return Ast("OP1", [kid], op=op, coord=coord)

    def visitEMulDivMod(self, ctx):
        coord = self._ctx_coord(ctx)
        operator = ctx.operator.text
        if operator == "*":
            op = "MUL"
        if operator == "/":
            op = "DIV"
        if operator == "%":
            op = "REM"
        leftOperand = self.visit(ctx.left)
        rightOperand = self.visit(ctx.right)
        return Ast("OP2", [leftOperand, rightOperand], op=op, coord=coord)
    
    def visitEAddSub(self, ctx):
        coord = self._ctx_coord(ctx)
        operator = ctx.operator.text
        if operator == "+":
            op = "ADD"
        if operator == "-":
            op = "SUB"
        leftOperand = self.visit(ctx.left)
        rightOperand = self.visit(ctx.right)
        return Ast("OP2", [leftOperand, rightOperand], op=op, coord=coord)

    def visitERelation(self, ctx):
        coord = self._ctx_coord(ctx)
        operator = ctx.operator.text
        if operator == "==":
            op = "EQ"
        if operator == "!=":
            op = "NE"
        if operator == "<":
            op = "LT"
        if operator == ">":
            op = "GT"
        if operator == "<=":
            op = "LE"
        if operator == ">=":
            op = "GE"
        leftOperand = self.visit(ctx.left)
        rightOperand = self.visit(ctx.right)
        return Ast("OP2", [leftOperand, rightOperand], op=op, coord=coord)

    def visitENot(self, ctx):
        coord = self._ctx_coord(ctx)
        op = "NOT"
        kid = self.visit(ctx.expr())
        return Ast("OP1", [kid], op=op, coord=coord)

    def visitEAnd(self, ctx):
        coord = self._ctx_coord(ctx)
        op = "AND"
        leftOperand = self.visit(ctx.left)
        rightOperand = self.visit(ctx.right)
        return Ast("OP2", [leftOperand, rightOperand], op=op, coord=coord)

    def visitEOr(self, ctx):
        coord = self._ctx_coord(ctx)
        op = "OR"
        leftOperand = self.visit(ctx.left)
        rightOperand = self.visit(ctx.right)
        return Ast("OP2", [leftOperand, rightOperand], op=op, coord=coord)

    def visitETern(self, ctx):
        coord = self._ctx_coord(ctx)
        cond = self.visit(ctx.cond)
        then = self.visit(ctx.then)
        elseExpr = self.visit(ctx.elseExpr)
        return Ast("COND", [cond, then, elseExpr], coord=coord)

    def visitEAssign(self, ctx):
        coord = self._ctx_coord(ctx)
        leftOperand = self.visit(ctx.left)
        rightOperand = self.visit(ctx.right)
        return Ast("ASSIGN", [leftOperand, rightOperand], coord=coord)
    

    #---------------------------------------------------------------------------
    
    
    def visitProgram(self, ctx):
        #pdb.set_trace() #activate to turn on python debugger
        kids = self._visit_kids(ctx)
        coord = self._kids_coord(kids)
        return Ast('PROGRAM', kids, coord=coord)

    def visitFnDefinition(self, ctx):
        coord = self._ctx_coord(ctx)
        proto = self.visit(ctx.fnHeader())
        body = self.visit(ctx.block())
        return Ast('DEFN', [proto.returnType, proto.params, body],
                   kind=proto.kind, isStatic=proto.isStatic,
                   name=proto.name, coord=coord)

    Proto = namedtuple('Proto', 'kind isStatic name returnType params')

    def visitFnProto(self, ctx):
        isStatic = ctx.isStatic != None
        name = ctx.ID().getText()
        typeSpec = self.visit(ctx.typeSpec())
        tName = typeSpec.name
        tRank = typeSpec.rank
        tCoord = typeSpec.coord
        returnType = Ast("TYPE", type_name=tName, rank=tRank, coord=tCoord)
        params = self.visit(ctx.params())
        return WalnutAstBuilder.Proto(kind='function', isStatic=isStatic,
                                      name=name, returnType=returnType,
                                      params=params)

    def visitConstrProto(self, ctx):
        coord = self._ctx_coord(ctx)
        isStatic = True
        name = ctx.TYPE_ID().getText()
        params = self.visit(ctx.params())
        returnType = Ast('TYPE', type_name='$inferred', rank=0, coord=coord)
        return WalnutAstBuilder.Proto(kind='constructor', isStatic=True,
                                      name=name, returnType=returnType,
                                      params=params)

    def visitParams(self, ctx):
        coord = self._ctx_coord(ctx)
        if ctx.formals:
            params = [ self.visit(formal) for formal in ctx.formals ]
        else:
            params = []
        params += [ self.visit(initFormal) for initFormal in ctx.initFormals ]
        return Ast('PARAMS', params, coord=coord)

    def visitParam(self, ctx):
        coord = self._ctx_coord(ctx)
        typeSpec = self.visit(ctx.typeSpec())
        tName = typeSpec.name
        tRank = typeSpec.rank
        tCoord = typeSpec.coord
        typeAst = Ast("TYPE", type_name=tName, rank=tRank, coord=tCoord)
        name = ctx.ID().getText()
        return Ast('PARAM', [typeAst], coord=coord, name=name)

    def visitInitParam(self, ctx):
        coord = self._ctx_coord(ctx)
        if ctx.typeSpec():
            typeSpec = self.visit(ctx.typeSpec())
            tName = typeSpec.name
            tRank = typeSpec.rank
            tCoord = typeSpec.coord
            typeAst = Ast("TYPE", type_name=tName, rank=tRank, coord=tCoord)
        else:
            typeAst = Ast('TYPE', type_name='$inferred', coord=coord)
        name = ctx.ID().getText()
        init = self.visit(ctx.init())
        return Ast('INIT_PARAM', [typeAst, init], coord=coord, name=name)

    def visitInit(self, ctx):
        if ctx.exp:
            return self.visit(ctx.expr())
        else:
            return self.visit(ctx.array())


    def visitAnId(self, ctx):
        coord = self._ctx_coord(ctx)
        return Ast('REF', name=ctx.ID().getText(), coord=coord)
   



    #helpers

    def _ctx_coord(self, ctx, index=0):
        """return source coordinate of terminal token at ctx[index]
           Allows negative indexes to index from end of ctx"""
        if index >= 0:
            startIndex = ctx.getSourceInterval()[0]
        else:
            startIndex = ctx.getSourceInterval()[1] + 1
        token = self._tokens.get(startIndex + index)
        return Coord(self._path, token.line, token.column)

    def _ctx_text(self, ctx, index=0):
        """return source text for ctx[index]"""
        startIndex = ctx.getSourceInterval()[0]
        token = self._tokens.get(startIndex + index)
        return token.text

    def _visit_kids(self, ctx, startIndex=0, endIndex=-1):
        """return ast's resulting from recursive visit of
           kids ctx[startIndex] to ctx[endIndex] inclusive,
           where negative indices index from end of context ctx
           Filter out returned None Asts."""
        n = ctx.getChildCount()
        if startIndex < 0: startIndex = n + startIndex
        if endIndex < 0: endIndex = n + endIndex + 1
        asts = [ self.visit(ctx.getChild(i))
                       for i in range(startIndex, endIndex)]
        return list(filter(lambda ast: ast, asts))

    def _kids_coord(self, kids, index=0):
        """return source coordinate of kids[index]"""
        return Coord(self._path, 1, 0)
        if index >= len(kids):
            return Coord(self._path, 1, 0)
        else:
            return kids[index].coord

#track locations within files
Coord = namedtuple('Coord', 'path lineN colN')
Coord.__str__ = lambda self: '%s:%s:%s' % (self.path, self.lineN, self.colN)


def out_ast_formats(source_path, ast):
    base_path = re.sub(r"\.\w+$", '', source_path)
    for fmt in [ 'text', 'xml', 'dot' ]:
        dest_path = base_path + '.' + fmt
        with open(dest_path, 'w') as f:
            if fmt == 'dot':
                s = ast.dot()
            elif fmt == 'xml':
                s = ast.xml()
            else:
                s = str(ast)
            f.write(s)


def main(path, do_gen):
    with util.open_file_or_stdio(path) as f:
        input = InputStream(f.read())
        lexer = WalnutLexer(input)
        tokens = CommonTokenStream(lexer)
        parser = WalnutParser(tokens)
        parse_tree = parser.program()
        n_errors = parser.getNumberOfSyntaxErrors()
        if n_errors == 0:
            astBuilder = WalnutAstBuilder(path, tokens)
            ast = astBuilder.visit(parse_tree)
            if do_gen: out_ast_formats(path, ast)
            print(str(ast))
        return n_errors

if __name__ == '__main__':
    do_gen = False
    if len(sys.argv) == 2:
        path = sys.argv[1]
    elif len(sys.argv) == 3 and sys.argv[1] == '-g':
        path = sys.argv[2]
        do_gen = True
    else:
        sys.stderr.write('usage: %s [-g] WALNUT_FILE|-\n' % (sys.argv[0]))
        sys.sterr.write('-g flag generates ast in files *.xml, *.dot, *.text')
        sys.exit(1)

    n_errors = main(path, do_gen)
    sys.exit(n_errors != 0)
