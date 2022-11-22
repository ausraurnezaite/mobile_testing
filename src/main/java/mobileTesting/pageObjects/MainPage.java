package mobileTesting.pageObjects;

import ch.qos.logback.classic.Logger;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MainPage extends BasePage {

    private static final Logger log = (Logger) LoggerFactory.getLogger(MainPage.class);

    @AndroidFindBy(id = "com.google.android.apps.translate:id/language_button_a")
    private AndroidElement inputLanguage;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/language_button_b")
    private AndroidElement outputLanguage;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/enter_text_label")
    private List<AndroidElement> enterTextLabel;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/original_text")
    private List<AndroidElement> originalText;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/text_input_field")
    private AndroidElement textInputField;

//    @AndroidFindBy(id = "com.google.android.apps.translate:id/text_output_field")
    @AndroidFindBy(id = "com.google.android.apps.translate:id/translated_text")
    private AndroidElement textOutputField;


    public MainPage() {
        super();
    }

    public LanguageSelectionPage goToSelectInputLanguagePage() {
        inputLanguage.click();
        log.info("Going to input language selection page");
        return new LanguageSelectionPage();
    }

    public LanguageSelectionPage goToSelectOutputLanguagePage() {
        outputLanguage.click();
        log.info("Going to output language selection page");
        return new LanguageSelectionPage();
    }

    public void translate(String string) {
        if (enterTextLabel.size() > 0) {
            enterTextLabel.get(0).click();
        } else if (originalText.size() > 0) {
            originalText.get(0).click();
            originalText.get(0).click();
            textInputField.clear();
        }
        textInputField.sendKeys(string);
        log.info(String.format("'%s' entered", string));
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "go"));
    }

    public String getTranslation() {
        log.info(String.format("Getting the translation: '%s'", textOutputField.getText()));
        return textOutputField.getText();
    }
}