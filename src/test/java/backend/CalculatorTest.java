package backend;

import common.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testPlus() {
        Assertions.assertEquals(calculator.plus(2,3),  5);
    }

    @Test
    void testMinus() {
        Assertions.assertEquals(calculator.minus(3,2), 1);
    }

    @Test
    void testMultiply() {
        Assertions.assertEquals(calculator.multiply(2,4),8);
    }

    @Test
    void testDivide() {
        Assertions.assertEquals(calculator.divide(4,2), 2);
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        calculator = null;
    }
}
