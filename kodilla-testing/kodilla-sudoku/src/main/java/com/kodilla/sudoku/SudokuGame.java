package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {

    private final Scanner scanner = new Scanner(System.in);
    private SudokuBoard board = new SudokuBoard();

    public boolean resolveSudoku() {
        System.out.println("=== NOWA GRA SUDOKU ===");
        System.out.println(board);

        while (true) {
            System.out.println("Wpisz współrzędne i wartość w formacie: KOLUMNA,WIERSZ,WARTOŚĆ (np. 2,3,9)");
            System.out.println("Wpisz 'SUDOKU', aby rozwiązać planszę, lub 'EXIT' aby wyjść:");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("EXIT")) {
                return true; // Koniec programu
            }

            if (input.equalsIgnoreCase("SUDOKU")) {
                SudokuSolver solver = new SudokuSolver(board);
                boolean solved = solver.solve();

                if (solved) {
                    System.out.println("--- ROZWIAZANIE SUDOKU ---");
                    System.out.println(solver.getBoard());
                } else {
                    System.out.println("BŁĄD: Wprowadzone Sudoku jest nieprawidłowe lub nie ma rozwiązania!");
                }

                System.out.println("Naciśnij ENTER, aby przejść do nowej planszy...");
                scanner.nextLine();
                return false; // Kontynuuj pętlę i utwórz nową grę
            }

            // Obsługa wprowadzania danych (np. 2,3,9)
            try {
                String[] parts = input.split(",");
                if (parts.length == 3) {
                    int col = Integer.parseInt(parts[0].trim()) - 1;
                    int row = Integer.parseInt(parts[1].trim()) - 1;
                    int val = Integer.parseInt(parts[2].trim());

                    if (col >= 0 && col < 9 && row >= 0 && row < 9 && val >= 1 && val <= 9) {
                        // Sprawdzamy, czy ruch jest poprawny zgodnie z zasadami Sudoku
                        if (isValidMove(board, row, col, val)) {
                            board.getElement(row, col).setValue(val);
                            System.out.println(board);
                        } else {
                            System.out.println("BŁĄD: Ta cyfra już znajduje się w tym wierszu, kolumnie lub bloku 3x3!");
                        }
                    } else {
                        System.out.println("Niepoprawny zakres danych (Współrzędne: 1-9, Wartość: 1-9). Spróbuj ponownie.");
                    }
                } else {
                    System.out.println("Błędny format! Przykład: 2,3,9");
                }
            } catch (Exception e) {
                System.out.println("Niepoprawne wejście. Spróbuj ponownie.");
            }
        }
    }

    /**
     * Metoda sprawdzająca, czy wpisanie wartości nie narusza zasad Sudoku
     * w danym wierszu, kolumnie lub bloku 3x3.
     */
    private boolean isValidMove(SudokuBoard board, int row, int col, int val) {
        // 1. Sprawdzenie wiersza i kolumny
        for (int i = 0; i < 9; i++) {
            if (board.getElement(row, i).getValue() == val) {
                return false;
            }
            if (board.getElement(i, col).getValue() == val) {
                return false;
            }
        }

        // 2. Sprawdzenie bloku 3x3
        int blockStartRow = (row / 3) * 3;
        int blockStartCol = (col / 3) * 3;
        for (int br = blockStartRow; br < blockStartRow + 3; br++) {
            for (int bc = blockStartCol; bc < blockStartCol + 3; bc++) {
                if (board.getElement(br, bc).getValue() == val) {
                    return false;
                }
            }
        }

        return true;
    }
}