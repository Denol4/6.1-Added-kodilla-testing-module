package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Zabrze", true);
        airports.put("Warszawa", true);
        airports.put("Kraków", false);
        airports.put("Poznań", true);

        String arrival = flight.getArrivalAirport();

        if (airports.containsKey(arrival)) {
            return airports.get(arrival);
        } else {
            throw new RouteNotFoundException("Lotnisko '" + arrival + "' nie zostało znalezione w systemie.");
        }
    }
}