package workspace.creationbytemplate;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.project.ProjectPage;

class Task11359Test {

    private static HomePage homePage;
    private static ProjectPage projectPage;
    private static String user = "nadezda_peskun@epam.com";
    private String projectName = "autoTestName2";
    private String customWorkspaceName = "autoTestCustomWS1";
    private String fromTemplateWorkspaceName = "autoTestFromTemplateWS1";
    private String fromTemplateWSLevel1 = "Chemistry";
    private String fromTemplateWSLevel2 = "Route Scouting";


    @BeforeAll
    static void setUp() {

        homePage = new HomePage(user);
    }

    @Test
    @DisplayName("BMSQKNCT-11836 Create Child Workspace from Custom WS")
    void createChildWorkspaceFromCustomWorkspaceTest() {

        String wsName = homePage
                .goToTopMenu()
                .goToHomePage()
                .goToAllProjects()
                .filterByProjectName(projectName)
                .openFilteredProject(projectName)
                .goToWorkspaces()
                .goToCreateChildWorkspace()
                .goToFromTemplate()
                .setCustomWorkspaceName(customWorkspaceName)
                .createChildWorkspace()
                .goToWorkspaces()
                .openWorkSpaceByName(customWorkspaceName)
                .getWorkspaceName();

        Assertions.assertEquals(customWorkspaceName, wsName);
    }

    @Test
    @DisplayName("BMSQKNCT-11844 Create Workspace from Template from Project Dashboard")
    void createWorkspacefromTemplateFromProjectDashboardTest() {

        String wsName = homePage
                .goToTopMenu()
                .goToHomePage()
                .goToAllProjects()
                .filterByProjectName(projectName)
                .openFilteredProject(projectName)
                .goToWorkspaces()
                .goToCreateChildWorkspace()
                .goToFromTemplate()
                .simpleSelectWorkspaceFromDropDown(fromTemplateWSLevel1)
                .simpleSelectWorkspaceFromDropDown(fromTemplateWSLevel2)
                .setWorkspaceNameFromTemplate(fromTemplateWorkspaceName)
                .createChildWorkspace()
                .goToWorkspaces()
                .openWorkSpaceByName(customWorkspaceName)
                .getWorkspaceName();

        Assertions.assertEquals(fromTemplateWorkspaceName, wsName);
    }

    @Test
    @DisplayName("BMSQKNCT-11845 View of 'Create Workspace' modal opened from PD/View all WSs for Project that doesn't have any Process selected")
    void defaultTabWithoutAnyProcessSelected() {

        String wsName = homePage
                .goToTopMenu()
                .goToHomePage()
                .goToAllProjects()
                .filterByProjectName(projectName)
                .openFilteredProject(projectName)
                .goToWorkspaces()
                .goToCreateChildWorkspace()
                .goToCustomWorkspace()
                .goToFromTemplate()
                .cancel()
                .goToWorkspaces()
                .viewAllWorkspaces()
                .createChildWorkspace()
                .cancel()
                .getProjectName();

        Assertions.assertEquals(fromTemplateWorkspaceName, wsName);
    }

    @AfterAll
    static void tearDown() {

        Init.closeDriver();
        homePage = null;
    }
}
