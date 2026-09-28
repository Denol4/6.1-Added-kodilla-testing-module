package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("Logogowania");

        //When
        String result = Logger.getInstance().getLastLog();

        //Then
        Object Assertions;
        Assertions.assertEquals("Log logowania", result);
    }
}