import DataModels.Passenger;
import Services.PassengerCSVReader;
import Services.SpringApplicationContext;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class JUnit {

    @Inject
    @Named("myFirstBean")
    String message;

    @Inject
    Passenger passenger;

    @Inject
    DataSource dataSource;

    private PassengerCSVReader passengerCSVReader;
    private List<Passenger> passengers;

    @BeforeAll
    public static void init() {
        System.out.println("Hi from JUnit");
    }

    @BeforeEach
    public void initPassenger() {
        System.out.println("Initializing passenger csv");
        this.passengerCSVReader = new PassengerCSVReader();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Cleared the list of passengers.");
        passengers = null;
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.print("All test passed.");
    }

    @Test
    public void TestJUN2() {
        List<Passenger> passengers = this.passengerCSVReader.readAllData();
        for (Passenger p: passengers) {
            System.out.println(p);
        }

    }

    @Test
    public void TestJUN3() {
        // given
        Exception caughtException = null;

        // when
        try {
            List<Passenger> passengers = this.passengerCSVReader.readAllData();
            for (Passenger p: passengers) {
                System.out.println(p);
            }
        } catch (Exception e) {
            caughtException = e;
        }
        // then
        Assertions.assertTrue(caughtException == null);
    }

    @Test
    public void TestSPR2() {
        System.out.println(message);
    }

    @Test
    public void TestSPR3() {
        System.out.println(passenger);
    }

    @Test
    public void TestSPR4() throws SQLException {
        Connection connection = dataSource.getConnection();
        Assertions.assertNotNull(connection);
        System.out.println("This Database is ready to use.");

        if (connection != null) {
            connection.close();
        }
    }
}
