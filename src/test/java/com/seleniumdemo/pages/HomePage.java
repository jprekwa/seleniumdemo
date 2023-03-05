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

    @FindBy(xpath = "//div[@data-sek-id='__nimble__cc091b3ff1c1']")
    private WebElement firstPicTextDiv;

    @FindBy(xpath = "//div[@data-sek-id='__nimble__59beae0d916a']//p")
    private WebElement firstPicTextParagraph;

    @FindBy(xpath = "//div[@data-sek-id='__nimble__91dfba3bdf88']//h3")
    private WebElement secondPicFirstTextHeader;

    @FindBy(xpath = "//div[@data-sek-id='__nimble__ce9c67ba2a1c']//p")
    private WebElement secondPicFirstTextParagraph;

    @FindBy(xpath = "//div[@data-sek-id='__nimble__2979ac9def83']//h3")
    private WebElement secondPicSecondTextHeader;

    @FindBy(xpath = "//div[@data-sek-id='__nimble__6e96a4095315']//p")
    private WebElement secondPicSecondTextParagraph;

    @FindBy(xpath = "//div[@data-sek-id='__nimble__5d6417c05922']//h3")
    private WebElement secondPicThirdTextHeader;

    @FindBy(xpath = "//div[@data-sek-id='__nimble__b547e4fe7ec6']//p")
    private WebElement secondPicThirdTextParagraph;

    @FindBy(id = "post-39")
    private WebElement firstPost;

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

    public WebElement getFirstPicTextDiv() {
        return firstPicTextDiv;
    }

    public WebElement getFirstPicTextParagraph() {
        return firstPicTextParagraph;
    }

    public WebElement getSecondPicFirstTextHeader() {
        return secondPicFirstTextHeader;
    }

    public WebElement getSecondPicFirstTextParagraph() {
        return secondPicFirstTextParagraph;
    }

    public WebElement getSecondPicSecondTextHeader() {
        return secondPicSecondTextHeader;
    }

    public WebElement getSecondPicSecondTextParagraph() {
        return secondPicSecondTextParagraph;
    }

    public WebElement getSecondPicThirdTextHeader() {
        return secondPicThirdTextHeader;
    }

    public WebElement getSecondPicThirdTextParagraph() {
        return secondPicThirdTextParagraph;
    }

    public PostPage goToFirstPost() {
        firstPost.click();
        return new PostPage(driver);
    }
}