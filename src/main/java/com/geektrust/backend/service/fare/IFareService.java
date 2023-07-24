package com.geektrust.backend.service.fare;


public interface IFareService {
    double calculateFare(String passenger, String journeyType);
    double getBaseFare(String passengerType);
}
