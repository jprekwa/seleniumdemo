package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']//p[text()='Hello ']")
    private WebElement helloMessage;

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getHelloMessage() {
        return helloMessage;
    }

    public ProductListPage openShopPage() {
        shopLink.click();
        return new ProductListPage(driver);
    }
}