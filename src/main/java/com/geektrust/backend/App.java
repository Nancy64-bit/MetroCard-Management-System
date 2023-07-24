package com.geektrust.backend;

import com.geektrust.backend.exceptions.CardNotFoundException;
import com.geektrust.backend.exceptions.InsufficientBalanceException;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;
import com.geektrust.backend.exceptions.StationNotFoundException;
import com.geektrust.backend.service.fare.FareService;
import com.geektrust.backend.service.fare.IFareService;
import com.geektrust.backend.service.metrocard.IMetroCardManagementService;
import com.geektrust.backend.service.metrocard.MetroCardManagementService;

public class App {

    public static void main(String[] args) throws StationNotFoundException, CardNotFoundException, InsufficientBalanceException, MetroCardNotFoundException {
        // Create instances of your services and other necessary dependencies
        
        IMetroCardManagementService metroCardManagementService = new MetroCardManagementService(null, null, null, null, null);
        IFareService fareService = new FareService();

        // Check if any command line arguments are provided
        if (args.length > 0) {
            // Extract the command and arguments from the command line
            String command = args[0];
            String[] commandArgs = new String[args.length - 1];
            System.arraycopy(args, 1, commandArgs, 0, commandArgs.length);

            // Perform operations based on the command
            switch (command) {
                case "BALANCE":
                    // Handle balance command
                    if (commandArgs.length >= 2) {
                        String metroCardNumber = commandArgs[0];
                        double balance = Double.parseDouble(commandArgs[1]);
                        // Call the method to set the balance of the MetroCard
                        metroCardManagementService.setBalance(metroCardNumber, balance);
                    } else {
                        System.out.println("Invalid BALANCE command");
                    }
                    break;

                case "CHECK_IN":
                    // Handle check-in command
                    if (commandArgs.length >= 3) {
                        String metroCardNumber = commandArgs[0];
                        String passengerType = commandArgs[1];
                        String station = commandArgs[2];
                        // Call the method to perform check-in for the MetroCard
                        metroCardManagementService.checkIn(metroCardNumber, passengerType, station);
                    } else {
                        System.out.println("Invalid CHECK_IN command");
                    }
                    break;

                case "PRINT_SUMMARY":
                    // Handle print summary command
                    // Call the method to print the summary
                    metroCardManagementService.printSummary();
                    break;

                default:
                    // Handle unrecognized commands
                    System.out.println("Invalid command");
                    break;
            }
        } else {
            // No command line arguments provided
            System.out.println("Please provide a command");
        }
    }
}
