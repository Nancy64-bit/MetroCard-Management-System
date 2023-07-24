package com.geektrust.backend.repository;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class MetroCardRepositoryImpl implements IMetroCardRepository {

    private Map<String, MetroCard> metroCards;

    public MetroCardRepositoryImpl() {
        metroCards = new HashMap<>();
    }

    @Override
    public void addMetroCard(MetroCard metroCard) {
        metroCards.put(metroCard.getCardId(), metroCard);
    }

    @Override
    public MetroCard findByNumber(String metroCardNumber) throws MetroCardNotFoundException {
        MetroCard metroCard = metroCards.get(metroCardNumber);
        if (metroCard == null) {
            throw new MetroCardNotFoundException("MetroCard with number " + metroCardNumber + " not found");
        }
        return metroCard;
    }

    @Override
    public void updateCard(MetroCard metroCard) {
        metroCards.put(metroCard.getCardId(), metroCard);
    }

    @Override
    public void updateCardBalance(String cardId, double balance) throws MetroCardNotFoundException {
        MetroCard metroCard = metroCards.get(cardId);
        if (metroCard == null) {
            throw new MetroCardNotFoundException("MetroCard not found: " + cardId);
        }
        metroCard.setBalance(balance);
        metroCards.put(cardId, metroCard);
    }
}
