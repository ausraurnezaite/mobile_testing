package mobileTesting.pageObjects;

import ch.qos.logback.classic.Logger;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mobileTesting.util.Language;
import org.slf4j.LoggerFactory;

public class LanguageSelectionPage extends BasePage {

    private static final Logger log = (Logger) LoggerFactory.getLogger(LanguageSelectionPage.class);

    @AndroidFindBy(id = "android:id/list")
    private AndroidElement languageList;

    private final String languageElement = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"%s\"))";

    public LanguageSelectionPage() {
        super();
    }

    public MainPage selectLanguage(Language language) {
        languageList.findElementByAndroidUIAutomator(String.format(languageElement, language.value)).click();
        log.info(String.format("Selected language: '%s'", language.value));
        return new MainPage();
    }
}