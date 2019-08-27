package projects;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.project.ProjectPage;

class CreateProjectTest {

    private static HomePage homePage;
    private ProjectPage projectPage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "123456789";

    @BeforeAll
    static void setUp() {
        homePage = new HomePage(user);
    }

    @Test
    @DisplayName("Create new Project with all Processes")
    void testSearchByProjectNameFilter() {
        projectPage = homePage.goToTopMenu().goToHomePage().goToAllProjects().addNewProject().setProjectCode("code").setProjectName("name").setApiId("apiid").setTherapeuticArea("a").saveProject();
        Assertions.assertEquals(projectPage.getName(), projectName);
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}
