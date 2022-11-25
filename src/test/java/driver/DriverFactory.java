package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver getDriver(DriverSelector driverSelector) {

        String browser = System.getenv("BROWSER");

        if (browser == null) {
            browser = String.valueOf(driverSelector);
        } else browser = browser;

        switch (browser) {
            case "IE":
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "CHROME":
            default:
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--disable-notification");
                    options.addArguments("--disable--popup-blocking");
                    options.addArguments("--start-maximized");
                }

                return new ChromeDriver(options);
        }
    }
}
