package by.gsu.epamlab;


public class DiscountInBynPurchase extends AbstractPurchase {
    private Byn discountInByn;

    public DiscountInBynPurchase(Product product, int number, Byn discountInByn) {
        super(product, number);
        this.discountInByn = discountInByn;
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

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        return baseCost.subtrac(discountInByn.multiply(getNumber()));
    }
}
