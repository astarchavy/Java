package by.gsu.epamlab;


public class TransportExpensesPurchase extends AbstractPurchase {
    private Byn transportPrice;

    public TransportExpensesPurchase(Product product, int number, Byn transportPrice) {
        super(product, number);
        this.transportPrice = transportPrice;
    }

    public Byn getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(Byn transportPrice) {
        this.transportPrice = transportPrice;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + transportPrice;
    }

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        return baseCost.add(transportPrice);
    }
}
