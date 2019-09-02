package workspace;

import common.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.project.ProjectPage;

class CreateWorkspaceTest {

    private static HomePage homePage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "autoTestName2";
    private String workspace1 = "Chemistry";
    private String workspace2 = "Route";
    private String workspaceName = "autoTestWS1";


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
                openFilteredProject(projectName).
                goToWorkspaces().
                goToCreateChildWorkspace().
                selectWorkspace(workspace1).
                selectWorkspace(workspace2).
                setWorkspaceNameFromTemplate(workspaceName);

                /*.
                createWorkspace();
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
