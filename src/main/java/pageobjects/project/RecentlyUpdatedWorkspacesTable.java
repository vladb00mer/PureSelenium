package pageobjects.project;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RecentlyUpdatedWorkspacesTable extends ParentPage {

    @FindBy(xpath = "//div[@ng-if='(selectedTab === Entities.KA || selectedTab === Entities.Workspaces)']")
    private WebElement createChildWorkspaceButton;

    @FindBy(xpath = "")
    private List<WebElement> workspacesTableNames;

    @FindBy(xpath = "")
    private List<WebElement> workspacesTableParentWS;

    @FindBy(xpath = "")
    private List<WebElement> workspacesTableMetrics;

    @FindBy(xpath = "")
    private List<WebElement> workspacesTableLastUpdated;

    @FindBy(xpath = "")
    private List<WebElement> workspacesTableStatus;

    @FindBy(xpath = "")
    private List<WebElement> workspacesTableOptions;

    @FindBy(xpath = "//a[@title='View All Workspaces']")
    private WebElement viewAllWorkspacesButton;

    RecentlyUpdatedWorkspacesTable() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(createChildWorkspaceButton));
    }

    public void goToCreateChildWorkspace() {
        clickOnElement(createChildWorkspaceButton);
    }

    public void openWorkSpaceByName(String name) {

    }

    public void openParentWorkSpace(String parent) {

    }

    public void getStatusByName(String name) {

    }

    public void goToOption(String option) {

    }

    public void goToViewAllWorkspaces() {
        clickOnElement(viewAllWorkspacesButton);
    }
}
