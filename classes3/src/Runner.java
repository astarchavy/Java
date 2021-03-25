import by.gsu.epamlab.WeekDay;
import by.gsu.epamlab.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static by.gsu.epamlab.Utility.convert;

public class Runner {

    private static void printPurchases(Purchase[] purchases) {
        System.out.println("product name:" + Purchase.PRODUCT_NAME + "; " + "price:" + convert(Purchase.PRICE));
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
    }

    public static void main(String[] args) {
        final String FILE_NAME = "src/in.txt";
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                purchases[i] = new Purchase(sc.nextInt(), sc.nextDouble(), sc.nextInt());
            }
            printPurchases(purchases);
            int totalCostMonday = 0;
            double meanCost = 0;
            int totalCost = 0;
            int maxCost = 0;
            WeekDay maxCostDay = null;
            for (Purchase purchase : purchases) {
                int cost = purchase.getCost();
                if (purchase.getWeekDay() == WeekDay.MONDAY) {
                    totalCostMonday += cost;
                }
                totalCost += cost;
                if (cost >= maxCost) {
                    maxCost = cost;
                    maxCostDay = purchase.getWeekDay();
                }
            }
            if (purchases.length > 0) {
                meanCost = (double) totalCost / purchases.length;
            }
            System.out.printf(Locale.ENGLISH, "Mean cost of all purchases: %.3f%n", meanCost / 100);
            System.out.println("The total cost on Monday = " + convert(totalCostMonday));
            System.out.println("The day with the maximum cost purchase is " + maxCostDay);
            Arrays.sort(purchases);
            printPurchases(purchases);

            int index = -1;
            if (purchases.length > 0) {
                index = Arrays.binarySearch(purchases, new Purchase(5, 0, null));
            }
            System.out.println(index >= 0 ? purchases[index] : "Required purchase is not found");

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }


    }
}
