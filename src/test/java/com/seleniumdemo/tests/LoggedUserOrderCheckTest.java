package com.seleniumdemo.tests;

import com.seleniumdemo.models.User;
import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.MyAccountPage;
import com.seleniumdemo.pages.OrderDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoggedUserOrderCheckTest extends BaseTest {

    User user = new User();
    String productName = "Java Selenium WebDriver";

    @Test
    public void loggedUserMakeOrder() {

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData(user.getEmail(), user.getPassword())
                .openShopPage()
                .openProduct(productName)
                .addProductToCart()
                .viewCart()
                .openOrdersPage()
                .checkoutLoggedUser();


        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertTrue(orderDetailsPage.getProductName().getText().equals(productName + " × 1"));
    }

    @Test
    public void loggedUserOrderInfoCheck() {

        MyAccountPage myAccountPage = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData(user.getEmail(), user.getPassword())
                .goToOrderDetails();

        Assert.assertTrue(myAccountPage.getProductName().isDisplayed());
        Assert.assertEquals(myAccountPage.getProductName().getText(), productName + " × 1");
    }
}
