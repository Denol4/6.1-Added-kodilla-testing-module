package com.kodilla.exception.test;

public class Dodatkowe {


    public long power(int base, int exponent) {

        if (base < 0 || exponent < 0) {
            throw new IllegalArgumentException("Podstawa i wykładnik muszą być liczbami naturalnymi (>= 0).");
        }


        if (exponent == 0) {
            return 1;
        }


        if (base == 0) {
            return 0;
        }


        if (exponent == 1) {
            return base;
        }


        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }
}