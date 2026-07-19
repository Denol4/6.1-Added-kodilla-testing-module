package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private temperatures temperatures;

    public WeatherForecast(temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0.0;
        Collection<Double> temps = temperatures.getTemperatures().values();
        for (Double temp : temps) {
            sum += temp;
        }
        return sum / temps.size();
    }

    public double calculateMedianTemperature() {
        List<Double> temps = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temps);
        int size = temps.size();
        if (size % 2 == 0) {
            return (temps.get(size / 2 - 1) + temps.get(size / 2)) / 2.0;
        } else {
            return temps.get(size / 2);
        }
    }
}