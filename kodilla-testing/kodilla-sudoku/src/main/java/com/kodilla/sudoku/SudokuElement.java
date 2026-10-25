package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SudokuElement {
    public static int EMPTY = -1;

    private int value;
    private List<Integer> possibleValues;

    public SudokuElement() {
        this.value = EMPTY;
        this.possibleValues = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            this.possibleValues.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public SudokuElement deepCopy() {
        SudokuElement copied = new SudokuElement();
        copied.setValue(this.value);
        copied.possibleValues = new ArrayList<>(this.possibleValues);
        return copied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuElement element = (SudokuElement) o;
        return value == element.value && Objects.equals(possibleValues, element.possibleValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, possibleValues);
    }
}