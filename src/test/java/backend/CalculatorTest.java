package backend;

import common.Init;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
public class CalculatorTest {

    private static Calculator calculator;

    @BeforeSuite
    static void setUp() {
        calculator = new Calculator();
    }

    @Test(priority = 2, groups = {"backend","regress"})
    void testPlus() {

        Assert.assertEquals(calculator.plus(2,3),  5, "Assertion Error! 2+3=5");
    }

    @Test(priority = 2, groups = {"backend","regress"})
    void testMinus() {

        Assert.assertEquals(calculator.minus(3,2), 1, "Assertion Error! 3-2=1");
    }

    @Test(priority = 2, groups = {"backend","regress"})
    void testMultiply() {

        Assert.assertEquals(calculator.multiply(2,4),8, "Assertion Error! 2*4=8");
    }

    @Test(priority = 2, groups = {"backend","regress"})
    void testDivide() {

        Assert.assertEquals(calculator.divide(4,2), 2, "Assertion Error! 4/2=2");
    }

    @AfterSuite
    static void tearDown() {
        Init.closeDriver();
        calculator = null;
    }
}
