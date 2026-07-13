package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Shape Collector Test Suite")
class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Tests for adding and removing figures")
    class TestAddRemove {
        @Test
        void testAddFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5.0);

            // When
            shapeCollector.addFigure(square);

            // Then
            assertEquals(square, shapeCollector.getFigure(0));
        }

        @Test
        void testRemoveFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5.0);
            shapeCollector.addFigure(square);

            // When
            shapeCollector.removeFigure(square);

            // Then
            assertNull(shapeCollector.getFigure(0));
        }
    }

    @Nested
    @DisplayName("Tests for figure retrieval")
    class TestRetrieval {
        @Test
        void testGetFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(2.0);
            shapeCollector.addFigure(circle);

            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            assertEquals(circle, retrievedShape);
        }
    }

    @Nested
    @DisplayName("Tests for displaying figures")
    class TestDisplay {
        @Test
        void testShowFigures() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5.0);
            Shape circle = new Circle(2.0);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);

            // When
            String result = shapeCollector.showFigures();

            // Then
            assertEquals("Square, Circle", result);
        }
    }
}