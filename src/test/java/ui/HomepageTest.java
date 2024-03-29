package ui;

import common.Init;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertTrue;

@Test
public class HomepageTest {

    private static HomePage homePage;
    private static String request;

    @BeforeClass(alwaysRun = true)
    static void setUp() {
        homePage = new HomePage();
        request = "тест";
    }

    @Test(groups = {"ui","regress"})
    void testSearch() {

        homePage.search(request);
        List<WebElement> result = Init.getWebDriver().findElements(By.xpath("//div/b[contains(text(), '"+request+"')]"));
        assertTrue(result.size() > 10, "Количество элементов = "+result.size());
    }

    @AfterClass(alwaysRun = true)
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
        request = null;
        }
}