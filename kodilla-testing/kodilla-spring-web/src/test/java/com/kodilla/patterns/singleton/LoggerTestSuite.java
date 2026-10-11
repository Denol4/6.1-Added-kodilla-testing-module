package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("Log logowania");

        //When
        String result = Logger.getInstance().getLastLog();

        //Then
        Assertions.assertEquals("Log logowania", result);
    }
}