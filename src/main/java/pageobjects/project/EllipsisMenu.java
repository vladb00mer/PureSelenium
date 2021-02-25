package pageobjects.project;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EllipsisMenu extends ParentPage {

    @FindBy(xpath = "//button[@aria-label='Open']")
    private WebElement open;

    @FindBy(xpath = "//button[@aria-label='Edit']")
    private WebElement edit;

    @FindBy(xpath = "//button[@aria-label='Add to \"My Projects\" list']")
    private WebElement add;

    @FindBy(xpath = "//button[@aria-label='Create Child Workspace']")
    private WebElement createChildWorkspace;


    public EllipsisMenu() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(add));
    }

    public ProjectPage open() {

        clickOnElement(open);
        return new ProjectPage();
    }

    public AllProjectsPage add() {

        clickOnElement(add);
        return new AllProjectsPage();
    }
}
