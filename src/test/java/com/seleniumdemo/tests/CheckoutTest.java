package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.OrderDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        Customer customer = new Customer();

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
}