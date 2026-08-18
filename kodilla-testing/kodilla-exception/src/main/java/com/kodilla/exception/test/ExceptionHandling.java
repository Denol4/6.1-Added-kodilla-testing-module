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
}