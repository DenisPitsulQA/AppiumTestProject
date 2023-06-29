package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        openApp();
    }

    public void openApp() {
        String dir = System.getProperty("user.dir");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:deviceName", "Redmi 9");
        cap.setCapability("udid", "36c2d4050404");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:platformVersion", "10");
        cap.setCapability("appium:automationName", "UiAutomator2");
//        cap.setCapability("appPackage", "com.miui.calculator");
//        cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
        cap.setCapability("autoGrantPermission", true);
        cap.setCapability("appium:app", dir + "\\src\\test\\resources\\apks\\GoNo.apk");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AndroidDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
