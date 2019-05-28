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

        contactFormPage.fillContactForm("name", "lastName", "position", "1234567890",
                "0987654321", "Induism", "13", "description", "38");
    }

    @Test
    void textFieldsTest() {

        contactFormPage.fillContactForm("name", "lastName", "position", "1234567890",
                "0987654321", "", "", "description", "");
    }

    @AfterEach
    void tearDown() {

        menuPage.logOut();
        contactFormPage = null;
        menuPage = null;
    }
}