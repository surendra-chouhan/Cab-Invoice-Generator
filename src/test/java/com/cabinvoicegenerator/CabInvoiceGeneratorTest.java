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
}
