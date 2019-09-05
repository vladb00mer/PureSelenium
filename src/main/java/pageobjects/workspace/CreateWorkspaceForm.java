package pageobjects.workspace;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.project.ProjectPage;

import java.util.List;

public class CreateWorkspaceForm extends ParentPage {

    @FindBy(xpath = "//a[@ui-id='createNewWSAsKrmTemplate']")
    private WebElement fromTemplateTab;

    @FindBy(xpath = "//md-autocomplete[@ui-id='SelectNodesForCreateNewWS']//input")
    private WebElement fromTemplateSelectWorkspace;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement workspaceName;

    @FindBy(xpath = "//ul/li/button[@ng-click='onSelectNextItem(node)']/span[@class='chip-name ng-binding']")
    private List<WebElement> workspaces;

    @FindBy(xpath = "//button[@aria-label='Remove']")
    private WebElement removeWorkspaceButton;

    @FindBy(xpath = "//a[@ui-id='createNewWSAsCustom']")
    private WebElement customWorkspaceTab;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement fromTemplateWorkspaceName;

    @FindBy(xpath = "//input[@id='workspaceName']")
    private WebElement customWorkspaceName;

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

    public CreateWorkspaceForm simpleSelectWorkspaceFromDropDown(String ws) {

        setTextValue(fromTemplateSelectWorkspace, ws);
        return this;
    }

    public CreateWorkspaceForm selectWorkspaceFromDropDown(String ws) {

        setTextValue(fromTemplateSelectWorkspace, ws);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element = Init.getWebDriver().findElement(By.xpath("//span[@title='"+ws+"']"));
        clickOnElement(element);

        return this;
    }

    public CreateWorkspaceForm selectWorkspaceFromTags(String tag) {

        Init.getWebDriver().findElement(By.xpath("//span[contains(text(), '"+tag+"')]/..")).click();
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

    public ProjectPage createWorkspace() {

        clickOnElement(createWorkspaceButton);
        return new ProjectPage();
    }
}
