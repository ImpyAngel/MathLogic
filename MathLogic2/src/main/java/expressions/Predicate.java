package expressions;

import java.util.ArrayList;

public class Predicate implements Expression {
    public String name;
    public ArrayList<Expression> terms;
    public Predicate(String name, ArrayList<Expression> terms) {
        this.name = name;
        this.terms = terms;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Predicate) {
            Predicate that = (Predicate) obj;
            if (that.name.equals(name) && that.terms.size() == terms.size()) {
                for (int i = 0; i < terms.size(); i++) {
                    if (!that.terms.get(i).equals(terms.get(i))) return false;
                }
                return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (Expression term:terms) {
            result = prime * result + term.hashCode();
        }
        return result;
    }
    @Override
    public String toString() {
        String finalAns = name;
        if (!terms.isEmpty()) {
            finalAns += "(";
            for (int i = 0; i < terms.size() - 1; ++i) {
                finalAns += terms.get(i).toString() + ",";
            }
            finalAns += terms.get(terms.size() - 1) + ")";
        }
        return finalAns;
    }

    @Override
    public Expression getCopy() {
        ArrayList<Expression> newList = new ArrayList<>();
        for (Expression term : terms) {
            newList.add(term.getCopy());
        }
        return new Predicate(name, newList);
    }
}
