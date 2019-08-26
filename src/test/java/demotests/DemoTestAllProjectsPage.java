package demotests;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.ProjectPage;

class DemoTestAllProjectsPage {

    private static HomePage homePage;
    private ProjectPage projectPage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "123456789";

    @BeforeAll
    static void setUp() {
        homePage = new HomePage(user);
    }

    @Test
    @DisplayName("Search Project using Project Name filter in All Projects Page")
    void testSearchByProjectNameFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName);
        Assertions.assertEquals(projectPage.getName(), projectName);
    }

    @Test
    @DisplayName("Search Project using Project Code filter in All Projects Page")
    void testSearchByProjectCodeFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectCode(projectName).openFilteredProject(projectName);
        Assertions.assertEquals(projectPage.getName(), projectName);
    }

    @Test
    @DisplayName("Search Project using API ID filter in All Projects Page")
    void testSearchByApiIdFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByApiId(projectName).openFilteredProject(projectName);
        Assertions.assertEquals(projectPage.getName(), projectName);
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}
