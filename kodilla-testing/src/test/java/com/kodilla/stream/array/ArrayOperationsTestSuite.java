package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        // Given
        int[] numbers = new int[] {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        double expectedAverage = 27.5;

        // When
        double actualAverage = ArrayOperations.getAverage(numbers);

        // Then
        Assertions.assertEquals(expectedAverage, actualAverage, 0.0001);
    }
}