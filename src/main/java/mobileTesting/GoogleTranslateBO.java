package mobileTesting;

import mobileTesting.pageObjects.MainPage;
import mobileTesting.util.Language;

public class GoogleTranslateBO {

    public GoogleTranslateBO selectLanguages(Language from, Language to) {
        new MainPage()
                .goToSelectInputLanguagePage().selectLanguage(from)
                .goToSelectOutputLanguagePage().selectLanguage(to);
        return this;
    }

    public GoogleTranslateBO translate(String string) {
        new MainPage().translate(string);
        return this;
    }
}