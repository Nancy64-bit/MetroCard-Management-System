package com.geektrust.backend.service.journey;

import java.util.List;
import com.geektrust.backend.entities.Journey;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.exceptions.JourneyNotFoundException;
import com.geektrust.backend.entities.Station;

public interface IJourneyService {
    void addJourney(Journey journey);
    Journey findJourneyById(String journeyId) throws JourneyNotFoundException;
    public Journey startJourney(Passenger passenger, Station station);
    void endJourney(String journeyId);
    List<Journey> getAllJourneys();
}

