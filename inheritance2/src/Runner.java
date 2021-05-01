import by.gsu.epamlab.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        final Product LIVER = new Product("liver", new Byn(1000));
        AbstractPurchase[] purchases = {
                new DiscountInBynPurchase(LIVER, 3, new Byn(22)),
                new DiscountInBynPurchase(LIVER, 4, new Byn(500)),
                new DiscountInPercentPurchase(LIVER, 3, 4.8),
                new DiscountInPercentPurchase(LIVER, 3, 61.3),
                new TransportExpensesPurchase(LIVER, 3, new Byn(40)),
                new TransportExpensesPurchase(LIVER, 1, new Byn(50))
        };
        display(purchases);
        System.out.println("sorted:");
        Arrays.sort(purchases);
        display(purchases);

        System.out.println("min cost = " + purchases[purchases.length - 1].getCost());

        int searchPurchase = Arrays.binarySearch(purchases, new DiscountInBynPurchase(LIVER, 4, new Byn(500)));
        if (searchPurchase >= 0) {
            System.out.println(purchases[searchPurchase]);
        } else {
            System.out.println("Required purchase is not found");
        }

    }

    private static void display(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }
    }
}