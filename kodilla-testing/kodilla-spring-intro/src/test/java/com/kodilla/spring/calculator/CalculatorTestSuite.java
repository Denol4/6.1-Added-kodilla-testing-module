package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {Calculator.class, Display.class})
class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given
        double a = 10.0;
        double b = 5.0;

        //When & Then
        assertEquals(15.0, calculator.add(a, b));
        assertEquals(5.0, calculator.sub(a, b));
        assertEquals(50.0, calculator.mul(a, b));
        assertEquals(2.0, calculator.div(a, b));
    }
}