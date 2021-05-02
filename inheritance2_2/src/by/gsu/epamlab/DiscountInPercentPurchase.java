package by.gsu.epamlab;

public class DiscountInPercentPurchase extends AbstractPurchase {
    private final static int MIN_ITEM_FOR_DISCOUNT = 5;
    private double discountInPercent;

    public DiscountInPercentPurchase(Product product, int number, double discountInPercent) {
        super(product, number);
        this.discountInPercent = discountInPercent;
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
    protected Byn getFinalCost(Byn byn) {
        if (getNumber() > MIN_ITEM_FOR_DISCOUNT) {
            byn.multiply((int) (1 - (discountInPercent / 100)));
        }
        return byn.round(RoundMethod.FLOOR, 2);
    }
}