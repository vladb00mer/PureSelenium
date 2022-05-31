package common;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Init {

    private static WebDriver driver;
    private static final int TIMEOUT = 10;
    private static String baseUrlAlpha = "https://sudift.delta.sbrf.ru/meta/gac/";
    private static String baseUrlSigma = "http://nginx-gac.ci00706314-edevgen-gaac.apps.dev-gen.sigma.sbrf.ru/";
    private static DesiredCapabilities capabilities;
    private static ChromeOptions chromeOptions;

    public static WebDriver getWebDriver() {

        System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver.exe");

        capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.ANY);

        chromeOptions = new ChromeOptions();
        chromeOptions.merge(capabilities);

        if(driver == null) {
            driver = new ChromeDriver();
            //driver = new RemoteWebDriver(getGridUrl(), chromeOptions);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static URL getGridUrl() {

        URL url = null;

        try {
            url = new URL("http://selenium-hub.ci00706314-edevgen-gaac.apps.dev-gen.sigma.sbrf.ru/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getBaseUrlSigma() {
        return baseUrlSigma;
    }

    public static String getBaseUrlAlpha() {
        return baseUrlAlpha;
    }

    public static int getTimeOut() {

        return TIMEOUT;
    }

    public String getCurrentDateAdTime(){

        return new SimpleDateFormat("ddMMyy-Hmm").format(Calendar.getInstance().getTime());
    }

    public static void closeDriver() {

        if(null != driver) {
            driver.quit();
            driver = null;
        }
    }
}

