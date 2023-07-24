package com.geektrust.backend.serviceTest.journeyTest;

import com.geektrust.backend.entities.Journey;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;
import com.geektrust.backend.exceptions.JourneyNotFoundException;
import com.geektrust.backend.service.journey.IJourneyService;
import com.geektrust.backend.service.journey.JourneyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JourneyServiceTest {

    private IJourneyService journeyService;

    public void setJourneyService(IJourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @BeforeEach
    public void setup() {
        journeyService = new JourneyService();
    }

    // Other tests...

    @Ignore
    public void testFindJourneyById_JourneyFound() throws JourneyNotFoundException {
        Journey journey = createDummyJourney();
        journeyService.addJourney(journey);

        Journey foundJourney = journeyService.findJourneyById(journey.getJourneyId());
        Assertions.assertEquals(journey, foundJourney);
    }

    @Test
    public void testFindJourneyById_JourneyNotFound() {
        String invalidJourneyId = "invalid-id";
        Assertions.assertThrows(JourneyNotFoundException.class, () -> {
            journeyService.findJourneyById(invalidJourneyId);
        });
    }

    // Helper method to create a dummy journey
    private Journey createDummyJourney() {
        String journeyType = "Regular";
        MetroCard card = new MetroCard("SHI11", 10.0);
        Passenger passenger = new Passenger("ADULT", card);
        Station sourceStation = new Station("AIRPORT", null);
        Station destinationStation = new Station("CENTRAL", null);
        return new Journey("journey-123", sourceStation, destinationStation, passenger, journeyType);
    }
}
