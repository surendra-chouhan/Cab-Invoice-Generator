package com.cabinvoicegenerator;

public class CabInvoiceGenerator {
    private final int COST_PER_KM = 10;
    private final int COST_PER_MINUTE = 1;
    private final double MINIMUM_FARE = 5.0;
    public RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time) {
        double totalFare;
        totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        if (totalFare < MINIMUM_FARE)
            totalFare = MINIMUM_FARE;

        return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides)
            totalFare += this.calculateFare(ride.distance, ride.time);

        return totalFare;
    }

    public int numberOfRides(Ride[] rides) {
        return rides.length;
    }

    public double calculateAverageFarePerRide(Ride[] rides) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        double numberOfRides = rides.length;
        double averageFare = totalFare/numberOfRides;
        return averageFare;
    }

    public double getRidesDetails(String userID) {
        return this.calculateFare(rideRepository.getRides(userID));
    }

    public void addRides(String userID, Ride[] rides) {
        rideRepository.addRides(userID, rides);
    }
}
