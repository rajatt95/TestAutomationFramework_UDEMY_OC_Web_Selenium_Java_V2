/**
 # * @author Rajat Verma
 # * https://www.linkedin.com/in/rajat-v-3b0685128/
 # * https://github.com/rajatt95
 # * https://rajatt95.github.io/
 # *
 # * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
 # * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 # * Learnings from Other Courses - https://github.com/stars/rajatt95/lists/udemy-omprakash-chavan
 # */
/***************************************************/

package com.learning.pom.pages;

import com.learning.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By searchFld = By.xpath("//input[@id='woocommerce-product-search-field-0']");
    private final By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    // Hard coded String - Product name has been used to find the Element
    // private final By addToCartBtn = By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");


    public StorePage(WebDriver driver){
        super(driver);
    }

//    public void enterTxtInSearchFld(String txt){
//        driver.findElement(searchFld).sendKeys(txt);
//    }


    // Structural Page Object
    public StorePage enterTxtInSearchFld(String txt){
        driver.findElement(searchFld).sendKeys(txt);
        // This is the example of Builder Pattern
            // After filling value in textBox, User is on the same Page (StorePage)
        return this;
    }

    // Structural Page Object
    public StorePage clearSearchFld(){
        driver.findElement(searchFld).clear();
        return this;
    }

    // Structural Page Object
    public StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }


    // Functional Page Object
    public StorePage searchProduct(String productName){
        clearSearchFld();
        enterTxtInSearchFld(productName);
        clickSearchBtn();
        return this;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    private By getAddToCartBtnElement(String productName){
        // addToCartBtn = By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']");
        return By.xpath("//a[@aria-label='Add “"+productName+"” to your cart']");
    }
    public StorePage clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartBtnElement(productName);
        driver.findElement(addToCartBtn).click();
        return this;
    }

    public CartPage clickViewCart(){
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }


}// StorePage
