package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import com.seleniumdemo.pages.PostPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayTest extends BaseTest {

    @Test
    public void homePageHeadersAndParagraphsDisplay() {
        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.getFirstPicTextDiv().isDisplayed());
        Assert.assertEquals(homePage.getFirstPicTextDiv().getText(), "Design your own space");

        Assert.assertTrue(homePage.getFirstPicTextParagraph().isDisplayed());
        Assert.assertEquals(homePage.getFirstPicTextParagraph().getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.");

        Assert.assertTrue(homePage.getSecondPicFirstTextHeader().isDisplayed());
        Assert.assertEquals(homePage.getSecondPicFirstTextHeader().getText(), "High performances");

        Assert.assertTrue(homePage.getSecondPicFirstTextParagraph().isDisplayed());
        Assert.assertEquals(homePage.getSecondPicFirstTextParagraph().getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus.");

        Assert.assertTrue(homePage.getSecondPicSecondTextHeader().isDisplayed());
        Assert.assertEquals(homePage.getSecondPicSecondTextHeader().getText(), "Industry leader");

        Assert.assertTrue(homePage.getSecondPicSecondTextParagraph().isDisplayed());
        Assert.assertEquals(homePage.getSecondPicSecondTextParagraph().getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus.");

        Assert.assertTrue(homePage.getSecondPicThirdTextHeader().isDisplayed());
        Assert.assertEquals(homePage.getSecondPicThirdTextHeader().getText(), "Delivers on time");

        Assert.assertTrue(homePage.getSecondPicThirdTextParagraph().isDisplayed());
        Assert.assertEquals(homePage.getSecondPicThirdTextParagraph().getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus.");

    }

    @Test
    public void firstPostPageContentDisplay() {
        PostPage postpage = new HomePage(driver).goToFirstPost();

        Assert.assertTrue(postpage.getCategoryLink().isDisplayed());
        Assert.assertEquals(postpage.getCategoryLink().getText(), "UNCATEGORIZED");

        Assert.assertTrue(postpage.getTitleHeader().isDisplayed());
        Assert.assertEquals(postpage.getTitleHeader().getText(), "Hello World");

        Assert.assertTrue(postpage.getMetaInfoSpan().isDisplayed());
        Assert.assertEquals(postpage.getMetaInfoSpan().getText(), "by admin|Published January 17, 2019");

        Assert.assertTrue(postpage.getPostContentParagraph().isDisplayed());
        Assert.assertEquals(postpage.getPostContentParagraph().getText(), "Hello World !");

        Assert.assertTrue(postpage.getRelatedPostHeader().isDisplayed());
        Assert.assertEquals(postpage.getRelatedPostHeader().getText(), "YOU MAY ALSO LIKE");

        Assert.assertTrue(postpage.getSecondPostPicture().isDisplayed());

        Assert.assertTrue(postpage.getMetaInfoSecondPost().isDisplayed());
        Assert.assertEquals(postpage.getMetaInfoSecondPost().getText(), "Published January 18, 2019");

        Assert.assertTrue(postpage.getSecondPostTitle().isDisplayed());
        Assert.assertEquals(postpage.getSecondPostTitle().getText(), "Second post");

        Assert.assertTrue(postpage.getSecondPostContentParagraph().isDisplayed());
        Assert.assertEquals(postpage.getSecondPostContentParagraph().getText(), "Second post");

        Assert.assertTrue(postpage.getCommentHeader().isDisplayed());
        Assert.assertEquals(postpage.getCommentHeader().getText(), "Leave a comment");

        Assert.assertTrue(postpage.getCommentParagraph().isDisplayed());
        Assert.assertEquals(postpage.getCommentParagraph().getText(), "Your email address will not be published. Required fields are marked *");

        Assert.assertTrue(postpage.getCommentAreaInput().isDisplayed());
        Assert.assertTrue(postpage.getAuthorInput().isDisplayed());
        Assert.assertTrue(postpage.getEmailInput().isDisplayed());
        Assert.assertTrue(postpage.getWebsiteInput().isDisplayed());
        Assert.assertTrue(postpage.getPostCommentButton().isDisplayed());
        Assert.assertTrue(postpage.getBackToPostListLink().isDisplayed());
        Assert.assertTrue(postpage.getNextPostSpan().isDisplayed());
    }
}