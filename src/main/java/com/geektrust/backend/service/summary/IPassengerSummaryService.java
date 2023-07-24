package com.geektrust.backend.service.summary;

import java.util.List;
import java.util.Map;

public interface IPassengerSummaryService {
    void addPassenger(String passengerType);
    Map<String, Integer> getPassengerTypeCounts();
    List<String> getPassengerSummary();
}
