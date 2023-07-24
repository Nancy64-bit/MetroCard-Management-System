package com.geektrust.backend.entitiesTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;

public class PassengerTest {

    @Test
    public void testPassenger() {
        // Prepare test data
        String passengerType = "Adult";
        MetroCard metroCard = new MetroCard("MC123", 500);

        // Create a Passenger instance
        Passenger passenger = new Passenger(passengerType, metroCard);

        // Assert the values
        assertEquals(passengerType, passenger.getPassengerType());
        assertEquals(metroCard, passenger.getMetroCard());
    }

    @Test
    public void testPassengerWithNullMetroCard() {
        // Prepare test data
        String passengerType = "Kid";
        MetroCard metroCard = null;

        // Create a Passenger instance
        Passenger passenger = new Passenger(passengerType, metroCard);

        // Assert the values
        assertEquals(passengerType, passenger.getPassengerType());
        assertEquals(metroCard, passenger.getMetroCard());
    }

    @Test
    public void testPassengerWithEmptyPassengerType() {
        // Prepare test data
        String passengerType = "";
        MetroCard metroCard = new MetroCard("MC456", 200);

        // Create a Passenger instance
        Passenger passenger = new Passenger(passengerType, metroCard);

        // Assert the values
        assertEquals(passengerType, passenger.getPassengerType());
        assertEquals(metroCard, passenger.getMetroCard());
    }
}
