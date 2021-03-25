package by.gsu.epamlab;

import static by.gsu.epamlab.Convert.convert;

public class Purchase implements Comparable<Purchase> {
    public static final String PRODUCT_NAME = "kettle";
    public static final int PRICE = 2334;
    private int number;
    private double discountPercent;
    private WeekDay weekDay;

    public Purchase() {
    }

    public Purchase(int number, int discountPercent, WeekDay weekDay) {
        this.number = number;
        this.discountPercent = discountPercent;
        this.weekDay = weekDay;
    }

    public Purchase(int number, int discountPercent, int weekDay) {
        this(number, discountPercent, WeekDay.values()[weekDay]);
    }

    public int getNumber() {
        return number;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getCost() {
        return (int) Math.round((PRICE * number * (100 - discountPercent) / 100) / 100) * 100;
    }

    @Override
    public int compareTo(Purchase purchase) {
        return number - purchase.number;
    }

    @Override
    public String toString() {
        return number + ";" + discountPercent + ";" + weekDay + ";" + convert(getCost());
    }
}


