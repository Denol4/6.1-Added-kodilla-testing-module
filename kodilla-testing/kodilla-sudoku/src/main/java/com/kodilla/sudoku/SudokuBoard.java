package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private final List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    public SudokuElement getElement(int row, int col) {
        return rows.get(row).getElement(col);
    }

    public SudokuBoard deepCopy() {
        SudokuBoard copiedBoard = new SudokuBoard();
        copiedBoard.rows.clear();
        for (SudokuRow row : rows) {
            copiedBoard.rows.add(row.deepCopy());
        }
        return copiedBoard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   1 2 3   4 5 6   7 8 9\n");
        sb.append(" +-------+-------+-------+\n");

        for (int r = 0; r < 9; r++) {
            sb.append(r + 1).append("| ");
            for (int c = 0; c < 9; c++) {
                int val = getElement(r, c).getValue();
                String valStr = (val == SudokuElement.EMPTY) ? " " : String.valueOf(val);
                sb.append(valStr).append(" ");

                if ((c + 1) % 3 == 0) {
                    sb.append("| ");
                }
            }
            sb.append("\n");
            if ((r + 1) % 3 == 0) {
                sb.append(" +-------+-------+-------+\n");
            }
        }
        return sb.toString();
    }
}