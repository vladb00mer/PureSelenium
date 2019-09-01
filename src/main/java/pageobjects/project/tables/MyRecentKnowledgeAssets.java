package pageobjects.project.tables;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyRecentKnowledgeAssets extends ParentPage {

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//input[@ng-model='name']")
    private WebElement searchByName;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//td[@data-title-text='Name']//a")
    private List<WebElement> knowledgeAssetsTableNames;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//input[@placeholder='Search by Project Name']")
    private WebElement searchByProjectName;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//td[@data-title-text='Project Name']//span")
    private List<WebElement> knowledgeAssetsTableProjectNames;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//md-select[@aria-label='Select Types']")
    private WebElement searchByType;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//td[@data-title-text='Type']//span")
    private List<WebElement> knowledgeAssetsTableTypes;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//input[@aria-label='Search by Name']")
    private WebElement searchByUpdatedBy;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//td[@data-title-text='Updated By']//span")
    private List<WebElement> knowledgeAssetsTableUpdatedBy;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//input[@placeholder='Select Date Range']")
    private WebElement searchByDateRange;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//td[@data-title-text='My Last Accessed']//span")
    private List<WebElement> knowledgeAssetsTableMyLastAccessed;

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//div[@ui-id='ellipsisMenuKAgrid']")
    private List<WebElement> knowledgeAssetsTableOptions;


    public MyRecentKnowledgeAssets() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(searchByName));
    }
}
