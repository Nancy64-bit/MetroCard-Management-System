package com.geektrust.backend.repository;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;

public interface IMetroCardRepository {
    void addMetroCard(MetroCard metroCard);
    MetroCard findByNumber(String metroCardNumber) throws MetroCardNotFoundException;
    void updateCard(MetroCard metroCard);
    public void updateCardBalance(String cardId, double balance) throws MetroCardNotFoundException;
}
