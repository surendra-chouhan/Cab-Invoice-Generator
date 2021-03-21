package com.cabinvoicegenerator;

public class CabInvoiceGenerator {
    private final int COST_PER_KM = 10;
    private final int COST_PER_MINUTE = 1;
    private final double MINIMUM_FARE = 5.0;

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
}
