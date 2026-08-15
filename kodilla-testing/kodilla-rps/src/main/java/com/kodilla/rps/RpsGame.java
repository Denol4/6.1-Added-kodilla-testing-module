package com.kodilla.rps;

import java.util.Random;

public class RpsGame {
    private final UserDialogs userDialogs = new UserDialogs();
    private final Random random = new Random();

    private String playerName;
    private int roundsToWin;
    private int playerWins;
    private int computerWins;
    private boolean end = false;

    public void start() {
        initGame();

        while (!end) {
            playRound();

            if (playerWins == roundsToWin || computerWins == roundsToWin) {
                showFinalResult();
                handleGameEndMenu();
            }
        }
    }

    private void initGame() {
        System.out.println("--- WITAJ W GRZE ");
        playerName = userDialogs.getPlayerName();
        roundsToWin = userDialogs.getRoundsToWin();
        playerWins = 0;
        computerWins = 0;
        userDialogs.showInstructions();
    }

    private void playRound() {
        String input = userDialogs.getUserInput();

        switch (input) {
            case "1":
            case "2":
            case "3":
                int moveKey = Integer.parseInt(input);
                Move playerMove = Move.fromKey(moveKey);
                Move computerMove = getRandomComputerMove();

                processMoves(playerMove, computerMove);
                break;

            case "x":
                if (userDialogs.confirmAction("Czy na pewno zakończyć grę?")) {
                    System.out.println("Dziękujemy za grę. ");
                    end = true;
                }
                break;

            case "n":
                if (userDialogs.confirmAction("Czy na pewno zakończyć aktualną grę i zacząć od nowa?")) {
                    initGame();
                }
                break;

            default:
                System.out.println("Niepoprawny klawisz! Użyj 1, 2, 3, x lub n.");
                break;
        }
    }

    private Move getRandomComputerMove() {
        int randomKey = random.nextInt(3) + 1;
        return Move.fromKey(randomKey);
    }

    private void processMoves(Move playerMove, Move computerMove) {
        System.out.println("\n----------------------------------------");
        System.out.println(playerName + " zagrał(a): " + playerMove.getName());
        System.out.println("Komputer zagrał:   " + computerMove.getName());

        int result = playerMove.compareWith(computerMove);

        if (result == 0) {
            System.out.println("Wynik rundy: REMIS!");
        } else if (result > 0) {
            playerWins++;
            System.out.println("Wynik rundy: Wygrywa " + playerName + "!");
        } else {
            computerWins++;
            System.out.println("Wynik rundy: Wygrywa Komputer!");
        }

        System.out.println("Bieżący wynik gry -> " + playerName + ": " + playerWins + " | Komputer: " + computerWins);
        System.out.println("----------------------------------------\n");
    }

    private void showFinalResult() {
        System.out.println("========================================");
        System.out.println("             KONIEC GRY!                ");
        System.out.println("========================================");
        System.out.println("Ostateczny wynik -> " + playerName + ": " + playerWins + " | Komputer: " + computerWins);

        if (playerWins > computerWins) {
            System.out.println("GRATULACJE! " + playerName.toUpperCase() + " WYGRYWA CAŁĄ GRĘ!");
        } else {
            System.out.println("NIESTETY! KOMPUTER WYGRYWA CAŁĄ GRĘ!");
        }
        System.out.println("========================================\n");
    }

    private void handleGameEndMenu() {
        while (true) {
            System.out.println("Co chcesz teraz zrobić?");
            System.out.println("Klawisz n – Nowa gra");
            System.out.println("Klawisz x – Zakończenie gry");

            String input = userDialogs.getUserInput();

            if ("n".equalsIgnoreCase(input)) {
                initGame();
                break;
            } else if ("x".equalsIgnoreCase(input)) {
                System.out.println("Dziękujemy za grę! Do zobaczenia.");
                end = true;
                break;
            } else {
                System.out.println("Niepoprawny wybór. Wybierz 'n' lub 'x'.");
            }
        }
    }
}