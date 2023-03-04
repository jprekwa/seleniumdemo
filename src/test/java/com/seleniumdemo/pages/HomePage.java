package com.seleniumdemo.pages;

import com.seleniumdemo.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;

    @FindBy(xpath = "//li[contains(@class, 'czr-dropdown')]/a/i[@class='icn-shoppingcart']")
    private WebElement shoppingCartIcon;

    @FindBy(className = "sek-btn-text")
    private WebElement shopButton;

    @FindBy(name = "nimble_name")
    private WebElement contactUsNameInput;

    @FindBy(name = "nimble_email")
    private WebElement contactUsEmailInput;

    @FindBy(name = "nimble_message")
    private WebElement contactUsMessageInput;

    @FindBy(name = "nimble_submit")
    private WebElement contactUsSubmitButton;

    @FindBy(xpath = "//div[@id='sek-form-respond']/span")
    private WebElement contactUsMessageSentInfo;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();
        return new MyAccountPage(driver);
    }

    public ProductListPage openShopPage() {
        shopLink.click();
        return new ProductListPage(driver);
    }

    public CartPage openCartPage() {
        Actions actions = new Actions(driver);
        actions.doubleClick(shoppingCartIcon);
        actions.perform();
        return new CartPage(driver);
    }

    public ProductListPage openShopPageWithShopButton() {
        shopButton.click();
        return new ProductListPage(driver);
    }

    public HomePage setContactName(String name) {
        contactUsNameInput.sendKeys(name);
        return this;
    }

    public HomePage setContactEmail(String email) {
        contactUsEmailInput.sendKeys(email);
        return this;
    }

    public HomePage setContactMessage(String message) {
        contactUsMessageInput.sendKeys(message);
        return this;
    }

    public HomePage submitContactUsMessage() {
        contactUsSubmitButton.click();
        return this;
    }

    public String getContactUsMessageSentInfo() {
        SeleniumHelper.waitForElement(contactUsMessageSentInfo, driver);
        return contactUsMessageSentInfo.getText();
    }
}