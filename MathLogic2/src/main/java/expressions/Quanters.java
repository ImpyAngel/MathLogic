package expressions;

/**
 * @autor Toropin Konstantin (impy.bian@gmail.com)
 */
abstract public class Quanters extends AbstractUnaryOperator {
    public Quanters(Expression mainExpression, Expression helpExpression, String op) {
        super(mainExpression, helpExpression, op);
    }
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            Quanters second = (Quanters) obj;
            return (op.equals(second.op) && mainExpression.equals(second.mainExpression)
             && helpExpression.equals(second.helpExpression));
        }
        return false;
    }
    @Override
    public int hashCode() {
        final int prime = 19;
        int result = 1;
        result = prime * result + mainExpression.hashCode();
        result = prime * result + helpExpression.hashCode();
        result = prime * result + op.hashCode();
        return result + op.hashCode();
    }
}
