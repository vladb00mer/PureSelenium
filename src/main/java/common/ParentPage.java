package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ParentPage {

    protected void clickOnElement(WebElement element) {

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    protected void setTextValue(WebElement element, String value) {

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        element.click();
        element.clear();
        element.sendKeys(value);
    }

    protected String getTextValue(WebElement element) {

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        return element.getAttribute("value");
    }
}