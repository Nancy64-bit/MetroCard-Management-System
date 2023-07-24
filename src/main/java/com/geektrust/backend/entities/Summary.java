package com.geektrust.backend.entities;

public class Summary {
    private String stationName;
    private double totalCollection;
    private double totalDiscount;
    private PassengerSummary[] passengerSummaries;

    public Summary(String stationName, double totalCollection, double totalDiscount, PassengerSummary[] passengerSummaries) {
        this.stationName = stationName;
        this.totalCollection = totalCollection;
        this.totalDiscount = totalDiscount;
        this.passengerSummaries = passengerSummaries;
    }

    public String getStationName() {
        return stationName;
    }

    public double getTotalCollection() {
        return totalCollection;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public PassengerSummary[] getPassengerSummaries() {
        return passengerSummaries;
    }
}
