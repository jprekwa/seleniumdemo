package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.CartPage;
import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.OrderDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    private Customer customer = new Customer();
    private String productName = "Java Selenium WebDriver";

    @Test
    public void checkoutTest() {
        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct(productName)
                .addProductToCart()
                .viewCart()
                .openOrdersPage()
                .fillOrderDetails(customer, "Some random comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertTrue(orderDetailsPage.getProductName().getText().equals(productName + " × 1"));
    }

    @Test
    public void orderedProductDetailsTest() {
        int quantity = 600;
        int price = 1;
        String priceDisplayed = price + ",00 zł";
        String total = quantity * price + ",00 zł";


        CartPage cartPage = new HomePage(driver)
                .openShopPageWithShopButton()
                .openProduct(productName)
                .setQuantity(quantity)
                .addProductToCart()
                .viewCart();

        Assert.assertEquals(cartPage.getProductName(), productName);
        Assert.assertEquals(cartPage.getProductPrice(), priceDisplayed);
        Assert.assertEquals(cartPage.getProductQuantity(), String.valueOf(quantity));
        Assert.assertEquals(cartPage.getProductTotal(), total);
    }

    @Test
    public void deleteProductFromCartTest() {
        CartPage cartPage = new HomePage(driver)
                .openShopPage()
                .openProduct(productName)
                .addProductToCart()
                .viewCart()
                .removeProductFromCart();

        Assert.assertEquals(cartPage.getRemovedMessage(), "“" + productName + "” removed. Undo?");
        Assert.assertEquals(cartPage.getEmptyCartMessage(), "Your cart is currently empty.");
    }
}