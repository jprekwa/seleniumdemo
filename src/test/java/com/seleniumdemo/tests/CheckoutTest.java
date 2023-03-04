package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.CartPage;
import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.OrderDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    private Customer customer = new Customer();

    @Test
    public void checkoutTest() {
        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openOrdersPage()
                .fillOrderDetails(customer, "Some random comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertTrue(orderDetailsPage.getProductName().getText().equals("Java Selenium WebDriver × 1"));
    }

    @Test
    public void orderedProductDetailsTest() {
        int quantity = 600;
        int price = 1;
        String priceDisplayed = price + ",00 zł";
        String total = quantity * price + ",00 zł";


        CartPage cartPage = new HomePage(driver)
                .openShopPageWithShopButton()
                .openProduct("GIT basics")
                .setQuantity(quantity)
                .addProductToCart()
                .viewCart();

        Assert.assertEquals(cartPage.getProductName(), "GIT basics");
        Assert.assertEquals(cartPage.getProductPrice(), priceDisplayed);
        Assert.assertEquals(cartPage.getProductQuantity(), String.valueOf(quantity));
        Assert.assertEquals(cartPage.getProductTotal(), total);
    }
}