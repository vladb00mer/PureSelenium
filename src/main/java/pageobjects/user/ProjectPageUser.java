package pageobjects.user;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectPageUser extends ParentPage {

    @FindBy(xpath = "//label[@for='mine-no']")
    private WebElement mineNoFlag;


    ProjectPageUser() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(mineNoFlag));
    }

    public boolean checkFlagPresence() {

        return mineNoFlag.isDisplayed();
    }
}
