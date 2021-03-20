import by.gsu.epamlab.DayOfWeek;
import by.gsu.epamlab.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static by.gsu.epamlab.Convert.convert;

public class Runner {
    public static void main(String[] args) {
        final int PURCHASES_NUMBER;
        Purchase[] purchases;
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            PURCHASES_NUMBER = sc.nextInt();
            purchases = new Purchase[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                purchases[i] = new Purchase(sc.nextInt(), sc.nextInt(), DayOfWeek.values()[sc.nextInt()]);
            }

            System.out.println("product name:" + Purchase.PRODUCTNAME + "; " + "price:" + convert(Purchase.PRICE));
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
            int totalCostMonday = 0;
            int meanCost = 0;
            int sum = 0;
            int max = 0;
            DayOfWeek day = null;
            for (Purchase purchase : purchases) {
                if (purchase.getDayOfWeek() == DayOfWeek.MONDAY) {
                    totalCostMonday += purchase.getCost();
                }
                sum += purchase.getCost();
                if (purchase.getCost() > max) {
                    max = purchase.getCost();
                    day = purchase.getDayOfWeek();
                }
            }
            meanCost = sum / PURCHASES_NUMBER;
            System.out.printf("Mean cost = %d.%03d\n", meanCost / 100, (meanCost * 10) % 1000);
            System.out.println("The total cost on Monday = " + convert(totalCostMonday));
            System.out.println("The day with the maximum cost purchase is " + day);
            Arrays.sort(purchases);
            System.out.println("product name:" + Purchase.PRODUCTNAME + "; " + "price:" + convert(Purchase.PRICE));
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
            if (PURCHASES_NUMBER != 0) {
                System.out.println(purchases[Arrays.binarySearch(purchases, new Purchase(5, 0, null))]);
            } else {
                System.out.println("Required purchase is not found");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }
}
