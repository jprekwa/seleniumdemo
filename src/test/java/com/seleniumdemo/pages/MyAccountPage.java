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

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement errorMessage;

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()='Orders']")
    private WebElement ordersSection;

    @FindBy(xpath = "//a[text()='View']")
    private WebElement ordersSectionViewButton;

    @FindBy(xpath = "//td[contains(@class, 'product-name')]")
    private WebElement ordersSectionProductName;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserWithUniqueEmail(String email, String password) {
        registerUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserWithSameEmail(String email, String password) {
        registerUser(email, password);
        return new MyAccountPage(driver);
    }

    private void registerUser(String email, String password) {
        regEmailAddress.sendKeys(email);
        regPassword.sendKeys(password);
        regButton.click();
    }

    public LoggedUserPage logInValidData(String username, String password) {
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInInvalidData(String username, String password) {
        logIn(username, password);
        return this;
    }

    private void logIn(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public MyAccountPage goToOrderDetails() {
        ordersSection.click();
        ordersSectionViewButton.click();
        return this;
    }

    public WebElement getProductName() {
        return ordersSectionProductName;
    }

}