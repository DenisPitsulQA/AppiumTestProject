package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        openAppOnRemoteDevice();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    public void openAppOnLocalDevice() {
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

    public void openAppOnRemoteDevice() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=GoNo.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:platformVersion", "12");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-denys.pitsul.qa-94d0a");
        sauceOptions.setCapability("accessKey", "14194a4f-c9ea-4143-b8b7-a9d7a00013e8");
        sauceOptions.setCapability("build", "appium-build-CJZGF");
        sauceOptions.setCapability("name", "Sign In");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
