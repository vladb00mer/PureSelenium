import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DemoTest {

    @Test
    void demoTest() {

        MenuPage menuPage = new MainPage().goToMenu();
        menuPage.logIn("Roman", "Jdi1234");
        assertEquals("ROMAN IOVLEV", menuPage.getLoggedUser());

        ContactFormPage contactFormPage = menuPage.goToContactForm();
        contactFormPage.fillContactForm();



        menuPage.logOut();
    }
}