package com.geektrust.backend.entitiesTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.entities.PassengerSummary;

public class PassengerSummaryTest {

    @Test
    public void testPassengerSummary() {
        // Prepare test data
        String passengerType = "Adult";
        int passengerCount = 5;

        // Create a PassengerSummary instance
        PassengerSummary summary = new PassengerSummary(passengerType, passengerCount);

        // Assert the values
        assertEquals(passengerType, summary.getPassengerType());
        assertEquals(passengerCount, summary.getPassengerCount());
    }

    @Test
    public void testPassengerSummaryWithNegativeCount() {
        // Prepare test data
        String passengerType = "Kid";
        int passengerCount = -2;

        // Create a PassengerSummary instance
        PassengerSummary summary = new PassengerSummary(passengerType, passengerCount);

        // Assert the values
        assertEquals(passengerType, summary.getPassengerType());
        assertEquals(passengerCount, summary.getPassengerCount());
    }

    @Test
    public void testPassengerSummaryWithEmptyType() {
        // Prepare test data
        String passengerType = "";
        int passengerCount = 10;

        // Create a PassengerSummary instance
        PassengerSummary summary = new PassengerSummary(passengerType, passengerCount);

        // Assert the values
        assertEquals(passengerType, summary.getPassengerType());
        assertEquals(passengerCount, summary.getPassengerCount());
    }
}
