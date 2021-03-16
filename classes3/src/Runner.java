import by.gsu.epamlab.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final int PURCHASES_NUMBER;
        Purchase[] array;
        try(Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);

            PURCHASES_NUMBER = sc.nextInt();
            array = new Purchase[PURCHASES_NUMBER];
            for (Purchase purchase:array) {
                purchase = new Purchase(sc.nextInt(),sc.nextInt(),sc.nextInt());
            }
            for (Purchase purchase : array) {
                purchase.toString();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }
}
