package workspace;

import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.project.ProjectPage;

class Task11359Test {

    private static HomePage homePage;
    private static ProjectPage projectPage;
    private static String user = "nadezda_peskun@epam.com";


    @BeforeAll
    static void setUp() {homePage = new HomePage(user);}

    @Test
    @DisplayName("BMSQKNCT-11836 Create Child Workspace from Custom WS")
    void createChildWorkspaceFromCustomWorkspaceTest() {

        String wsName = homePage
                .goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToCreateChildWorkspace()
                .goToFromTemplate().setCustomWorkspaceName("").createChildWorkspace().goToWorkspaces().openWorkSpaceByName("").getWorkspaceName();

        Assertions.assertEquals("customWorkspaceName", wsName);
    }

    @Test
    @DisplayName("BMSQKNCT-11844 Create Workspace from Template from Project Dashboard")
    void createWorkspacefromTemplateFromProjectDashboardTest() {

        String wsName = homePage
                .goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToCreateChildWorkspace().goToFromTemplate()
                                .setWorkspaceNameFromTemplate("").createChildWorkspace().goToWorkspaces().openWorkSpaceByName("").getWorkspaceName();

        Assertions.assertEquals("fromTemplateWorkspaceName", wsName);
    }

    @Test
    @DisplayName("BMSQKNCT-11845 View of 'Create Workspace' modal opened from PD/View all WSs for Project that doesn't have any Process selected")
    void defaultTabWithoutAnyProcessSelectedTest() {

        String wsName = homePage
                .goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToCreateChildWorkspace()
                .goToCustomWorkspace().goToFromTemplate().cancel().goToWorkspaces().viewAllWorkspaces().createChildWorkspace().cancel().getProjectName();

        Assertions.assertEquals("", wsName);
    }

    @Test
    @DisplayName("BMSQKNCT-11854 Create Child Workspace from terminal node")
    void customWorkspaceTabByDefaultTest() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToCreateChildWorkspace();
    }

    @Test
    @DisplayName("BMSQKNCT-11855 Create Child Workspace for case when KRM WS was deleted")
    void childWorkspaceForDeletedKrmWsTest() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToCreateChildWorkspace();
    }

    @Test
    @DisplayName("BMSQKNCT-11856 Keep automatic creation of the first nodes based on Process selection in Add Project modal")
    void keepAutomaticCreationOfTheFirstNodesBasedOnProcessSelectionInAddProjectModalTest() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().addNewProject().setProjectName("").setProjectCode("").setApiId("")
                .selectProcesses(1,4).saveProject().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToCreateChildWorkspace()
                .selectWorkspaceFromTags("Chemistry").cancel();
    }

    @Test
    @DisplayName("BMSQKNCT-11859 Keep automatic creation of the first nodes based on Process selection in Modify Project modal")
    void automaticCreationOfTheFirstNodesBasedOnProcessSelectionInModifyProjectModal() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().useEllipsisMenu("123456789").edit();
    }
}
