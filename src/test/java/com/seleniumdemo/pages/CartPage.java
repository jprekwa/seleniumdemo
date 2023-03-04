package com.seleniumdemo.pages;

import com.seleniumdemo.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement proceedToCheckoutButton;

    @FindBy(className = "cart-empty")
    private WebElement emptyCarParagraph;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrdersPage openOrdersPage() {
        SeleniumHelper.waitForClickable(proceedToCheckoutButton, driver);
        proceedToCheckoutButton.click();
        return new OrdersPage(driver);
    }

    public String getEmptyCartMessage() {
        return emptyCarParagraph.getText();
    }
}
