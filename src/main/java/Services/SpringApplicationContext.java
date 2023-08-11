package Services;

import DataModels.Passenger;
import Services.PassengerCSVReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringApplicationContext {

    @Bean(name = "myFirstBean")
    public String myFirstBean() {
        return "Hello from Spring, bicky-raj_kayastha";
    }

    @Bean
    public Passenger passenger() {
        return new Passenger("bicky-raj_kayastha", "1st", 28d, "male", 1);
    }

    @Bean
    public DataSource mainDataSource() {
        return new DriverManagerDataSource("jdbc:h2:mem:test", "user", "user");
    }
}
