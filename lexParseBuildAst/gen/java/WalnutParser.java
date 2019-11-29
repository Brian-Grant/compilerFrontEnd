// Generated from Walnut.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WalnutParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, TYPE_ID=40, ID=41, INT=42, STRING=43, REAL=44, LINE_COMMENT=45, 
		BLOCK_COMMENT=46, WS=47;
	public static final int
		RULE_program = 0, RULE_varDec = 1, RULE_decl = 2, RULE_initDecl = 3, RULE_array = 4, 
		RULE_classDefinition = 5, RULE_classElement = 6, RULE_fnDefinition = 7, 
		RULE_fnHeader = 8, RULE_params = 9, RULE_param = 10, RULE_initParam = 11, 
		RULE_typeSpec = 12, RULE_primitiveType = 13, RULE_init = 14, RULE_actualParams = 15, 
		RULE_keywordParam = 16, RULE_expr = 17, RULE_literal = 18, RULE_block = 19, 
		RULE_statement = 20, RULE_anId = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "varDec", "decl", "initDecl", "array", "classDefinition", 
			"classElement", "fnDefinition", "fnHeader", "params", "param", "initParam", 
			"typeSpec", "primitiveType", "init", "actualParams", "keywordParam", 
			"expr", "literal", "block", "statement", "anId"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'static'", "'const'", "'var'", "','", "';'", "'='", "'{'", "'}'", 
			"'class'", "':'", "'('", "')'", "'['", "']'", "'String'", "'Int'", "'Real'", 
			"'Void'", "'.'", "'-'", "'*'", "'/'", "'%'", "'+'", "'=='", "'!='", "'<'", 
			"'>'", "'<='", "'>='", "'!'", "'&&'", "'||'", "'?'", "'nil'", "'while'", 
			"'if'", "'else'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "TYPE_ID", "ID", "INT", "STRING", "REAL", "LINE_COMMENT", 
			"BLOCK_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Walnut.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WalnutParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(WalnutParser.EOF, 0); }
		public List<FnDefinitionContext> fnDefinition() {
			return getRuleContexts(FnDefinitionContext.class);
		}
		public FnDefinitionContext fnDefinition(int i) {
			return getRuleContext(FnDefinitionContext.class,i);
		}
		public List<ClassDefinitionContext> classDefinition() {
			return getRuleContexts(ClassDefinitionContext.class);
		}
		public ClassDefinitionContext classDefinition(int i) {
			return getRuleContext(ClassDefinitionContext.class,i);
		}
		public List<VarDecContext> varDec() {
			return getRuleContexts(VarDecContext.class);
		}
		public VarDecContext varDec(int i) {
			return getRuleContext(VarDecContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__30) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__38) | (1L << TYPE_ID) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << REAL))) != 0)) {
				{
				setState(48);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(44);
					fnDefinition();
					}
					break;
				case 2:
					{
					setState(45);
					classDefinition();
					}
					break;
				case 3:
					{
					setState(46);
					varDec();
					}
					break;
				case 4:
					{
					setState(47);
					statement();
					}
					break;
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDecContext extends ParserRuleContext {
		public Token isStatic;
		public Token kind;
		public TypeSpecContext typeSp;
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<InitDeclContext> initDecl() {
			return getRuleContexts(InitDeclContext.class);
		}
		public InitDeclContext initDecl(int i) {
			return getRuleContext(InitDeclContext.class,i);
		}
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterVarDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitVarDec(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_varDec);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(55);
					((VarDecContext)_localctx).isStatic = match(T__0);
					}
				}

				setState(58);
				((VarDecContext)_localctx).kind = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
					((VarDecContext)_localctx).kind = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(59);
				((VarDecContext)_localctx).typeSp = typeSpec();
				setState(62);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(60);
					decl();
					}
					break;
				case 2:
					{
					setState(61);
					initDecl();
					}
					break;
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(64);
					match(T__3);
					setState(67);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						setState(65);
						decl();
						}
						break;
					case 2:
						{
						setState(66);
						initDecl();
						}
						break;
					}
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(76);
					((VarDecContext)_localctx).isStatic = match(T__0);
					}
				}

				setState(79);
				((VarDecContext)_localctx).kind = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
					((VarDecContext)_localctx).kind = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(80);
				initDecl();
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(81);
					match(T__3);
					setState(82);
					initDecl();
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(88);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public Token name;
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((DeclContext)_localctx).name = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclContext extends ParserRuleContext {
		public InitDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDecl; }
	 
		public InitDeclContext() { }
		public void copyFrom(InitDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayInitContext extends InitDeclContext {
		public Token name;
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public ArrayInitContext(InitDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterArrayInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitArrayInit(this);
		}
	}
	public static class ExprInitContext extends InitDeclContext {
		public Token name;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public ExprInitContext(InitDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterExprInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitExprInit(this);
		}
	}

	public final InitDeclContext initDecl() throws RecognitionException {
		InitDeclContext _localctx = new InitDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_initDecl);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new ExprInitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				((ExprInitContext)_localctx).name = match(ID);
				setState(95);
				match(T__5);
				setState(96);
				expr(0);
				}
				break;
			case 2:
				_localctx = new ArrayInitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				((ArrayInitContext)_localctx).name = match(ID);
				setState(98);
				match(T__5);
				setState(99);
				match(T__6);
				setState(100);
				array();
				setState(101);
				match(T__7);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public ArrayContext array;
		public List<ArrayContext> nested = new ArrayList<ArrayContext>();
		public ExprContext expr;
		public List<ExprContext> elements = new ArrayList<ExprContext>();
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_array);
		int _la;
		try {
			int _alt;
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(T__6);
				setState(106);
				((ArrayContext)_localctx).array = array();
				((ArrayContext)_localctx).nested.add(((ArrayContext)_localctx).array);
				setState(107);
				match(T__7);
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(108);
						match(T__3);
						setState(109);
						match(T__6);
						setState(110);
						((ArrayContext)_localctx).array = array();
						((ArrayContext)_localctx).nested.add(((ArrayContext)_localctx).array);
						setState(111);
						match(T__7);
						}
						} 
					}
					setState(117);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(118);
					match(T__3);
					}
				}

				}
				break;
			case T__10:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__19:
			case T__30:
			case T__34:
			case TYPE_ID:
			case ID:
			case INT:
			case STRING:
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((ArrayContext)_localctx).expr = expr(0);
				((ArrayContext)_localctx).elements.add(((ArrayContext)_localctx).expr);
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(122);
						match(T__3);
						setState(123);
						((ArrayContext)_localctx).expr = expr(0);
						((ArrayContext)_localctx).elements.add(((ArrayContext)_localctx).expr);
						}
						} 
					}
					setState(128);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(129);
					match(T__3);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefinitionContext extends ParserRuleContext {
		public Token typeName;
		public Token superName;
		public ClassElementContext classElement;
		public List<ClassElementContext> classBody = new ArrayList<ClassElementContext>();
		public List<TerminalNode> TYPE_ID() { return getTokens(WalnutParser.TYPE_ID); }
		public TerminalNode TYPE_ID(int i) {
			return getToken(WalnutParser.TYPE_ID, i);
		}
		public List<ClassElementContext> classElement() {
			return getRuleContexts(ClassElementContext.class);
		}
		public ClassElementContext classElement(int i) {
			return getRuleContext(ClassElementContext.class,i);
		}
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterClassDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitClassDefinition(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__8);
			setState(135);
			((ClassDefinitionContext)_localctx).typeName = match(TYPE_ID);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(136);
				match(T__9);
				setState(137);
				((ClassDefinitionContext)_localctx).superName = match(TYPE_ID);
				}
			}

			setState(140);
			match(T__6);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << TYPE_ID))) != 0)) {
				{
				{
				setState(141);
				((ClassDefinitionContext)_localctx).classElement = classElement();
				((ClassDefinitionContext)_localctx).classBody.add(((ClassDefinitionContext)_localctx).classElement);
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassElementContext extends ParserRuleContext {
		public FnDefinitionContext fnDefinition() {
			return getRuleContext(FnDefinitionContext.class,0);
		}
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public ClassElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterClassElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitClassElement(this);
		}
	}

	public final ClassElementContext classElement() throws RecognitionException {
		ClassElementContext _localctx = new ClassElementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(149);
				fnDefinition();
				}
				break;
			case 2:
				{
				setState(150);
				varDec();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnDefinitionContext extends ParserRuleContext {
		public FnHeaderContext fnHeader() {
			return getRuleContext(FnHeaderContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterFnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitFnDefinition(this);
		}
	}

	public final FnDefinitionContext fnDefinition() throws RecognitionException {
		FnDefinitionContext _localctx = new FnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fnDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			fnHeader();
			setState(154);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnHeaderContext extends ParserRuleContext {
		public FnHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnHeader; }
	 
		public FnHeaderContext() { }
		public void copyFrom(FnHeaderContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstrProtoContext extends FnHeaderContext {
		public TerminalNode TYPE_ID() { return getToken(WalnutParser.TYPE_ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ConstrProtoContext(FnHeaderContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterConstrProto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitConstrProto(this);
		}
	}
	public static class FnProtoContext extends FnHeaderContext {
		public Token isStatic;
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FnProtoContext(FnHeaderContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterFnProto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitFnProto(this);
		}
	}

	public final FnHeaderContext fnHeader() throws RecognitionException {
		FnHeaderContext _localctx = new FnHeaderContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fnHeader);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new FnProtoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(156);
					((FnProtoContext)_localctx).isStatic = match(T__0);
					}
				}

				setState(159);
				typeSpec();
				setState(160);
				match(ID);
				setState(161);
				match(T__10);
				setState(162);
				params();
				setState(163);
				match(T__11);
				}
				break;
			case 2:
				_localctx = new ConstrProtoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(TYPE_ID);
				setState(166);
				match(T__10);
				setState(167);
				params();
				setState(168);
				match(T__11);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public ParamContext param;
		public List<ParamContext> formals = new ArrayList<ParamContext>();
		public InitParamContext initParam;
		public List<InitParamContext> initFormals = new ArrayList<InitParamContext>();
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<InitParamContext> initParam() {
			return getRuleContexts(InitParamContext.class);
		}
		public InitParamContext initParam(int i) {
			return getRuleContext(InitParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_params);
		int _la;
		try {
			int _alt;
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				((ParamsContext)_localctx).param = param();
				((ParamsContext)_localctx).formals.add(((ParamsContext)_localctx).param);
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(173);
						match(T__3);
						setState(174);
						((ParamsContext)_localctx).param = param();
						((ParamsContext)_localctx).formals.add(((ParamsContext)_localctx).param);
						}
						} 
					}
					setState(179);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(180);
					match(T__3);
					setState(181);
					((ParamsContext)_localctx).initParam = initParam();
					((ParamsContext)_localctx).initFormals.add(((ParamsContext)_localctx).initParam);
					}
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				((ParamsContext)_localctx).initParam = initParam();
				((ParamsContext)_localctx).initFormals.add(((ParamsContext)_localctx).initParam);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(188);
					match(T__3);
					setState(189);
					((ParamsContext)_localctx).initParam = initParam();
					((ParamsContext)_localctx).initFormals.add(((ParamsContext)_localctx).initParam);
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			typeSpec();
			setState(199);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public InitParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterInitParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitInitParam(this);
		}
	}

	public final InitParamContext initParam() throws RecognitionException {
		InitParamContext _localctx = new InitParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_initParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << TYPE_ID))) != 0)) {
				{
				setState(201);
				typeSpec();
				}
			}

			setState(204);
			match(ID);
			setState(205);
			match(T__5);
			setState(206);
			init();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecContext extends ParserRuleContext {
		public TypeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpec; }
	 
		public TypeSpecContext() { }
		public void copyFrom(TypeSpecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NamedTypeContext extends TypeSpecContext {
		public Token s13;
		public List<Token> brackets = new ArrayList<Token>();
		public TerminalNode TYPE_ID() { return getToken(WalnutParser.TYPE_ID, 0); }
		public NamedTypeContext(TypeSpecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterNamedType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitNamedType(this);
		}
	}
	public static class PrimTypeContext extends TypeSpecContext {
		public Token s13;
		public List<Token> brackets = new ArrayList<Token>();
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public PrimTypeContext(TypeSpecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterPrimType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitPrimType(this);
		}
	}

	public final TypeSpecContext typeSpec() throws RecognitionException {
		TypeSpecContext _localctx = new TypeSpecContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typeSpec);
		int _la;
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
			case T__17:
				_localctx = new PrimTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				primitiveType();
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(209);
					((PrimTypeContext)_localctx).s13 = match(T__12);
					((PrimTypeContext)_localctx).brackets.add(((PrimTypeContext)_localctx).s13);
					setState(210);
					match(T__13);
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case TYPE_ID:
				_localctx = new NamedTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(TYPE_ID);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(217);
					((NamedTypeContext)_localctx).s13 = match(T__12);
					((NamedTypeContext)_localctx).brackets.add(((NamedTypeContext)_localctx).s13);
					setState(218);
					match(T__13);
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitContext extends ParserRuleContext {
		public ExprContext exp;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_init);
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__19:
			case T__30:
			case T__34:
			case TYPE_ID:
			case ID:
			case INT:
			case STRING:
			case REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				((InitContext)_localctx).exp = expr(0);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(T__6);
				setState(230);
				array();
				setState(231);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualParamsContext extends ParserRuleContext {
		public ExprContext expr;
		public List<ExprContext> exprParams = new ArrayList<ExprContext>();
		public KeywordParamContext keywordParam;
		public List<KeywordParamContext> keyParams = new ArrayList<KeywordParamContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<KeywordParamContext> keywordParam() {
			return getRuleContexts(KeywordParamContext.class);
		}
		public KeywordParamContext keywordParam(int i) {
			return getRuleContext(KeywordParamContext.class,i);
		}
		public ActualParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterActualParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitActualParams(this);
		}
	}

	public final ActualParamsContext actualParams() throws RecognitionException {
		ActualParamsContext _localctx = new ActualParamsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_actualParams);
		int _la;
		try {
			int _alt;
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				((ActualParamsContext)_localctx).expr = expr(0);
				((ActualParamsContext)_localctx).exprParams.add(((ActualParamsContext)_localctx).expr);
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(236);
						match(T__3);
						setState(237);
						((ActualParamsContext)_localctx).expr = expr(0);
						((ActualParamsContext)_localctx).exprParams.add(((ActualParamsContext)_localctx).expr);
						}
						} 
					}
					setState(242);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(243);
					match(T__3);
					setState(244);
					((ActualParamsContext)_localctx).keywordParam = keywordParam();
					((ActualParamsContext)_localctx).keyParams.add(((ActualParamsContext)_localctx).keywordParam);
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				((ActualParamsContext)_localctx).keywordParam = keywordParam();
				((ActualParamsContext)_localctx).keyParams.add(((ActualParamsContext)_localctx).keywordParam);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(251);
					match(T__3);
					setState(252);
					((ActualParamsContext)_localctx).keywordParam = keywordParam();
					((ActualParamsContext)_localctx).keyParams.add(((ActualParamsContext)_localctx).keywordParam);
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public KeywordParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterKeywordParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitKeywordParam(this);
		}
	}

	public final KeywordParamContext keywordParam() throws RecognitionException {
		KeywordParamContext _localctx = new KeywordParamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_keywordParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(ID);
			setState(262);
			match(T__9);
			setState(263);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EIdContext extends ExprContext {
		public AnIdContext anId() {
			return getRuleContext(AnIdContext.class,0);
		}
		public EIdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEId(this);
		}
	}
	public static class ArrConstructionContext extends ExprContext {
		public PrimitiveTypeContext prim;
		public ExprContext expr;
		public List<ExprContext> idxs = new ArrayList<ExprContext>();
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TYPE_ID() { return getToken(WalnutParser.TYPE_ID, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ArrConstructionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterArrConstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitArrConstruction(this);
		}
	}
	public static class ENotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ENotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterENot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitENot(this);
		}
	}
	public static class ETernContext extends ExprContext {
		public ExprContext cond;
		public ExprContext then;
		public ExprContext elseExpr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ETernContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterETern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitETern(this);
		}
	}
	public static class ELiteralContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ELiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterELiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitELiteral(this);
		}
	}
	public static class EStaticAccessContext extends ExprContext {
		public TerminalNode TYPE_ID() { return getToken(WalnutParser.TYPE_ID, 0); }
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public EStaticAccessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEStaticAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEStaticAccess(this);
		}
	}
	public static class EArrIndexContext extends ExprContext {
		public ExprContext arr;
		public ExprContext index;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EArrIndexContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEArrIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEArrIndex(this);
		}
	}
	public static class EOrContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEOr(this);
		}
	}
	public static class EParenContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EParenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEParen(this);
		}
	}
	public static class ECastContext extends ExprContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ECastContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterECast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitECast(this);
		}
	}
	public static class EAccessContext extends ExprContext {
		public Token name;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public EAccessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEAccess(this);
		}
	}
	public static class EMinusContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEMinus(this);
		}
	}
	public static class ERelationContext extends ExprContext {
		public ExprContext left;
		public Token operator;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ERelationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterERelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitERelation(this);
		}
	}
	public static class EMulDivModContext extends ExprContext {
		public ExprContext left;
		public Token operator;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EMulDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEMulDivMod(this);
		}
	}
	public static class EAddSubContext extends ExprContext {
		public ExprContext left;
		public Token operator;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EAddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEAddSub(this);
		}
	}
	public static class ObjConstructionContext extends ExprContext {
		public TerminalNode TYPE_ID() { return getToken(WalnutParser.TYPE_ID, 0); }
		public ActualParamsContext actualParams() {
			return getRuleContext(ActualParamsContext.class,0);
		}
		public ObjConstructionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterObjConstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitObjConstruction(this);
		}
	}
	public static class EAndContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEAnd(this);
		}
	}
	public static class EFnCallContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ActualParamsContext actualParams() {
			return getRuleContext(ActualParamsContext.class,0);
		}
		public EFnCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEFnCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEFnCall(this);
		}
	}
	public static class EAssignContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EAssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterEAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitEAssign(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				_localctx = new EParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(266);
				match(T__10);
				setState(267);
				expr(0);
				setState(268);
				match(T__11);
				}
				break;
			case 2:
				{
				_localctx = new EIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				anId();
				}
				break;
			case 3:
				{
				_localctx = new ELiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				literal();
				}
				break;
			case 4:
				{
				_localctx = new EStaticAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				match(TYPE_ID);
				setState(273);
				match(T__18);
				setState(274);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ObjConstructionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				match(TYPE_ID);
				setState(276);
				match(T__10);
				setState(277);
				actualParams();
				setState(278);
				match(T__11);
				}
				break;
			case 6:
				{
				_localctx = new ArrConstructionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE_ID:
					{
					setState(280);
					match(TYPE_ID);
					}
					break;
				case T__14:
				case T__15:
				case T__16:
				case T__17:
					{
					setState(281);
					((ArrConstructionContext)_localctx).prim = primitiveType();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(284);
				match(T__12);
				setState(285);
				((ArrConstructionContext)_localctx).expr = expr(0);
				((ArrConstructionContext)_localctx).idxs.add(((ArrConstructionContext)_localctx).expr);
				setState(286);
				match(T__13);
				setState(293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(287);
						match(T__12);
						setState(288);
						((ArrConstructionContext)_localctx).expr = expr(0);
						((ArrConstructionContext)_localctx).idxs.add(((ArrConstructionContext)_localctx).expr);
						setState(289);
						match(T__13);
						}
						} 
					}
					setState(295);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				}
				}
				break;
			case 7:
				{
				_localctx = new ECastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(296);
				match(T__10);
				setState(297);
				typeSpec();
				setState(298);
				match(T__11);
				setState(299);
				expr(10);
				}
				break;
			case 8:
				{
				_localctx = new EMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(301);
				match(T__19);
				setState(302);
				expr(9);
				}
				break;
			case 9:
				{
				_localctx = new ENotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				match(T__30);
				setState(304);
				expr(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(346);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(344);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new EMulDivModContext(new ExprContext(_parentctx, _parentState));
						((EMulDivModContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(307);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(308);
						((EMulDivModContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((EMulDivModContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(309);
						((EMulDivModContext)_localctx).right = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new EAddSubContext(new ExprContext(_parentctx, _parentState));
						((EAddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(310);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(311);
						((EAddSubContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__23) ) {
							((EAddSubContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(312);
						((EAddSubContext)_localctx).right = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ERelationContext(new ExprContext(_parentctx, _parentState));
						((ERelationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(313);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(314);
						((ERelationContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
							((ERelationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(315);
						((ERelationContext)_localctx).right = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new EAndContext(new ExprContext(_parentctx, _parentState));
						((EAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(316);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(317);
						match(T__31);
						setState(318);
						((EAndContext)_localctx).right = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new EOrContext(new ExprContext(_parentctx, _parentState));
						((EOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(319);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(320);
						match(T__32);
						setState(321);
						((EOrContext)_localctx).right = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new ETernContext(new ExprContext(_parentctx, _parentState));
						((ETernContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(322);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(323);
						match(T__33);
						setState(324);
						((ETernContext)_localctx).then = expr(0);
						setState(325);
						match(T__9);
						setState(326);
						((ETernContext)_localctx).elseExpr = expr(2);
						}
						break;
					case 7:
						{
						_localctx = new EAssignContext(new ExprContext(_parentctx, _parentState));
						((EAssignContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(328);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(329);
						match(T__5);
						setState(330);
						((EAssignContext)_localctx).right = expr(1);
						}
						break;
					case 8:
						{
						_localctx = new EArrIndexContext(new ExprContext(_parentctx, _parentState));
						((EArrIndexContext)_localctx).arr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(331);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(332);
						match(T__12);
						setState(333);
						((EArrIndexContext)_localctx).index = expr(0);
						setState(334);
						match(T__13);
						}
						break;
					case 9:
						{
						_localctx = new EFnCallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(336);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(337);
						match(T__10);
						setState(338);
						actualParams();
						setState(339);
						match(T__11);
						}
						break;
					case 10:
						{
						_localctx = new EAccessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(341);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(342);
						match(T__18);
						setState(343);
						((EAccessContext)_localctx).name = match(ID);
						}
						break;
					}
					} 
				}
				setState(348);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RealLitContext extends LiteralContext {
		public TerminalNode REAL() { return getToken(WalnutParser.REAL, 0); }
		public RealLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterRealLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitRealLit(this);
		}
	}
	public static class StringLitContext extends LiteralContext {
		public TerminalNode STRING() { return getToken(WalnutParser.STRING, 0); }
		public StringLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterStringLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitStringLit(this);
		}
	}
	public static class IntLitContext extends LiteralContext {
		public TerminalNode INT() { return getToken(WalnutParser.INT, 0); }
		public IntLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterIntLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitIntLit(this);
		}
	}
	public static class NilLitContext extends LiteralContext {
		public NilLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterNilLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitNilLit(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_literal);
		try {
			setState(353);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				match(INT);
				}
				break;
			case STRING:
				_localctx = new StringLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				match(STRING);
				}
				break;
			case REAL:
				_localctx = new RealLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(351);
				match(REAL);
				}
				break;
			case T__34:
				_localctx = new NilLitContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(352);
				match(T__34);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<VarDecContext> varDec() {
			return getRuleContexts(VarDecContext.class);
		}
		public VarDecContext varDec(int i) {
			return getRuleContext(VarDecContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_block);
		int _la;
		try {
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				match(T__6);
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__6) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__30) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__38) | (1L << TYPE_ID) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << REAL))) != 0)) {
					{
					setState(358);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__4:
					case T__6:
					case T__10:
					case T__14:
					case T__15:
					case T__16:
					case T__17:
					case T__19:
					case T__30:
					case T__34:
					case T__35:
					case T__36:
					case T__38:
					case TYPE_ID:
					case ID:
					case INT:
					case STRING:
					case REAL:
						{
						setState(356);
						statement();
						}
						break;
					case T__0:
					case T__1:
					case T__2:
						{
						setState(357);
						varDec();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(362);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(363);
				match(T__7);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				match(T__6);
				setState(365);
				match(T__7);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StEmptyContext extends StatementContext {
		public StEmptyContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterStEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitStEmpty(this);
		}
	}
	public static class StExprContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StExprContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterStExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitStExpr(this);
		}
	}
	public static class StIfContext extends StatementContext {
		public ExprContext ifExpr;
		public StatementContext ifStmnt;
		public StatementContext elseStmnt;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterStIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitStIf(this);
		}
	}
	public static class StWhileContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterStWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitStWhile(this);
		}
	}
	public static class StReturnContext extends StatementContext {
		public ExprContext ret;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterStReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitStReturn(this);
		}
	}
	public static class StBlockContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterStBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitStBlock(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statement);
		int _la;
		try {
			setState(393);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				_localctx = new StWhileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				match(T__35);
				setState(369);
				match(T__10);
				setState(370);
				expr(0);
				setState(371);
				match(T__11);
				setState(372);
				statement();
				}
				break;
			case T__36:
				_localctx = new StIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(374);
				match(T__36);
				setState(375);
				match(T__10);
				setState(376);
				((StIfContext)_localctx).ifExpr = expr(0);
				setState(377);
				match(T__11);
				setState(378);
				((StIfContext)_localctx).ifStmnt = statement();
				setState(381);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(379);
					match(T__37);
					setState(380);
					((StIfContext)_localctx).elseStmnt = statement();
					}
					break;
				}
				}
				break;
			case T__38:
				_localctx = new StReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(383);
				match(T__38);
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__30) | (1L << T__34) | (1L << TYPE_ID) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << REAL))) != 0)) {
					{
					setState(384);
					((StReturnContext)_localctx).ret = expr(0);
					}
				}

				setState(387);
				match(T__4);
				}
				break;
			case T__6:
				_localctx = new StBlockContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(388);
				block();
				}
				break;
			case T__10:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__19:
			case T__30:
			case T__34:
			case TYPE_ID:
			case ID:
			case INT:
			case STRING:
			case REAL:
				_localctx = new StExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(389);
				expr(0);
				setState(390);
				match(T__4);
				}
				break;
			case T__4:
				_localctx = new StEmptyContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(392);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WalnutParser.ID, 0); }
		public AnIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).enterAnId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WalnutListener ) ((WalnutListener)listener).exitAnId(this);
		}
	}

	public final AnIdContext anId() throws RecognitionException {
		AnIdContext _localctx = new AnIdContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_anId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u0190\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\7\2"+
		"\63\n\2\f\2\16\2\66\13\2\3\2\3\2\3\3\5\3;\n\3\3\3\3\3\3\3\3\3\5\3A\n\3"+
		"\3\3\3\3\3\3\5\3F\n\3\7\3H\n\3\f\3\16\3K\13\3\3\3\3\3\3\3\5\3P\n\3\3\3"+
		"\3\3\3\3\3\3\7\3V\n\3\f\3\16\3Y\13\3\3\3\3\3\5\3]\n\3\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5j\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\6t\n\6\f\6\16\6w\13\6\3\6\5\6z\n\6\3\6\3\6\3\6\7\6\177\n\6\f\6\16\6"+
		"\u0082\13\6\3\6\5\6\u0085\n\6\5\6\u0087\n\6\3\7\3\7\3\7\3\7\5\7\u008d"+
		"\n\7\3\7\3\7\7\7\u0091\n\7\f\7\16\7\u0094\13\7\3\7\3\7\3\b\3\b\5\b\u009a"+
		"\n\b\3\t\3\t\3\t\3\n\5\n\u00a0\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00ad\n\n\3\13\3\13\3\13\7\13\u00b2\n\13\f\13\16\13\u00b5"+
		"\13\13\3\13\3\13\7\13\u00b9\n\13\f\13\16\13\u00bc\13\13\3\13\3\13\3\13"+
		"\7\13\u00c1\n\13\f\13\16\13\u00c4\13\13\3\13\5\13\u00c7\n\13\3\f\3\f\3"+
		"\f\3\r\5\r\u00cd\n\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16\u00d6\n\16\f"+
		"\16\16\16\u00d9\13\16\3\16\3\16\3\16\7\16\u00de\n\16\f\16\16\16\u00e1"+
		"\13\16\5\16\u00e3\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u00ec\n"+
		"\20\3\21\3\21\3\21\7\21\u00f1\n\21\f\21\16\21\u00f4\13\21\3\21\3\21\7"+
		"\21\u00f8\n\21\f\21\16\21\u00fb\13\21\3\21\3\21\3\21\7\21\u0100\n\21\f"+
		"\21\16\21\u0103\13\21\3\21\5\21\u0106\n\21\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u011d\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0126"+
		"\n\23\f\23\16\23\u0129\13\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\5\23\u0134\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u015b\n\23\f\23\16\23\u015e\13\23\3\24\3\24\3\24\3\24\5\24\u0164\n\24"+
		"\3\25\3\25\3\25\7\25\u0169\n\25\f\25\16\25\u016c\13\25\3\25\3\25\3\25"+
		"\5\25\u0171\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u0180\n\26\3\26\3\26\5\26\u0184\n\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\5\26\u018c\n\26\3\27\3\27\3\27\2\3$\30\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,\2\7\3\2\4\5\3\2\21\24\3\2\27\31\4\2\26\26"+
		"\32\32\3\2\33 \2\u01bf\2\64\3\2\2\2\4\\\3\2\2\2\6^\3\2\2\2\bi\3\2\2\2"+
		"\n\u0086\3\2\2\2\f\u0088\3\2\2\2\16\u0099\3\2\2\2\20\u009b\3\2\2\2\22"+
		"\u00ac\3\2\2\2\24\u00c6\3\2\2\2\26\u00c8\3\2\2\2\30\u00cc\3\2\2\2\32\u00e2"+
		"\3\2\2\2\34\u00e4\3\2\2\2\36\u00eb\3\2\2\2 \u0105\3\2\2\2\"\u0107\3\2"+
		"\2\2$\u0133\3\2\2\2&\u0163\3\2\2\2(\u0170\3\2\2\2*\u018b\3\2\2\2,\u018d"+
		"\3\2\2\2.\63\5\20\t\2/\63\5\f\7\2\60\63\5\4\3\2\61\63\5*\26\2\62.\3\2"+
		"\2\2\62/\3\2\2\2\62\60\3\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2"+
		"\2\64\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7\2\2\38\3\3\2\2\29;"+
		"\7\3\2\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\t\2\2\2=@\5\32\16\2>A\5\6\4\2"+
		"?A\5\b\5\2@>\3\2\2\2@?\3\2\2\2AI\3\2\2\2BE\7\6\2\2CF\5\6\4\2DF\5\b\5\2"+
		"EC\3\2\2\2ED\3\2\2\2FH\3\2\2\2GB\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2"+
		"JL\3\2\2\2KI\3\2\2\2LM\7\7\2\2M]\3\2\2\2NP\7\3\2\2ON\3\2\2\2OP\3\2\2\2"+
		"PQ\3\2\2\2QR\t\2\2\2RW\5\b\5\2ST\7\6\2\2TV\5\b\5\2US\3\2\2\2VY\3\2\2\2"+
		"WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7\7\2\2[]\3\2\2\2\\:\3\2\2"+
		"\2\\O\3\2\2\2]\5\3\2\2\2^_\7+\2\2_\7\3\2\2\2`a\7+\2\2ab\7\b\2\2bj\5$\23"+
		"\2cd\7+\2\2de\7\b\2\2ef\7\t\2\2fg\5\n\6\2gh\7\n\2\2hj\3\2\2\2i`\3\2\2"+
		"\2ic\3\2\2\2j\t\3\2\2\2kl\7\t\2\2lm\5\n\6\2mu\7\n\2\2no\7\6\2\2op\7\t"+
		"\2\2pq\5\n\6\2qr\7\n\2\2rt\3\2\2\2sn\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2"+
		"\2\2vy\3\2\2\2wu\3\2\2\2xz\7\6\2\2yx\3\2\2\2yz\3\2\2\2z\u0087\3\2\2\2"+
		"{\u0080\5$\23\2|}\7\6\2\2}\177\5$\23\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2"+
		"\u0083\u0085\7\6\2\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087"+
		"\3\2\2\2\u0086k\3\2\2\2\u0086{\3\2\2\2\u0087\13\3\2\2\2\u0088\u0089\7"+
		"\13\2\2\u0089\u008c\7*\2\2\u008a\u008b\7\f\2\2\u008b\u008d\7*\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0092\7\t"+
		"\2\2\u008f\u0091\5\16\b\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0095\u0096\7\n\2\2\u0096\r\3\2\2\2\u0097\u009a\5\20\t\2\u0098\u009a"+
		"\5\4\3\2\u0099\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a\17\3\2\2\2\u009b"+
		"\u009c\5\22\n\2\u009c\u009d\5(\25\2\u009d\21\3\2\2\2\u009e\u00a0\7\3\2"+
		"\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2"+
		"\5\32\16\2\u00a2\u00a3\7+\2\2\u00a3\u00a4\7\r\2\2\u00a4\u00a5\5\24\13"+
		"\2\u00a5\u00a6\7\16\2\2\u00a6\u00ad\3\2\2\2\u00a7\u00a8\7*\2\2\u00a8\u00a9"+
		"\7\r\2\2\u00a9\u00aa\5\24\13\2\u00aa\u00ab\7\16\2\2\u00ab\u00ad\3\2\2"+
		"\2\u00ac\u009f\3\2\2\2\u00ac\u00a7\3\2\2\2\u00ad\23\3\2\2\2\u00ae\u00b3"+
		"\5\26\f\2\u00af\u00b0\7\6\2\2\u00b0\u00b2\5\26\f\2\u00b1\u00af\3\2\2\2"+
		"\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00ba"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\7\6\2\2\u00b7\u00b9\5\30\r\2"+
		"\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb\u00c7\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00c2\5\30\r\2"+
		"\u00be\u00bf\7\6\2\2\u00bf\u00c1\5\30\r\2\u00c0\u00be\3\2\2\2\u00c1\u00c4"+
		"\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c7\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00ae\3\2\2\2\u00c6\u00bd\3\2"+
		"\2\2\u00c6\u00c5\3\2\2\2\u00c7\25\3\2\2\2\u00c8\u00c9\5\32\16\2\u00c9"+
		"\u00ca\7+\2\2\u00ca\27\3\2\2\2\u00cb\u00cd\5\32\16\2\u00cc\u00cb\3\2\2"+
		"\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\7+\2\2\u00cf\u00d0"+
		"\7\b\2\2\u00d0\u00d1\5\36\20\2\u00d1\31\3\2\2\2\u00d2\u00d7\5\34\17\2"+
		"\u00d3\u00d4\7\17\2\2\u00d4\u00d6\7\20\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9"+
		"\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00e3\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00df\7*\2\2\u00db\u00dc\7\17\2\2\u00dc\u00de\7\20"+
		"\2\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00d2\3\2"+
		"\2\2\u00e2\u00da\3\2\2\2\u00e3\33\3\2\2\2\u00e4\u00e5\t\3\2\2\u00e5\35"+
		"\3\2\2\2\u00e6\u00ec\5$\23\2\u00e7\u00e8\7\t\2\2\u00e8\u00e9\5\n\6\2\u00e9"+
		"\u00ea\7\n\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e6\3\2\2\2\u00eb\u00e7\3\2"+
		"\2\2\u00ec\37\3\2\2\2\u00ed\u00f2\5$\23\2\u00ee\u00ef\7\6\2\2\u00ef\u00f1"+
		"\5$\23\2\u00f0\u00ee\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f9\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7\6"+
		"\2\2\u00f6\u00f8\5\"\22\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u0106\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fc\u0101\5\"\22\2\u00fd\u00fe\7\6\2\2\u00fe\u0100\5\"\22\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0106\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0106\3\2\2\2\u0105"+
		"\u00ed\3\2\2\2\u0105\u00fc\3\2\2\2\u0105\u0104\3\2\2\2\u0106!\3\2\2\2"+
		"\u0107\u0108\7+\2\2\u0108\u0109\7\f\2\2\u0109\u010a\5$\23\2\u010a#\3\2"+
		"\2\2\u010b\u010c\b\23\1\2\u010c\u010d\7\r\2\2\u010d\u010e\5$\23\2\u010e"+
		"\u010f\7\16\2\2\u010f\u0134\3\2\2\2\u0110\u0134\5,\27\2\u0111\u0134\5"+
		"&\24\2\u0112\u0113\7*\2\2\u0113\u0114\7\25\2\2\u0114\u0134\7+\2\2\u0115"+
		"\u0116\7*\2\2\u0116\u0117\7\r\2\2\u0117\u0118\5 \21\2\u0118\u0119\7\16"+
		"\2\2\u0119\u0134\3\2\2\2\u011a\u011d\7*\2\2\u011b\u011d\5\34\17\2\u011c"+
		"\u011a\3\2\2\2\u011c\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\7\17"+
		"\2\2\u011f\u0120\5$\23\2\u0120\u0127\7\20\2\2\u0121\u0122\7\17\2\2\u0122"+
		"\u0123\5$\23\2\u0123\u0124\7\20\2\2\u0124\u0126\3\2\2\2\u0125\u0121\3"+
		"\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u0134\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\7\r\2\2\u012b\u012c\5\32"+
		"\16\2\u012c\u012d\7\16\2\2\u012d\u012e\5$\23\f\u012e\u0134\3\2\2\2\u012f"+
		"\u0130\7\26\2\2\u0130\u0134\5$\23\13\u0131\u0132\7!\2\2\u0132\u0134\5"+
		"$\23\7\u0133\u010b\3\2\2\2\u0133\u0110\3\2\2\2\u0133\u0111\3\2\2\2\u0133"+
		"\u0112\3\2\2\2\u0133\u0115\3\2\2\2\u0133\u011c\3\2\2\2\u0133\u012a\3\2"+
		"\2\2\u0133\u012f\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u015c\3\2\2\2\u0135"+
		"\u0136\f\n\2\2\u0136\u0137\t\4\2\2\u0137\u015b\5$\23\13\u0138\u0139\f"+
		"\t\2\2\u0139\u013a\t\5\2\2\u013a\u015b\5$\23\n\u013b\u013c\f\b\2\2\u013c"+
		"\u013d\t\6\2\2\u013d\u015b\5$\23\t\u013e\u013f\f\6\2\2\u013f\u0140\7\""+
		"\2\2\u0140\u015b\5$\23\7\u0141\u0142\f\5\2\2\u0142\u0143\7#\2\2\u0143"+
		"\u015b\5$\23\6\u0144\u0145\f\4\2\2\u0145\u0146\7$\2\2\u0146\u0147\5$\23"+
		"\2\u0147\u0148\7\f\2\2\u0148\u0149\5$\23\4\u0149\u015b\3\2\2\2\u014a\u014b"+
		"\f\3\2\2\u014b\u014c\7\b\2\2\u014c\u015b\5$\23\3\u014d\u014e\f\17\2\2"+
		"\u014e\u014f\7\17\2\2\u014f\u0150\5$\23\2\u0150\u0151\7\20\2\2\u0151\u015b"+
		"\3\2\2\2\u0152\u0153\f\16\2\2\u0153\u0154\7\r\2\2\u0154\u0155\5 \21\2"+
		"\u0155\u0156\7\16\2\2\u0156\u015b\3\2\2\2\u0157\u0158\f\r\2\2\u0158\u0159"+
		"\7\25\2\2\u0159\u015b\7+\2\2\u015a\u0135\3\2\2\2\u015a\u0138\3\2\2\2\u015a"+
		"\u013b\3\2\2\2\u015a\u013e\3\2\2\2\u015a\u0141\3\2\2\2\u015a\u0144\3\2"+
		"\2\2\u015a\u014a\3\2\2\2\u015a\u014d\3\2\2\2\u015a\u0152\3\2\2\2\u015a"+
		"\u0157\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2"+
		"\2\2\u015d%\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0164\7,\2\2\u0160\u0164"+
		"\7-\2\2\u0161\u0164\7.\2\2\u0162\u0164\7%\2\2\u0163\u015f\3\2\2\2\u0163"+
		"\u0160\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0162\3\2\2\2\u0164\'\3\2\2\2"+
		"\u0165\u016a\7\t\2\2\u0166\u0169\5*\26\2\u0167\u0169\5\4\3\2\u0168\u0166"+
		"\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a"+
		"\u016b\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u0171\7\n"+
		"\2\2\u016e\u016f\7\t\2\2\u016f\u0171\7\n\2\2\u0170\u0165\3\2\2\2\u0170"+
		"\u016e\3\2\2\2\u0171)\3\2\2\2\u0172\u0173\7&\2\2\u0173\u0174\7\r\2\2\u0174"+
		"\u0175\5$\23\2\u0175\u0176\7\16\2\2\u0176\u0177\5*\26\2\u0177\u018c\3"+
		"\2\2\2\u0178\u0179\7\'\2\2\u0179\u017a\7\r\2\2\u017a\u017b\5$\23\2\u017b"+
		"\u017c\7\16\2\2\u017c\u017f\5*\26\2\u017d\u017e\7(\2\2\u017e\u0180\5*"+
		"\26\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u018c\3\2\2\2\u0181"+
		"\u0183\7)\2\2\u0182\u0184\5$\23\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2"+
		"\2\2\u0184\u0185\3\2\2\2\u0185\u018c\7\7\2\2\u0186\u018c\5(\25\2\u0187"+
		"\u0188\5$\23\2\u0188\u0189\7\7\2\2\u0189\u018c\3\2\2\2\u018a\u018c\7\7"+
		"\2\2\u018b\u0172\3\2\2\2\u018b\u0178\3\2\2\2\u018b\u0181\3\2\2\2\u018b"+
		"\u0186\3\2\2\2\u018b\u0187\3\2\2\2\u018b\u018a\3\2\2\2\u018c+\3\2\2\2"+
		"\u018d\u018e\7+\2\2\u018e-\3\2\2\2/\62\64:@EIOW\\iuy\u0080\u0084\u0086"+
		"\u008c\u0092\u0099\u009f\u00ac\u00b3\u00ba\u00c2\u00c6\u00cc\u00d7\u00df"+
		"\u00e2\u00eb\u00f2\u00f9\u0101\u0105\u011c\u0127\u0133\u015a\u015c\u0163"+
		"\u0168\u016a\u0170\u017f\u0183\u018b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}