package org.example;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class SignInPage {

    private AndroidDriver driver;

    private By emailInput = By.xpath("//android.view.View[@content-desc='Sign in']/android.widget.EditText[1]");
    private By passwordInput = By.xpath("//android.view.View[@content-desc='Sign in']/android.widget.EditText[2]");
    private By signInBtn = By.xpath("//android.widget.Button[@content-desc='Sign in']");
    private By accountDoesNotExistMessage = By.xpath("//android.view.View[@content-desc=\"Sign in\n" +
            "Account doesn't exist\"]");

    public SignInPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void typeEmail(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
        driver.hideKeyboard();
    }

    public void typePassword(String password) {
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(password);
        driver.hideKeyboard();
    }

    public void clickSignIn() {
        scrollDown();
        driver.findElement(signInBtn).click();
    }

    public void signIn(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickSignIn();
    }

    public boolean isAccountDoesNotExistMessageVisible() {
        return driver.findElements(accountDoesNotExistMessage).size() > 0;
    }

    public void scrollDown() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        int startYCoordinate = (int) (height * 0.8);
        int endYCoordinate = (int) (height * 0.2);
        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction()
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }
}
