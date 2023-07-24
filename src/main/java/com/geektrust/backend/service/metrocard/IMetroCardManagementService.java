package com.geektrust.backend.service.metrocard;

import com.geektrust.backend.exceptions.CardNotFoundException;
import com.geektrust.backend.exceptions.InsufficientBalanceException;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;
import com.geektrust.backend.exceptions.StationNotFoundException;

public interface IMetroCardManagementService {
    void checkIn(String cardId, String passangerType, String stationCode) throws InsufficientBalanceException, StationNotFoundException, CardNotFoundException, MetroCardNotFoundException;
    double getBalance(String cardId) throws CardNotFoundException, MetroCardNotFoundException;
    public void setBalance(String cardId, double balance) throws MetroCardNotFoundException;
        void rechargeCard(String cardId, double amount) throws CardNotFoundException, MetroCardNotFoundException;
    void printSummary();
}
