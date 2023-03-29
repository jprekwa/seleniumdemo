package com.seleniumdemo.pages;

import com.seleniumdemo.models.Customer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_company")
    private WebElement companyNameInput;

    @FindBy(id = "billing_country")
    private WebElement countryNameSelect;

    @FindBy(id = "billing_address_1")
    private WebElement streetAddressFirstInput;

    @FindBy(id = "billing_address_2")
    private WebElement streetAddressSecondInput;

    @FindBy(id = "billing_postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "billing_city")
    private WebElement cityInput;

    @FindBy(id = "billing_phone")
    private WebElement phoneNumberInput;

    @FindBy(id = "billing_email")
    private WebElement emailAddressInput;

    @FindBy(id = "order_comments")
    private WebElement orderCommentsInput;

    @FindBy(xpath = "//button[text()='Place order']")
    private WebElement placeOrderButton;

    private WebDriver driver;

    public OrdersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage checkoutCustomer(Customer customer) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select countrySelect = new Select(countryNameSelect);
        countrySelect.selectByVisibleText(customer.getCountryName());
        streetAddressFirstInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        postalCodeInput.sendKeys(customer.getPostalCode());
        cityInput.sendKeys(customer.getCity());
        phoneNumberInput.sendKeys(customer.getPhoneNumber());
        emailAddressInput.sendKeys(customer.getEmail());
        orderCommentsInput.sendKeys("Some comment");
        orderCommentsInput.sendKeys(Keys.TAB);
        placeOrderButton.sendKeys(Keys.ENTER);
        return new OrderDetailsPage(driver);
    }

    public OrderDetailsPage checkoutLoggedUser() {
        orderCommentsInput.sendKeys(Keys.TAB);
        placeOrderButton.sendKeys(Keys.ENTER);
        return new OrderDetailsPage(driver);
    }
}