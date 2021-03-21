package com.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RideRepository {
    public HashMap<String, ArrayList<Ride>> userRides;

    public RideRepository(){
        userRides = new HashMap<>();
    }

    public void addRides(String userID, Ride[] rides) {
        ArrayList<Ride> rideList = this.userRides.get(userID);
        if (rideList == null)
            this.userRides.putIfAbsent(userID, new ArrayList<>(Arrays.asList(rides)));
    }

    public Ride[] getRides(String userID) {
        return this.userRides.get(userID).toArray(new Ride[0]);
    }
}
