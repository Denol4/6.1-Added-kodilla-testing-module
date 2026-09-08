package com.kodilla.exception.test;

public class ExceptionHandling {

    public void handleException(double x, double y) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(x, y);
            System.out.println("Wynik: " + result);
        } catch (Exception e) {
            System.out.println("Catch: Parametry x=" + x + ", y=" + y);
        } finally {
            System.out.println("Koniec");
        }
    }

    public static void main(String[] args) {
        ExceptionHandling exceptionHandling = new ExceptionHandling();

        System.out.println("--- Przypadek 1:---");
        exceptionHandling.handleException(1.5, 2.0);

        System.out.println("\n--- Przypadek 2:");
        exceptionHandling.handleException(2.0, 2.0);

        System.out.println("\n--- Przypadek 3: 1.5) ---");
        exceptionHandling.handleException(1.5, 1.5);
    }
}