package project;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.project.ProjectPage;

class HomePageTest {

    private static HomePage homePage;
    private ProjectPage projectPage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "123456789";

    @BeforeAll
    static void setUp() {
        homePage = new HomePage(user);
    }

    @Test
    @DisplayName("Search Project using Project Name filter in Home Page")
    void testSearchByProjectNameFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().filterByProjectName(projectName).openFilteredProject();
        Assertions.assertEquals(projectPage.getProjectName(), projectName);
    }

    @Test
    @DisplayName("Search Project using Project Code filter in Home Page")
    void testSearchByProjectCodeFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().filterByProjectCode(projectName).openFilteredProject();
        Assertions.assertEquals(projectPage.getProjectName(), projectName);
    }

    @Test
    @DisplayName("Search Project using API ID filter in Home Page")
    void testSearchByApiIdFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().filterByApiId(projectName).openFilteredProject();
        Assertions.assertEquals(projectPage.getProjectName(), projectName);
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}