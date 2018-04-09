import java.io.FileNotFoundException;

/**
 * @autor Toropin Konstantin (impy.bian@gmail.com)
 */
public class Main {

    public static void main(String[] args) {
        String output;
        String input;
        boolean isHW1;
        if (args.length < 3) {
            System.err.println("use <input file> <output file> <number of hw 1 or 2>");
            return;
        } else {
            output = args[0];
            input = args[1];
            isHW1 = Integer.parseInt(args[2]) == 1;
        }
        ProveMachine proveMachine = new ProveMachine(input, output, new Correctness());
        try {
            long time = System.currentTimeMillis();
            if (isHW1) {
                proveMachine.runHW1();
            } else {
                proveMachine.runHW2();
            }
            System.out.println("----TIME : " + (System.currentTimeMillis() - time) + "ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
