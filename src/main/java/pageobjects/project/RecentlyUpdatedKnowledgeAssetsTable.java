package pageobjects.project;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class RecentlyUpdatedKnowledgeAssetsTable extends ParentPage {

    @FindBy(xpath = "//div[@ng-if='(selectedTab === Entities.KA || selectedTab === Entities.Workspaces)']")
    private WebElement addFileOrLinkButton;


    RecentlyUpdatedKnowledgeAssetsTable() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(addFileOrLinkButton));
    }
}
