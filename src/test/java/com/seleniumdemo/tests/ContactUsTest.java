package com.seleniumdemo.tests;

import com.seleniumdemo.models.Customer;
import com.seleniumdemo.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseTest {

    Customer customer = new Customer();

    @Test
    public void contactUsTest() {
        String name = customer.getFirstName() + " " + customer.getLastName();
        String email = customer.getEmail();
        String message = "Hi, this is " + name + "! Just testing this functionality. Have a nice day!";

        String messageSent = new HomePage(driver)
                .setContactName(name)
                .setContactEmail(email)
                .setContactMessage(message)
                .submitContactUsMessage()
                .getContactUsMessageSentInfo();

        Assert.assertEquals(messageSent, "It is demo page! We are not sending emails!");
    }
}
