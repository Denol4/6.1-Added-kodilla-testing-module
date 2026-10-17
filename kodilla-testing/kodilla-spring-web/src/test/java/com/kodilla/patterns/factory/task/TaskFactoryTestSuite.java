package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {
    private final com.kodilla.patterns.factory.tasks.TaskFactory factory = new com.kodilla.patterns.factory.tasks.TaskFactory();

    @Test
    public void testShoppingTask() {
        // Given
        com.kodilla.patterns.factory.tasks.Task shopping = factory.makeTask(com.kodilla.patterns.factory.tasks.TaskFactory.SHOPPING);

        // When & Then
        Assertions.assertNotNull(shopping);
        Assertions.assertEquals("Zakupy spożywcze", shopping.getTaskName());
        Assertions.assertFalse(shopping.isTaskExecuted());

        shopping.executeTask();
        Assertions.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testPaintingTask() {
        // Given
        com.kodilla.patterns.factory.tasks.Task painting = factory.makeTask(com.kodilla.patterns.factory.tasks.TaskFactory.PAINTING);

        // When & Then
        Assertions.assertNotNull(painting);
        Assertions.assertEquals("Malowanie pokoju", painting.getTaskName());
        Assertions.assertFalse(painting.isTaskExecuted());

        painting.executeTask();
        Assertions.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testDrivingTask() {
        // Given
        com.kodilla.patterns.factory.tasks.Task driving = factory.makeTask(com.kodilla.patterns.factory.tasks.TaskFactory.DRIVING);

        // When & Then
        Assertions.assertNotNull(driving);
        Assertions.assertEquals("Wyjazd służbowy", driving.getTaskName());
        Assertions.assertFalse(driving.isTaskExecuted());

        driving.executeTask();
        Assertions.assertTrue(driving.isTaskExecuted());
    }
}