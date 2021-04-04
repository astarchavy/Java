package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class DiscountInBynPurchase extends Purchase {
    private Byn discountInByn;

    public DiscountInBynPurchase(String product, Byn price, int number, int discountInByn) {
        super(product, price, number);
        this.discountInByn = new Byn(discountInByn);
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
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountInBynPurchase that = (DiscountInBynPurchase) o;
        return Objects.equals(discountInByn, that.discountInByn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountInByn);
    }

    @Override
    public Byn getCost() {
        return new Byn(getPrice()).subtraction(discountInByn).multiply(getNumber());
    }
}
