package by.gsu.epamlab;

public class Runner {
    public static void main(String[] args) {
        //Creation of objects
        BusinessTrip first = new BusinessTrip("Ivan Ivanov", 1023, 5);
        BusinessTrip second = new BusinessTrip("Peter Petrov", 1045, 3);
        BusinessTrip fourth = new BusinessTrip("Daniil Daniilov", 2021, 1);
        BusinessTrip fifthWithoutArg = new BusinessTrip();
        //Creation of array
        BusinessTrip[] businessTrips = new BusinessTrip[]{first, second, null, fourth, fifthWithoutArg};
        //Content output of array by show() method
        for (BusinessTrip businessTrip : businessTrips
        ) {
            if (businessTrip != null)
                businessTrip.show();
        }
        //maxCost trip output
        int maxTripCost = businessTrips[0].getTotal();
        for (BusinessTrip businessTrip : businessTrips
        ) {
            if (businessTrip != null)
                if (businessTrip.getTotal() > maxTripCost)
                    maxTripCost = businessTrip.getTotal();
        }
        for (BusinessTrip businessTrip : businessTrips
        ) {
            if (businessTrip != null)
                if (businessTrip.getTotal() == maxTripCost)
                    System.out.println(businessTrip);
        }
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
