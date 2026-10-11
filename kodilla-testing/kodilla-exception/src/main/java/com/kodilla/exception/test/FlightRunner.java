package com.kodilla.exception.test;

public class FlightRunner {

    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();


        Flight validFlight = new Flight("Warszawa", "Kraków");


        Flight unavailableFlight = new Flight("Warszawa", "Zabrze");

        Flight unknownFlight = new Flight("Warszawa", "Wrocław");

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