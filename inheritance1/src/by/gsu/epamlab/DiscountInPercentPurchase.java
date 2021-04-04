package by.gsu.epamlab;

import java.util.Scanner;

public class DiscountInPercentPurchase extends Purchase {
    private final static int MIN_ITEM_FOR_DISCOUNT = 5;
    private double discountInPercent;

    public DiscountInPercentPurchase(String name, Byn price, int number, double discountInPercent) {
        super(name, price, number);
        this.discountInPercent = discountInPercent;
    }

    public DiscountInPercentPurchase() {
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
    public Byn getCost() {
        Byn cost = super.getCost();
        if(getNumber() >= MIN_ITEM_FOR_DISCOUNT){
           cost =  cost.multiply(1 - discountInPercent / 100);
        }
        return cost;
    }
}
