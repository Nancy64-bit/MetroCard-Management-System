package com.geektrust.backend.repository;

import com.geektrust.backend.entities.Journey;
import com.geektrust.backend.exceptions.JourneyNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class JourneyRepositoryImpl implements IJourneyRepository {

    private List<Journey> journeys;

    public JourneyRepositoryImpl() {
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
    public List<Journey> getAllJourneys() {
        return new ArrayList<>(journeys);
    }
}

