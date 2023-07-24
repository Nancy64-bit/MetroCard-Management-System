package com.geektrust.backend.entitiesTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.entities.Summary;
import com.geektrust.backend.entities.PassengerSummary;

public class SummaryTest {

    @Test
    public void testSummary() {
        // Prepare test data
        String stationName = "AIRPORT";
        double totalCollection = 500.0;
        double totalDiscount = 100.0;
        PassengerSummary[] passengerSummaries = {
                new PassengerSummary("Adult", 2),
                new PassengerSummary("Kid", 1)
        };

        // Create a Summary instance
        Summary summary = new Summary(stationName, totalCollection, totalDiscount, passengerSummaries);

        // Assert the values
        assertEquals(stationName, summary.getStationName());
        assertEquals(totalCollection, summary.getTotalCollection());
        assertEquals(totalDiscount, summary.getTotalDiscount());
        assertEquals(passengerSummaries, summary.getPassengerSummaries());
    }

    @Test
    public void testSummaryWithEmptyPassengerSummaries() {
        // Prepare test data
        String stationName = "Central";
        double totalCollection = 300.0;
        double totalDiscount = 50.0;
        PassengerSummary[] passengerSummaries = new PassengerSummary[0];

        // Create a Summary instance
        Summary summary = new Summary(stationName, totalCollection, totalDiscount, passengerSummaries);

        // Assert the values
        assertEquals(stationName, summary.getStationName());
        assertEquals(totalCollection, summary.getTotalCollection());
        assertEquals(totalDiscount, summary.getTotalDiscount());
        assertEquals(passengerSummaries, summary.getPassengerSummaries());
    }

    @Test
    public void testSummaryWithNullPassengerSummaries() {
        // Prepare test data
        String stationName = "AIRPORT";
        double totalCollection = 0.0;
        double totalDiscount = 0.0;
        PassengerSummary[] passengerSummaries = null;

        // Create a Summary instance
        Summary summary = new Summary(stationName, totalCollection, totalDiscount, passengerSummaries);

        // Assert the values
        assertEquals(stationName, summary.getStationName());
        assertEquals(totalCollection, summary.getTotalCollection());
        assertEquals(totalDiscount, summary.getTotalDiscount());
        assertEquals(passengerSummaries, summary.getPassengerSummaries());
    }
}
