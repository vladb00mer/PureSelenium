package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Init {

    private static WebDriver driver;
    private static final int TIMEOUT = 10;

    public static WebDriver getWebDriver() {


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

    public static int getTimeOut() {

        return TIMEOUT;
    }

    public static String getCurrentDateTime() {

        return new SimpleDateFormat("ddMMyy-HHmm").format(Calendar.getInstance().getTime());
    }

    public static void closeDriver() {

        if(null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
