import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjects.user.HomePageUser;
import pageobjects.user.MainMenuPageUser;


class DemoTest {

    private HomePageUser homePageUser;
    private MainMenuPageUser mainMenuPageUser;

    @BeforeEach
    void setUp() {

        homePageUser = new HomePageUser("Administrator");
    }

    @Test
    void allFieldsTest() {

    }

    @Test
    void textFieldsTest() {

    }

    @AfterEach
    void tearDown() {

        homePageUser = null;
    }
}