package mobileTesting;

import mobileTesting.pageObjects.MainPage;
import org.testng.Assert;

public class GoogleTranslateVerifier {
    public void translation(String expectedTranslation) {
        Assert.assertTrue(new MainPage().getTranslation().equalsIgnoreCase(expectedTranslation));
    }
}
