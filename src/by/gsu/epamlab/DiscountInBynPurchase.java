package by.gsu.epamlab;

public class DiscountInBynPurchase extends AbstractPurchase {
    private Byn discountInByn;

    public DiscountInBynPurchase(String product, Byn price, int number, int discountInByn) {
        super(new Product(product, price), number);
        this.discountInByn = new Byn(discountInByn);
    }

    public DiscountInBynPurchase() {
    }

    public Byn getDiscountInByn() {
        return discountInByn;
    }

    public void setDiscountInByn(Byn discountInByn) {
        this.discountInByn = discountInByn;
    }

    @Override
    public Byn getCost() {
      //  return new Byn(getPrice()).subtraction(discountInByn).multiply(getNumber());
    }

    @Override
    public String toString() {
        return "DiscountInBynPurchase{" +
                "discountInByn=" + discountInByn +
                ", product=" + product +
                ", number=" + number +
                '}';
    }
}
