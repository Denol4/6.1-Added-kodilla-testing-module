package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .forEach(element -> System.out.println(element));

        return IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .average()
                .orElse(0.0);
    }
}