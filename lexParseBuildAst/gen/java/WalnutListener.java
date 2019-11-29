// Generated from Walnut.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WalnutParser}.
 */
public interface WalnutListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WalnutParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(WalnutParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(WalnutParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(WalnutParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(WalnutParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(WalnutParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(WalnutParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInit}
	 * labeled alternative in {@link WalnutParser#initDecl}.
	 * @param ctx the parse tree
	 */
	void enterExprInit(WalnutParser.ExprInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInit}
	 * labeled alternative in {@link WalnutParser#initDecl}.
	 * @param ctx the parse tree
	 */
	void exitExprInit(WalnutParser.ExprInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayInit}
	 * labeled alternative in {@link WalnutParser#initDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayInit(WalnutParser.ArrayInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayInit}
	 * labeled alternative in {@link WalnutParser#initDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayInit(WalnutParser.ArrayInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(WalnutParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(WalnutParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(WalnutParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(WalnutParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#classElement}.
	 * @param ctx the parse tree
	 */
	void enterClassElement(WalnutParser.ClassElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#classElement}.
	 * @param ctx the parse tree
	 */
	void exitClassElement(WalnutParser.ClassElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#fnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFnDefinition(WalnutParser.FnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#fnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFnDefinition(WalnutParser.FnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fnProto}
	 * labeled alternative in {@link WalnutParser#fnHeader}.
	 * @param ctx the parse tree
	 */
	void enterFnProto(WalnutParser.FnProtoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fnProto}
	 * labeled alternative in {@link WalnutParser#fnHeader}.
	 * @param ctx the parse tree
	 */
	void exitFnProto(WalnutParser.FnProtoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constrProto}
	 * labeled alternative in {@link WalnutParser#fnHeader}.
	 * @param ctx the parse tree
	 */
	void enterConstrProto(WalnutParser.ConstrProtoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constrProto}
	 * labeled alternative in {@link WalnutParser#fnHeader}.
	 * @param ctx the parse tree
	 */
	void exitConstrProto(WalnutParser.ConstrProtoContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(WalnutParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(WalnutParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(WalnutParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(WalnutParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#initParam}.
	 * @param ctx the parse tree
	 */
	void enterInitParam(WalnutParser.InitParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#initParam}.
	 * @param ctx the parse tree
	 */
	void exitInitParam(WalnutParser.InitParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primType}
	 * labeled alternative in {@link WalnutParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void enterPrimType(WalnutParser.PrimTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primType}
	 * labeled alternative in {@link WalnutParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void exitPrimType(WalnutParser.PrimTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code namedType}
	 * labeled alternative in {@link WalnutParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void enterNamedType(WalnutParser.NamedTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code namedType}
	 * labeled alternative in {@link WalnutParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void exitNamedType(WalnutParser.NamedTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(WalnutParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(WalnutParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(WalnutParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(WalnutParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void enterActualParams(WalnutParser.ActualParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void exitActualParams(WalnutParser.ActualParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#keywordParam}.
	 * @param ctx the parse tree
	 */
	void enterKeywordParam(WalnutParser.KeywordParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#keywordParam}.
	 * @param ctx the parse tree
	 */
	void exitKeywordParam(WalnutParser.KeywordParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eId}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEId(WalnutParser.EIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eId}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEId(WalnutParser.EIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrConstruction}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrConstruction(WalnutParser.ArrConstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrConstruction}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrConstruction(WalnutParser.ArrConstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eNot}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterENot(WalnutParser.ENotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eNot}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitENot(WalnutParser.ENotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eTern}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterETern(WalnutParser.ETernContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eTern}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitETern(WalnutParser.ETernContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eLiteral}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterELiteral(WalnutParser.ELiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eLiteral}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitELiteral(WalnutParser.ELiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eStaticAccess}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEStaticAccess(WalnutParser.EStaticAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eStaticAccess}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEStaticAccess(WalnutParser.EStaticAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eArrIndex}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEArrIndex(WalnutParser.EArrIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eArrIndex}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEArrIndex(WalnutParser.EArrIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eOr}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEOr(WalnutParser.EOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eOr}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEOr(WalnutParser.EOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eParen}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEParen(WalnutParser.EParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eParen}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEParen(WalnutParser.EParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eCast}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterECast(WalnutParser.ECastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eCast}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitECast(WalnutParser.ECastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eAccess}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEAccess(WalnutParser.EAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eAccess}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEAccess(WalnutParser.EAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eMinus}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEMinus(WalnutParser.EMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eMinus}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEMinus(WalnutParser.EMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eRelation}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterERelation(WalnutParser.ERelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eRelation}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitERelation(WalnutParser.ERelationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eMulDivMod}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEMulDivMod(WalnutParser.EMulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eMulDivMod}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEMulDivMod(WalnutParser.EMulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eAddSub}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEAddSub(WalnutParser.EAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eAddSub}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEAddSub(WalnutParser.EAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objConstruction}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterObjConstruction(WalnutParser.ObjConstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objConstruction}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitObjConstruction(WalnutParser.ObjConstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eAnd}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEAnd(WalnutParser.EAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eAnd}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEAnd(WalnutParser.EAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eFnCall}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEFnCall(WalnutParser.EFnCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eFnCall}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEFnCall(WalnutParser.EFnCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eAssign}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEAssign(WalnutParser.EAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eAssign}
	 * labeled alternative in {@link WalnutParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEAssign(WalnutParser.EAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLit}
	 * labeled alternative in {@link WalnutParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntLit(WalnutParser.IntLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLit}
	 * labeled alternative in {@link WalnutParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntLit(WalnutParser.IntLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLit}
	 * labeled alternative in {@link WalnutParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLit(WalnutParser.StringLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLit}
	 * labeled alternative in {@link WalnutParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLit(WalnutParser.StringLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realLit}
	 * labeled alternative in {@link WalnutParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterRealLit(WalnutParser.RealLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realLit}
	 * labeled alternative in {@link WalnutParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitRealLit(WalnutParser.RealLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nilLit}
	 * labeled alternative in {@link WalnutParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNilLit(WalnutParser.NilLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nilLit}
	 * labeled alternative in {@link WalnutParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNilLit(WalnutParser.NilLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(WalnutParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(WalnutParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stWhile}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStWhile(WalnutParser.StWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stWhile}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStWhile(WalnutParser.StWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stIf}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStIf(WalnutParser.StIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stIf}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStIf(WalnutParser.StIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stReturn}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStReturn(WalnutParser.StReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stReturn}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStReturn(WalnutParser.StReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stBlock}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStBlock(WalnutParser.StBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stBlock}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStBlock(WalnutParser.StBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stExpr}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStExpr(WalnutParser.StExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stExpr}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStExpr(WalnutParser.StExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stEmpty}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStEmpty(WalnutParser.StEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stEmpty}
	 * labeled alternative in {@link WalnutParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStEmpty(WalnutParser.StEmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link WalnutParser#anId}.
	 * @param ctx the parse tree
	 */
	void enterAnId(WalnutParser.AnIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link WalnutParser#anId}.
	 * @param ctx the parse tree
	 */
	void exitAnId(WalnutParser.AnIdContext ctx);
}