import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParentPage {

    public void clickOnElement(WebElement element) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.elementToBeClickable(element));

        element.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }

    public void setValue(WebElement element, String value) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        element.click();
        element.clear();
        element.sendKeys(value);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }

    public String getValue(WebElement element) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        element.click();
        return element.getText();
    }

    public void setSelectValue(WebElement element, String value) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        Select select = new Select(element);
        select.selectByValue(value);
        select.selectByVisibleText(value);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }

    public void setDropDownWithCheckBoxesValues(WebElement element, int... values) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));
        element.click();

        List<WebElement> allWalues = Init.getDriver().findElements(By.xpath("//a[@class='checkbox']/label"));

        for (int i =0; i < values.length; i++) {

            allWalues.get(values[i]).click();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }

    public void setRadioButtons(int... values) {

        List<WebElement> allWalues = Init.getDriver().findElements(By.xpath("//div[@class='info-panel-section']/section[@class='horizontal-group']/p[@class='radio']/label"));

        for (int i =0; i < values.length; i++) {

            allWalues.get(values[i]).click();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }
}
