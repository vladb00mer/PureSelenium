import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.ProjectPage;

class DemoTestHomePage {

    private static HomePage homePage;
    private ProjectPage projectPage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "123456789";

    @BeforeAll
    static void setUp() {
        homePage = new HomePage(user);
    }
    @Test
    @Tag("priority1")
    void testSearchByProjectNameFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().filterByProjectName(projectName).openFilteredProject();
        Assertions.assertEquals(projectPage.getName(), projectName);
    }
    @Test
    @Tag("priority2")
    void testSearchByProjectCodeFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().filterByProjectCode(projectName).openFilteredProject();
        Assertions.assertEquals(projectPage.getName(), projectName);
    }
    @Test
    @Tag("priority3")
    void testSearchByApiIdFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().filterByApiId(projectName).openFilteredProject();
        Assertions.assertEquals(projectPage.getName(), projectName);
    }
    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}