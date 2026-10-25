package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private final List<SudokuElement> cols = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            cols.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getCols() {
        return cols;
    }

    public SudokuElement getElement(int col) {
        return cols.get(col);
    }

    public SudokuRow deepCopy() {
        SudokuRow copiedRow = new SudokuRow();
        copiedRow.cols.clear();
        for (SudokuElement element : cols) {
            copiedRow.cols.add(element.deepCopy());
        }
        return copiedRow;
    }
}