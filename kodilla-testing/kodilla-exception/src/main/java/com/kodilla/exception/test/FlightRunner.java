package com.kodilla.exception.test;

public class FlightRunner {

    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();

        // Test 1: Lotnisko istnieje i dostępne
        Flight validFlight = new Flight("Warszawa", "Kraków");
        // Test 2: Lotnisko istnieje, niedostępne
        Flight unavailableFlight = new Flight("Warszawa", "Zabrze");
        // Test 3: Lotnisko NIE istniejee (wyjątek)
        Flight unknownFlight = new Flight("Warszawa", "Poznań");

        checkFlight(flightFinder, validFlight);
        checkFlight(flightFinder, unavailableFlight);
        checkFlight(flightFinder, unknownFlight);
    }

    private static void checkFlight(FlightFinder finder, Flight flight) {
        try {
            boolean canFly = finder.findFlight(flight);
            if (canFly) {
                System.out.println("Można lecieć do: " + flight.getArrivalAirport());
            } else {
                System.out.println("Lotnisko " + flight.getArrivalAirport() + " jest obecnie niedostępne.");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Błąd: " + e.getMessage());
        } finally {
            System.out.println("Wyszukiwanie dla kierunku: " + flight.getArrivalAirport() + " zostało zakończone.\n");
        }
    }
}