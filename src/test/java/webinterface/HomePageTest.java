package webinterface;

import common.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;


class HomePageTest {

    private static HomePage homePage;
    private static String request;

    @BeforeAll
    static void setUp() {
        homePage = new HomePage();
        request = "test";
    }

    @Test
    @DisplayName("Search UI Test")
    @Tag("UI")
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