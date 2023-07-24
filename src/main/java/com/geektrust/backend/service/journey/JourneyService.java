package com.geektrust.backend.service.journey;

import java.util.ArrayList;
import java.util.List;
import com.geektrust.backend.entities.Journey;
import com.geektrust.backend.exceptions.JourneyNotFoundException;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;

public class JourneyService implements IJourneyService {

    private List<Journey> journeys;

    public JourneyService() {
        journeys = new ArrayList<>();
    }

    @Override
    public void addJourney(Journey journey) {
        journeys.add(journey);
    }

    @Override
    public Journey findJourneyById(String journeyId) throws JourneyNotFoundException {
        for (Journey journey : journeys) {
            if (journey.getJourneyId().equals(journeyId)) {
                return journey;
            }
        }
        throw new JourneyNotFoundException("Journey not found: " + journeyId);
    }

    @Override
    public Journey startJourney(Passenger passenger, Station station) {
        Journey journey = new Journey(generateJourneyId(), passenger, station, passenger.getMetroCard().getJourneyType());
                journeys.add(journey);
                System.err.println(passenger.getMetroCard().getJourneyType());
                return journey;
    }

    @Override
    public void endJourney(String journeyId) {
        for (Journey journey : journeys) {
            if (journey.getJourneyId().equals(journeyId)) {
                journey.setEndTime(System.currentTimeMillis());
                return;
            }
        }
        throw new JourneyNotFoundException("Journey not found: " + journeyId);
    }

    private String generateJourneyId() {
        // Generate a unique ID for the journey
        // Replace this with your actual implementation to generate IDs
        return "J" + System.currentTimeMillis();
    }

    @Override
    public List<Journey> getAllJourneys() {
        return new ArrayList<>(journeys);
    }
   
}
