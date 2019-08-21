import common.Init;
import org.junit.jupiter.api.*;
import pageobjects.user.HomePageUser;
import pageobjects.user.ProjectPageUser;


class DemoTest {

    private HomePageUser homePageUser;
    private ProjectPageUser projectPageUser;

    @BeforeEach
    void setUp() {

        homePageUser = new HomePageUser("auto_bmsq-knct_qa1@epam.com");
    }

    @Test
    @Tag("priority1")
    void test() {
        projectPageUser = homePageUser.goToTopMenu().goToHomePage().filterByName("123581321").openFilteredProject();
        Assertions.assertTrue(projectPageUser.checkFlagPresence());
    }

    @AfterEach
    void tearDown() {

        Init.closeDriver();
        homePageUser = null;
    }
}