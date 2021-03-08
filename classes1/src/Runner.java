import by.gsu.epamlab.BusinessTrip;

public class Runner {
    public static void main(String[] args) {
        //Creation of array
        BusinessTrip[] businessTrips = new BusinessTrip[]{
                new BusinessTrip("Ivan Ivanov", 2423, 5),
                new BusinessTrip("Peter Petrov", 1045, 3),
                null,
                new BusinessTrip("Daniil Daniilov", 2021, 1),
                new BusinessTrip()
        };
        //Content output of array by show() method
        for (BusinessTrip businessTrip : businessTrips
        ) {
            if (businessTrip != null)
                businessTrip.show();
        }
        //maxCost trip output
        BusinessTrip max = new BusinessTrip();
        int maxTripCost = businessTrips[0].getTotal();
        for (BusinessTrip businessTrip : businessTrips
        ) {
            if (businessTrip != null)
                if (businessTrip.getTotal() > maxTripCost){
                    max = businessTrip;
                    maxTripCost = businessTrip.getTotal();}
        }
        max.show();

        //Setting transportationCost in the last element
        businessTrips[businessTrips.length - 1].setTransportCost(1332);
        //Total duration of two first elements output
        System.out.println("Duration = " + (businessTrips[0].getNumberOfDays()
                + businessTrips[1].getNumberOfDays()));
        //Output by toString() method
        for (BusinessTrip businessTrip : businessTrips
        ) {
            System.out.println(businessTrip);
        }
    }
}
