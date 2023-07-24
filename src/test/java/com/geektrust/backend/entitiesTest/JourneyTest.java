package com.geektrust.backend.entitiesTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.geektrust.backend.entities.Journey;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;

public class JourneyTest {

    private String journeyId;
    private Station destinationStation;
    private MetroCard card;
    private Passenger passenger;
    private String journeyType;

    @BeforeEach
    public void setUp() {
        journeyId = "J123";
        destinationStation = new Station("AIRPORT", "Airport Station");
    }
   
    @Test
    public void testJourneyWithDifferentPassengerTypes() {
        // Prepare test data
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 5000;
        card = new MetroCard(journeyId, 420);
        journeyType = "Single Journey";

        // Create a Journey instance with ADULT passenger
        passenger = new Passenger("ADULT", card);
        Journey adultJourney = new Journey(journeyId, passenger, destinationStation, journeyType);
        adultJourney.setEndTime(endTime);

        // Create a Journey instance with KID passenger
        passenger = new Passenger("KID", card);
        Journey kidJourney = new Journey(journeyId, passenger, destinationStation, journeyType);
        kidJourney.setEndTime(endTime);

        // Create a Journey instance with SENIOR_CITIZEN passenger
        passenger = new Passenger("SENIOR_CITIZEN", card);
        Journey seniorCitizenJourney = new Journey(journeyId, passenger, destinationStation, journeyType);
        seniorCitizenJourney.setEndTime(endTime);

        // Assert the values
        assertEquals("ADULT", adultJourney.getPassenger().getPassengerType());
        assertEquals("KID", kidJourney.getPassenger().getPassengerType());
        assertEquals("SENIOR_CITIZEN", seniorCitizenJourney.getPassenger().getPassengerType());
    }

    @Test
    public void testJourneyWithDifferentJourneyTypes() {
        // Prepare test data
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 5000;
        card = new MetroCard(journeyId, 420);
        passenger = new Passenger("ADULT", card);

        // Create a Journey instance with Single Journey type
        journeyType = "Single Journey";
        Journey singleJourney = new Journey(journeyId, passenger, destinationStation, journeyType);
        singleJourney.setEndTime(endTime);

        // Create a Journey instance with Return Journey type
        journeyType = "Return Journey";
        Journey returnJourney = new Journey(journeyId, passenger, destinationStation, journeyType);
        returnJourney.setEndTime(endTime);

        // Assert the values
        assertEquals("Single Journey", singleJourney.getJourneyType());
        assertEquals("Return Journey", returnJourney.getJourneyType());
    }

    @Test
    public void testJourneyWithNullDestinationStation() {
        // Prepare test data
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 5000;
        card = new MetroCard(journeyId, 420);
        passenger = new Passenger("ADULT", card);
        journeyType = "Single Journey";

        // Create a Journey instance with null destination station
        Journey journey = new Journey(journeyId, passenger, null, journeyType);
        journey.setEndTime(endTime);

        // Assert the values
        assertEquals(journeyId, journey.getJourneyId());
        assertEquals(passenger, journey.getPassenger());
        assertEquals(journeyType, journey.getJourneyType());
        assertEquals(startTime, journey.getStartTime());
        assertEquals(endTime, journey.getEndTime());
        assertNull(journey.getStation());
    }
}
