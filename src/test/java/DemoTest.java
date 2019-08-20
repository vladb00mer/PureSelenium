import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjects.MainPage;
import pageobjects.MainMenuPage;


class DemoTest {

    private MainPage mainPage;
    private MainMenuPage mainMenuPage;

    @BeforeEach
    void setUp() {

        mainPage = new MainPage("Administrator");
    }

    @Test
    void allFieldsTest() {

    }

    @Test
    void textFieldsTest() {

    }

    @AfterEach
    void tearDown() {

        mainPage = null;
    }
}