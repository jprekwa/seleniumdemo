package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {


    @Test
    public void logInTest() {
        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData("test952@test.com", "test@test.com")
                .getHelloMessage();

        Assert.assertTrue(entryTitle.getText().contains("Hello test24"));
    }

    @Test
    public void logInWithInvalidPassword() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData("test952@test.com", "NotVerySecret")
                .getErrorMessage();

        Assert.assertTrue(error.getText().contains("Incorrect username or password"), "Expected error text doesn't match");
    }
}