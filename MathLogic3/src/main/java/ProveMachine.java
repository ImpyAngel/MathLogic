import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @autor Toropin Konstantin (impy.bian@gmail.com)
 */

public class ProveMachine {
    private final File output;
    private final String COMMUTATIVITY = "prove_templates/commutativity.txt";
    private final String DELETE_ZERO = "prove_templates/delete_zero.txt";
    private final String ASSOC_INC = "prove_templates/assoc_inc.txt";
    private final String NOT_EXISTS = "prove_templates/not_exists.txt";
    public ProveMachine(String output) {
        this.output = new File(output);
    }

    public void evaluate(int a, int b) {
        try (PrintWriter writer = new PrintWriter(output)) {
            if (b >= a) {
                int c = b - a;
                StringBuilder Ab = new StringBuilder("0");
                StringBuilder Bb = new StringBuilder("0");
                StringBuilder Cb = new StringBuilder("");
                for (int i = 0; i < b; i++) {
                    if (i < c) {
                        Cb.append("'");
                    }
                    if (i < a) {
                        Ab.append("'");
                    }
                    Bb.append("'");
                }
                String A = Ab.toString();
                String B = Bb.toString();
                String C = Cb.toString();
                writer.println("W|-?p(" + A + "+p)=" + B);
                try (Scanner scanner = new Scanner(new File(COMMUTATIVITY))) {
                    while (scanner.hasNext()) {
                        writer.println(scanner.nextLine());
                    }
                }
                writer.println("@a(a+0=a)->" + A + "+0=" + A);
                writer.println(A + "+0=" + A);
                for (String i = ""; i.length() < c; i += "'") {

                    try (Scanner scanner = new Scanner(new File(DELETE_ZERO))) {
                        while (scanner.hasNext()) {
                            writer.println(scanner.nextLine().replaceAll("A", A).replaceAll("_", i));
                        }
                    }
                }
                writer.println("(" + A + "+0" + C + ")=" + B + "->?p(" + A + "+p)=" + B + "\n" + "?p(" + A + "+p)=" + B);
            } else {
                StringBuilder Ab = new StringBuilder("0");
                StringBuilder Bb = new StringBuilder("0");
                for (int i = 0; i < a; i++) {
                    if (i < b) {
                        Bb.append("'");
                    }
                    Ab.append("'");
                }
                String A = Ab.toString();
                StringBuilder B = new StringBuilder(Bb.toString());
                writer.println("W|-!?p(" + A + "+p)=" + B );
                try (Scanner scanner = new Scanner(new File(ASSOC_INC))) {
                    while (scanner.hasNext()) {
                        writer.println(scanner.nextLine());
                    }
                }
                int c = a - b;
                B = new StringBuilder();
                StringBuilder C = new StringBuilder();
                for (int i = 0; i < c - 1; i++) {
                    if (i < b) {
                        B.append("'");
                    }
                    C.append("'");
                }
                if (c - 1 < b) {
                    for (int i = c - 1; i < b; i++) {
                        B.append("'");
                    }
                }
                try (Scanner scanner = new Scanner(new File(NOT_EXISTS))) {
                    while (scanner.hasNext()) {
                        writer.println(scanner.nextLine().replaceAll("B", B.toString()).replaceAll("C", C.toString()));
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
