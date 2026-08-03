package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        // Given
        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country germany = new Country("Germany", new BigDecimal("83000000"));
        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);

        Country china = new Country("China", new BigDecimal("1400000000"));
        Country japan = new Country("Japan", new BigDecimal("125000000"));
        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(japan);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);

        // When
        BigDecimal totalPeople = world.getPeopleQuantity();

        // Then
        BigDecimal expectedPeople = new BigDecimal("1646000000");
        assertEquals(expectedPeople, totalPeople);
    }
}