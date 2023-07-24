package com.geektrust.backend.serviceTest.summaryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;
import com.geektrust.backend.service.summary.CollectionSummaryServiceImpl;
import com.geektrust.backend.service.summary.ICollectionSummaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectionSummaryServiceTest {
    
    private ICollectionSummaryService collectionSummaryService;

    @BeforeEach
    public void setUp() {
        // Create an instance of the CollectionSummaryService implementation or mock it using Mockito
        collectionSummaryService = new CollectionSummaryServiceImpl();
    }

    @Test
    public void testAddCollection() {
        // Arrange
        double amount = 100.0;
        double discount = 20.0;
        String stationName = "Central";
        
        // Act
        collectionSummaryService.addCollection(amount, discount, stationName);
        
        // Assert
        // You can add assertions here to check if the data is correctly added to the service
    }

    @Test
    public void testGetTotalAmount() {
        // Arrange
        double expectedTotalAmount = 500.0;
        // Mock the data in the service
        ICollectionSummaryService collectionSummaryService = mock(ICollectionSummaryService.class);
        when(collectionSummaryService.getTotalAmount()).thenReturn(expectedTotalAmount);

        // Act
        double totalAmount = collectionSummaryService.getTotalAmount();

        // Assert
        assertEquals(expectedTotalAmount, totalAmount);
    }

    @Test
    public void testGetTotalDiscount() {
        // Arrange
        double expectedTotalDiscount = 50.0;
        // Mock the data in the service
        ICollectionSummaryService collectionSummaryService = mock(ICollectionSummaryService.class);
        when(collectionSummaryService.getTotalDiscount()).thenReturn(expectedTotalDiscount);

        // Act
        double totalDiscount = collectionSummaryService.getTotalDiscount();

        // Assert
        assertEquals(expectedTotalDiscount, totalDiscount);
    }

    @Test
    public void testGetStationWiseCollection() {
        // Arrange
        Map<String, Double> expectedStationWiseCollection = new HashMap<>();
        expectedStationWiseCollection.put("Station1", 100.0);
        expectedStationWiseCollection.put("Station2", 200.0);
        expectedStationWiseCollection.put("Station3", 300.0);
        // Mock the data in the service
        ICollectionSummaryService collectionSummaryService = mock(ICollectionSummaryService.class);
        when(collectionSummaryService.getStationWiseCollection()).thenReturn(expectedStationWiseCollection);

        // Act
        Map<String, Double> stationWiseCollection = collectionSummaryService.getStationWiseCollection();

        // Assert
        assertEquals(expectedStationWiseCollection, stationWiseCollection);
    }
   
}
