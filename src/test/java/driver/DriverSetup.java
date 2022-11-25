package driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

public class DriverSetup {

    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = DriverFactory.getDriver(DriverSelector.CHROME);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
