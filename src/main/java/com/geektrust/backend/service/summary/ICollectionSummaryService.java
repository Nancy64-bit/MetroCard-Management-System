package com.geektrust.backend.service.summary;

import java.util.Map;

public interface ICollectionSummaryService {
    void addCollection(double amount, double discount, String stationName);
    double getTotalAmount();
    double getTotalDiscount();
    Map<String, Double> getStationWiseCollection();
}
