package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyCartTest extends BaseTest {

    @Test
    public void emptyCartTest() {

        String emptyCartMessage = new HomePage(driver)
                .openCartPage()
                .getEmptyCartMessage();

        Assert.assertEquals(emptyCartMessage, "Your cart is currently empty.");
    }

}
