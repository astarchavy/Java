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
        System.out.println("rate = " + DAYLI_RATE / 100 + "."
                + ("00" + DAYLI_RATE).substring(("00" + DAYLI_RATE).length() - 2));
        System.out.println("account = " + employeesAccount);
        System.out.println("transport = " + transportCost / 100 + "."
                + ("00" + transportCost).substring(("00" + transportCost).length() - 2));
        System.out.println("days = " + numberOfDays);
        System.out.println("total = " + getTotal() / 100 + "."
                + ("00" + getTotal()).substring(("00" + getTotal()).length() - 2));
    }

    /**
     * Override method toString()
     *
     * @return employeesAccount + transportCost + numberOfDays + totalTripCost
     */
    @Override
    public String toString() {
        return employeesAccount + ";"
                + transportCost / 100 + "."
                    + ("00" + transportCost).substring(("00" + transportCost).length() - 2) + ";"
                + numberOfDays + ";"
                + getTotal() / 100 + "."
                    + ("00" + getTotal()).substring(("00" + getTotal()).length() - 2);
    }
}
