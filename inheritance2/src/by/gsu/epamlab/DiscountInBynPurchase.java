package by.gsu.epamlab;


public class DiscountInBynPurchase extends AbstractPurchase {
    private Byn discountInByn;

    public DiscountInBynPurchase(Product product, int number, Byn discountInByn) {
        super(product, number);
        this.discountInByn = new Byn(discountInByn);
    }

    public DiscountInBynPurchase() {
    }

    @Override
    protected Byn getFinalCost(Byn byn) {
        return byn.subtraction(discountInByn.multiply(getNumber()));
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


}
