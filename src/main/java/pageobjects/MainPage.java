package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends ParentPage {

    @FindBy(xpath = "//a[@aria-label='Knection']")
    private WebElement knectionLink;

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


    public MainPage(String user) {

        Init.getWebDriver().navigate().to("http://ecsc00a0154c.epam.com:82/Home?ssoUserId="+user);
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(knectionLink));
    }

    public TopMenuPage goToTopMenu() {

        return new TopMenuPage();
    }

    public MainPage filterByName(String name) {

        clickOnElement(searchByName);
        setValue(searchByName, name);
        return this;
    }
    public MainPage filterByProjectCode(String code) {

        clickOnElement(searchByProjectCode);
        setValue(searchByProjectCode, code);
        return this;
    }
    public MainPage filterByApiId(String apiId) {

        clickOnElement(searchByName);
        setValue(searchByApiId, apiId);
        return this;
    }
    public MainPage filterByLastUpdated(String date) {

        clickOnElement(selectDateRange);
        setValue(selectDateRange, date);
        return this;
    }
}
