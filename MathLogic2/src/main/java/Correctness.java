import expressions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class Correctness {
    public boolean checkEqualStructure(Expression firstExp, Expression secondExp, HashMap<String, Expression> mapOfExpr) {
        if (firstExp == null || secondExp == null) return false;
        if (firstExp.getClass() == secondExp.getClass()) {
            if (firstExp instanceof AbstractBinaryOperator) {
                return checkEqualStructure(((AbstractBinaryOperator) firstExp).firstExpression,
                        ((AbstractBinaryOperator) secondExp).firstExpression, mapOfExpr) &&
                        checkEqualStructure(((AbstractBinaryOperator) firstExp).secondExpression,
                                ((AbstractBinaryOperator) secondExp).secondExpression, mapOfExpr);
            }

            if (firstExp instanceof Predicate) {
                if (((Predicate) firstExp).terms.size()
                        != ((Predicate) secondExp).terms.size() ||
                        !(((Predicate) firstExp).name.
                                equals(((Predicate) secondExp).name))) return false;
                boolean flag = true;
                for (int i = 0; i < ((Predicate) firstExp).terms.size(); i++) {
                    flag = checkEqualStructure(((Predicate) firstExp).terms.get(i),
                            ((Predicate) secondExp).terms.get(i), mapOfExpr);
                    if (!flag) break;
                }
                return flag;
            }

            if (firstExp instanceof Function) {
                if (((Function) firstExp).terms.size()
                        != ((Function) secondExp).terms.size() ||
                        !(((Function) firstExp).name.
                                equals(((Function) secondExp).name))) return false;
                boolean flag2 = true;
                for (int i = 0; i < ((Function) firstExp).terms.size(); i++) {
                    flag2 = checkEqualStructure(((Function) firstExp).terms.get(i),
                            ((Function) secondExp).terms.get(i), mapOfExpr);
                    if (!flag2) break;
                }
                return flag2;
            }

            if (firstExp instanceof AbstractUnaryOperator) {
                return checkEqualStructure(((AbstractUnaryOperator) firstExp).mainExpression,
                        ((AbstractUnaryOperator) secondExp).mainExpression, mapOfExpr)
                        && (((AbstractUnaryOperator) firstExp).helpExpression == null || checkEqualStructure(((AbstractUnaryOperator) firstExp).helpExpression,
                        ((AbstractUnaryOperator) secondExp).helpExpression, mapOfExpr));
            }

            if (firstExp instanceof Variable) {
                if (Character.isDigit(((Variable) firstExp).value.charAt(0))
                        && Character.isDigit(((Variable) secondExp).value.charAt(0))) {
                    return ((Variable) firstExp).value.equals(((Variable) secondExp).value);
                }
                if (((Variable) firstExp).value.equals(((Variable) secondExp).value)) {
                    if (!mapOfExpr.containsKey(((Variable) secondExp).value))
                        mapOfExpr.put(((Variable) firstExp).value, secondExp);
                    else return mapOfExpr.
                            get(((Variable) secondExp).value).toString().
                            equals(((Variable) firstExp).value);
                    return true;
                }

                String tmpName = ((Variable) secondExp).value;
                if (mapOfExpr.containsKey(tmpName)) {
                    return firstExp.equals(mapOfExpr.get(tmpName));
                }
                mapOfExpr.put(tmpName, firstExp);
                return true;
            }

        }
        if (secondExp instanceof Variable) {
            String tmpName = ((Variable) secondExp).value;
            if (mapOfExpr.containsKey(tmpName)) {
                return firstExp.equals(mapOfExpr.get(tmpName));
            }
            mapOfExpr.put(tmpName, firstExp);
            return true;
        }
        return false;
    }

    public int checkAxioms(Expression expr, List<Expression> axioms) {
        HashMap<String, Expression> mapForAxioms;
        Expression e = expr.getCopy();
        for (int i = 0; i < axioms.size(); i++) {
            Expression axiom = axioms.get(i);
            mapForAxioms = new HashMap<>();
            if (checkEqualStructure(e.getCopy(), axiom, mapForAxioms)) {
                return i + 1;
            }
        }

        mapForAxioms = new HashMap<>();
        if (e instanceof Implication && ((Implication) e).firstExpression instanceof Any) {
            Any any = (Any) ((Implication) e).firstExpression;
            Expression another = ((Implication) e).secondExpression;
            Variable var = ((Variable) any.mainExpression);
            if (checkEqualStructure(another,
                    any.helpExpression, mapForAxioms)) {
                if (isFreeForSubst(((Implication) e).firstExpression, var, mapForAxioms.get(var.value))) {
                    Expression tmpExpr = e.getCopy();
                    Expression tmp = substitution(((Implication) e).firstExpression, var, mapForAxioms.get(var.value));
                    e = tmpExpr;
                    if (another.equals(((Any) tmp).helpExpression)) {
                        Expression exp = mapForAxioms.get(var.value);
                        if (exp!= null && exp.equals(any.mainExpression) ||
                                checkQuant(any.helpExpression, var, false, false, exp)) {
                            return 0;
                        } else {
                            ProvingException.reason = ProvingException.Reasons.NOT_FREE_TO_SUBS;
                            ProvingException.list = new Expression[]{mapForAxioms.get(var.value), any, var};
                            checkEqualStructure(another,
                                    any.helpExpression, mapForAxioms);
                        }
                    }
                } else {
                    ProvingException.reason = ProvingException.Reasons.NOT_FREE_TO_SUBS;
                    ProvingException.list = new Expression[]{mapForAxioms.get(var.value), any, var};
                    checkEqualStructure(another,
                            any.helpExpression, mapForAxioms);
                }
            }
        }

        mapForAxioms = new HashMap<>();
        if (e instanceof Implication && ((Implication) e).secondExpression instanceof Exists
            && checkEqualStructure(((Implication) e).firstExpression,
                ((Exists) ((Implication) e).secondExpression).helpExpression, mapForAxioms)) {
            Exists exists = (Exists) ((Implication) e).secondExpression;
            Expression another = ((Implication) e).firstExpression;
            Variable var = ((Variable) exists.mainExpression);
            if (isFreeForSubst(exists, var, mapForAxioms.get(var.value))) {
                Expression tmp = substitution(exists, var, mapForAxioms.get(var.value));
                if (another.equals(((Exists) tmp).helpExpression)) {
                    Expression exp = mapForAxioms.get(var.value);
                    if (exp.equals(exists.mainExpression) ||
                            checkQuant(exists.helpExpression, var,false, false, exp)) {
                        return 0;
                    } else {
                        ProvingException.reason = ProvingException.Reasons.NOT_FREE_TO_SUBS;
                        ProvingException.list = new Expression[]{mapForAxioms.get(var.value), exists, var};
                    }
                }
            } else {

                ProvingException.reason = ProvingException.Reasons.NOT_FREE_TO_SUBS;
                ProvingException.list = new Expression[]{mapForAxioms.get(var.value), exists, var};
            }
        }
        return -1;
    }

    public boolean nineAxiomFA(Expression e) {
        if (e instanceof Implication && ((Implication) e).firstExpression instanceof And &&
                ((And) ((Implication) e).firstExpression).secondExpression instanceof Any) {

            HashMap<String, Expression> mapOfExp = new HashMap<>();
            if (checkEqualStructure(((And) ((Implication) e).firstExpression).firstExpression,
                    ((Implication) e).secondExpression, mapOfExp)) {
                Variable v = ((Variable) ((Any) ((And) ((Implication) e).firstExpression).secondExpression).mainExpression);
                if (mapOfExp.get(v.value) instanceof Variable && Character.isDigit(((Variable) mapOfExp.get(v.value)).value.charAt(0))) {
                    Expression tmpExpr = e.getCopy();
                    Expression subs = substitution(((Implication) tmpExpr).secondExpression,
                            v, mapOfExp.get(v.value));
                    if (subs.equals(((And) ((Implication) tmpExpr).firstExpression).firstExpression)) {
                        mapOfExp.clear();
                        Expression tmp = ((Any) ((And) ((Implication) tmpExpr).firstExpression).
                                secondExpression).helpExpression;
                        if (tmp instanceof Implication &&
                                checkEqualStructure(((Implication) tmp).secondExpression,
                                        ((Implication) tmp).firstExpression, mapOfExp)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public boolean checkForFreeInstances(Variable x, Expression expression) {
        if (expression instanceof Variable && expression.equals(x)) {
            return false;
        }
        if (expression instanceof AbstractBinaryOperator)
            return checkForFreeInstances(x, ((AbstractBinaryOperator) expression).firstExpression)
                    && checkForFreeInstances(x, ((AbstractBinaryOperator) expression).secondExpression);
        if (expression instanceof AbstractUnaryOperator) {
            if (((AbstractUnaryOperator) expression).helpExpression != null) {
                return ((AbstractUnaryOperator) expression).mainExpression.equals(x) ||
                        checkForFreeInstances(x, ((AbstractUnaryOperator) expression).helpExpression);
            }
            return (checkForFreeInstances(x, ((AbstractUnaryOperator) expression).mainExpression));
        }
        if (expression instanceof Predicate) {
            boolean flag = false;
            for (int i = 0; i < ((Predicate) expression).terms.size(); i++) {
                if (!(checkForFreeInstances(x, ((Predicate) expression).terms.get(i)))) {
                    flag = true;
                    break;
                }
            }
            return !flag;
        }
        if (expression instanceof Function) {
            boolean flag = false;
            for (int i = 0; i < ((Function) expression).terms.size(); i++) {
                if (!(checkForFreeInstances(x,
                        ((Function) expression).terms.get(i)))) {
                    flag = true;
                    break;
                }
            }
            return !flag;
        }
        return true;
    }

    private boolean isFreeForSubst(Expression expr, Variable var, Expression sub) {
        HashSet<String> freeVars = getFreeVars(sub, new HashSet<>());
        return isRecFree(((AbstractUnaryOperator) expr).helpExpression, var, freeVars, true);
    }

    private boolean isRecFree(Expression expr, Variable var, HashSet<String> freeVars, boolean noQuantOnFreeVar) {
        if (expr instanceof AbstractBinaryOperator) {
            return isRecFree(((AbstractBinaryOperator) expr).firstExpression, var, freeVars, noQuantOnFreeVar)
                    && isRecFree(((AbstractBinaryOperator) expr).secondExpression, var, freeVars, noQuantOnFreeVar);
        }
        if (expr instanceof AbstractUnaryOperator) {
            if (((AbstractUnaryOperator) expr).helpExpression != null) {
                Expression tmp = ((AbstractUnaryOperator) expr).mainExpression;
                String tmpString = tmp.toString();
                if (var.toString().equals(tmpString)) {
                    return noQuantOnFreeVar;
                }
                if (freeVars.contains(((Variable) ((AbstractUnaryOperator) expr).mainExpression).value)) {
                    return isRecFree(((AbstractUnaryOperator) expr).helpExpression, var, freeVars, false);
                }
            }
            return isRecFree(((AbstractUnaryOperator) expr).mainExpression, var, freeVars, noQuantOnFreeVar);
        }
        if (expr instanceof Predicate) {
            boolean result = true;
            for (Expression term : ((Predicate) expr).terms) {
                result &= isRecFree(term, var, freeVars, noQuantOnFreeVar);
            }
            return result;
        }
        if (expr instanceof Function) {
            boolean result = true;
            for (Expression term : ((Function) expr).terms) {
                result &= isRecFree(term, var, freeVars, noQuantOnFreeVar);
            }
            return result;
        }
        if (expr instanceof Variable) {
            if (((Variable) expr).value.equals(var.value)) {
                return noQuantOnFreeVar;
            }
        }
        return true;
    }

    private HashSet<String> getFreeVars(Expression exp, HashSet<String> quantors) {
        if (exp instanceof AbstractBinaryOperator) {
            HashSet<String> result = getFreeVars(((AbstractBinaryOperator) exp).firstExpression, new HashSet<>(quantors));
            result.addAll(getFreeVars(((AbstractBinaryOperator) exp).secondExpression, new HashSet<>(quantors)));
            return result;
        }
        if (exp instanceof AbstractUnaryOperator) {
            if (((AbstractUnaryOperator) exp).helpExpression != null) {
                quantors.add(((Variable) ((AbstractUnaryOperator) exp).mainExpression).value);
                return getFreeVars(((AbstractUnaryOperator) exp).helpExpression, quantors);
            }
            return getFreeVars(((AbstractUnaryOperator) exp).mainExpression, quantors);
        }
        if (exp instanceof Predicate) {
            HashSet<String> result = new HashSet<>();
            for (Expression term : ((Predicate) exp).terms) {
                result.addAll(getFreeVars(term, new HashSet<>(quantors)));
            }
            return result;
        }
        if (exp instanceof Function) {
            HashSet<String> result = new HashSet<>();
            for (Expression term : ((Function) exp).terms) {
                result.addAll(getFreeVars(term, new HashSet<>(quantors)));
            }
            return result;
        }
        if (exp instanceof Variable) {
            if (!quantors.contains(((Variable) exp).value)) {
                HashSet<String> result = new HashSet<>();
                result.add(((Variable) exp).value);
                return result;
            }
        }
        return new HashSet<>();
    }

    private boolean checkQuant(Expression e1, Variable v1, boolean bool1, boolean bool2, Expression e2) {
        if (e1 instanceof Variable && e1.equals(v1)) {
            return bool1 || !bool2;
        }
        if (e1 instanceof AbstractBinaryOperator)
            return checkQuant(((AbstractBinaryOperator) e1).firstExpression, v1, bool1, bool2, e2)
                    && checkQuant(((AbstractBinaryOperator) e1).secondExpression,
                    v1, bool1, bool2, e2);
        if (e1 instanceof AbstractUnaryOperator) {
            if (((AbstractUnaryOperator) e1).helpExpression != null) {
                if (((AbstractUnaryOperator) e1).mainExpression.equals(e2)) {
                    return checkQuant(((AbstractUnaryOperator) e1).helpExpression, v1, bool1, true, e2);
                }
                if (((AbstractUnaryOperator) e1).mainExpression.equals(v1)) {
                    return true;
                }
            } else {
                return (checkQuant(((AbstractUnaryOperator) e1).mainExpression,
                        v1, bool1, bool2, e2));
            }
        }
        if (e1 instanceof Predicate)
            return (!((Predicate) e1).terms.contains(v1)) || bool1 || !bool2;
        return !(e1 instanceof Function) ||
                ((Function) e1).terms.contains(v1) && !bool1 && bool2;
    }

    private Expression substitution(Expression expr, Variable var, Expression sub) {
        if (expr instanceof AbstractBinaryOperator) {
            ((AbstractBinaryOperator) expr).firstExpression =
                    substitution(((AbstractBinaryOperator) expr).firstExpression, var, sub);
            ((AbstractBinaryOperator) expr).secondExpression =
                    substitution(((AbstractBinaryOperator) expr).secondExpression, var, sub);
            return expr;
        }
        if (expr instanceof AbstractUnaryOperator) {
                if (((AbstractUnaryOperator) expr).helpExpression != null) {
//                    checkEqual(((AbstractUnaryOperator) expr).mainExpression, sub);
                    ((AbstractUnaryOperator) expr).helpExpression
                            = substitution(((AbstractUnaryOperator) expr).helpExpression, var, sub);
                    return expr;
                }
            ((AbstractUnaryOperator) expr).mainExpression
                    = substitution(((AbstractUnaryOperator) expr).mainExpression, var, sub);
            return expr;
        }
        if (expr instanceof Predicate) {
            ((Predicate) expr).terms = ((Predicate) expr).terms.stream()
                    .map(e -> substitution(e, var, sub))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        if (expr instanceof Function) {
            ArrayList<Expression> new_vars = new ArrayList<>();
            for (int i = 0; i < ((Function) expr).terms.size(); i++) {
                new_vars.add(substitution(((Function) expr).terms.get(i), var, sub));
            }
            ((Function) expr).terms = new_vars;
        }
        if (expr instanceof Variable)
            if (expr.equals(var))
                return sub;

        return expr;
    }

}
