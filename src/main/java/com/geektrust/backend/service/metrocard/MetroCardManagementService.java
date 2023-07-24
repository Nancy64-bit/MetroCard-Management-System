package com.geektrust.backend.service.metrocard;

import java.util.List;
import java.util.Map;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Station;
import com.geektrust.backend.exceptions.CardNotFoundException;
import com.geektrust.backend.exceptions.InsufficientBalanceException;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;
import com.geektrust.backend.exceptions.StationNotFoundException;
import com.geektrust.backend.repository.MetroCardRepositoryImpl;
import com.geektrust.backend.service.fare.FareService;
import com.geektrust.backend.service.fare.IFareService;
import com.geektrust.backend.service.station.StationService;
import com.geektrust.backend.service.summary.ICollectionSummaryService;
import com.geektrust.backend.service.summary.IPassengerSummaryService;

public class MetroCardManagementService implements IMetroCardManagementService {

    private final MetroCardRepositoryImpl metroCardRepository;
    private final IFareService fareService;
    private final StationService stationService;
    private final ICollectionSummaryService collectionSummaryService;
    private final IPassengerSummaryService passengerSummaryService;

    public MetroCardManagementService(MetroCardRepositoryImpl metroCardRepository,
            FareService fareService, StationService stationService,
            ICollectionSummaryService collectionSummaryService,
            IPassengerSummaryService passengerSummaryService) {
        this.metroCardRepository = metroCardRepository;
        this.fareService = fareService;
        this.stationService = stationService;
        this.collectionSummaryService = collectionSummaryService;
        this.passengerSummaryService = passengerSummaryService;
    }

    @Override
    public void checkIn(String cardId, String passengerType, String stationCode)
            throws InsufficientBalanceException, StationNotFoundException, CardNotFoundException,
            MetroCardNotFoundException {
        Station station = stationService.getStationByCode(stationCode);
        if (station == null) {
            throw new StationNotFoundException("Invalid station code: " + stationCode);
        }

        MetroCard metroCard = metroCardRepository.findByNumber(cardId);
        if (metroCard == null) {
            throw new CardNotFoundException("MetroCard not found: " + cardId);
        }

        double fare = fareService.calculateFare(passengerType, metroCard.getJourneyType());
        double remainingBalance = metroCard.getBalance() - fare;
        if (remainingBalance < 0) {
            throw new InsufficientBalanceException("Insufficient balance on MetroCard: " + cardId);
        }

        metroCard.setBalance(remainingBalance);
        metroCardRepository.updateCard(metroCard);

        collectionSummaryService.addCollection(fare, 0.0, station.getName());
        passengerSummaryService.addPassenger(passengerType);
    }

    @Override
    public void setBalance(String cardId, double balance) throws MetroCardNotFoundException {
        metroCardRepository.updateCardBalance(cardId, balance);
    }

    @Override
    public double getBalance(String cardId)
            throws CardNotFoundException, MetroCardNotFoundException {
        MetroCard metroCard = metroCardRepository.findByNumber(cardId);
        if (metroCard == null) {
            throw new CardNotFoundException("MetroCard not found: " + cardId);
        }
        return metroCard.getBalance();
    }

    @Override
    public void rechargeCard(String cardId, double amount)
            throws CardNotFoundException, MetroCardNotFoundException {
        MetroCard metroCard = metroCardRepository.findByNumber(cardId);
        if (metroCard == null) {
            throw new CardNotFoundException("MetroCard not found: " + cardId);
        }

        double rechargeAmount = amount + (amount * 0.02); // Apply 2% service fee
        double newBalance = metroCard.getBalance() + rechargeAmount;
        metroCard.setBalance(newBalance);
        metroCardRepository.updateCard(metroCard);
    }

    @Override
    public void printSummary() {
        System.out.println("Collection Summary");
        System.out.println("Total Amount: " + collectionSummaryService.getTotalAmount());
        System.out.println("Total Discount: " + collectionSummaryService.getTotalDiscount());
        System.out.println("Station-wise Collection:");
        Map<String, Double> stationWiseCollection =
                collectionSummaryService.getStationWiseCollection();
        for (Map.Entry<String, Double> entry : stationWiseCollection.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Passenger Summary");
        Map<String, Integer> passengerTypeCounts = passengerSummaryService.getPassengerTypeCounts();
        for (Map.Entry<String, Integer> entry : passengerTypeCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        List<String> passengerSummary = passengerSummaryService.getPassengerSummary();
        System.out.println("Passenger Summary (Sorted):");
        for (String passengerType : passengerSummary) {
            System.out.println(passengerType);
        }
    }

}
