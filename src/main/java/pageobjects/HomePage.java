package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.project.AllProjectsPage;
import pageobjects.project.ProjectPage;

import java.util.List;

public class HomePage extends ParentPage {

    @FindBy(xpath = "//span[contains(text(), 'My Projects ')]")
    private WebElement myProjectsHeader;

    @FindBy(xpath = "//a[@title='View All Project']")
    private WebElement viewAllProjects;

    @FindBy(xpath = "//div[@display-name='Project Name']//input[@placeholder='Search by Name']")
    private WebElement searchByName;

    @FindBy(xpath = "//div[@display-name='Project Code']//input[@placeholder='Search by Project Code']")
    private WebElement searchByProjectCode;

    @FindBy(xpath = "//div[@display-name='API ID']//input[@placeholder='Search by API ID']")
    private WebElement searchByApiId;

    @FindBy(xpath = "//div[@display-name='Last Updated']//input[@placeholder='Select Date Range']")
    private WebElement selectDateRange;


    HomePage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(myProjectsHeader));
    }

    public HomePage(String user) {

        Init.getWebDriver().navigate().to("http://ecsc00a0154c.epam.com:82/Home?ssoUserId="+user);
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(myProjectsHeader));
    }

    public TopMenuPage goToTopMenu() {

        return new TopMenuPage();
    }

    public HomePage filterByProjectName(String name) {

        setTextValue(searchByName, name);
        return this;
    }

    public HomePage filterByProjectCode(String code) {

        setTextValue(searchByProjectCode, code);
        return this;
    }

    public HomePage filterByApiId(String apiId) {

        setTextValue(searchByApiId, apiId);
        return this;
    }

    public HomePage filterByLastUpdated(String date) {

        setTextValue(selectDateRange, date);
        return this;
    }

    public ProjectPage openFilteredProject() {

        List<WebElement> projectNames = Init.getWebDriver().findElements(By.xpath("//td[@data-title-text='Project Name']/div/a"));
        projectNames.get(0).click();

        return new ProjectPage();
    }

    public AllProjectsPage goToAllProjects() {

        clickOnElement(viewAllProjects);
        return new AllProjectsPage();
    }

    
}
