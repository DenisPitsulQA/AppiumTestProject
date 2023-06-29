package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver driver;

    private By emailInput = By.xpath("//android.view.View[@content-desc='Sign in']/android.widget.EditText[1]");
    private By passwordInput = By.xpath("//android.view.View[@content-desc='Sign in']/android.widget.EditText[2]");
    private By signInBtn = By.xpath("//android.widget.Button[@content-desc='Sign in']");
    private By accountDoesNotExistMessage = By.xpath("//android.view.View[@content-desc=\"Sign in\n" +
            "Account doesn't exist\"]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeEmail(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void typePassword(String password) {
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignIn() {
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
}
