import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class DemoTest {

    private MenuPage menuPage;
    private ContactFormPage contactFormPage;

    @BeforeEach
    void setUp() {

        menuPage = new MainPage().goToMenu();
        menuPage.logIn("Roman", "Jdi1234");
        assertEquals("ROMAN IOVLEV", menuPage.getLoggedUser());
        contactFormPage = menuPage.goToContactForm();
    }

    @Test()
    void allFieldsTest() {

        contactFormPage.fillContactForm("name", "lastName", "position", "uncheck",
                "0987654321", "1234567890", "Female", "Other", "Sun, Weather", "description", "check");
    }

    @Test
    void textFieldsTest() {

        contactFormPage.fillContactForm("name", "lastName", "position", "check",
                "1234567890", "0987654321", "Male", "Induism", "Rain, Snow", "description", "uncheck");
    }

    @AfterEach
    void tearDown() {

        menuPage.logOut();
        contactFormPage = null;
        menuPage = null;
    }
}