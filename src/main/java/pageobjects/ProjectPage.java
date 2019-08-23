package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectPage extends ParentPage {

    @FindBy(xpath = "//span[@ng-bind='::project.Name']")
    private WebElement projectName;

    @FindBy(xpath = "//label[@for='mine-no']")
    private WebElement mineNoFlag;

    @FindBy(xpath = "//input[@id='chemistry_btn']/..")
    private WebElement chemistry;

    @FindBy(xpath = "//input[@id='formulation_btn']/..")
    private WebElement formulation;

    @FindBy(xpath = "//input[@id='analytical_btn']/..")
    private WebElement analytical;

    @FindBy(xpath = "//input[@id='biologics_btn']/..")
    private WebElement biologics;

    @FindBy(xpath = "//input[@id='all_btn']/..")
    private WebElement all;

    @FindBy(xpath = "//switch-leads/span")
    private WebElement showList;


    ProjectPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(mineNoFlag));
    }

    public String getName() {

        return getTextValue(projectName);
    }
}
