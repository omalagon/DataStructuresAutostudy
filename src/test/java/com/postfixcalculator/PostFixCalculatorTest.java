package com.postfixcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oscarmalagon
 * @since 8/13/17.
 */
class PostFixCalculatorTest {
    @Test
    void calculate() {
        String[] args = {"5", "6", "7", "*", "+", "1", "-"};
        PostFixCalculator calculator = new PostFixCalculator();
        Integer result = calculator.calculate(args);


        assertEquals(46, result.intValue());
    }

}