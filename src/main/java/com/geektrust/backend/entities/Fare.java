package com.geektrust.backend.entities;

public class Fare {
    private String passengerType;
    private double travelCharge;

    public Fare(String passengerType, double travelCharge) {
        this.passengerType = passengerType;
        this.travelCharge = travelCharge;
    }

    // Getter and setter methods
    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public double getTravelCharge() {
        return travelCharge;
    }

    public void setTravelCharge(double travelCharge) {
        this.travelCharge = travelCharge;
    }
}
