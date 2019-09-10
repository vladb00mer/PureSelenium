package pageobjects.workspace;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.project.ProjectPage;

import javax.swing.*;
import java.util.List;

public class CreateWorkspaceForm extends ParentPage {

    @FindBy(xpath = "//a[@ui-id='createNewWSAsKrmTemplate']")
    private WebElement fromTemplateTab;

    @FindBy(xpath = "//a[@ui-id='createNewWSAsCustom']")
    private WebElement customWorkspaceTab;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement fromTemplateWorkspaceName;

    @FindBy(xpath = "//input[@id='workspaceName']")
    public WebElement customWorkspaceName;

    @FindBy(xpath = "//button[contains(text(), 'Create Workspace')]")
    private WebElement createWorkspaceButton;

    @FindBy(xpath = "//button[@aria-label='Cancel action if form valid']")
    private WebElement cancelButton;


    public CreateWorkspaceForm() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(fromTemplateTab));
    }

    public CreateWorkspaceForm goToFromTemplate() {

        clickOnElement(fromTemplateTab);
        return this;
    }

    public CreateWorkspaceForm goToCustomWorkspace() {

        clickOnElement(customWorkspaceTab);
        return this;
    }

    public CreateWorkspaceForm selectWorkspaceFromChips(String tag) {

        clickOnElement(Init.getWebDriver().findElement(By.xpath("//button[ui-id='"+tag+"')]")));
        return this;
    }

    public CreateWorkspaceForm setWorkspaceNameFromTemplate(String name) {

        setTextValue(fromTemplateWorkspaceName, name);
        return this;
    }

    public CreateWorkspaceForm setCustomWorkspaceName(String name) {

        setTextValue(customWorkspaceName, name);
        return this;
    }

    public ProjectPage createChildWorkspace() {

        clickOnElement(createWorkspaceButton);
        return new ProjectPage();
    }

    public ProjectPage cancel() {

        clickOnElement(cancelButton);
        return new ProjectPage();
    }

    public CreateWorkspaceForm removeChips(String tag) {

        Init.getWebDriver().findElement(By.xpath("//button[@ui-id='"+tag+"Remove']")).click();
        return new CreateWorkspaceForm();
    }
}
