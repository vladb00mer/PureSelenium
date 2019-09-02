package pageobjects.workspace;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateWorkspaceForm extends ParentPage {

    @FindBy(xpath = "//span[contains(text(), 'From template')]")
    private WebElement fromTemplateTab;

    @FindBy(xpath = "//input[@name='autoCompleteWorkspace']")
    private WebElement selectWorkspace;

    @FindBy(xpath = "//input[@name='workspaceName']")
    private WebElement workspaceName;

    @FindBy(xpath = "//button[@aria-label='Remove']")
    private WebElement removeWorkspaceButton;

    @FindBy(xpath = "//span[contains(text(), 'Custom workspace')]")
    private WebElement customWorkspaceTab;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement fromTemplateWorkspaceName;

    @FindBy(xpath = "//button[contains(text(), 'Create Workspace')]")
    private WebElement createWorkspaceButton;

    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
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

    public CreateWorkspaceForm selectWorkspace(String ws) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Init.getWebDriver().findElement(By.xpath("//span[contains(text(), '"+ws+"')]/..")).click();
        return this;
    }

    public CreateWorkspaceForm setWorkspaceNameFromTemplate(String name) {

        setTextValue(fromTemplateWorkspaceName, name);
        return this;
    }

    public void createWorkspace() {

        clickOnElement(createWorkspaceButton);
    }
}
