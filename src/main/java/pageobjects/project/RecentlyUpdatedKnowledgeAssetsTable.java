package pageobjects.project;

import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class RecentlyUpdatedKnowledgeAssetsTable extends ParentPage {

    @FindBy(xpath = "//div[@ng-if='(selectedTab === Entities.KA || selectedTab === Entities.Workspaces)']")
    private WebElement addFileOrLinkButton;


}
