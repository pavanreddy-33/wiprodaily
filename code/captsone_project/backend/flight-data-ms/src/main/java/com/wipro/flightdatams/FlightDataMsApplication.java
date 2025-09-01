package com.wipro.flightdatams;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.context.annotation.Bean;
//import com.wipro.flightdatams.model.Flight;
//import com.wipro.flightdatams.repository.FlightRepository;

//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableDiscoveryClient
public class FlightDataMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightDataMsApplication.class, args);
    }

//    @Bean
//    CommandLineRunner seedData(FlightRepository repo) {
//        return args -> {
//            long existing = repo.count();
//            // If you already have lots of records, skip seeding.
//            if (existing >= 50) {
//                System.out.println("Flight seed skipped (already " + existing + " records).");
//                return;
//            }
//
//            System.out.println("Seeding flight data...");
//
//            List<String[]> cityAirports = List.of(
//                new String[]{"Kolkata", "CCU"},
//                new String[]{"Chennai", "MAA"},
//                new String[]{"Delhi", "DEL"},
//                new String[]{"Mumbai", "BOM"},
//                new String[]{"Bengaluru", "BLR"},
//                new String[]{"Hyderabad", "HYD"},
//                new String[]{"Ahmedabad", "AMD"},
//                new String[]{"Goa", "GOI"},
//                new String[]{"Kochi", "COK"},
//                new String[]{"Pune", "PNQ"},
//                new String[]{"Jaipur", "JAI"},
//                new String[]{"Lucknow", "LKO"}
//            );
//
//            String[] airlines = new String[]{
//                "Air India", "IndiGo", "SpiceJet", "Vistara", "GoAir", "AirAsia India", "TruJet"
//            };
//
//            String[] airlineCodes = new String[]{
//                "AI", "6E", "SG", "UK", "G8", "I5", "2T"
//            };
//
//            String[] aircrafts = new String[]{
//                "A320", "A321", "B737", "B737MAX", "A319", "A330", "ATR72"
//            };
//
//            Random rnd = new Random();
//            LocalDate startDate = LocalDate.now();
//            int daysSpan = 90;           
//            int flightsPerDay = 8;       
//            int totalToGenerate = daysSpan * cityAirports.size() * 1;
//
//            List<Flight> buffer = new ArrayList<>();
//            int batchSize = 200;
//
//            for (int d = 0; d <= daysSpan; d++) {
//                LocalDate date = startDate.plusDays(d);
//                for (int route = 0; route < cityAirports.size(); route++) {
//                    int originIndex = route;
//                    int destIndex = (route + 1 + rnd.nextInt(cityAirports.size() - 1)) % cityAirports.size();
//                    String origin = cityAirports.get(originIndex)[0];
//                    String originCode = cityAirports.get(originIndex)[1];
//                    String destination = cityAirports.get(destIndex)[0];
//                    String destinationCode = cityAirports.get(destIndex)[1];
//
//                    int flightsThisRoute = 3 + rnd.nextInt(6); 
//                    for (int f = 0; f < flightsThisRoute; f++) {
//                        int ai = rnd.nextInt(airlines.length);
//                        String airline = airlines[ai];
//                        String airlineCode = airlineCodes[ai];
//                        String flightNumber = airlineCode + String.format("%03d", 100 + rnd.nextInt(900));
//
//                        int departHour = 5 + rnd.nextInt(19);
//                        int departMinute = (rnd.nextInt(4)) * 15;
//                        LocalTime departureTime = LocalTime.of(departHour, departMinute);
//
//
//                        int durationMinutes = 60 + rnd.nextInt(341);
//                        LocalTime arrivalTime = departureTime.plus(durationMinutes, ChronoUnit.MINUTES);
//
//                        double price = Math.round((2000 + rnd.nextDouble() * 23000) * 1.0);
//
//                        int stops = rnd.nextInt(3); 
//                        String aircraft = aircrafts[rnd.nextInt(aircrafts.length)];
//
//                        Flight flight = new Flight();
//                        flight.setAirline(airline);
//                        flight.setFlightNumber(flightNumber);
//                        flight.setOrigin(origin);
//                        flight.setDestination(destination);
//                        flight.setDepartureDate(date);
//                        flight.setDepartureTime(departureTime);
//                        flight.setArrivalTime(arrivalTime);
//                        flight.setDurationMinutes(durationMinutes);
//                        flight.setPrice(price);
//                        flight.setStops(stops);
//                        flight.setAircraftName(aircraft);
//
//                        buffer.add(flight);
//
//                        if (buffer.size() >= batchSize) {
//                            repo.saveAll(buffer);
//                            buffer.clear();
//                            System.out.println("Saved a batch of flights, date = " + date);
//                        }
//                    }
//                }
//            }
//
//            if (!buffer.isEmpty()) {
//                repo.saveAll(buffer);
//                buffer.clear();
//            }
//
//            System.out.println("Seeding finished.");
//        };
//    }
}
