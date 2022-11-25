package pages;

import com.thoughtworks.gauge.Step;
import methods.Methods;

public class GoogleMainPageImp {

    Methods methods;

    public GoogleMainPageImp() {
        methods = new Methods();
    }

    @Step("Start driver")
    public void startDriver() {
        methods.getDriver("https://www.google.com.tr/?hl=tr/");
    }

    @Step("Search <key>")
    public void search(String key) {
        methods.sendKey("inputSearch", "gauge");
        methods.click("inputSearch");
        methods.keyEnter("inputSearch");
    }

}
