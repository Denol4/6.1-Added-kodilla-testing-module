package com.kodilla.sudoku;

import java.util.ArrayDeque;
import java.util.Deque;

public class SudokuSolver {

    private SudokuBoard board;
    private final Deque<SudokuBackup> backtrack = new ArrayDeque<>();

    public SudokuSolver(SudokuBoard board) {
        this.board = board;
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public boolean solve() {
        while (!isBoardFullyFilled()) {
            boolean progress = eliminatePossibilities();

            if (!progress) {
                if (hasErrors()) {
                    if (!backtrack.isEmpty()) {
                        restoreFromBacktrack();
                    } else {
                        return false;
                    }
                } else {
                    guessValue();
                }
            }
        }
        return !hasErrors();
    }

    private boolean eliminatePossibilities() {
        boolean changed = false;

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                SudokuElement element = board.getElement(r, c);
                if (element.getValue() != SudokuElement.EMPTY) {
                    continue;
                }


                for (int i = 0; i < 9; i++) {

                    int rowVal = board.getElement(r, i).getValue();
                    if (rowVal != SudokuElement.EMPTY) {
                        if (element.getPossibleValues().remove(Integer.valueOf(rowVal))) {
                            changed = true;
                        }
                    }
                    int colVal = board.getElement(i, c).getValue();
                    if (colVal != SudokuElement.EMPTY) {
                        if (element.getPossibleValues().remove(Integer.valueOf(colVal))) {
                            changed = true;
                        }
                    }
                }

                // rozmiar czy dziala?
                int blockStartRow = (r / 3) * 3;
                int blockStartCol = (c / 3) * 3;
                for (int br = blockStartRow; br < blockStartRow + 3; br++) {
                    for (int bc = blockStartCol; bc < blockStartCol + 3; bc++) {
                        int blockVal = board.getElement(br, bc).getValue();
                        if (blockVal != SudokuElement.EMPTY) {
                            if (element.getPossibleValues().remove(Integer.valueOf(blockVal))) {
                                changed = true;
                            }
                        }
                    }
                }

                if (element.getPossibleValues().size() == 1) {
                    element.setValue(element.getPossibleValues().get(0));
                    changed = true;
                }
            }
        }
        return changed;
    }

    private boolean isBoardFullyFilled() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board.getElement(r, c).getValue() == SudokuElement.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasErrors() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                SudokuElement element = board.getElement(r, c);
                if (element.getValue() == SudokuElement.EMPTY && element.getPossibleValues().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void guessValue() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                SudokuElement element = board.getElement(r, c);
                if (element.getValue() == SudokuElement.EMPTY && !element.getPossibleValues().isEmpty()) {
                    int guessedVal = element.getPossibleValues().get(0);


                    backtrack.push(new SudokuBackup(board, r, c, guessedVal));

                    element.setValue(guessedVal);
                    return;
                }
            }
        }
    }

    private void restoreFromBacktrack() {
        SudokuBackup backup = backtrack.pop();
        this.board = backup.getBoard();

        int r = backup.getRow();
        int c = backup.getCol();
        int wrongValue = backup.getGuessedValue();


        this.board.getElement(r, c).getPossibleValues().remove(Integer.valueOf(wrongValue));
    }
}