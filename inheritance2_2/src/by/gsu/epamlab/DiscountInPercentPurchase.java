package by.gsu.epamlab;

public class DiscountInPercentPurchase extends AbstractPurchase {
    private final static int MIN_ITEM_FOR_DISCOUNT = 5;
    private double discountPercent;

    public DiscountInPercentPurchase(Product product, int number, double discountInPercent) {
        super(product, number);
        this.discountPercent = discountInPercent;
    }

    public double getDiscountInPercent() {
        return discountPercent;
    }

    public void setDiscountInPercent(double discountInPercent) {
        this.discountPercent = discountInPercent;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discountPercent;
    }

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        if (getNumber() >= MIN_ITEM_FOR_DISCOUNT) {
            baseCost = baseCost.multiply(1 - discountPercent / 100, RoundMethod.ROUND, 0);
        }
        return baseCost.round(RoundMethod.FLOOR, 2);
    }
}