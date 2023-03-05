package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPage {

    @FindBy(className = "tax__link")
    private WebElement categoryLink;

    @FindBy(xpath = "//header[@class='entry-header ']//h1")
    private WebElement titleHeader;

    @FindBy(xpath = "//div[@class='post-info']/span")
    private WebElement metaInfoSpan;

    @FindBy(xpath = "//div[@class='post-entry tc-content-inner']//p")
    private WebElement postContentParagraph;

    @FindBy(xpath = "//h3[@class='related-posts_title col']")
    private WebElement relatedPostHeader;

    @FindBy(xpath = "//a[@class='bg-link']")
    private WebElement secondPostPicture;

    @FindBy(xpath = "//div[@class='entry-meta post-info']")
    private WebElement metaInfoSecondPost;

    @FindBy(className = "czr-title")
    private WebElement secondPostTitle;

    @FindBy(xpath = "//div[@class='tc-content-inner entry-summary']//p")
    private WebElement secondPostContentParagraph;

    @FindBy(id = "reply-title")
    private WebElement commentHeader;

    @FindBy(className = "comment-notes")
    private WebElement commentParagraph;

    @FindBy(id = "comment")
    private WebElement commentAreaInput;

    @FindBy(id = "author")
    private WebElement authorInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "url")
    private WebElement websiteInput;

    @FindBy(id = "submit")
    private WebElement postCommentButton;

    @FindBy(xpath = "//a[@title='Back to post list']")
    private WebElement backToPostListLink;

    @FindBy(className = "meta-nav")
    private WebElement nextPostSpan;

    public PostPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getCategoryLink() {
        return categoryLink;
    }

    public WebElement getTitleHeader() {
        return titleHeader;
    }

    public WebElement getMetaInfoSpan() {
        return metaInfoSpan;
    }

    public WebElement getPostContentParagraph() {
        return postContentParagraph;
    }

    public WebElement getRelatedPostHeader() {
        return relatedPostHeader;
    }

    public WebElement getSecondPostPicture() {
        return secondPostPicture;
    }

    public WebElement getMetaInfoSecondPost() {
        return metaInfoSecondPost;
    }

    public WebElement getSecondPostTitle() {
        return secondPostTitle;
    }

    public WebElement getSecondPostContentParagraph() {
        return secondPostContentParagraph;
    }

    public WebElement getCommentHeader() {
        return commentHeader;
    }

    public WebElement getCommentParagraph() {
        return commentParagraph;
    }

    public WebElement getCommentAreaInput() {
        return commentAreaInput;
    }

    public WebElement getAuthorInput() {
        return authorInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getWebsiteInput() {
        return websiteInput;
    }

    public WebElement getPostCommentButton() {
        return postCommentButton;
    }

    public WebElement getBackToPostListLink() {
        return backToPostListLink;
    }

    public WebElement getNextPostSpan() {
        return nextPostSpan;
    }
}
