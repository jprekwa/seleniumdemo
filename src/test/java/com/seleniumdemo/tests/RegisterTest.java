package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    int random = (int) (Math.random() * 1000);
    private String email = "test" + random + "@test.com";
    private String password = "test@test.com";

    @Test(priority = 0)
    public void registerUserWithUniqueEmail() {
        String username = email.substring(0, email.indexOf("@"));

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .registerUserWithUniqueEmail(email, password)
                .getHelloMessage();

        Assert.assertEquals(entryTitle.getText(), "Hello " + username + " (not " + username + "? Log out)");
    }

    @Test(priority = 1)
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserWithSameEmail(email, password)
                .getErrorMessage();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address."));
    }
}