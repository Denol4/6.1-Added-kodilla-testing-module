package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.*;
import java.util.*;

class WeatherForecastTestSuite {

    @Test
    void testCalculateForecastWithStub() {
        temperatures temperatures = new temperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        Assertions.assertEquals(5, quantityOfSensors);
    }

    // Możesz tu też dodać testy Average/Median używając TemperaturesStub
}