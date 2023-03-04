package com.seleniumdemo.tests;

import com.seleniumdemo.models.User;
import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    User user = new User();

    @Test
    public void logInTest() {
        String username = user.getEmail().substring(0, user.getEmail().indexOf("@"));

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData(user.getEmail(), user.getPassword())
                .getHelloMessage();

        Assert.assertTrue(entryTitle.getText().contains("Hello " + username));
    }

    @Test
    @Ignore
    public void logInWithInvalidDataTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData(user.getEmail(), user.getPassword() + "?")
                .getErrorMessage();

        Assert.assertTrue(error.getText().contains("Incorrect username or password"), "Expected error text doesn't match");
    }
}