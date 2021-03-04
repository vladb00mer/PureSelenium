package pageobjects;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends ParentPage {

    @FindBy(xpath = "//span[contains(text(), 'My Projects ')]")
    private WebElement searchArea;

    @FindBy(xpath = "//a[@title='View All Project']")
    private WebElement searchButton;

    public HomePage() {

        Init.getWebDriver().navigate().to("yandex.ru");
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(searchArea));
    }

    public HomePage search(String name) {

        setTextValue(searchArea, name);
        return this;
    }
}
