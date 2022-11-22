package mobileTesting.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileTesting.util.driverManager.DriverManager;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {

    protected AndroidDriver<AndroidElement> driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}