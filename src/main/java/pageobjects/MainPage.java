package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends ParentPage {

    @FindBy(xpath = "//a[contains(text(),'JDI Github')]")
    private WebElement jdiGitHubLink;

    public MainPage() {

        Init.getDriver().navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        PageFactory.initElements(Init.getDriver(), this);
        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(jdiGitHubLink));
    }

    public MenuPage goToMenu() {

        return new MenuPage();
    }
}
