package expressions;

public abstract class AbstractUnaryOperator implements Expression {
    public Expression mainExpression;
    public Expression helpExpression;
    protected String op;

    public AbstractUnaryOperator(Expression mainExpression, String op) {
        this.mainExpression = mainExpression;
        this.helpExpression = null;
        this.op = op;
    }

    public AbstractUnaryOperator(Expression mainExpression, Expression helpExpression, String op) {
        this.mainExpression = mainExpression;
        this.helpExpression = helpExpression;
        this.op = op;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            AbstractUnaryOperator second = (AbstractUnaryOperator) obj;
            return (op.equals(second.op) && mainExpression.equals(second.mainExpression)
                    && ((helpExpression == null) || helpExpression.equals(second.helpExpression)));
            // i believe that there is no situations where it can produce NPE
        }
        return false;
    }
    @Override
    public int hashCode() {
        final int prime = 23;
        int result = 1;
        if (helpExpression != null) result = prime * result + helpExpression.hashCode();
        result = prime * result + mainExpression.hashCode();
        result = prime * result + op.hashCode();
        return result + op.hashCode();
    }
    @Override
    public String toString() {
        String result;
        if (helpExpression != null) {
            result = op + mainExpression.toString() + "(" + helpExpression.toString() + ")";
        } else {
            result = op + "(" + mainExpression.toString() + ")";
        }
        return result;
    }
}
