package by.gsu.epamlab;


import java.util.Objects;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private int number;

    public AbstractPurchase(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    protected abstract Byn getFinalCost(Byn baseCost);

    public Byn getCost() {
        Byn baseCost = product.getPrice().multiply(number);
        Byn finalCost = getFinalCost(baseCost);
        return finalCost.round(RoundMethod.FLOOR, 2);
    }

    protected String fieldsToString() {
        return product + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return o.getCost().compareTo(getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((!(o instanceof AbstractPurchase))) return false;
        AbstractPurchase that = (AbstractPurchase) o;
        return number == that.number &&
                Objects.equals(product, that.product);
    }
}
