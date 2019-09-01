package pageobjects.project.tables;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RecentlyUpdatedWorkspacesTable extends ParentPage {

    @FindBy(xpath = "//div[@ui-id='addNewEntity']")
    private WebElement createChildWorkspaceButton;

    @FindBy(xpath = "//td[@data-title-text='Name']/div/a")
    private List<WebElement> workspacesTableNames;

    @FindBy(xpath = "//td[@data-title-text='Parent Workspace']/div/a")
    private List<WebElement> workspacesTableParentWS;

    @FindBy(xpath = "//td[@data-title-text='Metrics']/div/div/div")
    private List<WebElement> workspacesTableMetrics;

    @FindBy(xpath = "//td[@data-title-text='Last Updated']/div/span")
    private List<WebElement> workspacesTableLastUpdated;

    @FindBy(xpath = "//td[@data-title-text='Status']//img")
    private List<WebElement> workspacesTableStatus;

    @FindBy(xpath = "//div[@ui-id='ellipsisMenuWSgrid']")
    private List<WebElement> workspacesTableOptions;

    @FindBy(xpath = "//a[@title='View All Workspaces']")
    private WebElement viewAllWorkspacesButton;

    @FindBy(xpath = "//a[contains(text(), 'Show more')]")
    private WebElement showMoreButton;


    public RecentlyUpdatedWorkspacesTable() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(createChildWorkspaceButton));
    }

    public void goToCreateChildWorkspace() {

        clickOnElement(createChildWorkspaceButton);
    }

    public void openWorkSpaceByName(int i) {

        clickOnElement(workspacesTableNames.get(i));
    }

    public void openParentWorkSpace(int i) {

        clickOnElement(workspacesTableParentWS.get(i));
    }

    public String getMetrics(int i) {

        return workspacesTableMetrics.get(i).getAttribute("kas")+" "+workspacesTableMetrics.get(i).getAttribute("workspaces");
    }

    public String getLastUpdated(int i) {

        return workspacesTableLastUpdated.get(i).getAttribute("title");
    }

    public String getStatus(int i) {

        return workspacesTableStatus.get(i).getAttribute("alt");
    }

    public void goToOptions(int i) {

        clickOnElement(workspacesTableOptions.get(i));
    }

    public void viewAllWorkspaces() {

        clickOnElement(viewAllWorkspacesButton);
    }

    public RecentlyUpdatedWorkspacesTable showMore() {

        clickOnElement(showMoreButton);
        return this;
    }
}
