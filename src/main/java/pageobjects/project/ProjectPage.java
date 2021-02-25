package pageobjects.project;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.TopMenuPage;

import java.util.List;

public class ProjectPage extends ParentPage {

    @FindBy(xpath = "//span[@ui-id='projectTitle']")
    private WebElement projectName;

    @FindBy(xpath = "//input[@ui-id='toggleMineAll']")
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

    @FindBy(xpath = "//a[@ui-id='WSTab']")
    private WebElement workspacesTable;

    @FindBy(xpath = "//td[@data-title-text='Name']/div/a")
    private List<WebElement> workspacesTableNames;

    @FindBy(xpath = "//a[@ui-id='KATab']")
    private WebElement knowledgeAssetsTable;

    @FindBy(xpath = "//switch-leads/span")
    private WebElement showList;

    @FindBy(xpath = "//div[@ui-id='ellipsisMenuWSgrid']")
    private WebElement ellipsisMenu;


    public ProjectPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(projectName));
    }

    public String getProjectName() {
        return getTextValue(projectName);
    }

    public String getFirstWorkspaceNameFromTable() {

        return getTextValue(workspacesTableNames.get(0));
    }

    public TopMenuPage goToTopMenu() {

        return new TopMenuPage();
    }

    public EllipsisMenu goToEllipsisMenu(String ws) {

        clickOnElement(ellipsisMenu);
        return new EllipsisMenu();
    }
}
