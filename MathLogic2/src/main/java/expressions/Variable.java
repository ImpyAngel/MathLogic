package expressions;

public class Variable implements Expression {
    public String value;

    public Variable(String value) {this.value = value;}

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Variable) {
            return value.equals(((Variable)obj).value);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    @Override
    public Expression getCopy() {
        return new Variable(value);
    }
}
