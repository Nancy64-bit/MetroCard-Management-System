package com.geektrust.backend.service.fare;

public class FareService implements IFareService {
    private final int adultFare = 200;
    private final int kidFare = 50;
    private final int seniorCitizen = 100;

    @Override
    public double calculateFare(String passengerType, String journeyType) {
        double baseFare = getBaseFare(passengerType);
        if (journeyType.equals("Return Journey")) {
            baseFare *= 0.5; // Apply 50% discount for return journey
        }
        return baseFare;
    }
    
    @Override
    public double getBaseFare(String passengerType) {

        switch (passengerType) {
            case "ADULT":
                return adultFare;
            case "KID":
                return kidFare;
            case "SENIOR_CITIZEN":
                return seniorCitizen;
            default:
                throw new IllegalArgumentException("Invalid passenger type: " + passengerType);
        }
    }
}
