package pageobjects.project.tables;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyRecentKnowledgeAssets extends ParentPage {

    @FindBy(xpath = "//table[@ng-table='recentKAsTableParams']//input[@ng-model='name']")
    private WebElement searchByName;

    public MyRecentKnowledgeAssets() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(searchByName));
    }
}
