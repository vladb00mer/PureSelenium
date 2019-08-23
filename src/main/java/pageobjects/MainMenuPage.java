package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainMenuPage extends ParentPage {

    @FindBy(xpath = "//a[@title='Dashboard']")
    private WebElement leftMenuDashboard;

    @FindBy(xpath = "//a[@title='Action Items']")
    private WebElement leftMenuActionItems;

    @FindBy(xpath = "//a[@title='Meetings']")
    private WebElement leftMenuMeetings;

    @FindBy(xpath = "//a[@title='All Projects']")
    private WebElement leftMenuAllProjects;

    @FindBy(xpath = "//a[@title='Help Center']")
    private WebElement leftMenuHelpCenter;

    @FindBy(xpath = "//a[@title='Admin Management']")
    private WebElement leftMenuAdminManagement;

    @FindBy(xpath = "//span[@ng-bind='userName']")
    private WebElement leftMenuUserName;

    @FindBy(xpath = "//span[@ng-show='department']")
    private WebElement leftMenuDepartment;

    @FindBy(xpath = "//a[@href='/ProfileSettings']")
    private WebElement leftMenuProfileSettings;


    MainMenuPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(leftMenuProfileSettings));
    }

    public void goToDashboard() {

        clickOnElement(leftMenuDashboard);
    }
    public void goToActionItems() {

        clickOnElement(leftMenuActionItems);
    }
    public void goToMeetings() {

        clickOnElement(leftMenuMeetings);
    }
    public void goToAllProjects() {

        clickOnElement(leftMenuAllProjects);
    }
    public void goToHelpCenter() {

        clickOnElement(leftMenuHelpCenter);
    }
    public void goToAdminManagement() {

        clickOnElement(leftMenuAdminManagement);
    }
    public void goToProfileSettings() {

        clickOnElement(leftMenuProfileSettings);
    }
    public String getUserName() {

        return getTextValue(leftMenuUserName);
    }
    public String getUserDepartment() {

        return getTextValue(leftMenuDepartment);
    }
}
