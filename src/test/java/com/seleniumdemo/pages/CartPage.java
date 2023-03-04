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

    @FindBy(xpath = "//td[@class='product-name']/a")
    private WebElement productName;

    @FindBy(xpath = "//td[@class='product-price']/span")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='quantity']/input")
    private WebElement productQuantity;

    @FindBy(xpath = "//td[@class='product-subtotal']/span")
    private WebElement productTotal;

    @FindBy(xpath = "//td[@class='product-remove']/a")
    private WebElement removeLink;

    @FindBy(className = "woocommerce-message")
    private WebElement removedMessage;

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

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getProductQuantity() {
        return productQuantity.getAttribute("value");
    }

    public String getProductTotal() {
        return productTotal.getText();
    }

    public CartPage removeProductFromCart() {
        removeLink.click();
        return this;
    }

    public String getRemovedMessage() {
        return removedMessage.getText();
    }
}
