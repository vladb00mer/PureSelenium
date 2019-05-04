import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends ParentPage {

    @FindBy(xpath = "//div[@class='profile-photo']/img[@id='user-icon']")
    private WebElement userIcon;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPassword;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement enterButton;

    @FindBy(xpath = "//div[@class='profile-photo']/span[@id='user-name']")
    private WebElement userLoggedIn;

    @FindBy(xpath = "//span[contains(text(),'Logout')]")
    private WebElement userLogOut;

    @FindBy(xpath = "//a[contains(text(),'Contact form')]")
    private WebElement contactForm;


    public MenuPage() {

        PageFactory.initElements(Init.getDriver(), this);
        new WebDriverWait(Init.getDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(userIcon));
    }

    public void logIn(String name, String password) {

        clickOnElement(userIcon);
        setValue(userName, name);
        setValue(userPassword, password);
        clickOnElement(enterButton);
    }

    public void logOut() {

        clickOnElement(userLoggedIn);
        clickOnElement(userLogOut);
        Init.closeDriver();
    }

    public String getLoggedUser() {

        return getValue(userLoggedIn);
    }

    public ContactFormPage goToContactForm() {

        clickOnElement(contactForm);
        return new ContactFormPage();
    }
}
