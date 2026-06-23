package com.kodilla.testing;

import com.kodilla.testing.Calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();


        int addResult = calculator.add(10, 5);
        if (addResult == 15) {
            System.out.println("Test dodawania OK");
        } else {
            System.out.println("Test dodawania BŁĄD!");
        }


        int subResult = calculator.subtract(10, 5);
        if (subResult == 5) {
            System.out.println("Test odejmowania OK");
        } else {
            System.out.println("Test odejmowania BŁĄD!");
        }
    }
}