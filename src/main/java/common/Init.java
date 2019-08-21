package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Init {

    private static WebDriver driver;
    private static final int TIMEOUT = 5;

    public static WebDriver getWebDriver() {


        //MacOS driver
        System.setProperty("webdriver.chrome.driver", "./WebDrivers/chromedriver");

        //Windows driver
        //System.setProperty("webdriver.chrome.driver", "./WebDrivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("disable-infobars");

        if(driver == null) {
            driver = new ChromeDriver(options);
        }

        return driver;
    }

    public static int getTimeOut() {

        return TIMEOUT;
    }

    public static void closeDriver() {

        if(null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
