package expressions;

public class Exists extends Quanters {
    public Exists(Expression mainExpression, Expression helpExpression) {super(mainExpression, helpExpression, "?");}

    @Override
    public Expression getCopy() {
        return new Exists(mainExpression.getCopy(), helpExpression.getCopy());
    }
}
