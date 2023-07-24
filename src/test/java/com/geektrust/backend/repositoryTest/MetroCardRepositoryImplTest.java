package com.geektrust.backend.repositoryTest;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;
import com.geektrust.backend.repository.MetroCardRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MetroCardRepositoryImplTest {

    private MetroCardRepositoryImpl metroCardRepository;

    @BeforeEach
    public void setUp() {
        // Initialize the MetroCardRepositoryImpl
        metroCardRepository = new MetroCardRepositoryImpl();
    }

    @Test
    public void testAddMetroCard() throws MetroCardNotFoundException {
        // Prepare test data
        MetroCard metroCard = new MetroCard("MC123", 100.0);

        // Add the metro card
        metroCardRepository.addMetroCard(metroCard);

        // Retrieve the metro card by number
        MetroCard retrievedCard = metroCardRepository.findByNumber("MC123");

        // Assert the result
        assertNotNull(retrievedCard);
        assertEquals(metroCard, retrievedCard);
    }

    @Test
    public void testFindByNumber_MetroCardNotFound() {
        // Try to find a non-existent metro card
        assertThrows(MetroCardNotFoundException.class, () -> {
            metroCardRepository.findByNumber("MC456");
        });
    }

    @Test
    public void testGetCardById() throws MetroCardNotFoundException {
        // Prepare test data
        MetroCard metroCard = new MetroCard("MC789", 200.0);
        metroCardRepository.addMetroCard(metroCard);

        // Retrieve the metro card by ID
        MetroCard retrievedCard = metroCardRepository.findByNumber("MC789");

        // Assert the result
        assertNotNull(retrievedCard);
        assertEquals(metroCard, retrievedCard);
    }

    @Test
    public void testUpdateCard() throws MetroCardNotFoundException {
        // Prepare test data
        MetroCard metroCard = new MetroCard("MC789", 200.0);
        metroCardRepository.addMetroCard(metroCard);

        // Update the balance of the metro card
        metroCard.setBalance(300.0);
        metroCardRepository.updateCard(metroCard);

        // Retrieve the updated metro card
        MetroCard updatedCard = metroCardRepository.findByNumber("MC789");

        // Assert the updated balance
        assertNotNull(updatedCard);
        assertEquals(300.0, updatedCard.getBalance());
    }
}
