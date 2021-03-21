package com.cabinvoicegenerator;

public enum CabRide {
    NORMAL(10.0, 1.0, 5.0),
    PREMIUM(15.0, 2.0, 20.0);

    private  final double costPerKM;
    private final double costPerMinute;
    private final double minFare;

    CabRide(double costPerKM, double costPerMinute, double minFare) {
        this.costPerKM = costPerKM;
        this.costPerMinute = costPerMinute;
        this.minFare = minFare;
    }

    public double calculateCostofCabRide(Ride ride) {
        double cost = ((ride.distance * costPerKM) + (ride.time * costPerMinute));
        return cost;
    }
}
