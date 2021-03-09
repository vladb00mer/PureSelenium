package backend;

import common.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("All Negative Test")
    @Tag("calculator")
    void testAll() {

        assertAll("Multi assertion negative sample",
                () -> assertEquals(calculator.plus(2,3),  4, "Assertion Error! 2+3=5"),
                () -> assertEquals(calculator.minus(2,3),  1, "Assertion Error! 3-2=1"),
                () -> assertEquals(calculator.multiply(2,3),  3, "Assertion Error! 2*4=8"),
                () -> assertEquals(calculator.divide(2,3),  2, "Assertion Error! 4/2=2")
        );
    }

    @Test
    @DisplayName("Plus Test")
    @Tag("calculator")
    void testPlus() {

        assertEquals(calculator.plus(2,3),  5, "Assertion Error! 2+3=5");
    }

    @Test
    @DisplayName("Minus Test")
    @Tag("calculator")
    @Disabled("!disabling demonstration!")
    void testMinus() {

        assertEquals(calculator.minus(3,2), 1, "Assertion Error! 3-2=1");
    }

    @Test
    @DisplayName("Multiply Test")
    @Tag("calculator")
    void testMultiply() {

        assertEquals(calculator.multiply(2,4),8, "Assertion Error! 2*4=8");
    }

    @Test
    @DisplayName("Divide Test")
    @Tag("calculator")
    void testDivide() {

        assertEquals(calculator.divide(4,2), 2, "Assertion Error! 4/2=2");
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        calculator = null;
    }
}
