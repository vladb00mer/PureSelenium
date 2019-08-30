package pageobjects.project.tables;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyRecentWorkspaces extends ParentPage {

    @FindBy(xpath = "//table[@ng-table='recentWSTableParams']//input[@placeholder='Search by Name']")
    private WebElement searchByName;

    public MyRecentWorkspaces() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(searchByName));
    }
}
