import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactFormPage extends MenuPage {

    @FindBy(xpath = "//form[@id='contact-form']//input[@id='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='position']")
    private WebElement position;

    @FindBy(xpath = "//input[@id='passport']")
    private WebElement passport;

    @FindBy(xpath = "//input[@id='passport-number']")
    private WebElement passportNumber;

    @FindBy(xpath = "//input[@id='passport-seria']")
    private WebElement passportSeria;

    @FindBy(xpath = "//select[@id='gender']")
    private WebElement gender;

    @FindBy(xpath = "//input[@id='religion']")
    private WebElement religion;

    @FindBy(xpath = "//div[@id='weather']")
    private WebElement weather;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement description;

    @FindBy(xpath = "//label[contains(text(),'Accept conditions')]")
    private WebElement acceptConditions;

    @FindBy(xpath = "//div[@id='summary-block']")
    private WebElement summaryBlock;

    @FindBy(xpath = "//button[contains(text(),'Calculate')]")
    private WebElement calculate;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submit;


    public ContactFormPage() {

        PageFactory.initElements(Init.getDriver(), this);
        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(name));
    }

    public void fillContactForm() {

        setValue(name, "Username");
        setValue(lastName, "Lastname");
        setValue(position, "Position");
        clickOnElement(passport);
        setValue(passportNumber, "PassportNumber");
        setValue(passportSeria, "PassportSeria");

        /* !defected element!
        setSelectValue(gender, "Female");
        */

        setValue(religion, "Other");
        setDropDownWithCheckBoxesValues(weather, 0,2);

        setValue(description, "Description");
        clickOnElement(acceptConditions);

        setRadioButtons(3,6);
        clickOnElement(calculate);

        clickOnElement(submit);
    }
}
