package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;
    @FindBy(id = "reg_email")
    private WebElement regEmailAddress;

    @FindBy(id = "reg_password")
    private WebElement regPassword;

    @FindBy(name = "register")
    private WebElement regButton;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUser(String email, String password) {
        regEmailAddress.sendKeys(email);
        regPassword.sendKeys(password);
        regButton.click();
        return new LoggedUserPage(driver);
    }
}
