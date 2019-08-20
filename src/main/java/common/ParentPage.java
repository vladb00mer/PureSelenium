package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ParentPage {

    protected void clickOnElement(WebElement element) {

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    protected void setValue(WebElement element, String value) {

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        element.click();
        element.clear();
        element.sendKeys(value);
    }

    protected String getValue(WebElement element) {

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        return element.getAttribute("value");
    }
}