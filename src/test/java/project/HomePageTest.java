package project;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;

class HomePageTest {

    private static HomePage homePage;
    private static String request = "тестовый запрос";

    @BeforeAll
    static void setUp() {
        homePage = new HomePage();
    }

    @Test
    @DisplayName("Тестирование поиска")
    void testSearchByProjectNameFilter() {

    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}