package selector;

public class SelectorFactory {

    public static Selector createElementHelper() {
        Selector elementHelper = null;
        elementHelper = new WebSelector();

        return elementHelper;

    }
}
