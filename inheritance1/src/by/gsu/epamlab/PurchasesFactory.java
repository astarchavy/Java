package by.gsu.epamlab;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new Purchase(sc);
            }
        },
        DISCOUNT_IN_BYN_PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new DiscountInBynPurchase(sc);
            }
        },
        DISCOUNT_IN_PERCENT_PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new DiscountInPercentPurchase(sc);
            }
        };
        abstract Purchase getPurchase(Scanner sc);
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        return kind.getPurchase(sc);

    }
}
