package driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverSetup {

    public static WebDriver driver;
    Logger logger = LogManager.getLogger(DriverSetup.class);
    @BeforeSuite
    public void setUp() {
        // Kullanilacak browser burada secilmelidir
        driver = DriverFactory.getDriver(DriverSelector.CHROME);
        logger.info( "Driver calistirildi");
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void tearDown() {
        logger.info("Driver kapatiliyor");
        driver.quit();

    }
}
