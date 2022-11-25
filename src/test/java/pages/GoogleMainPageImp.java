package pages;

import com.thoughtworks.gauge.Step;
import methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoogleMainPageImp {

    Methods methods;

    Logger logger = LogManager.getLogger(GoogleMainPageImp.class);

    public GoogleMainPageImp() {
        methods = new Methods();
    }

    @Step("Go to google page")
    public void startDriver() {
        methods.getDriver("https://www.google.com.tr/?hl=tr/");
        logger.info(methods.getCurrentURL() + " url e gidildi");
    }

    @Step("Search <key>")
    public void search(String key) {
        methods.sendKey("inputSearch", "gauge");
        logger.info(key + "yazildi");
        methods.keyEnter("inputSearch");
        logger.info("Enter basildi");
    }

    @Step("Next Step")
    public void nexStep(){

    }

}
