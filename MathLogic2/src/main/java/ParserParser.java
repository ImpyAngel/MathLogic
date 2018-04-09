// Generated from Parser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, WS=17, 
		LOWERCASE=18, UPPERCASE=19, DIGITS=20;
	public static final int
		RULE_file = 0, RULE_header = 1, RULE_proving = 2, RULE_expr = 3, RULE_dis = 4, 
		RULE_con = 5, RULE_unary = 6, RULE_not = 7, RULE_exist = 8, RULE_any = 9, 
		RULE_var = 10, RULE_acsiomvar = 11, RULE_pred = 12, RULE_term = 13, RULE_add = 14, 
		RULE_mul = 15;
	public static final String[] ruleNames = {
		"file", "header", "proving", "expr", "dis", "con", "unary", "not", "exist", 
		"any", "var", "acsiomvar", "pred", "term", "add", "mul"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\n'", "','", "'|-'", "'->'", "'|'", "'&'", "'('", "')'", "'!'", 
		"'?'", "'@'", "'='", "'+'", "'*'", "'0'", "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "WS", "LOWERCASE", "UPPERCASE", "DIGITS"
	};
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
	public String getGrammarFileName() { return "Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public ProvingContext proving() {
			return getRuleContext(ProvingContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			header();
			setState(33);
			match(T__0);
			setState(34);
			proving();
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

	public static class HeaderContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(36);
					expr();
					setState(37);
					match(T__1);
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(44);
			expr();
			setState(45);
			match(T__2);
			setState(46);
			expr();
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

	public static class ProvingContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EOF() { return getToken(ParserParser.EOF, 0); }
		public ProvingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proving; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterProving(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitProving(this);
		}
	}

	public final ProvingContext proving() throws RecognitionException {
		ProvingContext _localctx = new ProvingContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_proving);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__14) | (1L << LOWERCASE) | (1L << UPPERCASE))) != 0)) {
				{
				{
				setState(48);
				expr();
				setState(49);
				match(T__0);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(56);
				match(EOF);
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

	public static class ExprContext extends ParserRuleContext {
		public DisContext dis() {
			return getRuleContext(DisContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				dis(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				dis(0);
				setState(61);
				match(T__3);
				setState(62);
				expr();
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

	public static class DisContext extends ParserRuleContext {
		public ConContext con() {
			return getRuleContext(ConContext.class,0);
		}
		public DisContext dis() {
			return getRuleContext(DisContext.class,0);
		}
		public DisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterDis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitDis(this);
		}
	}

	public final DisContext dis() throws RecognitionException {
		return dis(0);
	}

	private DisContext dis(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DisContext _localctx = new DisContext(_ctx, _parentState);
		DisContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_dis, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(67);
			con(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DisContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_dis);
					setState(69);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(70);
					match(T__4);
					setState(71);
					con(0);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class ConContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public ConContext con() {
			return getRuleContext(ConContext.class,0);
		}
		public ConContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_con; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterCon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitCon(this);
		}
	}

	public final ConContext con() throws RecognitionException {
		return con(0);
	}

	private ConContext con(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConContext _localctx = new ConContext(_ctx, _parentState);
		ConContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_con, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(78);
			unary();
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_con);
					setState(80);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(81);
					match(T__5);
					setState(82);
					unary();
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class UnaryContext extends ParserRuleContext {
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AnyContext any() {
			return getRuleContext(AnyContext.class,0);
		}
		public ExistContext exist() {
			return getRuleContext(ExistContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unary);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				pred();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				not();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(T__6);
				setState(91);
				expr();
				setState(92);
				match(T__7);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				any();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				exist();
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

	public static class NotContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitNot(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__8);
			setState(99);
			unary();
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

	public static class ExistContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public ExistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterExist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitExist(this);
		}
	}

	public final ExistContext exist() throws RecognitionException {
		ExistContext _localctx = new ExistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_exist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__9);
			setState(102);
			var();
			setState(103);
			unary();
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

	public static class AnyContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public AnyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterAny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitAny(this);
		}
	}

	public final AnyContext any() throws RecognitionException {
		AnyContext _localctx = new AnyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_any);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__10);
			setState(106);
			var();
			setState(107);
			unary();
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode LOWERCASE() { return getToken(ParserParser.LOWERCASE, 0); }
		public List<TerminalNode> DIGITS() { return getTokens(ParserParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(ParserParser.DIGITS, i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_var);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(LOWERCASE);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(110);
					match(DIGITS);
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class AcsiomvarContext extends ParserRuleContext {
		public TerminalNode UPPERCASE() { return getToken(ParserParser.UPPERCASE, 0); }
		public List<TerminalNode> DIGITS() { return getTokens(ParserParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(ParserParser.DIGITS, i);
		}
		public AcsiomvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acsiomvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterAcsiomvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitAcsiomvar(this);
		}
	}

	public final AcsiomvarContext acsiomvar() throws RecognitionException {
		AcsiomvarContext _localctx = new AcsiomvarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_acsiomvar);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(UPPERCASE);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(117);
					match(DIGITS);
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class PredContext extends ParserRuleContext {
		public TerminalNode UPPERCASE() { return getToken(ParserParser.UPPERCASE, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> DIGITS() { return getTokens(ParserParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(ParserParser.DIGITS, i);
		}
		public AcsiomvarContext acsiomvar() {
			return getRuleContext(AcsiomvarContext.class,0);
		}
		public PredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterPred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitPred(this);
		}
	}

	public final PredContext pred() throws RecognitionException {
		PredContext _localctx = new PredContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pred);
		int _la;
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(UPPERCASE);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DIGITS) {
					{
					{
					setState(124);
					match(DIGITS);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(130);
				match(T__6);
				setState(131);
				term(0);
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(132);
					match(T__1);
					setState(133);
					term(0);
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(139);
				match(T__7);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				term(0);
				setState(142);
				match(T__11);
				setState(143);
				term(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				acsiomvar();
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

	public static class TermContext extends ParserRuleContext {
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(149);
			add(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(151);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(152);
					match(T__12);
					setState(153);
					add(0);
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class AddContext extends ParserRuleContext {
		public MulContext mul() {
			return getRuleContext(MulContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitAdd(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		return add(0);
	}

	private AddContext add(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddContext _localctx = new AddContext(_ctx, _parentState);
		AddContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_add, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(160);
			mul(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_add);
					setState(162);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(163);
					match(T__13);
					setState(164);
					mul(0);
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class MulContext extends ParserRuleContext {
		public TerminalNode LOWERCASE() { return getToken(ParserParser.LOWERCASE, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> DIGITS() { return getTokens(ParserParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(ParserParser.DIGITS, i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public MulContext mul() {
			return getRuleContext(MulContext.class,0);
		}
		public MulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitMul(this);
		}
	}

	public final MulContext mul() throws RecognitionException {
		return mul(0);
	}

	private MulContext mul(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulContext _localctx = new MulContext(_ctx, _parentState);
		MulContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_mul, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(171);
				match(LOWERCASE);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DIGITS) {
					{
					{
					setState(172);
					match(DIGITS);
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(178);
				match(T__6);
				setState(179);
				term(0);
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(180);
					match(T__1);
					setState(181);
					term(0);
					}
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(187);
				match(T__7);
				}
				break;
			case 2:
				{
				setState(189);
				var();
				}
				break;
			case 3:
				{
				setState(190);
				match(T__6);
				setState(191);
				term(0);
				setState(192);
				match(T__7);
				}
				break;
			case 4:
				{
				setState(194);
				match(T__14);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mul);
					setState(197);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(198);
					match(T__15);
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return dis_sempred((DisContext)_localctx, predIndex);
		case 5:
			return con_sempred((ConContext)_localctx, predIndex);
		case 13:
			return term_sempred((TermContext)_localctx, predIndex);
		case 14:
			return add_sempred((AddContext)_localctx, predIndex);
		case 15:
			return mul_sempred((MulContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dis_sempred(DisContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean con_sempred(ConContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean add_sempred(AddContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mul_sempred(MulContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u00cf\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\7\4\66\n\4\f\4\16\49\13\4\3\4\5\4<\n\4\3\5\3\5\3\5\3\5\3\5\5\5C\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7V\n\7\f\7\16\7Y\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bc\n\b\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\7\fr\n\f\f\f\16"+
		"\fu\13\f\3\r\3\r\7\ry\n\r\f\r\16\r|\13\r\3\16\3\16\7\16\u0080\n\16\f\16"+
		"\16\16\u0083\13\16\3\16\3\16\3\16\3\16\7\16\u0089\n\16\f\16\16\16\u008c"+
		"\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0095\n\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\7\17\u009d\n\17\f\17\16\17\u00a0\13\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\7\20\u00a8\n\20\f\20\16\20\u00ab\13\20\3\21\3\21\3"+
		"\21\7\21\u00b0\n\21\f\21\16\21\u00b3\13\21\3\21\3\21\3\21\3\21\7\21\u00b9"+
		"\n\21\f\21\16\21\u00bc\13\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5"+
		"\21\u00c6\n\21\3\21\3\21\7\21\u00ca\n\21\f\21\16\21\u00cd\13\21\3\21\2"+
		"\7\n\f\34\36 \22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u00d6\2"+
		"\"\3\2\2\2\4+\3\2\2\2\6\67\3\2\2\2\bB\3\2\2\2\nD\3\2\2\2\fO\3\2\2\2\16"+
		"b\3\2\2\2\20d\3\2\2\2\22g\3\2\2\2\24k\3\2\2\2\26o\3\2\2\2\30v\3\2\2\2"+
		"\32\u0094\3\2\2\2\34\u0096\3\2\2\2\36\u00a1\3\2\2\2 \u00c5\3\2\2\2\"#"+
		"\5\4\3\2#$\7\3\2\2$%\5\6\4\2%\3\3\2\2\2&\'\5\b\5\2\'(\7\4\2\2(*\3\2\2"+
		"\2)&\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\5\b\5"+
		"\2/\60\7\5\2\2\60\61\5\b\5\2\61\5\3\2\2\2\62\63\5\b\5\2\63\64\7\3\2\2"+
		"\64\66\3\2\2\2\65\62\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28;\3"+
		"\2\2\29\67\3\2\2\2:<\7\2\2\3;:\3\2\2\2;<\3\2\2\2<\7\3\2\2\2=C\5\n\6\2"+
		">?\5\n\6\2?@\7\6\2\2@A\5\b\5\2AC\3\2\2\2B=\3\2\2\2B>\3\2\2\2C\t\3\2\2"+
		"\2DE\b\6\1\2EF\5\f\7\2FL\3\2\2\2GH\f\3\2\2HI\7\7\2\2IK\5\f\7\2JG\3\2\2"+
		"\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\13\3\2\2\2NL\3\2\2\2OP\b\7\1\2PQ\5\16"+
		"\b\2QW\3\2\2\2RS\f\3\2\2ST\7\b\2\2TV\5\16\b\2UR\3\2\2\2VY\3\2\2\2WU\3"+
		"\2\2\2WX\3\2\2\2X\r\3\2\2\2YW\3\2\2\2Zc\5\32\16\2[c\5\20\t\2\\]\7\t\2"+
		"\2]^\5\b\5\2^_\7\n\2\2_c\3\2\2\2`c\5\24\13\2ac\5\22\n\2bZ\3\2\2\2b[\3"+
		"\2\2\2b\\\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\17\3\2\2\2de\7\13\2\2ef\5\16\b"+
		"\2f\21\3\2\2\2gh\7\f\2\2hi\5\26\f\2ij\5\16\b\2j\23\3\2\2\2kl\7\r\2\2l"+
		"m\5\26\f\2mn\5\16\b\2n\25\3\2\2\2os\7\24\2\2pr\7\26\2\2qp\3\2\2\2ru\3"+
		"\2\2\2sq\3\2\2\2st\3\2\2\2t\27\3\2\2\2us\3\2\2\2vz\7\25\2\2wy\7\26\2\2"+
		"xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\31\3\2\2\2|z\3\2\2\2}\u0081"+
		"\7\25\2\2~\u0080\7\26\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3"+
		"\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0085\7\t\2\2\u0085\u008a\5\34\17\2\u0086\u0087\7\4\2\2\u0087\u0089\5"+
		"\34\17\2\u0088\u0086\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7\n"+
		"\2\2\u008e\u0095\3\2\2\2\u008f\u0090\5\34\17\2\u0090\u0091\7\16\2\2\u0091"+
		"\u0092\5\34\17\2\u0092\u0095\3\2\2\2\u0093\u0095\5\30\r\2\u0094}\3\2\2"+
		"\2\u0094\u008f\3\2\2\2\u0094\u0093\3\2\2\2\u0095\33\3\2\2\2\u0096\u0097"+
		"\b\17\1\2\u0097\u0098\5\36\20\2\u0098\u009e\3\2\2\2\u0099\u009a\f\3\2"+
		"\2\u009a\u009b\7\17\2\2\u009b\u009d\5\36\20\2\u009c\u0099\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\35\3\2\2"+
		"\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\b\20\1\2\u00a2\u00a3\5 \21\2\u00a3"+
		"\u00a9\3\2\2\2\u00a4\u00a5\f\3\2\2\u00a5\u00a6\7\20\2\2\u00a6\u00a8\5"+
		" \21\2\u00a7\u00a4\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\37\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\b\21\1"+
		"\2\u00ad\u00b1\7\24\2\2\u00ae\u00b0\7\26\2\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\7\t\2\2\u00b5\u00ba\5\34\17\2\u00b6"+
		"\u00b7\7\4\2\2\u00b7\u00b9\5\34\17\2\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3"+
		"\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00be\7\n\2\2\u00be\u00c6\3\2\2\2\u00bf\u00c6\5\26"+
		"\f\2\u00c0\u00c1\7\t\2\2\u00c1\u00c2\5\34\17\2\u00c2\u00c3\7\n\2\2\u00c3"+
		"\u00c6\3\2\2\2\u00c4\u00c6\7\21\2\2\u00c5\u00ac\3\2\2\2\u00c5\u00bf\3"+
		"\2\2\2\u00c5\u00c0\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00cb\3\2\2\2\u00c7"+
		"\u00c8\f\3\2\2\u00c8\u00ca\7\22\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3"+
		"\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc!\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\24+\67;BLWbsz\u0081\u008a\u0094\u009e\u00a9\u00b1\u00ba\u00c5"+
		"\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}