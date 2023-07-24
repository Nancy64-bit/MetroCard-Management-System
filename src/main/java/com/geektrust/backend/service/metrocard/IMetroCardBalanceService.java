package com.geektrust.backend.service.metrocard;

import com.geektrust.backend.exceptions.MetroCardNotFoundException;

public interface IMetroCardBalanceService {
    double getBalance(String cardId) throws MetroCardNotFoundException;
    void setBalance(String metroCardNumber, double balance) throws MetroCardNotFoundException;
    void recharge(String cardId, double amount) throws MetroCardNotFoundException;
    void deductBalance(String cardId, double amount) throws MetroCardNotFoundException;
    boolean hasSufficientBalance(String cardId, double amount) throws MetroCardNotFoundException;
}
