package selector;

import model.ElementInfo;
import org.openqa.selenium.By;

public class WebSelector implements Selector {

    @Override
    public By getElementInfoToBy(ElementInfo elementInfo) {
        By by = null;
        switch (elementInfo.getKeyType()) {
            case "css":
                by = By.cssSelector(elementInfo.getKeyValue());
                break;
            case "id":
                by = By.id(elementInfo.getKeyValue());
                break;
            case "xpath":
                by = By.xpath(elementInfo.getKeyValue());
                break;
            case "class":
                by = By.className(elementInfo.getKeyValue());
                break;
            case "text":
                by = By.linkText(elementInfo.getKeyValue());
                break;
        }
        return by;
    }

    @Override
    public int getElementInfoToIndex(ElementInfo elementInfo) {
        return elementInfo.getKeyIndex();
    }
}
