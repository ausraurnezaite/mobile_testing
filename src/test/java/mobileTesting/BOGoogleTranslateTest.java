package mobileTesting;

import mobileTesting.util.Language;
import mobileTesting.util.driverManager.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BOGoogleTranslateTest {
    private GoogleTranslateBO googleTranslateBO = new GoogleTranslateBO();
    private GoogleTranslateVerifier verify = new GoogleTranslateVerifier();
    private Language from = Language.LITHUANIAN;
    private Language to = Language.ENGLISH;
    private String translatable = "labas";
    private String expectedTranslation = "hello";

    @Test
    public void test() {
        googleTranslateBO.selectLanguages(from, to);
        googleTranslateBO.translate(translatable);
        verify.translation(expectedTranslation);
    }

    @AfterMethod
    public void cleanUp() {
        DriverManager.tearDown();
    }
}