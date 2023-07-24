package com.geektrust.backend.service.summary;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionSummaryServiceImpl implements ICollectionSummaryService {
    private double totalAmount;
    private double totalDiscount;
    private Map<String, Double> stationWiseCollection;
    private Map<String, Integer> passengerTypeCounts;

    public CollectionSummaryServiceImpl() {
        this.totalAmount = 0.0;
        this.totalDiscount = 0.0;
        this.stationWiseCollection = new HashMap<>();
        this.passengerTypeCounts = new LinkedHashMap<>();
    }

    @Override
    public void addCollection(double amount, double discount, String stationName) {
        totalAmount += amount;
        totalDiscount += discount;

        stationWiseCollection.put(stationName, stationWiseCollection.getOrDefault(stationName, 0.0) + amount);

        // Increment passenger type count for the station
        passengerTypeCounts.put(stationName, passengerTypeCounts.getOrDefault(stationName, 0) + 1);
    }

    @Override
    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public double getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public Map<String, Double> getStationWiseCollection() {
        return stationWiseCollection;
    }


}
