package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

    private SignInPage signInPage;

    @Test
    public void signInTest() {
        signInPage = new SignInPage(driver);
        signInPage.signIn("test@gmail.com", "test1234");

        Assert.assertTrue(signInPage.isAccountDoesNotExistMessageVisible(), "Account does not exist message is invisible");
    }
}
