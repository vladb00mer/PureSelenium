import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class ParentPage {

    void clickOnElement(WebElement element) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.elementToBeClickable(element));

        element.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }

    void setValue(WebElement element, String value) {

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

    String getValue(WebElement element) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        element.click();
        return element.getText();
    }

    void setCheckBox(WebElement element, String value) {

        if ((value.equalsIgnoreCase("check")) && (!element.isSelected()))
            element.click();
        else if ((value.equalsIgnoreCase("uncheck")) && (element.isSelected()))
            element.click();
    }

    void setSelectValue(WebElement element, String value) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        element.click();

        WebElement nested = Init.getDriver().findElement(By.xpath("//select[@id='gender']/option[contains(text(),"+value+")]"));

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(nested));

        nested.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }

    void setDropDownWithCheckBoxesValues(WebElement element, String values) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));
        element.click();

        List<WebElement> allCheckBoxes = Init.getDriver().findElements(By.xpath("//a[@class='checkbox']/label"));

        if(values.contains("Sun")) allCheckBoxes.get(1).click();
        else if (values.contains("Rain")) allCheckBoxes.get(2).click();
        else if (values.contains("Weather")) allCheckBoxes.get(3).click();
        else if (values.contains("Snow")) allCheckBoxes.get(4).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }

    void setRadioButtons(String values) {

        List<WebElement> allWalues = Init.getDriver().findElements(By.xpath("//div[@class='info-panel-section']/section[@class='horizontal-group']/p[@class='radio']/label"));
        char[] valuesArr = values.toCharArray();

        for (char c : valuesArr) {

            int index = Character.getNumericValue(c);

            allWalues.get(index - 1).click();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }
}