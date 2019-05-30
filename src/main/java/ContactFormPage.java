import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ContactFormPage extends MenuPage {

    @FindBy(xpath = "//form[@id='contact-form']//input[@id='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='position']")
    private WebElement positionInput;

    @FindBy(xpath = "//input[@id='passport']")
    private WebElement passportInput;

    @FindBy(xpath = "//input[@id='passport-number']")
    private WebElement passportNumberInput;

    @FindBy(xpath = "//input[@id='passport-seria']")
    private WebElement passportSeriaInput;

    @FindBy(xpath = "//select[@id='gender']")
    private WebElement genderInput;

    @FindBy(xpath = "//input[@id='religion']")
    private WebElement religionInput;

    @FindBy(xpath = "//div[@id='weather']")
    private WebElement weatherInput;

    @FindBy(xpath = "//div[@id='weather']//button[@data-toggle='dropdown']")
    private WebElement weatherOutput;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//label[contains(text(),'Accept conditions')]")
    private WebElement acceptConditionsInput;

    @FindBy(xpath = "//div[@id='summary-block']")
    private WebElement summaryBlockInput;

    @FindBy(xpath = "//button[contains(text(),'Calculate')]")
    private WebElement calculateButton;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitButton;


    ContactFormPage() {

        PageFactory.initElements(Init.getDriver(), this);
        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(nameInput));
    }

    void fillContactForm(String name, String lastName, String position, String passport, String passportNumber, String passportSeria,
                         String gender, String religion, String weather, String description, String acceptConditions) {

        setValue(nameInput, name);
        setValue(lastNameInput, lastName);
        setValue(positionInput, position);
        setCheckBox(passportInput, passport);
        setValue(passportNumberInput, passportNumber);
        setValue(passportSeriaInput, passportSeria);
        setSelectValue(genderInput, gender);
        setValue(religionInput, religion);
        setDropDownWithCheckBoxesValues(weatherInput, weather);
        setValue(descriptionInput, description);
        setCheckBox(acceptConditionsInput, acceptConditions);
    }

    void submitForm() {

        clickOnElement(submitButton);
    }

    String getName() {

        return getValue(nameInput);
    }

    String getLastName() {

        return getValue(lastNameInput);
    }

    String getPosition() {

        return getValue(positionInput);
    }

    String getPassport() {

        return getCheckBox(passportInput);
    }

    String getNumber() {

        return getValue(passportNumberInput);
    }

    String getSeria() {

        return getValue(passportSeriaInput);
    }

    String getGender() {

        return getValue(genderInput);
    }

    String getReligion() {

        return getValue(religionInput);
    }

    String getWeather() {

        return weatherOutput.getText();
    }

    String getDescription() {

        return getValue(descriptionInput);
    }

    String getAcceptConditions() {

        return getCheckBox(acceptConditionsInput);
    }
}
