package com.geektrust.backend.entities;

public class PassengerSummary {
    private String passengerType;
    private int passengerCount;

    public PassengerSummary(String passengerType, int passengerCount) {
        this.passengerType = passengerType;
        this.passengerCount = passengerCount;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public int getPassengerCount() {
        return passengerCount;
    }
}
