package pageobjects.project;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;

public class EllipsisMenu extends ParentPage {

    @FindBy(xpath = "//button[@]")
    private WebElement open;

    @FindBy(xpath = "//button[@]")
    private WebElement edit;

    @FindBy(xpath = "//button[@]")
    private WebElement add;


    EllipsisMenu() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(add));
    }

    public ProjectPage open() {

        clickOnElement(open);
        return new ProjectPage();
    }

    public ModifyProjectForm edit() {

        clickOnElement(edit);
        return new ModifyProjectForm();
    }

    public AllProjectsPage add() {

        clickOnElement(add);
        return new AllProjectsPage();
    }
}
