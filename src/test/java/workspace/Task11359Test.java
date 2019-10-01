package workspace;

import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.HomePage;
import pageobjects.tables.RecentlyUpdatedWorkspacesTable;
import pageobjects.workspace.CreateWorkspaceForm;

class Task11359Test {

    private static HomePage homePage;
    private static String projectName;
    private static String adminUser = "auto_bmsq-knct_qa5@epam.com";
    private static String internalUser = "auto_bmsq-knct_qa3@epam.com";

    @BeforeAll
    static void createTestProject() {

        homePage = new HomePage(adminUser);
        projectName = "autoTestProject"+Init.getCurrentDateTime();

        homePage.goToAllProjects().addNewProject().setProjectName(projectName).setProjectCode("autoTestProjectCode").setApiId("autoTestProjectId").setTherapeuticArea("Metabolics")
                .selectProcesses(1,3).saveProject();
    }

    @Test
    @DisplayName("BMSQKNCT-11836 Create Child Workspace from Custom WS")
    void createChildWorkspaceFromCustomWorkspaceTest() {

        homePage = new HomePage(internalUser);

        String wsName = homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName)
                .goToWorkspaces().goToCreateChildWorkspace().goToCustomWorkspace().setCustomWorkspaceName("autoTestCustomWS-11836").createChildWorkspace().goToWorkspaces()
                .openWorkSpaceByName("autoTestCustomWS-11836").getWorkspaceName();

        Assertions.assertEquals(wsName, "autoTestCustomWS-11836");
    }

    @Test
    @DisplayName("BMSQKNCT-11844 Create Workspace from Template from Project Dashboard")
    void createWorkspacefromTemplateFromProjectDashboardTest() {

        homePage = new HomePage(internalUser);

        String wsName = homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName)
                .goToWorkspaces().goToCreateChildWorkspace().goToFromTemplate().selectWorkspaceFromChips("Chemistry").setWorkspaceNameFromTemplate("fromTemplateWorkspaceName-11844").createChildWorkspace()
                .goToWorkspaces().openWorkSpaceByName("fromTemplateWorkspaceName-11844").getWorkspaceName();

        Assertions.assertEquals("fromTemplateWorkspaceName-11844", wsName);
    }

    @Test
    @DisplayName("BMSQKNCT-11845 View of 'Create Workspace' modal opened from PD/View all WSs for Project that doesn't have any Process selected")
    void defaultTabWithoutAnyProcessSelectedTest() {

        String wsName = homePage
                .goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces().goToCreateChildWorkspace()
                .goToCustomWorkspace().goToFromTemplate().cancel().goToWorkspaces().viewAllWorkspaces().createChildWorkspace().cancel().getProjectName();

        Assertions.assertEquals(projectName, wsName);
    }

    @Test
    @DisplayName("BMSQKNCT-11854 Create Child Workspace from terminal node")
    void customWorkspaceTabByDefaultTest() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces().goToCreateChildWorkspace();
    }

    @Test
    @DisplayName("BMSQKNCT-11855 Create Child Workspace for case when KRM WS was deleted")
    void childWorkspaceForDeletedKrmWsTest() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces().goToCreateChildWorkspace();
    }

    @Test
    @DisplayName("BMSQKNCT-11856 Keep automatic creation of the first nodes based on Process selection in Add Project modal")
    void keepAutomaticCreationOfTheFirstNodesBasedOnProcessSelectionInAddProjectModalTest() {

        String localProjectName = "autoTestProject"+Init.getCurrentDateTime();

        homePage.goToTopMenu().goToHomePage().goToAllProjects().addNewProject().setProjectName(localProjectName).setProjectCode("autoTestProjectCode").setApiId("autoTestProjectId")
                .setTherapeuticArea("Metabolics").selectProcesses(1,4).saveProject().filterByProjectName(localProjectName).openFilteredProject(localProjectName).goToWorkspaces()
                .goToCreateChildWorkspace().selectWorkspaceFromChips("Chemistry").cancel();
    }

    @Test
    @DisplayName("BMSQKNCT-11859 Keep automatic creation of the first nodes based on Process selection in Modify Project modal")
    void automaticCreationOfTheFirstNodesBasedOnProcessSelectionInModifyProjectModalTest() {

        CreateWorkspaceForm createWorkspaceForm = homePage.goToTopMenu().goToHomePage().goToAllProjects().useEllipsisMenu("").edit().selectProcesses(3)
                .saveProject().filterByProjectName("").openFilteredProject("").goToWorkspaces().goToCreateChildWorkspace()
                .selectWorkspaceFromChips("Biologics").cancel().goToWorkspaces().goToEllipsisMenu("").createChildWorkspace();

        Assertions.assertTrue(createWorkspaceForm.customWorkspaceName.isDisplayed());
    }

    @Test
    @DisplayName("BMSQKNCT-11861 Create Workspace from Template from View All Workspaces page")
    void createWorkspaceFromTemplateFromViewAllWorkspacesPage() {

        RecentlyUpdatedWorkspacesTable recentlyUpdatedWorkspacesTable = homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName)
                .goToWorkspaces().goToCreateChildWorkspace().selectWorkspaceFromChips("Chemistry").removeChips("Chemistry").selectWorkspaceFromChips("Chemistry")
                .selectWorkspaceFromChips("Route Scouting").createChildWorkspace().goToWorkspaces();

        Assertions.assertTrue(recentlyUpdatedWorkspacesTable.tableContainsName("Chemistry"));
        Assertions.assertTrue(recentlyUpdatedWorkspacesTable.tableContainsName("Route Scouting"));
    }

    @Test
    @DisplayName("BMSQKNCT-11862 Attempt to create already created by template non-terminal fixed node")
    void createNonTerminalWorkspaceSameAsExisted() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName)
                .goToWorkspaces().goToCreateChildWorkspace().selectWorkspaceFromChips("Chemistry").selectWorkspaceFromChips("Route Scouting")
                .createChildWorkspace().goToWorkspaces().goToEllipsisMenu("").createChildWorkspace().selectWorkspaceFromChips("Route Scouting");
    }

    @Test
    @DisplayName("BMSQKNCT-11865 Attempt to create fixed node when Workspace with the same name was created in the same location")
    void createFixedNodeSameAsExistedWorkspace() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName)
                .goToWorkspaces().goToEllipsisMenu("Chemistry").createChildWorkspace().goToCustomWorkspace().setCustomWorkspaceName("Fixed Node")
                .createChildWorkspace().goToTopMenu().goToMainMenu().goToAdminManagement().goToKrmManagement().goToEditMode()
                ;
        homePage.goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces().goToCreateChildWorkspace()
                .selectWorkspaceFromChips("Chemistry").selectWorkspaceFromChips("Fixed Node");

    }

    @Test
    @DisplayName("BMSQKNCT-11866 Attempt to create already created by template terminal fixed node")
    void createTerminalFixedNodeSameAsExistedWorkspace() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces()
                .goToCreateChildWorkspace().selectWorkspaceFromChips("Chemistry").selectWorkspaceFromChips("Route Scouting").selectWorkspaceFromChips("Proposal Development")
                .createChildWorkspace().goToWorkspaces().goToEllipsisMenu("Chemistry").createChildWorkspace().selectWorkspaceFromChips("Route Scouting")
                .selectWorkspaceFromChips("Proposal Development");
    }

    @Test
    @DisplayName("BMSQKNCT-11867 Workspace Name instead of Modifier for non-fixed type node")
    void workspaceNameInsteadOfModifierForNonFixedTypeNode() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces()
                .goToEllipsisMenu("Chemistry").createChildWorkspace().selectWorkspaceFromChips("Route").setCustomWorkspaceName("autoTestWS-11867").createChildWorkspace()
                .goToEllipsisMenu("autoTestWS-11867").createChildWorkspace().selectWorkspaceFromChips("Step").setCustomWorkspaceName("autoTestWS-11867").createChildWorkspace();

    }

    @Test
    @DisplayName("BMSQKNCT-11868 Fill in duplicated Workspace name for type node (when created by template)")
    void duplicatedWorkspaceNameForTypeNodeWhenCreatedByTemplate() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces().goToEllipsisMenu("")
                .createChildWorkspace().selectWorkspaceFromChips("Route").setCustomWorkspaceName("autoTestCustomWS-11868").createChildWorkspace().goToEllipsisMenu("")
                .createChildWorkspace().selectWorkspaceFromChips("Route").setCustomWorkspaceName("autoTestCustomWS-11868");
    }

    @Test
    @DisplayName("BMSQKNCT-11869 Fill in duplicated Workspace name for type node (when created Custom Workspace)")
    void duplicatedWorkspaceNameForTypeNodeChenCreatedByCustomWorkspace() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces().goToEllipsisMenu("Chemistry")
                .createChildWorkspace().goToCustomWorkspace().setCustomWorkspaceName("autoTestCustomWS-11869").createChildWorkspace().goToEllipsisMenu("Chemistry").createChildWorkspace()
                .selectWorkspaceFromChips("Route").setCustomWorkspaceName("autoTestCustomWS-11868");

    }

    @Test
    @DisplayName("BMSQKNCT-11870 Create several new WSs from different levels at the same time")
    void createSeveralNewWsFromDifferentLevelsAtTheSameTime() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces().goToCreateChildWorkspace()
                .selectWorkspaceFromChips("Process1").selectWorkspaceFromChips("Type Node1").selectWorkspaceFromChips("Type Node1").createChildWorkspace().goToWorkspaces()
                .goToCreateChildWorkspace().selectWorkspaceFromChips("Process1").selectWorkspaceFromChips("Type Node1").selectWorkspaceFromChips("Type Node1")
                .selectWorkspaceFromChips("Terminal Node").createChildWorkspace();


    }

    @Test
    @DisplayName("BMSQKNCT-11871 Create Workspace from Template (non-terminal)")
    void createWorkspaceFromNobTerminalTemplate() {

        homePage.goToTopMenu().goToHomePage().goToAllProjects().filterByProjectName(projectName).openFilteredProject(projectName).goToWorkspaces().openWorkSpaceByName("")
                .goToCreateChildWorkspace().selectWorkspaceFromChips("").createChildWorkspace();
    }

    @AfterAll
    static void tearDown() {
        homePage = null;
        Init.closeDriver();
    }
}
