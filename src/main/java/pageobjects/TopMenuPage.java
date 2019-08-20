package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage extends ParentPage {

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


    TopMenuPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(knectionLink));
    }

    public MainMenuPage goToMainMenu() {

        return new MainMenuPage();
    }
    public void searchWorkSpaces(String workspace) {

        clickOnElement(searchArea);
        setValue(searchArea, workspace);
        clickOnElement(submitSearch);
    }
    public void selectProject(String project) {

        clickOnElement(projectDropDown);
    }
}
