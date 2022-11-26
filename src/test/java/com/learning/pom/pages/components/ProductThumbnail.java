/**
 # * @author Rajat Verma
 # * https://www.linkedin.com/in/rajat-v-3b0685128/
 # * https://github.com/rajatt95
 # * https://rajatt95.github.io/
 # *
 # * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 # * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)

 # * Code Repository: https://github.com/rajatt95/TestAutomationFramework_UDEMY_OC_Web_Selenium_Java_V2

 # * Document(s): https://github.com/rajatt95/Documents

 # * Learnings from Tutor (Code Repository):
 # *    This course
 # *        https://github.com/stars/rajatt95/lists/udemy-oc-selenium
 # *    Other course(s):
 # *        https://github.com/stars/rajatt95/lists/udemy-omprakash-chavan
 # */

/***************************************************/

package com.learning.pom.pages.components;

import com.learning.pom.base.BasePage;
import com.learning.pom.pages.CartPage;
import com.learning.pom.pages.CheckoutPage;
import com.learning.pom.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductThumbnail extends BasePage {

    private final By viewCartLink = By.cssSelector("a[title='View cart']");
    public ProductThumbnail(WebDriver driver) {
        super(driver);
    }

    private By getAddToCartBtnElement(String productName){
        // addToCartBtn = By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']");
        return By.xpath("//a[@aria-label='Add “"+productName+"” to your cart']");
    }
    public ProductThumbnail clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartBtnElement(productName);
        // driver.findElement(addToCartBtn).click();
        waitForElementToBeClickable(addToCartBtn).click();
        return this;
    }

    public CartPage clickViewCart(){
        // driver.findElement(viewCartLink).click();
        waitForElementToBeClickable(viewCartLink).click();
        return new CartPage(driver);
    }

}// ProductThumbnail
