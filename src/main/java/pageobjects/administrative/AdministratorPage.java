package pageobjects.administrative;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdministratorPage extends ParentPage {

    @FindBy(xpath = "//span[contains(text(), 'Administrator')]")
    private WebElement administratorHeader;

    @FindBy(xpath = "//a[@data-title='Krm']")
    private WebElement krmManagement;


    public AdministratorPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(administratorHeader));
    }

    public KrmManagementPage goToKrmManagement() {

        clickOnElement(krmManagement);
        return new KrmManagementPage();
    }

}
