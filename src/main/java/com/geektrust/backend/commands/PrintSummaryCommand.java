// package com.geektrust.backend.commands;

// import com.geektrust.backend.service.metrocard.IMetroCardBalanceService;
// import com.geektrust.backend.service.summary.ICollectionSummaryService;
// import com.geektrust.backend.service.summary.IPassengerSummaryService;

// public class PrintSummaryCommand {
//     private final ICollectionSummaryService collectionSummaryService;
//     private final IPassengerSummaryService passengerSummaryService;

//     public PrintSummaryCommand(ICollectionSummaryService collectionSummaryService, IPassengerSummaryService passengerSummaryService) {
//         this.collectionSummaryService = collectionSummaryService;
//         this.passengerSummaryService = passengerSummaryService;
//     }

//     public PrintSummaryCommand(IMetroCardBalanceService metroCardManagementService) {}

//     public void execute(String[] args) {
//         // Call the necessary methods of the collection summary service and passenger summary service
//         System.out.println("TOTAL_COLLECTION CENTRAL " + collectionSummaryService.getTotalAmount() + " " + collectionSummaryService.getTotalDiscount());
//         System.out.println("PASSENGER_TYPE_SUMMARY");
//         for (String passengerType : passengerSummaryService.getPassengerSummary()) {
//             System.out.println(passengerType + " " + passengerSummaryService.getPassengerTypeCounts().get(passengerType));
//         }
//         System.out.println("TOTAL_COLLECTION AIRPORT " + collectionSummaryService.getTotalAmount() + " " + collectionSummaryService.getTotalDiscount());
//         System.out.println("PASSENGER_TYPE_SUMMARY");
//         for (String passengerType : passengerSummaryService.getPassengerSummary()) {
//             System.out.println(passengerType + " " + passengerSummaryService.getPassengerTypeCounts().get(passengerType));
//         }
//     }
// }

