import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.Passenger;
import com.geektrust.backend.entities.Station;
import com.geektrust.backend.exceptions.MetroCardNotFoundException;
import com.geektrust.backend.repository.MetroCardRepositoryImpl;
import com.geektrust.backend.service.journey.IJourneyService;
import com.geektrust.backend.service.journey.JourneyService;
import com.geektrust.backend.service.metrocard.IMetroCardBalanceService;
import com.geektrust.backend.service.metrocard.MetroCardBalanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegrationTest {

    private IMetroCardBalanceService balanceService;
    private IJourneyService journeyService;
    private MetroCardRepositoryImpl metroCardRepository;

    @BeforeEach
    public void setup() {
        metroCardRepository = new MetroCardRepositoryImpl();
        balanceService = new MetroCardBalanceService(metroCardRepository);
        journeyService = new JourneyService();
    }

    @Test
    public void testMetroCardJourneyIntegration() throws MetroCardNotFoundException {
        // Add test data - MetroCards
        MetroCard metroCard1 = new MetroCard("MC1", 600);
        MetroCard metroCard2 = new MetroCard("MC2", 500);
        MetroCard metroCard3 = new MetroCard("MC3", 50);
        MetroCard metroCard4 = new MetroCard("MC4", 50);
        MetroCard metroCard5 = new MetroCard("MC5", 200);
        
        metroCardRepository.addMetroCard(metroCard1);
        metroCardRepository.addMetroCard(metroCard2);
        metroCardRepository.addMetroCard(metroCard3);
        metroCardRepository.addMetroCard(metroCard4);
        metroCardRepository.addMetroCard(metroCard5);
        
        Station station1 = new Station("AIRPORT", null);
        Station station2 = new Station("CENTRAL", null);

        Passenger passenger1 = new Passenger("ADULT", metroCard1);
        Passenger passenger2 = new Passenger("KID", metroCard2);
        Passenger passenger3 = new Passenger("KID", metroCard2);
        Passenger passenger4 = new Passenger("KID", metroCard2);
        Passenger passenger5 = new Passenger("KID", metroCard2);


        journeyService.startJourney(passenger1 ,station1);
        journeyService.startJourney(passenger2 ,station2);
        journeyService.startJourney(passenger3 ,station1);
        journeyService.startJourney(passenger4 ,station1);
        journeyService.startJourney(passenger5 ,station2);

        // Check the balances after the journeys
        double balance1 = balanceService.getBalance("MC1");
        double balance2 = balanceService.getBalance("MC2");
        double balance3 = balanceService.getBalance("MC3");
        double balance4 = balanceService.getBalance("MC4");
        double balance5 = balanceService.getBalance("MC5");

        // Perform assertions
        assertEquals(300.0, balance1);
        assertEquals(450.0, balance2);
        assertEquals(50.0, balance3);
        assertEquals(50.0, balance4);
        assertEquals(100.0, balance5);
    }
}

