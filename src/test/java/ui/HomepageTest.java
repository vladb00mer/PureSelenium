package ui;

import common.Init;
import pageobjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class HomepageTest {

    private static HomePage homePage;
    private static String request;

    @BeforeSuite
    static void setUp() {
        homePage = new HomePage();
        request = "тест";
    }

    @Test
    void testSearch() {

        homePage.search(request);
        List<WebElement> result = Init.getWebDriver().findElements(By.xpath("//div/b[contains(text(), '"+request+"')]"));
        assertTrue(result.size() > 10, "Количество элементов = "+result.size());
    }

    @AfterSuite
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
        request = null;
    }
}