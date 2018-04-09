import expressions.*;
import javafx.util.Pair;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Toropin Konstantin (impy.bian@gmail.com)
 */
public class ParserFA {
    private static List<Expression> expressionList = new ArrayList<>();
    private static List<Expression> header = new ArrayList<>();
    public static Pair<List<Expression>,List<Expression>> parseFile(String fileName, boolean isAxioms) throws IOException {
        expressionList = new ArrayList<>();
        header = new ArrayList<>();
        ParserLexer lexer = new ParserLexer( new ANTLRFileStream(fileName));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserParser parser = new ParserParser(tokens);
        ParseTree tree;
        if (!isAxioms) {
            tree = parser.file();
        } else {
            tree = parser.proving();
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Listener(), tree);
        return new  Pair<>(header, expressionList);
    }
    private static class Listener extends ParserBaseListener {
        private String digitsToString(List list) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Object obj : list) {
                stringBuilder.append(obj);
            }
            return stringBuilder.toString();
        }
        Expression handleExpr(ParseTree ctx) {
            if (ctx instanceof ParserParser.NotContext) return new Not(handleExpr(ctx.getChild(1)));
            if (ctx instanceof ParserParser.VarContext) {
                ParserParser.VarContext var = (ParserParser.VarContext) ctx;
                return new Variable(var.LOWERCASE() + digitsToString(var.DIGITS()));
            }
            if (ctx instanceof ParserParser.PredContext) {
                ParserParser.PredContext pred = (ParserParser.PredContext) ctx;
                if (pred.UPPERCASE() != null) {
                    String name = pred.UPPERCASE() + digitsToString(pred.DIGITS());
                    ArrayList<Expression> preds = new ArrayList<>();
                    for (ParseTree tree: pred.term()) {
                        preds.add(handleExpr(tree));
                    }
                    return new Predicate(name, preds);
                } else {
                    if (pred.acsiomvar() != null) return new Variable(pred.acsiomvar().UPPERCASE() + digitsToString(pred.acsiomvar().DIGITS()));
                    return new Equatation(handleExpr(ctx.getChild(0)), handleExpr(ctx.getChild(2)));
                }
            }
            if (ctx instanceof ParserParser.MulContext) {
                ParserParser.MulContext function = (ParserParser.MulContext) ctx;
                if (function.LOWERCASE() != null) {
                    String name = function.LOWERCASE() + digitsToString(function.DIGITS());
                    ArrayList<Expression> preds = new ArrayList<>();
                    for (ParseTree tree: function.term()) {
                        preds.add(handleExpr(tree));
                    }
                    return new Function(name, preds);
                }
                if (function.mul() != null) return new Increment(handleExpr(function.mul()));
                if (function.var() != null) return handleExpr(function.var());
                if (!function.term().isEmpty()) return handleExpr(function.term(0));
                return new Variable("0");
            }

            if (ctx.getChildCount() == 1) {
                return handleExpr(ctx.getChild(0));
            }
            if (ctx.getChildCount() == 3) {
                if (ctx instanceof ParserParser.ExprContext)
                    return new Implication(handleExpr(ctx.getChild(0)), handleExpr(ctx.getChild(2)));
                if (ctx instanceof ParserParser.DisContext)
                    return new Or(handleExpr(ctx.getChild(0)), handleExpr(ctx.getChild(2)));
                if (ctx instanceof ParserParser.ConContext)
                    return new And(handleExpr(ctx.getChild(0)), handleExpr(ctx.getChild(2)));
                if (ctx instanceof ParserParser.ExistContext)
                    return new Exists(handleExpr(ctx.getChild(1)), handleExpr(ctx.getChild(2)));
                if (ctx instanceof ParserParser.AnyContext)
                    return new Any(handleExpr(ctx.getChild(1)), handleExpr(ctx.getChild(2)));
                if (ctx instanceof ParserParser.TermContext)
                    return new Add(handleExpr(ctx.getChild(0)), handleExpr(ctx.getChild(2)));
                if (ctx instanceof ParserParser.AddContext)
                    return new Multiply(handleExpr(ctx.getChild(0)), handleExpr(ctx.getChild(2)));
                if (ctx instanceof ParserParser.UnaryContext)
                    return handleExpr(ctx.getChild(1));
            }
            assert false;
            return null;

        }
        @Override
        public void exitProving(ParserParser.ProvingContext ctx) {
            for (ParseTree expr : ctx.expr()) {
                if (expr!= null) expressionList.add(handleExpr(expr));
            }
        }

        @Override
        public void exitHeader(ParserParser.HeaderContext ctx) {
            for (ParseTree expr : ctx.expr()) {
                if (expr != null) header.add(handleExpr(expr));
            }

        }
    }
}
