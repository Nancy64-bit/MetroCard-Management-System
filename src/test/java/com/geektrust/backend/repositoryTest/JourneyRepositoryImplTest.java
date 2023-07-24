package com.geektrust.backend.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.geektrust.backend.entities.Journey;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;
import com.geektrust.backend.exceptions.JourneyNotFoundException;
import com.geektrust.backend.repository.IJourneyRepository;
import com.geektrust.backend.repository.JourneyRepositoryImpl;

public class JourneyRepositoryImplTest {

    private IJourneyRepository journeyRepository;
    private String journeyId;
    private Station station1;
    private Station station2;
    private Passenger passenger;
    private String journeyType;
    private MetroCard metroCard;

    @BeforeEach
    public void setUp() {
        journeyRepository = new JourneyRepositoryImpl();
        journeyId = "J123";
        station1 = new Station("CENTRAL", journeyId);
        station1 = new Station("AIRPORT", journeyId);

        passenger = new Passenger("John Doe", metroCard);
        journeyType = "Single Journey";
    }

    @Test
    public void testAddJourney() {
        // Prepare test data
        Journey journey = new Journey(journeyId, passenger, station2, journeyType);

        // Add the journey to the repository
        journeyRepository.addJourney(journey);

        // Retrieve all journeys from the repository
        List<Journey> allJourneys = journeyRepository.getAllJourneys();

        // Verify that the added journey is in the repository
        assertTrue(allJourneys.contains(journey));
    }

    @Test
    public void testFindJourneyById() throws JourneyNotFoundException {
        // Prepare test data
        Journey journey1 = new Journey("Journey1",  passenger, station2, journeyType);
        Journey journey2 = new Journey("DemoJourney", passenger, station1, journeyType);
        journeyRepository.addJourney(journey1);
        journeyRepository.addJourney(journey2);

        // Find a journey by its ID
        Journey foundJourney = journeyRepository.findJourneyById("Journey1");

        // Verify that the correct journey is found
        assertEquals(journey1, foundJourney);
    }

    @Test
    public void testFindJourneyByIdNotFound() {
        // Try to find a journey that does not exist
        assertThrows(JourneyNotFoundException.class, () -> {
            journeyRepository.findJourneyById("NonExistentJourney");
        });
    }

    @Test
    public void testGetAllJourneys() {
        // Prepare test data
        Journey journey1 = new Journey("Journey1",  passenger, station2, journeyType);
        Journey journey2 = new Journey("Journey2", passenger, station1, journeyType);
        journeyRepository.addJourney(journey1);
        journeyRepository.addJourney(journey2);

        // Retrieve all journeys from the repository
        List<Journey> allJourneys = journeyRepository.getAllJourneys();

        // Verify that the retrieved list contains all added journeys
        assertEquals(2, allJourneys.size());
        assertTrue(allJourneys.contains(journey1));
        assertTrue(allJourneys.contains(journey2));
    }
}
