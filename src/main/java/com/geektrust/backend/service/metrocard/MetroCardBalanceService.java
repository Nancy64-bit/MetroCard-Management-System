package com.geektrust.backend.service.metrocard;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;
import com.geektrust.backend.repository.MetroCardRepositoryImpl;

public class MetroCardBalanceService implements IMetroCardBalanceService {

    private final MetroCardRepositoryImpl metroCardRepository;

    public MetroCardBalanceService(MetroCardRepositoryImpl metroCardRepository) {
        this.metroCardRepository = metroCardRepository;
    }

    @Override
    public double getBalance(String cardId) throws MetroCardNotFoundException {
        MetroCard metroCard = metroCardRepository.findByNumber(cardId);
        if (metroCard != null) {
            return metroCard.getBalance();
        }
        return 0.0;
    }

    @Override
    public void recharge(String cardId, double amount) throws MetroCardNotFoundException {
        MetroCard metroCard = metroCardRepository.findByNumber(cardId);
        if (metroCard != null) {
            double newBalance = metroCard.getBalance() + amount;
            metroCard.setBalance(newBalance);
            metroCardRepository.updateCard(metroCard);
        }
    }

    @Override
    public void deductBalance(String cardId, double amount) throws MetroCardNotFoundException {
        MetroCard metroCard = metroCardRepository.findByNumber(cardId);
        if (metroCard != null) {
            double newBalance = metroCard.getBalance() - amount;
            metroCard.setBalance(newBalance);
            metroCardRepository.updateCard(metroCard);
        }
    }

    @Override
    public boolean hasSufficientBalance(String cardId, double amount) throws MetroCardNotFoundException {
        MetroCard metroCard = metroCardRepository.findByNumber(cardId);
        return metroCard != null && metroCard.getBalance() >= amount;
    }

    @Override
    public void setBalance(String metroCardNumber, double balance) throws MetroCardNotFoundException {
        MetroCard metroCard = metroCardRepository.findByNumber(metroCardNumber);
        if (metroCard != null) {
            metroCard.setBalance(balance);
            metroCardRepository.updateCard(metroCard);
        }
    }
}
