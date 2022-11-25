package methods;

import driver.DriverSetup;
import model.SelectorInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.Keys;
import selector.Selector;
import selector.SelectorFactory;
import javax.annotation.Nullable;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    protected Selector selector = SelectorFactory.createElementHelper();

    public Methods() {
        driver = DriverSetup.driver;
        wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    public void getDriver(String link) {
        driver.get(link);
    }

    public void waitBySecond(long second) {
        try {
            Thread.sleep(second * 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement findElement(By by) {
        return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return wait.until(new ExpectedCondition<List<WebElement>>() {
            @Nullable
            @Override
            public List<WebElement> apply(@Nullable WebDriver driver) {
                List<WebElement> elements = driver.findElements(by);
                return elements.size() > 0 ? elements : null;
            }
        });
    }

    public WebElement findElementBykey(String key) {
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        return selectorInfo.getIndex() > 0 ? findElements(selectorInfo.getBy())
                .get(selectorInfo.getIndex()) : findElement(selectorInfo.getBy());
    }

    public void click(String key) {
        findElementBykey(key).click();
    }

    public void sendKey(String element, String text) {
        findElementBykey(element).sendKeys(text);
    }

    public String getText(String element) {
        return findElementBykey(element).getText();
    }

    public void scrollScreen(String element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElementBykey(element))
                .build()
                .perform();
    }

    public int randomNumber(int number) {
        Random random = new Random();
        return random.nextInt(number - 3) + 3;
    }

    public WebElement randomElement(String element) {
        List<WebElement> elementList = (List<WebElement>) findElementBykey(element);
        return elementList.get(randomNumber(elementList.size()));
    }

    public void hoverCursor(String element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElementBykey(element)).perform();
    }

    public void keyEnter(String element) {
        findElementBykey(element).sendKeys(Keys.ENTER);
    }

}
