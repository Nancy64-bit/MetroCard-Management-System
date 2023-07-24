package com.geektrust.backend.repository;

import java.util.List;
import com.geektrust.backend.entities.Journey;
import com.geektrust.backend.exceptions.JourneyNotFoundException;

public interface IJourneyRepository {
    void addJourney(Journey journey);
    Journey findJourneyById(String journeyId) throws JourneyNotFoundException;
    List<Journey> getAllJourneys();
}

