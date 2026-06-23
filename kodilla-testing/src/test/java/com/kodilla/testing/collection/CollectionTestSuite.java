package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test case: end");
    }

    @DisplayName("Sprawdzenie czy metoda poprawnie radzi sobie z pustą listą")
    @Test
    void testOddNumbersExterminatorEmptyList() {

        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();


        List<Integer> result = exterminator.exterminate(emptyList);


        Assertions.assertEquals(0, result.size());
    }

    @DisplayName("Sprawdzenie czy metoda poprawnie usuwa liczby nieparzyste z normalnej listy")
    @Test
    void testOddNumbersExterminatorNormalList() {

        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);


        List<Integer> result = exterminator.exterminate(numbers);


        List<Integer> expectedList = Arrays.asList(2, 4, 6);
        Assertions.assertEquals(expectedList, result);
    }
}