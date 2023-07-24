package com.geektrust.backend.serviceTest.metrocardTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
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
import com.geektrust.backend.service.metrocard.IMetroCardBalanceService;
import com.geektrust.backend.service.metrocard.IMetroCardManagementService;
import com.geektrust.backend.service.metrocard.MetroCardManagementService;
import com.geektrust.backend.service.station.StationService;
import com.geektrust.backend.service.summary.ICollectionSummaryService;
import com.geektrust.backend.service.summary.IPassengerSummaryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MetroCardManagementServiceTest {

    @Mock
    private MetroCardRepositoryImpl metroCardRepository;
    @Mock
    private FareService fareService;
    @Mock
    private StationService stationService;
    @Mock
    private IMetroCardBalanceService balanceService;
    @Mock
    private ICollectionSummaryService collectionSummaryService;
    @Mock
    private IPassengerSummaryService passengerSummaryService;

    private IMetroCardManagementService metroCardManagementService;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        metroCardManagementService = new MetroCardManagementService(
                metroCardRepository,
                fareService,
                stationService,
                collectionSummaryService,
                passengerSummaryService
        );
    }
    
    @Test
    public void testCheckIn_InvalidStationCode_ThrowsStationNotFoundException() {
        String cardId = "MC1";
        String passengerType = "ADULT";
        String stationCode = "INVALID";

        Mockito.when(stationService.getStationByCode(stationCode)).thenReturn(null);

        Assertions.assertThrows(StationNotFoundException.class, () ->
                metroCardManagementService.checkIn(cardId, passengerType, stationCode));
    }

    @Test
    public void testCheckIn_CardNotFound_ThrowsCardNotFoundException() throws MetroCardNotFoundException {
        String cardId = "INVALID";
        String passengerType = "ADULT";
        String stationCode = "CENTRAL";

        Station station = new Station(stationCode, "CENTRAL");

        Mockito.when(stationService.getStationByCode(stationCode)).thenReturn(station);
        Mockito.when(metroCardRepository.findByNumber(cardId)).thenReturn(null);

        Assertions.assertThrows(CardNotFoundException.class, () ->
                metroCardManagementService.checkIn(cardId, passengerType, stationCode));
    }

    
    public void testCheckIn_InsufficientBalance_ThrowsInsufficientBalanceException() throws CardNotFoundException, StationNotFoundException, MetroCardNotFoundException {
        String cardId = "MC1";
        String passengerType = "ADULT";
        String stationCode = "CENTRAL";
    
        Station station = new Station(stationCode, "CENTRAL");
        MetroCard metroCard = new MetroCard(cardId, 50.0);
    
        Mockito.when(stationService.getStationByCode(stationCode)).thenReturn(station);
        Mockito.when(metroCardRepository.findByNumber(cardId)).thenReturn(metroCard);
    
        Assertions.assertThrows(InsufficientBalanceException.class, () ->
                metroCardManagementService.checkIn(cardId, passengerType, stationCode));
    }
    

    @Test
    public void testCheckIn_SuccessfulCheckIn() throws CardNotFoundException, StationNotFoundException, InsufficientBalanceException, MetroCardNotFoundException {
        String cardId = "MC1";
        String passengerType = "ADULT";
        String stationCode = "CENTRAL";

        Station station = new Station(stationCode, "CENTRAL");
        MetroCard metroCard = new MetroCard(cardId, 100.0);

        Mockito.when(stationService.getStationByCode(stationCode)).thenReturn(station);
        Mockito.when(metroCardRepository.findByNumber(cardId)).thenReturn(metroCard);

        metroCardManagementService.checkIn(cardId, passengerType, stationCode);

    }

    @Test
    public void testGetBalance_CardNotFound_ThrowsCardNotFoundException() throws MetroCardNotFoundException {
        String cardId = "INVALID";

        Mockito.when(metroCardRepository.findByNumber(cardId)).thenReturn(null);

        Assertions.assertThrows(CardNotFoundException.class, () ->
                metroCardManagementService.getBalance(cardId));
    }

    @Test
    public void testGetBalance_CardFound_ReturnsBalance() throws CardNotFoundException, MetroCardNotFoundException {
        String cardId = "MC1";
        double expectedBalance = 150.0;

        MetroCard metroCard = new MetroCard(cardId, expectedBalance);

        Mockito.when(metroCardRepository.findByNumber(cardId)).thenReturn(metroCard);

        double actualBalance = metroCardManagementService.getBalance(cardId);

        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void testRechargeCard_CardNotFound_ThrowsCardNotFoundException() {
        String cardId = "INVALID";
        double amount = 100.0;

        try {
            Mockito.when(metroCardRepository.findByNumber(cardId)).thenReturn(null);
        } catch (MetroCardNotFoundException e) {
            e.printStackTrace();
        }

        Assertions.assertThrows(CardNotFoundException.class, () ->
                metroCardManagementService.rechargeCard(cardId, amount));
    }

    
    public void testRechargeCard_CardFound_RechargesBalance() throws CardNotFoundException, MetroCardNotFoundException {
        String cardId = "MC1";
        double initialBalance = 100.0;
        double rechargeAmount = 50.0;
        double expectedBalance = initialBalance + rechargeAmount;
    
        MetroCard metroCard = new MetroCard(cardId, initialBalance);
    
        Mockito.when(metroCardRepository.findByNumber(cardId)).thenReturn(metroCard);
    
        metroCardManagementService.rechargeCard(cardId, rechargeAmount);
    
        double actualBalance = metroCard.getBalance();
    
        Assertions.assertEquals(expectedBalance, actualBalance);
    }
    

    
    public void testPrintCollectionSummary() {
        double totalAmount = 100.0;
        double totalDiscount = 10.0;
        Map<String, Double> stationWiseCollection = new HashMap<>();
        stationWiseCollection.put("Station1", 50.0);
        stationWiseCollection.put("Station2", 30.0);
    
        Mockito.when(collectionSummaryService.getTotalAmount()).thenReturn(totalAmount);
        Mockito.when(collectionSummaryService.getTotalDiscount()).thenReturn(totalDiscount);
        Mockito.when(collectionSummaryService.getStationWiseCollection()).thenReturn(stationWiseCollection);
    
        Map<String, Integer> passengerTypeCounts = new HashMap<>();
        passengerTypeCounts.put("ADULT", 5);
        passengerTypeCounts.put("CHILD", 3);
        passengerTypeCounts.put("SENIOR", 2);
    
        Mockito.when(passengerSummaryService.getPassengerTypeCounts()).thenReturn(passengerTypeCounts);
    
        List<String> passengerSummary = Arrays.asList("ADULT", "CHILD", "SENIOR");
        Mockito.when(passengerSummaryService.getPassengerSummary()).thenReturn(passengerSummary);
    
        String expectedOutput = "Collection Summary\n" +
                "Total Amount: 100.0\n" +
                "Total Discount: 10.0\n" +
                "Station-wise Collection:\n" +
                "Station1: 50.0\n" +
                "Station2: 30.0\n" +
                "Passenger Summary\n" +
                "ADULT: 5\n" +
                "CHILD: 3\n" +
                "SENIOR: 2\n" +
                "Passenger Summary (Sorted):\n" +
                "ADULT\n" +
                "CHILD\n" +
                "SENIOR\n";
    
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    
        metroCardManagementService.printSummary();
    
        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }
      

    
    public void testPrintPassengerSummary() {
        Map<String, Integer> passengerTypeCounts = new HashMap<>();
        passengerTypeCounts.put("ADULT", 5);
        passengerTypeCounts.put("CHILD", 3);
        passengerTypeCounts.put("SENIOR", 2);
    
        Mockito.when(passengerSummaryService.getPassengerTypeCounts()).thenReturn(passengerTypeCounts);
    
        String expectedOutput = "Passenger Summary\n" +
                "Passenger Type Counts:\n" +
                "ADULT: " + passengerTypeCounts.get("ADULT") + "\n" +
                "CHILD: " + passengerTypeCounts.get("CHILD") + "\n" +
                "SENIOR: " + passengerTypeCounts.get("SENIOR") + "\n" +
                "Passenger Summary (Sorted):\n" +
                "ADULT\n" +
                "CHILD\n" +
                "SENIOR\n";
    
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    
        metroCardManagementService.printSummary();
    
        String actualOutput = outputStream.toString();
    
        Assertions.assertEquals(expectedOutput.trim(), actualOutput.trim());
    }
    

}

