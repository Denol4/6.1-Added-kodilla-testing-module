package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.Temperatures;
import com.kodilla.testing.weather.WeatherForecast;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import java.util.*;


class WeatherForecastTestSuite {

    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;

    @BeforeEach
    void setUp() {
        temperaturesMock = Mockito.mock(Temperatures.class);
        Map<String, Double> data = new HashMap<>();
        data.put("Rzeszow", 25.5);
        data.put("Krakow", 26.2);
        data.put("Wroclaw", 24.8);
        data.put("Warszawa", 25.2);
        data.put("Gdansk", 26.1);
        Mockito.when(temperaturesMock.getTemperatures()).thenReturn(data);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateAverage() {
        double avg = weatherForecast.calculateAverage();
        Assertions.assertEquals(25.56, avg);
    }

    @Test
    void testCalculateMedian() {
        double median = weatherForecast.calculateMedian();
        Assertions.assertEquals(25.5, median);
    }
}