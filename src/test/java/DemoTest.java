import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.ProjectPage;


class DemoTest {

    private static HomePage homePage;
    private ProjectPage projectPage;
    private String projectName = "123456789";

    @BeforeAll
    static void setUp() {
        homePage = new HomePage("nadezda_peskun@epam.com");
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