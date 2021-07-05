import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    public static void main(String[] args) {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("in");
            Enumeration<String> keys = rb.getKeys();
            int numOfErrors = 0;
            final String INDEX_REGEXP = "index(.*)";
            final String DIGITS_REGEXP = "[1-9]\\d*";
            final int GROUP_INDEX = 1;
            final String VALUE = "value";
            Pattern indexPattern = Pattern.compile(INDEX_REGEXP);
            Pattern digitsPattern = Pattern.compile(DIGITS_REGEXP);
            double sum = 0.0;
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().trim();
                Matcher indexMatcher = indexPattern.matcher(key);
                if (indexMatcher.matches()) {
                    String i = indexMatcher.group(GROUP_INDEX);
                    String j = rb.getString(key).trim();
                    Matcher iMatcher = digitsPattern.matcher(i);
                    Matcher jMatcher = digitsPattern.matcher(j);
                    if (iMatcher.matches() && jMatcher.matches()) {


                        try {
                            String valueIJ = rb.getString(VALUE + i + j);
                            sum += Double.parseDouble(valueIJ);
                        } catch (NumberFormatException | MissingResourceException e ) {
                            numOfErrors++;
                        }

                    } else {
                        numOfErrors++;
                    }
                }
            }
            System.out.println("sum = " + sum);
            System.out.println("error-lines = " + numOfErrors);
        }catch (MissingResourceException e){
            System.out.println("Give me the file");
        }
    }
}

