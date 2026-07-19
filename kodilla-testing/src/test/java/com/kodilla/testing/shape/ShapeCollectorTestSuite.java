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
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5.0);

            shapeCollector.addFigure(square);

            assertEquals(square, shapeCollector.getFigure(0));
        }

        @Test
        void testRemoveFigure() {
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5.0);
            shapeCollector.addFigure(square);

            shapeCollector.removeFigure(square);

            assertNull(shapeCollector.getFigure(0));
        }

        @Test
        void testRemoveNotExistingFigure() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5.0);

            // When
            boolean result = shapeCollector.removeFigure(square);

            // Then
            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Tests for figure retrieval")
    class TestRetrieval {
        @Test
        void testGetFigure() {
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(2.0);
            shapeCollector.addFigure(circle);

            Shape retrievedShape = shapeCollector.getFigure(0);

            assertEquals(circle, retrievedShape);
        }

        @Test
        void testGetFigureOutsideBounds() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();

            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            assertNull(retrievedShape);
        }
    }

    @Nested
    @DisplayName("Tests for displaying figures")
    class TestDisplay {
        @Test
        void testShowFigures() {
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(5.0);
            Shape circle = new Circle(2.0);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);

            String result = shapeCollector.showFigures();

            assertEquals("Square, Circle", result);
        }

        @Test
        void testShowFiguresEmpty() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();

            // When
            String result = shapeCollector.showFigures();

            // Then
            assertEquals("", result);
        }
    }
}