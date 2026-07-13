package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures() {
        StringBuilder result = new StringBuilder();
        for (Shape shape : shapes) {
            result.append(shape.getShapeName());
            if (shapes.indexOf(shape) < shapes.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
}