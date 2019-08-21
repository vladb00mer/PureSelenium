package pageobjects.user;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class HomePageUser extends ParentPage {

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


    public HomePageUser() {}

    public HomePageUser(String user) {

        Init.getWebDriver().navigate().to("http://ecsc00a0154c.epam.com:82/Home?ssoUserId="+user);
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(knectionLink));
    }

    public TopMenuPageUser goToTopMenu() {

        return new TopMenuPageUser();
    }

    public HomePageUser filterByName(String name) {

        clickOnElement(searchByName);
        setTextValue(searchByName, name);
        return this;
    }
    public HomePageUser filterByProjectCode(String code) {

        clickOnElement(searchByProjectCode);
        setTextValue(searchByProjectCode, code);
        return this;
    }
    public HomePageUser filterByApiId(String apiId) {

        clickOnElement(searchByName);
        setTextValue(searchByApiId, apiId);
        return this;
    }
    public HomePageUser filterByLastUpdated(String date) {

        clickOnElement(selectDateRange);
        setTextValue(selectDateRange, date);
        return this;
    }

    public ProjectPageUser openProject(String project) {

        List<WebElement> projectNames = Init.getWebDriver().findElements(By.xpath("//td[@data-title-text='Project Name']/div/a"));
        projectNames.get(0).click();

        return new ProjectPageUser();
    }
}
