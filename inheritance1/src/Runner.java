
import by.gsu.epamlab.Byn;
import by.gsu.epamlab.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import static by.gsu.epamlab.PurchasesFactory.getPurchaseFromFactory;

public class Runner {

    public static void main(String[] args) {
        final int PURCHASES_NUMBER = 6;
        final String FILE_NAME = "src/in.txt";
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            sc.useLocale(Locale.ENGLISH);
            boolean allEqual = true;
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            Purchase purchaseWithMaxCost = new Purchase("", new Byn(0), 0);

            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                purchases[i] = getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);

                if (purchases[i].getCost().compareTo(purchaseWithMaxCost.getCost()) >= 0) {
                    purchaseWithMaxCost = purchases[i];
                }

                if (allEqual) {
                    allEqual = purchases[i].equals(purchases[0]);
                }
            }
            System.out.println("Purchase with max cost: " + purchaseWithMaxCost);
            System.out.println("All purchases are equal: " + allEqual);

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }
}
