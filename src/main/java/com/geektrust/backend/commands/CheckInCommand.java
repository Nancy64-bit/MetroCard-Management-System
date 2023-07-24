package com.geektrust.backend.commands;

import com.geektrust.backend.exceptions.CardNotFoundException;
import com.geektrust.backend.exceptions.InsufficientBalanceException;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;
import com.geektrust.backend.exceptions.StationNotFoundException;
import com.geektrust.backend.service.metrocard.IMetroCardManagementService;

public class CheckInCommand {
    private IMetroCardManagementService metroCardManagementService;
    private final int argsLength = 3;

    public CheckInCommand(IMetroCardManagementService metroCardManagementService) {
        this.metroCardManagementService = metroCardManagementService;
    }


    public void execute(String[] args) throws InsufficientBalanceException, StationNotFoundException, CardNotFoundException, MetroCardNotFoundException {
        // Check if the command has the correct number of arguments
        
        if (args.length == argsLength) {
            String metroCardNumber = args[0];
            String passengerType = args[1];
            String fromStation = args[2];

            // Call the checkIn method of the MetroCardManagementService
            metroCardManagementService.checkIn(metroCardNumber, passengerType, fromStation);
        } else {
            System.out.println("Invalid arguments for CHECK_IN command");
        }
    }
}
