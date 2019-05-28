import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Init {

    private static WebDriver driver;
    private static final int TIMEOUT = 5;

    static WebDriver getDriver() {


        //MacOS driver
        System.setProperty("webdriver.chrome.driver", "./WebDrivers/chromedriver");

        //Windows driver
        //System.setProperty("webdriver.chrome.driver", "./WebDrivers/chromedriver.exe");


        if(driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        return driver;
    }

    static int getTimeOut() {

        return TIMEOUT;
    }

    static void closeDriver() {

        if(null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
