package com.geektrust.backend.entities;

public class MetroCard {
    private String cardId;
    private double balance;
    private Station lastUsedStation;
    private String journeyType;

    public MetroCard(String cardId, double balance) {
        this.cardId = cardId;
        this.balance = balance;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardNumber) {
        this.cardId = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getJourneyType() {
        return journeyType;
    }

    public void setJourneyType(String journeyType) {
        this.journeyType = journeyType;
    }
    
    public Station getLastUsedStation() {
        return lastUsedStation;
    }

    public void setLastUsedStation(Station lastUsedStation) {
        this.lastUsedStation = lastUsedStation;
    }
}
