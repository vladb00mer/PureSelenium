package pageobjects.administrative;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdministratorPage extends ParentPage {

    @FindBy(xpath = "//span[contains(text(), 'Administrator')]")
    private WebElement administratorHeader;

    @FindBy(xpath = "//a[@ui-id='Users']")
    private WebElement usersManagement;

    @FindBy(xpath = "//a[@ui-id='Krm']")
    private WebElement krmManagement;

    @FindBy(xpath = "//a[@ui-id='Tags']")
    private WebElement tagManagement;

    @FindBy(xpath = "//a[@ui-id='Tags']")
    private WebElement auditManagement;

    @FindBy(xpath = "//a[@ui-id='Help']")
    private WebElement helpCentre;


    public AdministratorPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(administratorHeader));
    }

    public UsersManagementPage goToUsersManagement() {

        clickOnElement(usersManagement);
        return new UsersManagementPage();
    }

    public KrmManagementPage goToKrmManagement() {

        clickOnElement(krmManagement);
        return new KrmManagementPage();
    }

    public TagManagementPage goToTagManagementPage() {

        clickOnElement(tagManagement);
        return new TagManagementPage();
    }

    public AuditPage goToAuditPage() {

        clickOnElement(auditManagement);
        return new AuditPage();
    }
}
