
import by.gsu.epamlab.Byn;
import by.gsu.epamlab.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import static by.gsu.epamlab.PurchasesFactory.getPurchaseFromFactory;


public class Runner {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = 6;
            boolean purchaseEquals = true;
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            Purchase PurchaseWithMaxCost = new Purchase();
            Byn maxCost = new Byn(0);
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                purchases[i] = getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);
                if (purchases[i].getCost().compareTo(maxCost) > 0) {
                    maxCost = purchases[i].getCost();
                    PurchaseWithMaxCost = purchases[i];
                }
                if (purchases[0].equals(purchases[i]) == false) {
                    purchaseEquals = false;
                }
            }
            System.out.println("Purchase with max cost: " + PurchaseWithMaxCost);
            System.out.println("All purchases are equal: " + purchaseEquals);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }
}
