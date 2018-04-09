package expressions;

public abstract class AbstractBinaryOperator implements Expression {

    public Expression firstExpression;
    public Expression secondExpression;
    private  String op;

    public AbstractBinaryOperator(Expression firstExpression, Expression secondExpression, String op) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.op = op;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            AbstractBinaryOperator second = (AbstractBinaryOperator) obj;
            return (op.equals(second.op) && firstExpression.equals(second.firstExpression)
                    && secondExpression.equals(second.secondExpression));
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + firstExpression.hashCode();
        result = prime * result + secondExpression.hashCode();
        result = prime * result + op.hashCode();
        return result + op.hashCode();
    }

    @Override
    public String toString() {
        return "(" + firstExpression.toString() + op + secondExpression.toString() + ")";
    }

}