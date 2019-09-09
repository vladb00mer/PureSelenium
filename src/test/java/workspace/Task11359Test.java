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
                .selectWorkspaceFromTags("Biologics").cancel().goToWorkspaces().goToEllipsisMenu("").createChildWorkspace();

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
                .createChildWorkspace().goToWorkspaces().goToEllipsisMenu("").createChildWorkspace().selectWorkspaceFromTags("Route Scouting");
    }

    @Test
    @DisplayName("BMSQKNCT-11865 Attempt to create fixed node when Workspace with the same name was created in the same location")
    void createFixedNodeSameAsExistedWorkspace() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("")
                .goToWorkspaces().goToEllipsisMenu("Chemistry").createChildWorkspace().goToCustomWorkspace().setCustomWorkspaceName("Fixed Node")
                .createChildWorkspace().goToTopMenu().goToMainMenu().goToAdminManagement().goToKrmManagement().goToEditMode()
                ;
        homePage.goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToCreateChildWorkspace()
                .selectWorkspaceFromTags("Chemistry").selectWorkspaceFromTags("Fixed Node");

    }

    @Test
    @DisplayName("BMSQKNCT-11866 Attempt to create already created by template terminal fixed node")
    void createTerminalFixedNodeSameAsExistedWorkspace() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces()
                .goToCreateChildWorkspace().selectWorkspaceFromTags("Chemistry").selectWorkspaceFromTags("Route Scouting").selectWorkspaceFromTags("Proposal Development")
                .createChildWorkspace().goToWorkspaces().goToEllipsisMenu("Chemistry").createChildWorkspace().selectWorkspaceFromTags("Route Scouting")
                .selectWorkspaceFromTags("Proposal Development");
    }

    @Test
    @DisplayName("BMSQKNCT-11867 Workspace Name instead of Modifier for non-fixed type node")
    void workspaceNameInsteadOfModifierForNonFixedTypeNode() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces()
                .goToEllipsisMenu("Chemistry").createChildWorkspace().selectWorkspaceFromTags("Route").setCustomWorkspaceName("").createChildWorkspace()
                .goToEllipsisMenu("").createChildWorkspace().selectWorkspaceFromTags("Step").setCustomWorkspaceName("").createChildWorkspace();

    }

    @Test
    @DisplayName("BMSQKNCT-11868 Fill in duplicated Workspace name for type node (when created by template)")
    void duplicatedWorkspaceNameForTypeNodeWhenCreatedByTemplate() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToEllipsisMenu("")
                .createChildWorkspace().selectWorkspaceFromTags("Route").setCustomWorkspaceName("").createChildWorkspace().goToEllipsisMenu("")
                .createChildWorkspace().selectWorkspaceFromTags("Route").setCustomWorkspaceName("");
    }

    @Test
    @DisplayName("BMSQKNCT-11869 Fill in duplicated Workspace name for type node (when created Custom Workspace)")
    void duplicatedWorkspaceNameForTypeNodeChenCreatedByCustomWorkspace() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToEllipsisMenu("Chemistry")
                .createChildWorkspace().goToCustomWorkspace().setCustomWorkspaceName("").createChildWorkspace().goToEllipsisMenu("Chemistry").createChildWorkspace()
                .selectWorkspaceFromTags("Route").setCustomWorkspaceName("");

    }
}
