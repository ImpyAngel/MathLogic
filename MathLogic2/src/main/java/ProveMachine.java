import expressions.*;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @autor Toropin Konstantin (impy.bian@gmail.com)
 */
public class ProveMachine {

    private final String input;
    private final String output;
    private final Correctness correctness;
    private final String AXIOMS = "axioms.txt";
    private final String ANY = "deductions/anyDeduction.txt";
    private final String EXISTS = "deductions/existsDeduction.txt";

    private Set<Expression> header;
    private List<Expression> approvals;
    private List<Expression> axioms;
    private Expression beta;
    private Expression alpha;
    private Set<Expression> goodApprovals;
    private Set<Implication> goodImpls;

    private Map<Expression, Integer> goodApprovalsForHW1;
    private Map<Expression, List<Implication>> goodImplsMap;

    public ProveMachine(String input, String output, Correctness correctness) {
        this.input = input;
        this.output = output;
        this.correctness = correctness;
        goodImpls = new HashSet<>();
        goodApprovals = new HashSet<>();
        goodApprovalsForHW1 = new HashMap<>();
        goodImplsMap = new HashMap<>();
    }

    private Implication modusPonens(Expression expr) {
        if (goodImplsMap.get(expr) != null) {
            for (Implication impl : goodImplsMap.get(expr)) {
                if (impl.secondExpression.equals(expr) && goodApprovals.contains(impl.firstExpression)) return impl;
            }
        }
        return null;
    }

    /**
     * @return isAny or null if don't correct mp
     */
    private Boolean modusPonensAnyOrExist(Expression expr) {
        boolean isAny = true;
        if (expr instanceof Implication) {
            Expression first = ((Implication) expr).firstExpression;
            Expression second = ((Implication) expr).secondExpression;
            Variable var;
            Expression fi;
            Expression psi;
            if (first instanceof Exists) {
                var = (Variable) ((Exists) first).mainExpression;
                fi = ((Exists) first).helpExpression;
                psi = second;
                isAny = false;

                if (!correctness.checkForFreeInstances(var, psi)) {
                    ProvingException.reason = ProvingException.Reasons.IS_FREE;
                    ProvingException.list = new Expression[]{var, psi};
                    return null;
                }
            } else {
                if (second instanceof Any) {
                    var = (Variable) ((Any) second).mainExpression;
                    fi = first;
                    psi = ((Any) second).helpExpression;
                    if (!correctness.checkForFreeInstances(var, fi)) {
                        ProvingException.reason = ProvingException.Reasons.IS_FREE;
                        ProvingException.list = new Expression[]{var, fi};
                        return null;
                    }
                } else {
                    return null;
                }
            }
            if (!correctness.checkForFreeInstances(var, alpha)) {
                ProvingException.reason = ProvingException.Reasons.NOT_FREE;
                ProvingException.list = new Expression[]{var, alpha};
                return null;
            }
            if (goodImpls.contains(new Implication(fi, psi))) return isAny;
        }
        return null;
    }

    private String writeHeader(List<Expression> headerList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Expression header : headerList) {
            stringBuilder.append(header.toString());
        }
        stringBuilder.append("|-")
                .append(alpha)
                .append("->")
                .append(beta)
                .append('\n');
        return stringBuilder.toString();
    }

    private String writeAlpha() {
        String ax1 = "(" + alpha + ")->(" + alpha + ")->(" + alpha + ")";
        return ax1 + '\n' +
                "(" + ax1 + ")->((" + alpha + ")->(((" + alpha + ")->(" +
                alpha + "))->(" + alpha + ")))->((" + alpha + ")->(" + alpha + "))" +
                '\n' +
                "((" + alpha + ")->(((" + alpha + ")->(" + alpha + "))->(" +
                alpha + ")))->((" + alpha + ")->(" + alpha + "))" +
                '\n' +
                "((" + alpha + ")->(((" + alpha + ")->(" +
                alpha + "))->(" + alpha + ")))" +
                '\n' +
                "(" + alpha + ")->(" + alpha + ")" + '\n';

    }


    private String writerMP(Implication impl, Expression expr) {
        Expression b = impl.firstExpression;
        return "((" + alpha + ")->(" + b + "))->((" + alpha + ")->(" + impl + "))->((" + alpha + ")->(" + expr + "))" +
                '\n' +
                "((" + alpha + ")->(" + impl + "))->((" + alpha + ")->(" + expr + "))" +
                '\n' +
                "(" + alpha + ")->(" + expr + ")" + '\n';
    }

    private String writeHandle(Expression expr) {
        return expr.toString() + '\n' +
                "(" + expr + ")->(" + alpha + ")->(" + expr + ")" + '\n' +
                "(" + alpha + ")->(" + expr + ")" + '\n';
    }

    private String writerNewNP(Implication expr, boolean isAny) {
        StringBuilder stringBuilder = new StringBuilder();
        String path;
        Expression B;
        Expression C;
        Expression x;
        if (isAny) {
            path = ANY;
            B = expr.firstExpression;
            C = ((Any) expr.secondExpression).helpExpression;
            x = ((Any) expr.secondExpression).mainExpression;
        } else {
            path = EXISTS;
            B = ((Exists) expr.firstExpression).helpExpression;
            C = expr.secondExpression;
            x = ((Exists) expr.firstExpression).mainExpression;
        }
        try (Scanner in = new Scanner(new File(path))) {
            while (in.hasNext()) {
                String str = in.next();
                str = str.replace("_A", "(" + alpha + ")");
                str = str.replace("_B", "(" + B + ")");
                str = str.replace("_C", "(" + C + ")");
                str = str.replace("_x", x.toString());
                stringBuilder.append(str).append('\n');
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void runHW2() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File(output))) {
            try {
                Pair<List<Expression>, List<Expression>> pair = ParserFA.parseFile(AXIOMS, true);
                axioms = pair.getValue();
                pair = ParserFA.parseFile(input, false);
                List<Expression> headerList = pair.getKey();
                beta = headerList.remove(headerList.size() - 1);
                alpha = headerList.remove(headerList.size() - 1);
                header = new HashSet<>(headerList);
                approvals = pair.getValue();
                writer.write(writeHeader(headerList));
                for (int i = 0; i < approvals.size(); i++) {
                    Expression expr = approvals.get(i);
                    if (alpha.equals(expr)) {
                        writer.write(writeAlpha());
                    } else {
                        if (correctness.checkAxioms(expr, axioms) != -1 ||
                                correctness.nineAxiomFA(expr) || header.contains(expr)) {
                            writer.write(writeHandle(expr));
                        } else {
                            Implication impl = modusPonens(expr);
                            if (impl != null) {
                                writer.write(writerMP(impl, expr));
                            } else {
                                Boolean isAny = modusPonensAnyOrExist(expr);
                                if (isAny != null) {
                                    writer.write(writerNewNP((Implication) expr, isAny));
                                } else {
                                    throw new ProvingException(i + 1, expr);
                                }
                            }
                        }
                    }
                    goodApprovals.add(expr);
                    goodApprovalsForHW1.put(expr, i + 1);
                    if (expr instanceof Implication) {
                        goodImpls.add((Implication) expr);
                        Expression ex = ((Implication) expr).secondExpression;
                        if (!goodImplsMap.containsKey(ex)) goodImplsMap.put(ex, new ArrayList<>());
                        goodImplsMap.get(ex).add((Implication)expr);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ProvingException e) {
                //Todo it's really bad hack, need more IQ
                writer.close();
                PrintWriter writer2 = new PrintWriter(new File(output));
                writer2.write(e.getMessage());
                writer2.close();
            }
        }
    }

    public void runHW1() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File(output))) {
            try {
                Pair<List<Expression>, List<Expression>> pair = ParserFA.parseFile(AXIOMS, true);
                axioms = pair.getValue();
                pair = ParserFA.parseFile(input, false);
                List<Expression> headerList = pair.getKey();
                approvals = pair.getValue();
                for (int i = 0; i < approvals.size(); i++) {
                    Expression expr = approvals.get(i);
                    String annotation;
                    int val = correctness.checkAxioms(expr, axioms);
                    if (val != -1) {
                        annotation = "Сх. акс. " + val;
                    } else {
                        if (headerList.contains(expr)) {
                            annotation = "Предп. " + headerList.indexOf(expr);
                        } else {
                            Implication impl = modusPonens(expr);
                            if (impl != null) {
                                int jj = goodApprovalsForHW1.get(impl);
                                int ii = goodApprovalsForHW1.get(impl.firstExpression);
                                annotation = "M.P." + ii + " " + jj;
                            } else {
                                annotation = "Не доказано";
                            }
                        }
                    }
                    writer.write("(" + (i + 1) + ") " + expr + " (" + annotation + ")\n");
                    goodApprovals.add(expr);
                    goodApprovalsForHW1.put(expr, i + 1);
                    if (expr instanceof Implication) {
                        goodImpls.add((Implication) expr);
                        Expression ex = ((Implication) expr).secondExpression;
                        if (!goodImplsMap.containsKey(ex)) {
                            goodImplsMap.put(ex, new ArrayList<>());
                        }
                        goodImplsMap.get(ex).add((Implication)expr);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
