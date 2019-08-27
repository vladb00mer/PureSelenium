package projects;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.project.ProjectPage;

class CreateProjectTest {

    private static HomePage homePage;
    private ProjectPage projectPage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "autoTestName";
    private String projectCode = "autoTestCode";
    private String apiId = "autoTestApiId";
    private String therapeuticArea = "aaaaaaaaaaaaaaa";


    @BeforeAll
    static void setUp() {
        homePage = new HomePage(user);
    }

    @Test
    @DisplayName("Create new Project with all Processes")
    void testSearchByProjectNameFilter() {
        projectPage = homePage.goToTopMenu().
                goToHomePage().goToAllProjects().
                addNewProject().
                setProjectCode(projectCode).
                setProjectName(projectName).
                setApiId(apiId).
                setTherapeuticArea(therapeuticArea).
                saveProject();
        Assertions.assertEquals(projectPage.getName(), projectName);
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}
