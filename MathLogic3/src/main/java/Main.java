import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @autor Toropin Konstantin (impy.bian@gmail.com)
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String output;
        String input;
        if (args.length < 2) {
            input = "test.in";
            output = "test.out";
        } else {
            input = args[0];
            output = args[1];
        }
        Scanner scanner = new Scanner(new File(input));
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        new ProveMachine(output).evaluate(a, b);
    }
}
