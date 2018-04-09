import expressions.Expression;

/**
 * @autor Toropin Konstantin (impy.bian@gmail.com)
 */
public class ProvingException extends Exception {
    public enum Reasons{
        NOT_FREE_TO_SUBS, NOT_FREE, IS_FREE, NO_REASON
    }
    public static Reasons reason = Reasons.NO_REASON;
    public static Expression[] list;
    private final int index;
    private final Expression expr;

    public ProvingException(int index, Expression expr) {
        this.index = index;
        this.expr = expr;
    }

    @Override
    public String getMessage() {
        String ans = "Вывод некорректен, начиная с формулы номер " + index + " выражение "+ expr.toString() + "\n[: ";
        switch (reason) {
            case NOT_FREE_TO_SUBS:
                return ans + String.format("терм %1s не свободен для подстановки в формулу %2s вместо переменной %3s]",
                        list[0].toString(), list[1].toString(), list[2].toString());
            case IS_FREE:
                return ans + String.format("переменная %1s входит свободно в формулу %2s]",
                        list[0].toString(), list[1].toString());
            case NOT_FREE:
                return ans + String.format("используется правило с квантором по переменной %1s, входящей свободно в допущение %2s]",
                        list[0].toString(), list[1].toString());
            default:
                return ans + "нет подходящего правила для вывода строки " + expr.toString() + "]";
        }
    }
}
