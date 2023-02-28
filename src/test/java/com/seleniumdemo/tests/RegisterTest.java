package com.seleniumdemo.tests;

import com.seleniumdemo.models.User;
import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    User user = new User();

    @Test(priority = 0)
    public void registerUserWithUniqueEmail() {
        String username = user.getEmail().substring(0, user.getEmail().indexOf("@"));

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .registerUserWithUniqueEmail(user.getEmail(), user.getPassword())
                .getHelloMessage();

        Assert.assertEquals(entryTitle.getText(), "Hello " + username + " (not " + username + "? Log out)");
    }

    @Test(priority = 1)
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserWithSameEmail(user.getEmail(), user.getPassword())
                .getErrorMessage();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address."));
    }
}