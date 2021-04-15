package by.gsu.epamlab;

 public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    Product product;
    int number;

    public AbstractPurchase(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    public AbstractPurchase() {
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getCost() {
        return new Byn(product.getPrice()).multiply(number);
    }

    protected String fieldsToString() {
        return product + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase o) {
        return new Byn(o.getCost().subtraction(this.getCost())).getKopecks();
    }
}
