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

    @Test
    void allFieldsTest() {

        contactFormPage.fillContactForm("name", "lastName", "position", "uncheck", "0987654321",
                "1234567890", "Female", "Other", "Weather, Sun", "description", "check");

        assertAll("validation",
                    () -> assertEquals("name", contactFormPage.getName()),
                    () -> assertEquals("lastName", contactFormPage.getLastName()),
                    () -> assertEquals("position", contactFormPage.getPosition()),
                    () -> assertEquals("Unchecked", contactFormPage.getPassport()),
                    () -> assertEquals("0987654321", contactFormPage.getNumber()),
                    () -> assertEquals("1234567890", contactFormPage.getSeria()),
                    () -> assertEquals("Female", contactFormPage.getGender()),
                    () -> assertEquals("Other", contactFormPage.getReligion()),
                    () -> assertEquals("Sun, Weather", contactFormPage.getWeather()),
                    () -> assertEquals("description", contactFormPage.getDescription()),
                    () -> assertEquals("Unchecked", contactFormPage.getAcceptConditions())
                );

        contactFormPage.submitForm();
    }

    @Test
    void textFieldsTest() {

        contactFormPage.fillContactForm("name", "lastName", "position", "check", "1234567890",
                "0987654321", "Male", "Induism", "Snow, Rain", "description", "uncheck");

        assertAll("validation",
                    () -> assertEquals("name", contactFormPage.getName()),
                    () -> assertEquals("lastName", contactFormPage.getLastName()),
                    () -> assertEquals("position", contactFormPage.getPosition()),
                    () -> assertEquals("Checked", contactFormPage.getPassport()),
                    () -> assertEquals("1234567890", contactFormPage.getNumber()),
                    () -> assertEquals("0987654321", contactFormPage.getSeria()),
                    () -> assertEquals("Male", contactFormPage.getGender()),
                    () -> assertEquals("Induism", contactFormPage.getReligion()),
                    () -> assertEquals("Rain, Snow", contactFormPage.getWeather()),
                    () -> assertEquals("description", contactFormPage.getDescription()),
                    () -> assertEquals("Unchecked", contactFormPage.getAcceptConditions())
                );

        contactFormPage.submitForm();
    }

    @AfterEach
    void tearDown() {

        menuPage.logOut();
        contactFormPage = null;
        menuPage = null;
    }
}