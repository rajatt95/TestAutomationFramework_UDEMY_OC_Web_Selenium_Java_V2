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

package com.learning.pom.pages;

import com.learning.pom.base.BasePage;
import com.learning.pom.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By searchFld = By.xpath("//input[@id='woocommerce-product-search-field-0']");
    private final By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    // Hard coded String - Product name has been used to find the Element
    // private final By addToCartBtn = By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']");

    // private final By viewCartLink = By.cssSelector("a[title='View cart']");
        // Moved in ProductThumbnail (Composition)

    private ProductThumbnail productThumbnail;
    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }
    public StorePage(WebDriver driver){
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

//    public void enterTxtInSearchFld(String txt){
//        driver.findElement(searchFld).sendKeys(txt);
//    }

    public StorePage load(){
        load("store");
        return this;
    }

    // Structural Page Object
    public StorePage enterTxtInSearchFld(String txt){
        // driver.findElement(searchFld).sendKeys(txt);
        waitForElementToBeVisible(searchFld).sendKeys(txt);

        // This is the example of Builder Pattern
            // After filling value in textBox, User is on the same Page (StorePage)
        return this;
    }

    // Structural Page Object
    public StorePage clearSearchFld(){
        // driver.findElement(searchFld).clear();
        waitForElementToBeVisible(searchFld).clear();
        return this;
    }

    // Structural Page Object
    public StorePage clickSearchBtn(){
        // driver.findElement(searchBtn).click();
        waitForElementToBeClickable(searchBtn).click();
        return this;
    }


    // Functional Page Object
    public StorePage searchProduct(String productName){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clearSearchFld();
        enterTxtInSearchFld(productName);
        clickSearchBtn();
        return this;
    }

    public String getTitle(){
        // return driver.findElement(title).getText();
        return waitForElementToBeVisible(title).getText();

    }

//
//    private By getAddToCartBtnElement(String productName){
//        // addToCartBtn = By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']");
//        return By.xpath("//a[@aria-label='Add “"+productName+"” to your cart']");
//    }
//    public StorePage clickAddToCartBtn(String productName){
//        By addToCartBtn = getAddToCartBtnElement(productName);
//
//        // driver.findElement(addToCartBtn).click();
//        waitForElementToBeClickable(addToCartBtn).click();
//
//        return this;
//    }
//
//    public CartPage clickViewCart(){
//        // driver.findElement(viewCartLink).click();
//        waitForElementToBeClickable(viewCartLink).click();
//
//        return new CartPage(driver);
//    }


}// StorePage
