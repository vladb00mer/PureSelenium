package webinterface;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;

class HomePageTest {

    private static HomePage homePage;
    private static String request;

    @BeforeAll
    static void setUp() {
        homePage = new HomePage();
        request = "test";
    }

    @DisplayName("Search Test")
    @Test
    void testSearch() {
        homePage.search(request);
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
        request = null;
    }
}