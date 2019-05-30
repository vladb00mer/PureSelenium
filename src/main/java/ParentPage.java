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

        return element.getAttribute("value");
    }

    void setCheckBox(WebElement element, String value) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        if ((value.equalsIgnoreCase("check")) && (!element.isSelected()))
            element.click();
        else if ((value.equalsIgnoreCase("uncheck")) && (element.isSelected()))
            element.click();
    }

    String getCheckBox(WebElement element) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));

        if(element.isSelected()) return "Checked";
        else return "Unchecked";
    }

    void setSelectValue(WebElement element, String value) {

        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(element));
        element.click();

        List<WebElement> allValues = Init.getDriver().findElements(By.xpath("//select[@id='gender']/option"));

        if(value.equalsIgnoreCase("male"))
            allValues.get(0).click();
        else if(value.equalsIgnoreCase("female"))
            allValues.get(1).click();

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

        if(values.contains("Sun"))
            allCheckBoxes.get(0).click();
        if (values.contains("Rain"))
            allCheckBoxes.get(1).click();
        if (values.contains("Weather"))
            allCheckBoxes.get(2).click();
        if (values.contains("Snow"))
            allCheckBoxes.get(3).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParentPage.class.getName()).log(Level.SEVERE, "WARNING!", ex);
        }
    }
}