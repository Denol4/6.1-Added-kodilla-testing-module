package com.kodilla.rps;

import java.util.Scanner;

public class UserDialogs {
    private final Scanner scanner = new Scanner(System.in);

    public String getPlayerName() {
        System.out.print("Jak się nazywasz? ");
        while (true) {
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.print("Imię nie może być puste. ");
        }
    }

    public int getRoundsToWin() {
        while (true) {
            System.out.print("Podaj liczbę wygranych rund do zwycięstwa: ");
            String input = scanner.nextLine().trim();
            try {
                int rounds = Integer.parseInt(input);
                if (rounds > 0) {
                    return rounds;
                }
                System.out.println("Liczba rund musi być większa od 0!");
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy format liczby, spróbuj ponownie.");
            }
        }
    }

    public void showInstructions() {
        System.out.println("\n========================================");
        System.out.println("            INSTRUKCJA GRY              ");
        System.out.println("========================================");
        System.out.println("Klawisz 1 – zagranie \"Kamień\"");
        System.out.println("Klawisz 2 – zagranie \"Papier\"");
        System.out.println("Klawisz 3 – zagranie \"Nożyce\"");
        System.out.println("Klawisz x – zakończenie gry");
        System.out.println("Klawisz n – rozpoczęcie gry od nowa");
        System.out.println("========================================\n");
    }

    public String getUserInput() {
        System.out.print("Twój ruch (1 - Kamień, 2 - Papier, 3 - Nożyce, x - Wyjście, n - Nowa gra): ");
        return scanner.nextLine().trim().toLowerCase();
    }

    public boolean confirmAction(String message) {
        while (true) {
            System.out.print(message + " (Tak [t] / Nie [n]): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("t") || input.equals("tak")) {
                return true;
            } else if (input.equals("n") || input.equals("nie")) {
                return false;
            }
            System.out.println("Niepoprawny wybór. Wpisz 't' lub 'n'.");
        }
    }
}