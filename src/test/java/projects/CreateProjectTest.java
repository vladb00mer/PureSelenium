package projects;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.project.ProjectPage;

class CreateProjectTest {

    private static HomePage homePage;
    private ProjectPage projectPage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "autoTestName1";
    private String projectCode = "autoTestCode1";
    private String apiId = "autoTestApiId1";
    private String therapeuticArea = "Fibrosis";


    @BeforeAll
    static void setUp() {
        homePage = new HomePage(user);
    }

    @Test
    @DisplayName("Create new Project with all Processes")
    void testSearchByProjectNameFilter() {
        //projectPage =
                homePage.goToTopMenu().
                goToHomePage().
                goToAllProjects().
                addNewProject().
                setProjectCode(projectCode).
                setTherapeuticArea(therapeuticArea).
                setProjectName(projectName).
                setApiId(apiId).
                selectProcesses(1,3,5);
                        /*.
                saveProject().
                filterByProjectName(projectName).
                openFilteredProject(projectName);
        Assertions.assertEquals(projectPage.getProjectName(), projectName);*/
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}
