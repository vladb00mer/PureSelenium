package pageobjects.administrative;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KrmManagementPage extends ParentPage {

    @FindBy(xpath = "//span[contains(text(), 'KRM')]")
    private WebElement leftMenuDashboard;

    @FindBy(xpath = "//button[contains(text(), 'Edit KRM')]")
    private WebElement editKRM;

    @FindBy(xpath = "//button[contains(text(), 'Complete Editing')]")
    private WebElement completeEditing;


    KrmManagementPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(leftMenuDashboard));
    }

    public KrmManagementPage goToEditMode() {

        if (editKRM.isDisplayed())
            clickOnElement(editKRM);

        return new KrmManagementPage();
    }

    public KrmManagementPage completeEditing() {

        if (editKRM.isDisplayed())
            clickOnElement(editKRM);

        return new KrmManagementPage();
    }
}
