import by.gsu.epamlab.DayOfWeek;
import by.gsu.epamlab.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static by.gsu.epamlab.Convert.convert;

public class Runner {

    private static void printPurchases(Purchase[] purchases) {
        System.out.println("product name:" + Purchase.PRODUCTNAME + "; " + "price:" + convert(Purchase.PRICE));
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                purchases[i] = new Purchase(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            printPurchases(purchases);

            int totalCostMonday = 0;
            double meanCost = 0;
            int totalCost = 0;
            int maxCost = 0;
            DayOfWeek day = null;
            for (Purchase purchase : purchases) {
                if (purchase.getDayOfWeek() == DayOfWeek.MONDAY) {
                    totalCostMonday += purchase.getCost();
                }
                totalCost += purchase.getCost();
                if (purchase.getCost() > maxCost) {
                    maxCost = purchase.getCost();
                    day = purchase.getDayOfWeek();
                }
            }
            if (purchases.length > 0) {
                meanCost = ((double) totalCost) / purchases.length;
            }
            System.out.printf("Mean cost = %.03f\n", meanCost / 100);
            System.out.println("The total cost on Monday = " + convert(totalCostMonday));
            System.out.println("The day with the maximum cost purchase is " + day);
            Arrays.sort(purchases);
            printPurchases(purchases);
            if (purchases.length > 0) {
                int index = Arrays.binarySearch(purchases, new Purchase(5, 0, null));
                if (index >= 0)
                    System.out.println(purchases[index]);
                else
                    System.out.println("Required purchase is not found");
            } else {
                System.out.println("Required purchase is not found");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }
}
