package com.geektrust.backend.serviceTest.metrocardTest;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;
import com.geektrust.backend.repository.MetroCardRepositoryImpl;
import com.geektrust.backend.service.metrocard.IMetroCardBalanceService;
import com.geektrust.backend.service.metrocard.MetroCardBalanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MetroCardBalanceServiceTest {

    private IMetroCardBalanceService balanceService;
    private MetroCardRepositoryImpl metroCardRepository;

    @BeforeEach
    public void setup() {
        // Initialize your service implementation or mock object
        metroCardRepository = mock(MetroCardRepositoryImpl.class);
        balanceService = new MetroCardBalanceService(metroCardRepository);
    }

    @Test
    public void testGetBalance() throws MetroCardNotFoundException {
        // Prepare test data
        String cardId = "CARD123";
        double expectedBalance = 100.0;
        MetroCard metroCard = new MetroCard(cardId, expectedBalance);
        when(metroCardRepository.findByNumber(cardId)).thenReturn(metroCard);

        // Call the method to test
        double actualBalance = balanceService.getBalance(cardId);

        // Assert the result
        assertEquals(expectedBalance, actualBalance);
        verify(metroCardRepository, times(1)).findByNumber(cardId);
    }

    @Test
    public void testRecharge() throws MetroCardNotFoundException {
        // Prepare test data
        String cardId = "CARD123";
        double initialBalance = 100.0;
        double rechargeAmount = 50.0;
        double expectedBalance = initialBalance + rechargeAmount;
        MetroCard metroCard = new MetroCard(cardId, initialBalance);
        when(metroCardRepository.findByNumber(cardId)).thenReturn(metroCard);

        // Call the method to test
        balanceService.recharge(cardId, rechargeAmount);

        // Assert the result
        assertEquals(expectedBalance, metroCard.getBalance());
        verify(metroCardRepository, times(1)).updateCard(metroCard);
    }

    @Test
    public void testDeductBalance() throws MetroCardNotFoundException {
        // Prepare test data
        String cardId = "CARD123";
        double initialBalance = 100.0;
        double deductionAmount = 50.0;
        double expectedBalance = initialBalance - deductionAmount;
        MetroCard metroCard = new MetroCard(cardId, initialBalance);
        when(metroCardRepository.findByNumber(cardId)).thenReturn(metroCard);

        // Call the method to test
        balanceService.deductBalance(cardId, deductionAmount);

        // Assert the result
        assertEquals(expectedBalance, metroCard.getBalance());
        verify(metroCardRepository, times(1)).updateCard(metroCard);
    }

    @Test
    public void testHasSufficientBalance() throws MetroCardNotFoundException {
        // Prepare test data
        String cardId = "CARD123";
        double currentBalance = 100.0;
        double sufficientAmount = 50.0;
        double insufficientAmount = 150.0;
        MetroCard metroCard = new MetroCard(cardId, currentBalance);
        when(metroCardRepository.findByNumber(cardId)).thenReturn(metroCard);

        // Call the method to test
        boolean hasSufficientBalance1 = balanceService.hasSufficientBalance(cardId, sufficientAmount);
        boolean hasSufficientBalance2 = balanceService.hasSufficientBalance(cardId, insufficientAmount);

        // Assert the results
        assertTrue(hasSufficientBalance1);
        assertFalse(hasSufficientBalance2);
        verify(metroCardRepository, times(2)).findByNumber(cardId);
    }

}