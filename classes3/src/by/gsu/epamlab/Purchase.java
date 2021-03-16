package by.gsu.epamlab;

import static by.gsu.epamlab.DayOfWeek.*;

public class Purchase implements Comparable<Purchase> {
    private final String PRODUCTNAME = "kettle";
    private final int PRICE = 2334;
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
        this.number = number;
        this.discount = discount;
        this.dayOfWeek = getDayByNumber(dayOfWeek);
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

    public String getPRODUCTNAME() {
        return PRODUCTNAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    private DayOfWeek getDayByNumber(int numberOfDay) {
        switch (numberOfDay) {
            case 0:
                return SUNDAY;
            case 1:
                return MONDAY;
            case 2:
                return TUESDAY;
            case 3:
                return WEDNESDAY;
            case 4:
                return THURSDAY;
            case 5:
                return FRIDAY;
            case 6:
                return SATURDAY;
        }
        return null;
    }

    public int getCost() {
        return Math.round(PRICE * number * (100 - discount) / 100);
    }

    @Override
    public int compareTo(Purchase o) {
        if (this.getNumber() < o.getNumber()) {
            return -1;
        }
        if (this.getNumber() > o.getNumber()) {
            return 1;
        }
        if (this.getNumber() == o.getNumber()) {
            return 0;
        }
        return 0;
    }

    private static String convert(int money) {
        return String.format("%d.%d02d", money / 100, money % 100);
    }

    @Override
    public String toString() {
        return number + ";" + discount + ";" + convert(getCost()) + dayOfWeek;
    }
}


