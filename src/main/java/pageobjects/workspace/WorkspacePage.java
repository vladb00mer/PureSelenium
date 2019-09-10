package pageobjects.workspace;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkspacePage extends ParentPage {

    @FindBy(xpath = "//span[@editable-text='workspace.Name']")
    private WebElement workspaceName;

    @FindBy(xpath = "//div[contains(text(), 'Create Child Workspace')]")
    private WebElement createChildWorkspace;

    public WorkspacePage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(workspaceName));
    }

    public String getWorkspaceName() {

        return getTextValue(workspaceName);
    }

    public CreateWorkspaceForm goToCreateChildWorkspace() {

        clickOnElement(createChildWorkspace);
        return new CreateWorkspaceForm();
    }
}
