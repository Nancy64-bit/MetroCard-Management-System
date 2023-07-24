package com.geektrust.backend.entities;

public class Passenger {
    private String passengerType;
    private MetroCard metroCard;

    public Passenger(String passengerType, MetroCard card) {
        this.passengerType = passengerType;
        this.metroCard = card;
    }

    // Getter and setter methods


   public String getPassengerType() {
        return passengerType;
    }

    public void setType(String passengerType) {
        this.passengerType = passengerType;
    }

    public MetroCard getMetroCard() {
        return metroCard;
    }

    public void setMetroCard(MetroCard metroCard) {
        this.metroCard = metroCard;
    }
}
