# MetroCard Management System Challenge

MetroCard Management System Challenge is a simulation of a metro train system. It involves various components like metro trains, MetroCards, travel charges, passenger types, journey types, and more. This README.md provides an overview of the key features and components of the system.

## Key Features

1. **Metro Train**
   - A metro train operates non-stop between the Central station and the Airport.
   - Passengers can travel one way between these two stations.

2. **MetroCard**
   - MetroCard is an electronic payment utility used for metro travel charges.
   - Each passenger must carry a unique MetroCard, which acts as a wallet loaded with money.

3. **Travel Charges**
   - The travel charges vary based on the passenger's age.
   - Three passenger types are supported: Adult, Kid, and Senior Citizen.
   - Travel charges for each passenger type:
     - Adult: 200
     - Kid: 50
     - Senior Citizen: 100

4. **Journey Types**
   - Two types of journeys are supported: Single Trip and Return Trip.
   - A 50% discount is applied to the return journey's travel charges.

5. **MetroCard Recharge**
   - If a MetroCard doesn't have sufficient balance for the journey, the remaining cost can be paid by recharging the MetroCard.
   - Auto-recharge is available, which loads only the required amount of money for the journey.
   - A 2% service fee is collected for recharge transactions.

6. **Collection Summary**
   - The system generates a collection summary, including the total amount collected and total discount given at each station (Central and Airport).
   - The summary breaks down the total amount collected and the total discount given.
   - It also identifies the passenger type with the highest count, second-highest count, and least count at each station.

7. **Passenger Summary**
   - The system generates a passenger summary displaying the total number of passengers traveled per passenger type.
   - The passenger summary is presented in descending order of passenger count.
   - If multiple passenger types have the same count, they are displayed in ascending order of the passenger type.

8. **MetroCard Management**
   - Passengers need to have a MetroCard to travel on the metro train.
   - The system allows passengers to check-in using their MetroCard at the respective stations.
   - The appropriate travel charge is deducted from the MetroCard based on the passenger type and journey type.
   - If a passenger has already made a single journey, only 50% of the travel charge is deducted for their return journey.

9. **Interaction**
   - The system interacts with users through input commands and provides output based on the command.
   - Input commands include BALANCE for MetroCard balance, CHECK_IN for passenger check-in, and PRINT_SUMMARY for generating the summary.
   - The system processes the commands and generates the required output.

## File Structure

The project's files are organized into the following folders:

### service/fare
- IFareService.java
- FareService.java

### service/metrocard
- IMetroCardManagementService.java
- MetroCardManagementService.java
- IMetroCardBalanceService.java
- MetroCardBalanceService.java

### service/journey
- IJourneyService.java
- JourneyService.java

### service/summary
- IPassengerSummaryService.java
- PassengerSummaryService.java
- ICollectionSummaryService.java
- CollectionSummaryService.java

### service/station
- IStationService.java
- StationService.java

### repository
- IMetroCardRepository.java
- MetroCardRepository.java
- IJourneyRepository.java
- JourneyRepository.java

### model
- Station.java
- MetroCard.java
- Passenger.java
- Journey.java
- Fare.java

## Prerequisites

- Java 1.8/1.11/1.15
- Gradle 6

## How to Run the Code

We provide scripts for executing the code. Use `run.sh` for Linux/Unix/macOS operating systems and `run.bat` for Windows. These scripts run the following commands internally:

```shell
gradle clean build -x test --no-daemon
java -jar build/libs/geektrust.jar sample_input/input1.txt
```

You can also build and run the project manually using the provided `build.gradle` file. If your main class has changed, update the `Main-Class` entry in the `jar` task.

## How to Execute Unit Tests

Execute unit tests using the following command:

```shell
gradle clean test --no-daemon
```

## Help and Documentation

Refer to our [help documents](https://help.geektrust.in) for more information. You can also find build instructions [here](https://github.com/geektrust/coding-problem-artefacts/tree/master/Java).

Feel free to explore and contribute to this project!

## License

This code is open-source and does not require a specific license for use.

---

Thank you for using the MetroCard Management System Challenge! 🚇
