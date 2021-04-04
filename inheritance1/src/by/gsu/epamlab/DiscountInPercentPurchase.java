package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class DiscountInPercentPurchase extends Purchase {
    private final static int CONST_FOR_DISCOUNT = 5;
    private double discountInPercent;

    public DiscountInPercentPurchase(String product, Byn price, int number, double discountInPercent) {
        super(product, price, number);
        this.discountInPercent = discountInPercent;
    }

    public DiscountInPercentPurchase(Scanner sc) {
        super(sc);
        this.discountInPercent = sc.nextDouble();
    }

    public double getDiscountInPercent() {
        return discountInPercent;
    }

    public void setDiscountInPercent(double discountInPercent) {
        this.discountInPercent = discountInPercent;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discountInPercent;
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
        DiscountInPercentPurchase that = (DiscountInPercentPurchase) o;
        return Double.compare(that.discountInPercent, discountInPercent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountInPercent);
    }

    @Override
    public Byn getCost() {
        return getNumber() >= CONST_FOR_DISCOUNT ? super.getCost().multiply(1 - discountInPercent / 100) : super.getCost();
    }
}
