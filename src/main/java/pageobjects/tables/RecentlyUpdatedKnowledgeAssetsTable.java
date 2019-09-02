package pageobjects.tables;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RecentlyUpdatedKnowledgeAssetsTable extends ParentPage {

    @FindBy(xpath = "//div[@ui-id='addNewEntity']")
    private WebElement addFileOrLinkButton;

    @FindBy(xpath = "//td[@data-title-text='Name']/div/a")
    private List<WebElement> workspacesTableNames;

    @FindBy(xpath = "//table[@ng-table='kaTableParams']//td[@data-title-text='Metrics']/div/div/div")
    private List<WebElement> workspacesTableMetrics;

    @FindBy(xpath = "//table[@ng-table='kaTableParams']//td[@data-title-text='Last Updated']/div/span")
    private List<WebElement> workspacesTableLastUpdated;

    @FindBy(xpath = "//table[@ng-table='kaTableParams']//td[@data-title-text='Updated By']/div/span")
    private List<WebElement> workspacesTableUpdatedBy;

    @FindBy(xpath = "//table[@ui-id='ellipsisMenuKAgrid']")
    private List<WebElement> workspacesTableOptions;

    @FindBy(xpath = "//a[@title='View All Knowledge Assets']")
    private WebElement viewAllKnowledgeAssetsButton;


    public RecentlyUpdatedKnowledgeAssetsTable() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(addFileOrLinkButton));
    }

    public void addFileOrLink() {

        clickOnElement(addFileOrLinkButton);
    }

    public void openKAbyName(int i) {

        clickOnElement(workspacesTableNames.get(i));
    }

    public String getMetrics(int i) {

        return workspacesTableMetrics.get(i).getAttribute("workspaces");
    }

    public String getLastUpdated(int i) {

        return workspacesTableLastUpdated.get(i).getAttribute("title");
    }

    public String getUpdatedBy(int i) {

        return workspacesTableUpdatedBy.get(i).getAttribute("title");
    }

    public RecentlyUpdatedKnowledgeAssetsTable viewAllKnowledgeAssets() {

        clickOnElement(viewAllKnowledgeAssetsButton);
        return this;
    }
}
