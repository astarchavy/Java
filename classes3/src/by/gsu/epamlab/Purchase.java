package by.gsu.epamlab;

import static by.gsu.epamlab.Convert.convert;

public class Purchase implements Comparable<Purchase> {
    public static final String PRODUCTNAME = "kettle";
    public static final int PRICE = 2334;
    private int number;
    private int discount;
    private DayOfWeek dayOfWeek;

    public Purchase() {
    }

    public Purchase(int number, int discount, DayOfWeek dayOfWeek) {
        this.number = number;
        this.discount = discount;
        this.dayOfWeek = dayOfWeek;
    }

    public Purchase(int number, int discount, int dayOfWeek) {
        this(number, discount, DayOfWeek.values()[dayOfWeek]);
    }

    public int getNumber() {
        return number;
    }

    public int getDiscount() {
        return discount;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getCost() {
        int cost=(PRICE * number * (100 - discount) / 100);
        if (cost % 100 >= 50)
            return (cost / 100 + 1) * 100;
        else
            return (cost / 100) * 100;
    }

    @Override
    public int compareTo(Purchase purchase) {
        return number - purchase.number;
    }

    @Override
    public String toString() {
        return number + ";" + discount + ";" + convert(getCost()) + ";" + dayOfWeek;
    }
}


