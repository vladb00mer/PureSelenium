package workspace;

import common.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;

class CreateWorkspaceTest {

    private static HomePage homePage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "autoTestName2";
    private String workspace1 = "Chemistry";
    private String workspace2 = "Route";
    private String workspace3 = "Step";
    private String workspaceName = "autoTestWS1";


    @BeforeAll
    static void setUp() {
        homePage = new HomePage(user);
    }

    @Test
    @DisplayName("Create new Project with all Processes")
    void testSearchByProjectNameFilter() {
        //workspacePage =
                homePage.goToTopMenu()
                        .goToHomePage()
                        .goToAllProjects()
                        .filterByProjectName(projectName)
                        .openFilteredProject(projectName)
                        .goToWorkspaces()
                        .goToCreateChildWorkspace()
                        .simpleSelectWorkspaceFromDropDown(workspace1)
                        .selectWorkspaceFromDropDown(workspace2)
                        .simpleSelectWorkspaceFromDropDown(workspace3)
                        .setWorkspaceNameFromTemplate(workspaceName)
                        .goToCustomWorkspace()
                        .setCustomWorkspaceName(workspaceName)
                        .createWorkspace();
                /*
                Assertions.assertEquals(projectPage.getProjectName(), projectName);
                */

    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}
