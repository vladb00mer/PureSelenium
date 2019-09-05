package pageobjects.workspace;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllWorkspacesPage extends ParentPage {

    @FindBy(xpath = "//div[@data-ng-click='showCreateWorkspace($event)']")
    private WebElement createChildWorkspaceButton;

    public AllWorkspacesPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(createChildWorkspaceButton));
    }

    public CreateWorkspaceForm createChildWorkspace() {

        clickOnElement(createChildWorkspaceButton);
        return new CreateWorkspaceForm();
    }
}
