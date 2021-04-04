package by.gsu.epamlab;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE, DISCOUNT_IN_BYN_PURCHASE, DISCOUNT_IN_PERCENT_PURCHASE
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        switch (kind) {
            case GENERAL_PURCHASE:
                return new Purchase(sc);
            case DISCOUNT_IN_BYN_PURCHASE:
                return new DiscountInBynPurchase(sc);
            case DISCOUNT_IN_PERCENT_PURCHASE:
                return new DiscountInPercentPurchase(sc);
            default:
                throw new IllegalArgumentException();
        }
    }
}
