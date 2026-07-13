package com.kodilla.testing.weather;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public double calculateAverage() {
        Collection<Double> temps = temperatures.getTemperatures().values();
        return temps.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double calculateMedian() {
        List<Double> temps = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temps);
        int size = temps.size();
        if (size == 0) return 0.0;
        return (size % 2 == 0) ? (temps.get(size/2 - 1) + temps.get(size/2)) / 2.0 : temps.get(size/2);
    }
}