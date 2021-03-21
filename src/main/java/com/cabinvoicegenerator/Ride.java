package com.cabinvoicegenerator;

public class Ride {
    public double distance;
    public int time;
    public CabRide cabRide;

    public Ride(double distance, int time, CabRide cabRide) {
        this.distance = distance;
        this.time = time;
        this.cabRide = cabRide;
    }
}
