package ui;

import common.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;

import java.util.List;


class HomePageTest {

    private static HomePage homePage;
    private static String request;

    @BeforeAll
    static void setUp() {
        homePage = new HomePage();
        request = "тест";
    }

    @Test
    @DisplayName("Search UI Test")
    @Tag("ui")
    void testSearch() {

        homePage.search(request);
        List<WebElement> result = Init.getWebDriver().findElements(By.xpath("//div/b[contains(text(), '"+request+"')]"));
        Assertions.assertTrue(result.size() > 10, "Количество элементов = "+result.size());
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
        request = null;
    }
}