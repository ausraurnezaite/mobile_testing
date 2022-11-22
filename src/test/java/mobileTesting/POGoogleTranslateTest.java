package mobileTesting;

import mobileTesting.pageObjects.MainPage;
import mobileTesting.util.Language;
import mobileTesting.util.driverManager.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class POGoogleTranslateTest {

    private Language from = Language.LITHUANIAN;
    private Language to = Language.ENGLISH;
    private String translatable = "labas";
    private String expectedTranslation = "hello";

    @Test
    public void test() {

        MainPage mainPage = new MainPage();
        mainPage.goToSelectInputLanguagePage().selectLanguage(from);
        mainPage.goToSelectOutputLanguagePage().selectLanguage(to);
        mainPage.translate(translatable);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.getTranslation().equalsIgnoreCase(expectedTranslation));

        translatable = "labas rytas";
        expectedTranslation = "good morning";
        mainPage.translate(translatable);
        softAssert.assertTrue(mainPage.getTranslation().equalsIgnoreCase(expectedTranslation));
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        DriverManager.tearDown();
    }
}