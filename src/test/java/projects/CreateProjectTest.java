package projects;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.project.ProjectPage;

class CreateProjectTest {

    private static HomePage homePage;
    private ProjectPage projectPage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "autoTestName2";
    private String projectCode = "autoTestCode2";
    private String apiId = "autoTestApiId2";
    private String therapeuticArea = "Fibrosis";


    @BeforeAll
    static void setUp() {
        homePage = new HomePage(user);
    }

    @Test
    @DisplayName("Create new Project with all Processes")
    void testSearchByProjectNameFilter() {
        projectPage = homePage.goToTopMenu().
                goToHomePage().
                goToAllProjects().
                addNewProject().
                setProjectCode(projectCode).
                setTherapeuticArea(therapeuticArea).
                setProjectName(projectName).
                setApiId(apiId).
                saveProject().
                filterByProjectName(projectName).
                openFilteredProject(projectName);
        Assertions.assertEquals(projectPage.getProjectName(), projectName);
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}
