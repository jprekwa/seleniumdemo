package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayTest extends BaseTest {

    @Test
    public void homePageParagraphsDisplay() {
        WebElement firstImgFirstDiv = new HomePage(driver).getFirstPicTextDiv();
        WebElement firstImgFirstParagraph = new HomePage(driver).getFirstPicTextParagraph();
        WebElement secondImgFirstHeader = new HomePage(driver).getSecondPicFirstTextHeader();
        WebElement secondImgFirstParagraph = new HomePage(driver).getSecondPicFirstTextParagraph();
        WebElement secondImgSecondHeader = new HomePage(driver).getSecondPicSecondTextHeader();
        WebElement secondImgSecondParagraph = new HomePage(driver).getSecondPicSecondTextParagraph();
        WebElement secondImgThirdHeader = new HomePage(driver).getSecondPicThirdTextHeader();
        WebElement secondImgThirdParagraph = new HomePage(driver).getSecondPicThirdTextParagraph();

        Assert.assertTrue(firstImgFirstDiv.isDisplayed());
        Assert.assertTrue(firstImgFirstParagraph.isDisplayed());
        Assert.assertTrue(secondImgFirstHeader.isDisplayed());
        Assert.assertTrue(secondImgFirstParagraph.isDisplayed());
        Assert.assertTrue(secondImgSecondHeader.isDisplayed());
        Assert.assertTrue(secondImgSecondParagraph.isDisplayed());
        Assert.assertTrue(secondImgThirdHeader.isDisplayed());
        Assert.assertTrue(secondImgThirdParagraph.isDisplayed());

        Assert.assertEquals(firstImgFirstDiv.getText(), "Design your own space");
        Assert.assertEquals(firstImgFirstParagraph.getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor.");
        Assert.assertEquals(secondImgFirstHeader.getText(), "High performances");
        Assert.assertEquals(secondImgFirstParagraph.getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus.");
        Assert.assertEquals(secondImgSecondHeader.getText(), "Industry leader");
        Assert.assertEquals(secondImgSecondParagraph.getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus.");
        Assert.assertEquals(secondImgThirdHeader.getText(), "Delivers on time");
        Assert.assertEquals(secondImgThirdParagraph.getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus.");
    }
}