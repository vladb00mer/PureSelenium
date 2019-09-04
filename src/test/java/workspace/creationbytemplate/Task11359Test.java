package workspace.creationbytemplate;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.project.ProjectPage;

class Task11359Test {

    private static HomePage homePage;
    private static ProjectPage projectPage;
    private static String user = "auto_bmsq-knct_qa2@epam.com";
    private String projectName = "autoTestName2";
    private String workspaceName = "autoTestWS1";


    @BeforeAll
    static void setUp() {
        homePage = new HomePage(user);
    }

    @Test
    @DisplayName("11836: Create Child Workspace from Custom WS")
    void testSearchByProjectNameFilter() {

        projectPage = homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces().goToCreateChildWorkspace()
                .goToFromTemplate().goToCustomWorkspace().setCustomWorkspaceName(workspaceName).createWorkspace();

        Assertions.assertEquals(workspaceName, projectPage.getProjectName());
    }

    @AfterAll
    static void tearDown() {
        Init.closeDriver();
        homePage = null;
    }
}
