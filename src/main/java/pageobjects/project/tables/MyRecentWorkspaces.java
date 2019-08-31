package pageobjects.project.tables;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyRecentWorkspaces extends ParentPage {

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//input[@placeholder='Search by Name']")
    private WebElement searchByName;

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//td[@data-title-text='Name']//a")
    private List<WebElement> workspacesTableNames;

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//input[@placeholder='Search by Project Name']")
    private WebElement searchByProjectName;

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//td[@data-title-text='Project Name']//span")
    private List<WebElement> workspacesTableProjectNames;

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//input[@placeholder='Search by Workspace']")
    private WebElement searchByWorkspace;

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//td[@data-title-text='Parent Workspace']//a")
    private List<WebElement> workspacesTableWorkspaces;

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//input[@placeholder='Select Date Range']")
    private WebElement searchByDateRange;

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//td[@data-title-text='My Last Accessed']//span")
    private List<WebElement> workspacesTableLastAccessed;

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//input[@placeholder='Select Date Range']")
    private List<WebElement> optionsList;

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//div[@ui-id='ellipsisMenuWSgrid']")
    private List<WebElement> favoritesTableOptions;


    public MyRecentWorkspaces() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(searchByName));
    }
}
