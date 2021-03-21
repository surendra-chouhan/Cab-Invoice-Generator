package com.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator;

    @Before
    public void set() {
        cabInvoiceGenerator = new CabInvoiceGenerator();        
    }

    @Test
    public void givenDistanceAndTimeInvoiceGeneratorShouldReturnTotalFareTrueTest() {
        double totalFare = cabInvoiceGenerator.calculateFare(1.0, 5);
        Assert.assertEquals(15.0, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeInvoiceGeneratorShouldReturnMinimumFare() {
        double totalFare = cabInvoiceGenerator.calculateFare(0.2, 2);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRidesShouldReturnTotalFare() {
        Ride[] rides = { new Ride(1.0,5, CabRide.NORMAL),
                        new Ride(0.2,2, CabRide.NORMAL)};

        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        Assert.assertEquals(20, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRidesShouldReturnTotalRidesTotalFareandAverageFareperRide() {
        Ride[] rides = { new Ride(1.0,5, CabRide.NORMAL),
                         new Ride(0.2,2, CabRide.NORMAL)};

        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        int noOfRides = cabInvoiceGenerator.numberOfRides(rides);
        double averageFare = cabInvoiceGenerator.calculateAverageFarePerRide(rides);

        Assert.assertEquals(20,totalFare,0.0);
        Assert.assertEquals(2, noOfRides);
        Assert.assertEquals(10, averageFare,0.0);
    }

    @Test
    public void givenUserIdShouldReturntheInvoice() {
        String userID = "Surendra";
        Ride[] rides = {new Ride (1.0, 5, CabRide.NORMAL),
                        new Ride (0.2, 2, CabRide.NORMAL),
                        new Ride (2, 5, CabRide.NORMAL)};

        cabInvoiceGenerator.addRides(userID, rides);
        double rideDetails = cabInvoiceGenerator.getRidesDetails(userID);
        int NoOfRides = cabInvoiceGenerator.numberOfRides(rides);
        Assert.assertEquals(45, rideDetails, 0.0);
        Assert.assertEquals(3, NoOfRides);
    }

    @Test
    public void givenCategoriesOfRidesShouldReturnInvoice() {
        String userID = "ABC";
        Ride[] rides = {new Ride(2.0, 5, CabRide.NORMAL),
                        new Ride(0.1, 1, CabRide.NORMAL),
                        new Ride(2, 2, CabRide.PREMIUM)};

        cabInvoiceGenerator.addRides(userID, rides);
        double rideDetails = cabInvoiceGenerator.getRidesDetails(userID);
        int NoOfRides = cabInvoiceGenerator.numberOfRides(rides);
        Assert.assertEquals(52, rideDetails, 0.0);
        Assert.assertEquals(3, NoOfRides);
    }
}
