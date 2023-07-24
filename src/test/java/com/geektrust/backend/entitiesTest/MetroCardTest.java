package com.geektrust.backend.entitiesTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.entities.Station;
import com.geektrust.backend.entities.MetroCard;

public class MetroCardTest {

    @Test
    public void testGetCardId() {
        // Arrange
        String cardId = "MC123";
        double balance = 500.0;
        MetroCard metroCard = new MetroCard(cardId, balance);

        // Act
        String result = metroCard.getCardId();

        // Assert
        assertEquals(cardId, result);
    }

    @Test
    public void testSetCardId() {
        // Arrange
        String cardId = "MC456";
        double balance = 700.0;
        MetroCard metroCard = new MetroCard("MC123", balance);

        // Act
        metroCard.setCardId(cardId);

        // Assert
        assertEquals(cardId, metroCard.getCardId());
    }

    @Test
    public void testGetBalance() {
        // Arrange
        String cardId = "MC789";
        double balance = 1000.0;
        MetroCard metroCard = new MetroCard(cardId, balance);

        // Act
        double result = metroCard.getBalance();

        // Assert
        assertEquals(balance, result);
    }

    @Test
    public void testSetBalance() {
        // Arrange
        String cardId = "MC101";
        double balance = 1500.0;
        MetroCard metroCard = new MetroCard(cardId, 1200.0);

        // Act
        metroCard.setBalance(balance);

        // Assert
        assertEquals(balance, metroCard.getBalance());
    }

    @Test
    public void testGetJourneyType() {
        // Arrange
        String cardId = "MC111";
        double balance = 2000.0;
        String journeyType = "Single Journey";
        MetroCard metroCard = new MetroCard(cardId, balance);
        metroCard.setJourneyType(journeyType);

        // Act
        String result = metroCard.getJourneyType();

        // Assert
        assertEquals(journeyType, result);
    }

    @Test
    public void testSetJourneyType() {
        // Arrange
        String cardId = "MC222";
        double balance = 3000.0;
        String journeyType = "Return Journey";
        MetroCard metroCard = new MetroCard(cardId, balance);

        // Act
        metroCard.setJourneyType(journeyType);

        // Assert
        assertEquals(journeyType, metroCard.getJourneyType());
    }

    @Test
    public void testGetLastUsedStation() {
        // Arrange
        String cardId = "MC333";
        double balance = 4000.0;
        Station lastUsedStation = new Station("CENTRAL", "CS123");
        MetroCard metroCard = new MetroCard(cardId, balance);
        metroCard.setLastUsedStation(lastUsedStation);

        // Act
        Station result = metroCard.getLastUsedStation();

        // Assert
        assertEquals(lastUsedStation, result);
    }

    @Test
    public void testSetLastUsedStation() {
        // Arrange
        String cardId = "MC444";
        double balance = 5000.0;
        Station lastUsedStation = new Station("AIRPORT", "AP456");
        MetroCard metroCard = new MetroCard(cardId, balance);

        // Act
        metroCard.setLastUsedStation(lastUsedStation);

        // Assert
        assertEquals(lastUsedStation, metroCard.getLastUsedStation());
    }

}
