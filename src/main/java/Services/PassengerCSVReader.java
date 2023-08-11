package Services;

import DataModels.Passenger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PassengerCSVReader {
    public List<Passenger> readAllData() {
        File file = new File("./data.csv");
        List<Passenger> passengers = new ArrayList<>();
        try (Scanner scanner = new Scanner(file);) {
            scanner.nextLine(); // skipping the header file
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                try {
                    // splitting the csv formatted data to an array of string
                    String[] split = line.split(";");
                    String name = split[0].trim();
                    String passengerClass = split[1].trim().toString();
                    Double age = (!split[2].isBlank()) ? Double.parseDouble(split[2].trim()): 0d;
                    String gender = split[3].trim().toString();
                    Integer survived = Integer.parseInt(split[4].trim());
                    Passenger p = new Passenger(name, passengerClass, age, gender, survived);
                    passengers.add(p);
                } catch (Exception e) {
                    System.out.println("error in line: " + line);
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return this.sortPClass(passengers);
    }

    public List<Passenger> sortPClass(List<Passenger> passengers) {
        passengers.sort(Comparator.comparing(Passenger::getPClass));
        return passengers;
    }
}
