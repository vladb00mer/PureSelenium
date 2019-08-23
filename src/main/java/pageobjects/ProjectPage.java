package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ProjectPage extends ParentPage {

    @FindBy(xpath = "//span[@ng-bind='::project.Name']")
    private WebElement projectName;

    @FindBy(xpath = "//label[@for='mine-no']")
    private WebElement mineNoFlag;

    @FindBy(xpath = "//input[@id='chemistry_btn']/..")
    private WebElement chemistry;

    @FindBy(xpath = "//input[@id='formulation_btn']/..")
    private WebElement formulation;

    @FindBy(xpath = "//input[@id='analytical_btn']/..")
    private WebElement analytical;

    @FindBy(xpath = "//input[@id='biologics_btn']/..")
    private WebElement biologics;

    @FindBy(xpath = "//input[@id='all_btn']/..")
    private WebElement all;

    @FindBy(xpath = "//a[@ng-click='updateTabs(Entities.Workspaces)']")
    private WebElement workspacesTab;

    @FindBy(xpath = "//div[@ng-if='(selectedTab === Entities.KA || selectedTab === Entities.Workspaces)']")
    private WebElement createChildWorkspaceButton;

    @FindBy(xpath = "//td[@data-title='Name']/div/a")
    private WebElement knowledgeAssetsTab;

    @FindBy(xpath = "//switch-leads/span")
    private WebElement showList;


    ProjectPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(mineNoFlag));
    }

    public String getName() {

        return getTextValue(projectName);
    }
    public ProjectPage goToWorkspaces() {

        clickOnElement(workspacesTab);
        return this;
    }
    public ProjectPage goToKnowledgeAssets() {

        clickOnElement(knowledgeAssetsTab);
        return this;
    }
    public void createChildWorkspace() {

        clickOnElement(createChildWorkspaceButton);
    }
    public void openWorkspace(String name) {

        List<WebElement> names = Init.getWebDriver().findElements(By.xpath(""));
    }
}
