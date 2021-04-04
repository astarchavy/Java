package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String name;
    private Byn price;
    private int number;


    public Purchase() {
    }

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(Scanner sc) {
        this.name = sc.next();
        this.price = new Byn(sc.nextInt());
        this.number = sc.nextInt();
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    protected String fieldsToString() {
        return name + ";" + number + ";" + price;
    }

    public Byn getCost() {
        return new Byn(price).multiply(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return number == purchase.number &&
                name.equals(purchase.name) &&
                price.equals(purchase.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, number);
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }


}
