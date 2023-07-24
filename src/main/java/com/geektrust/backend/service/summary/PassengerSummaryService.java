package com.geektrust.backend.service.summary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerSummaryService implements IPassengerSummaryService {
    private Map<String, Integer> passengerTypeCounts;

    public PassengerSummaryService() {
        passengerTypeCounts = new HashMap<>();
    }

    @Override
    public void addPassenger(String passengerType) {
        passengerTypeCounts.put(passengerType, passengerTypeCounts.getOrDefault(passengerType, 0) + 1);
    }

    @Override
    public Map<String, Integer> getPassengerTypeCounts() {
        return passengerTypeCounts;
    }

    @Override
    public List<String> getPassengerSummary() {
        List<String> summary = new ArrayList<>(passengerTypeCounts.keySet());
        summary.sort((a, b) -> {
            int countComparison = Integer.compare(passengerTypeCounts.get(b), passengerTypeCounts.get(a));
            if (countComparison == 0) {
                return a.compareTo(b);
            }
            return countComparison;
        });
        return summary;
    }
}
