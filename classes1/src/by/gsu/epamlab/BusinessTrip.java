package by.gsu.epamlab;

/**
 * Class BusinessTrip
 */
class BusinessTrip {

    /**
     * Constructor without parameters
     */
    public BusinessTrip() {
    }

    /**
     * constant field DAYLI_RATE
     */
    private final static int DAYLI_RATE = 7;
    /**
     * field employeesAccount
     */
    private String employeesAccount;
    /**
     * field transportCost
     */
    private int transportCost;
    /**
     * field numbertOfDays
     */
    private int numberOfDays;

    /**
     * Constructor with parameters
     *
     * @param employeesAccount
     * @param numberOfDays
     * @param transportCost
     */
    public BusinessTrip(String employeesAccount, int transportCost, int numberOfDays) {
        this.employeesAccount = employeesAccount;
        this.transportCost = transportCost;
        this.numberOfDays = numberOfDays;
    }

    /**
     * Getter of employeesAccount
     *
     * @return employeesAccount
     */
    public String getEmployeesAccount() {
        return employeesAccount;
    }

    /**
     * Getter of transportCost
     *
     * @return transportCost
     */
    public int getTransportCost() {
        return transportCost;
    }

    /**
     * Getter of numberOfDays
     *
     * @return numberOfDays
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * Setter of numberOfDays
     *
     * @param employeesAccount
     */
    public void setEmployeesAccount(String employeesAccount) {
        this.employeesAccount = employeesAccount;
    }

    /**
     * Setter of transportCost
     *
     * @param transportCost
     */
    public void setTransportCost(int transportCost) {
        this.transportCost = transportCost;
    }

    /**
     * Setter of numberOfDays
     *
     * @param numberOfDays
     */
    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    /**
     * Function for calculation total cost of the trip
     *
     * @return totalCost
     */
    public int getTotal() {
        return transportCost + numberOfDays * DAYLI_RATE;
    }

    /**
     * Method that output information about object
     */
    public void show() {
        System.out.println("rate = " + convert(DAYLI_RATE));
        System.out.println("account = " + employeesAccount);
        System.out.println("transport = " + convert(transportCost));
        System.out.println("days = " + numberOfDays);
        System.out.println("total = " + convert(getTotal()));
    }

    /**
     * Override method toString()
     *
     * @return employeesAccount + transportCost + numberOfDays + totalTripCost
     */
    @Override
    public String toString() {
        return employeesAccount + ";"
                + convert(transportCost) + ";"
                + numberOfDays + ";"
                + convert(getTotal()) ;
    }
    private String convert (int money)
    {
        return + money / 100 + "."
                + ("00" + money).substring(("00" + money).length() - 2);
    }
}
