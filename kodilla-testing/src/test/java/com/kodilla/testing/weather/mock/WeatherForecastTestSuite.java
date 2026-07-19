package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private temperatures temperaturesMock;

    private WeatherForecast weatherForecast;

    @BeforeEach
    void setUp() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateAverageTemperature() {
        double average = weatherForecast.calculateAverageTemperature();
        Assertions.assertEquals(25.56, average, 0.01);
    }

    @Test
    void testCalculateMedianTemperature() {
        double median = weatherForecast.calculateMedianTemperature();
        Assertions.assertEquals(25.5, median, 0.01);
    }
}