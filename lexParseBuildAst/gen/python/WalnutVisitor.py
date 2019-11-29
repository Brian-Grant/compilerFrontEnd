# Generated from Walnut.g4 by ANTLR 4.7.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .WalnutParser import WalnutParser
else:
    from WalnutParser import WalnutParser

# This class defines a complete generic visitor for a parse tree produced by WalnutParser.

class WalnutVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by WalnutParser#program.
    def visitProgram(self, ctx:WalnutParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#varDec.
    def visitVarDec(self, ctx:WalnutParser.VarDecContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#decl.
    def visitDecl(self, ctx:WalnutParser.DeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#exprInit.
    def visitExprInit(self, ctx:WalnutParser.ExprInitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#arrayInit.
    def visitArrayInit(self, ctx:WalnutParser.ArrayInitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#array.
    def visitArray(self, ctx:WalnutParser.ArrayContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#classDefinition.
    def visitClassDefinition(self, ctx:WalnutParser.ClassDefinitionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#classElement.
    def visitClassElement(self, ctx:WalnutParser.ClassElementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#fnDefinition.
    def visitFnDefinition(self, ctx:WalnutParser.FnDefinitionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#fnProto.
    def visitFnProto(self, ctx:WalnutParser.FnProtoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#constrProto.
    def visitConstrProto(self, ctx:WalnutParser.ConstrProtoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#params.
    def visitParams(self, ctx:WalnutParser.ParamsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#param.
    def visitParam(self, ctx:WalnutParser.ParamContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#initParam.
    def visitInitParam(self, ctx:WalnutParser.InitParamContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#primType.
    def visitPrimType(self, ctx:WalnutParser.PrimTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#namedType.
    def visitNamedType(self, ctx:WalnutParser.NamedTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#primitiveType.
    def visitPrimitiveType(self, ctx:WalnutParser.PrimitiveTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#init.
    def visitInit(self, ctx:WalnutParser.InitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#actualParams.
    def visitActualParams(self, ctx:WalnutParser.ActualParamsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#keywordParam.
    def visitKeywordParam(self, ctx:WalnutParser.KeywordParamContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eId.
    def visitEId(self, ctx:WalnutParser.EIdContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#arrConstruction.
    def visitArrConstruction(self, ctx:WalnutParser.ArrConstructionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eNot.
    def visitENot(self, ctx:WalnutParser.ENotContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eTern.
    def visitETern(self, ctx:WalnutParser.ETernContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eLiteral.
    def visitELiteral(self, ctx:WalnutParser.ELiteralContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eStaticAccess.
    def visitEStaticAccess(self, ctx:WalnutParser.EStaticAccessContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eArrIndex.
    def visitEArrIndex(self, ctx:WalnutParser.EArrIndexContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eOr.
    def visitEOr(self, ctx:WalnutParser.EOrContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eParen.
    def visitEParen(self, ctx:WalnutParser.EParenContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eCast.
    def visitECast(self, ctx:WalnutParser.ECastContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eAccess.
    def visitEAccess(self, ctx:WalnutParser.EAccessContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eMinus.
    def visitEMinus(self, ctx:WalnutParser.EMinusContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eRelation.
    def visitERelation(self, ctx:WalnutParser.ERelationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eMulDivMod.
    def visitEMulDivMod(self, ctx:WalnutParser.EMulDivModContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eAddSub.
    def visitEAddSub(self, ctx:WalnutParser.EAddSubContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#objConstruction.
    def visitObjConstruction(self, ctx:WalnutParser.ObjConstructionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eAnd.
    def visitEAnd(self, ctx:WalnutParser.EAndContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eFnCall.
    def visitEFnCall(self, ctx:WalnutParser.EFnCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#eAssign.
    def visitEAssign(self, ctx:WalnutParser.EAssignContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#intLit.
    def visitIntLit(self, ctx:WalnutParser.IntLitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#stringLit.
    def visitStringLit(self, ctx:WalnutParser.StringLitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#realLit.
    def visitRealLit(self, ctx:WalnutParser.RealLitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#nilLit.
    def visitNilLit(self, ctx:WalnutParser.NilLitContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#block.
    def visitBlock(self, ctx:WalnutParser.BlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#stWhile.
    def visitStWhile(self, ctx:WalnutParser.StWhileContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#stIf.
    def visitStIf(self, ctx:WalnutParser.StIfContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#stReturn.
    def visitStReturn(self, ctx:WalnutParser.StReturnContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#stBlock.
    def visitStBlock(self, ctx:WalnutParser.StBlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#stExpr.
    def visitStExpr(self, ctx:WalnutParser.StExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#stEmpty.
    def visitStEmpty(self, ctx:WalnutParser.StEmptyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by WalnutParser#anId.
    def visitAnId(self, ctx:WalnutParser.AnIdContext):
        return self.visitChildren(ctx)



del WalnutParser