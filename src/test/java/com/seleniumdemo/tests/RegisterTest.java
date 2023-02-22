package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    int random = (int) (Math.random() * 1000);
    private String email = "test" + random + "@test.com";
    private String password = "topSecret" + email;

    @Test
    public void registerUser() {

        String username = email.substring(0, email.indexOf("@"));

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .registerUser(email, password)
                .getHelloMessage();

        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertEquals(entryTitle.getText(), "Hello " + username + " (not " + username + "? Log out)");
    }
}