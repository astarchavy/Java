
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws Exception {
        final String INPUT_CSV = "src/in.csv";

        try (Scanner sc = new Scanner(new FileReader(INPUT_CSV))) {
            final String BEFORE_SIGN = " ";
            final String AFTER_SIGN = " ";
            final String RESULT_HEAD = "result(";
            final String RESULT_TAIL = ") = ";
            final String ERROR_LINES = "errorNumbers = ";
            final String PLUS = BEFORE_SIGN + "+" + AFTER_SIGN;
            final String MINUS = BEFORE_SIGN + "-" + AFTER_SIGN;
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
                    String sign = valueByIndex < 0 ? MINUS : PLUS;
                    strResult.append(sign).append(Math.abs(valueByIndex));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    errorNumbers++;
                }
            }

            if (strResult.length() > 0) {
                final char CHAR_MINUS = '-';
                if (strResult.toString().startsWith(MINUS)) {
                    strResult.delete(0, LENGTH_WITH_SIGN);
                    strResult.insert(0, CHAR_MINUS);
                } else strResult.delete(0, LENGTH_WITH_SIGN);
            }

            System.out.println(RESULT_HEAD + strResult + RESULT_TAIL + result);
            System.out.println(ERROR_LINES + errorNumbers);

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}


