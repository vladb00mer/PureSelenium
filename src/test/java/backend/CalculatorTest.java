package backend;

import common.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }


    @Test
    @DisplayName("Plus Test")
    @Tag("Calculator")
    void testPlus() {

        assertEquals(calculator.plus(2,3),  5, "Assertion Error! 2+3=5");
    }

    @Test
    @DisplayName("Minus Test")
    @Tag("Calculator")
    @Disabled("!disabling demonstration!")
    void testMinus() {

        assertEquals(calculator.minus(3,2), 1, "Assertion Error! 3-2=1");
    }

    @Test
    @DisplayName("Multiply Test")
    @Tag("Calculator")
    void testMultiply() {

        assertEquals(calculator.multiply(2,4),8, "Assertion Error! 2*4=8");
    }

    @Test
    @DisplayName("Divide Test")
    @Tag("Calculator")
    void testDivide() {

        assertEquals(calculator.divide(4,2), 2, "Assertion Error! 4/2=2");
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        calculator = null;
    }
}
