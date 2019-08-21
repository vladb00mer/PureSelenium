package pageobjects.user;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TopMenuPageUser extends ParentPage {

    @FindBy(xpath = "//button[@aria-label='Menu']")
    private WebElement mainMenuButton;

    @FindBy(xpath = "//a[@aria-label='Knection']")
    private WebElement knectionLink;

    @FindBy(xpath = "//input[@id='searchWs']")
    private WebElement searchArea;

    @FindBy(xpath = "//input[@name='submitSearch']")
    private WebElement submitSearch;

    @FindBy(xpath = "//md-select[@id='commonProjectSelector']")
    private WebElement projectDropDown;

    @FindBy(xpath = "//a[@ng-click='openAllActionItem()']")
    private WebElement allActionItems;

    @FindBy(xpath = "//a[@ng-click='toggleRight()']")
    private WebElement calendar;


    TopMenuPageUser() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(knectionLink));
    }

    public MainMenuPageUser goToMainMenu() {

        clickOnElement(mainMenuButton);
        return new MainMenuPageUser();
    }
    public void searchWorkSpaces(String workspace) {

        clickOnElement(searchArea);
        setTextValue(searchArea, workspace);
        clickOnElement(submitSearch);
    }
    public void selectProject(String project) {

        clickOnElement(projectDropDown);
    }

    public HomePageUser goToHomePage() {

        clickOnElement(knectionLink);
        return new HomePageUser();
    }
}
