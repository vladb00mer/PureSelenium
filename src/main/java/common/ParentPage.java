package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ParentPage {

    protected void clickOnElement(WebElement element) {

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.elementToBeClickable(element));

        element.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void setTextValue(WebElement element, String value) {

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        element.click();
        element.clear();
        element.sendKeys(value);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected String getTextValue(WebElement element) {

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        return element.getText();
    }
}