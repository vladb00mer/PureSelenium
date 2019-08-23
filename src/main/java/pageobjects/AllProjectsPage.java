package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllProjectsPage extends ParentPage {

    @FindBy(xpath = "//div[@ng-if='userCanCreateorUpdateProject']")
    private WebElement addNewProject;

    @FindBy(xpath = "//div[contains(text(), 'All Projects')]")
    private WebElement allProjectsHeader;

    @FindBy(xpath = "//input[@placeholder='Search by Name']")
    private WebElement searchByName;

    @FindBy(xpath = "//input[@placeholder='Search by Project Code']")
    private WebElement searchByProjectCode;

    @FindBy(xpath = "//input[@placeholder='Search by API ID']")
    private WebElement searchByApiId;


    AllProjectsPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(allProjectsHeader));
    }

    public AllProjectsPage filterByProjectName(String name) {

        clickOnElement(searchByName);
        setTextValue(searchByName, name);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public AllProjectsPage filterByProjectCode(String code) {

        clickOnElement(searchByProjectCode);
        setTextValue(searchByProjectCode, code);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public AllProjectsPage filterByApiId(String apiId) {

        clickOnElement(searchByName);
        setTextValue(searchByApiId, apiId);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
