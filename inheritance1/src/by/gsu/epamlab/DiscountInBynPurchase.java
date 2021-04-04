package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class DiscountInBynPurchase extends Purchase {
    private Byn discountInByn;

    public DiscountInBynPurchase(String name, Byn price, int number, int discountInByn) {
        super(name, price, number);
        this.discountInByn = new Byn(discountInByn);
    }

    public DiscountInBynPurchase() {
    }

    public DiscountInBynPurchase(Scanner sc) {
        super(sc);
        this.discountInByn = new Byn(sc.nextInt());
    }

    public Byn getDiscountInByn() {
        return discountInByn;
    }

    public void setDiscountInByn(Byn discountInByn) {
        this.discountInByn = discountInByn;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discountInByn;
    }

    @Override
    public Byn getCost() {
        return new Byn(getPrice()).subtraction(discountInByn).multiply(getNumber());
    }
}
