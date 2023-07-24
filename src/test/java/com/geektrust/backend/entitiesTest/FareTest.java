package com.geektrust.backend.entitiesTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.entities.Fare;

public class FareTest {

    @Test
    public void testFareWithAdultPassenger() {
        // Prepare test data
        String passengerType = "Adult";
        double travelCharge = 200.0;

        // Create a Fare instance
        Fare fare = new Fare(passengerType, travelCharge);

        // Assert the values
        assertEquals(passengerType, fare.getPassengerType());
        assertEquals(travelCharge, fare.getTravelCharge());
    }

    @Test
    public void testFareWithKidPassenger() {
        // Prepare test data
        String passengerType = "Kid";
        double travelCharge = 50.0;

        // Create a Fare instance
        Fare fare = new Fare(passengerType, travelCharge);

        // Assert the values
        assertEquals(passengerType, fare.getPassengerType());
        assertEquals(travelCharge, fare.getTravelCharge());
    }

    @Test
    public void testFareWithSeniorCitizenPassenger() {
        // Prepare test data
        String passengerType = "SENIOR_CITIZEN";
        double travelCharge = 100.0;

        // Create a Fare instance
        Fare fare = new Fare(passengerType, travelCharge);

        // Assert the values
        assertEquals(passengerType, fare.getPassengerType());
        assertEquals(travelCharge, fare.getTravelCharge());
    }

    @Test
    public void testFareWithZeroTravelCharge() {
        // Prepare test data
        String passengerType = "Adult";
        double travelCharge = 0.0;

        // Create a Fare instance
        Fare fare = new Fare(passengerType, travelCharge);

        // Assert the values
        assertEquals(passengerType, fare.getPassengerType());
        assertEquals(travelCharge, fare.getTravelCharge());
    }

    @Test
    public void testFareWithNegativeTravelCharge() {
        // Prepare test data
        String passengerType = "Adult";
        double travelCharge = -100.0;

        // Create a Fare instance
        Fare fare = new Fare(passengerType, travelCharge);

        // Assert the values
        assertEquals(passengerType, fare.getPassengerType());
        assertEquals(travelCharge, fare.getTravelCharge());
    }
}
