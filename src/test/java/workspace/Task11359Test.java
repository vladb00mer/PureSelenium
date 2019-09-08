package workspace;

import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.tables.RecentlyUpdatedWorkspacesTable;
import pageobjects.workspace.CreateWorkspaceForm;

class Task11359Test {

    private static HomePage homePage;
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
    void automaticCreationOfTheFirstNodesBasedOnProcessSelectionInModifyProjectModalTest() {

        CreateWorkspaceForm createWorkspaceForm = homePage.goToTopMenu().goToHomePage().goToAllProjects().useEllipsisMenu("").edit().selectProcesses(3)
                .saveProject().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToCreateChildWorkspace()
                .selectWorkspaceFromTags("Biologics").cancel().goToWorkspaces().goToEllipsisMenu().createChildWorkspace();

        Assertions.assertTrue(createWorkspaceForm.customWorkspaceName.isDisplayed());
    }

    @Test
    @DisplayName("BMSQKNCT-11861 Create Workspace from Template from View All Workspaces page")
    void createWorkspaceFromTemplateFromViewAllWorkspacesPage() {

        RecentlyUpdatedWorkspacesTable recentlyUpdatedWorkspacesTable = homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("")
                .goToWorkspaces().goToCreateChildWorkspace().selectWorkspaceFromTags("Chemistry").removeChips("Chemistry").selectWorkspaceFromTags("Chemistry")
                .selectWorkspaceFromTags("Route Scouting").createChildWorkspace().goToWorkspaces();

        Assertions.assertTrue(recentlyUpdatedWorkspacesTable.tableContainsName("Chemistry"));
        Assertions.assertTrue(recentlyUpdatedWorkspacesTable.tableContainsName("Route Scouting"));
    }

    @Test
    @DisplayName("BMSQKNCT-11862 Attempt to create already created by template non-terminal fixed node")
    void createNonTerminalWorkspaceSameAsExisted() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("")
                .goToWorkspaces().goToCreateChildWorkspace().selectWorkspaceFromTags("Chemistry").selectWorkspaceFromTags("Route Scouting")
                .createChildWorkspace().goToWorkspaces().goToEllipsisMenu().createChildWorkspace().selectWorkspaceFromTags("Route Scouting");
    }
}
