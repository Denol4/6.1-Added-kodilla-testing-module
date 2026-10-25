package com.kodilla.sudoku;

public class SudokuBackup {
    private final SudokuBoard board;
    private final int row;
    private final int col;
    private final int guessedValue;

    public SudokuBackup(SudokuBoard board, int row, int col, int guessedValue) {
        this.board = board.deepCopy();
        this.row = row;
        this.col = col;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getGuessedValue() {
        return guessedValue;
    }
}