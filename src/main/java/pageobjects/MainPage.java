package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends ParentPage {

    @FindBy(xpath = "//a[@aria-label='Knection']")
    private WebElement knectionLink;

    @FindBy(xpath = "//a[@title='View All Project']")
    private WebElement viewAllProjects;


    public MainPage(String user) {

        Init.getWebDriver().navigate().to("http://ecsc00a0154c.epam.com:82/Home?ssoUserId="+user);
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(knectionLink));
    }

    public TopMenuPage goToTopMenu() {

        return new TopMenuPage();
    }
}
