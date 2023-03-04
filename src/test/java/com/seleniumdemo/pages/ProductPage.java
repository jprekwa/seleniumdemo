package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']/a[text()='View cart']")
    private WebElement viewCartButton;

    @FindBy(id = "quantity_640345874b6ad")
    private WebElement quantityInput;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage addProductToCart() {
        addToCartButton.click();
        return this;
    }

    public CartPage viewCart() {
        viewCartButton.click();
        return new CartPage(driver);
    }

    public ProductPage setQuantity(int quantity) {
        String qty = String.valueOf(quantity);
        quantityInput.clear();
        quantityInput.sendKeys(qty);
        return this;
    }
}