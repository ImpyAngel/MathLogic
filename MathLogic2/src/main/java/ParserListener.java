// Generated from Parser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserParser}.
 */
public interface ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(ParserParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(ParserParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(ParserParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(ParserParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#proving}.
	 * @param ctx the parse tree
	 */
	void enterProving(ParserParser.ProvingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#proving}.
	 * @param ctx the parse tree
	 */
	void exitProving(ParserParser.ProvingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ParserParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ParserParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#dis}.
	 * @param ctx the parse tree
	 */
	void enterDis(ParserParser.DisContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#dis}.
	 * @param ctx the parse tree
	 */
	void exitDis(ParserParser.DisContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#con}.
	 * @param ctx the parse tree
	 */
	void enterCon(ParserParser.ConContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#con}.
	 * @param ctx the parse tree
	 */
	void exitCon(ParserParser.ConContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(ParserParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(ParserParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(ParserParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(ParserParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#exist}.
	 * @param ctx the parse tree
	 */
	void enterExist(ParserParser.ExistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#exist}.
	 * @param ctx the parse tree
	 */
	void exitExist(ParserParser.ExistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#any}.
	 * @param ctx the parse tree
	 */
	void enterAny(ParserParser.AnyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#any}.
	 * @param ctx the parse tree
	 */
	void exitAny(ParserParser.AnyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(ParserParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(ParserParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#acsiomvar}.
	 * @param ctx the parse tree
	 */
	void enterAcsiomvar(ParserParser.AcsiomvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#acsiomvar}.
	 * @param ctx the parse tree
	 */
	void exitAcsiomvar(ParserParser.AcsiomvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#pred}.
	 * @param ctx the parse tree
	 */
	void enterPred(ParserParser.PredContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#pred}.
	 * @param ctx the parse tree
	 */
	void exitPred(ParserParser.PredContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ParserParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ParserParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(ParserParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(ParserParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(ParserParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(ParserParser.MulContext ctx);
}