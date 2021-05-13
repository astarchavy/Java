import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws Exception {
        final String INPUT_CSV = "src/in.csv";

        try (Scanner sc = new Scanner(new FileReader(INPUT_CSV))) {


            final String PLUS = " + ";
            final String MINUS = " - ";
            final int LENGTH_WITH_SIGN = PLUS.length();
            final String DIVIDER = ";";

            double result = 0;
            int errorNumbers = 0;

            StringBuilder strResult = new StringBuilder();

            while (sc.hasNextLine()) {
                String[] elements = sc.nextLine().split(DIVIDER);
                try {
                    int index = Integer.parseInt(elements[0]);
                    double valueByIndex = Double.parseDouble(elements[index]);
                    result += valueByIndex;
                    strResult.append(valueByIndex < 0.0 ? MINUS : PLUS).append(Math.abs(valueByIndex));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    errorNumbers++;
                }
            }

            if (strResult.length() > 0) {
                if (strResult.toString().startsWith(MINUS)) {
                    strResult.delete(0, LENGTH_WITH_SIGN);
                    strResult.insert(0, "-");
                } else strResult.delete(0, LENGTH_WITH_SIGN);
            }

            System.out.println("result(" + strResult + ") = " + result);
            System.out.println("errorNumbers = " + errorNumbers);

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}


