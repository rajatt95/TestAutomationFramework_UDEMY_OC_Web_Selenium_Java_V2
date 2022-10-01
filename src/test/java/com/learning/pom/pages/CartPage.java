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

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutBtn = By.xpath("//a[normalize-space()='Proceed to checkout']");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public CheckoutPage clickCheckoutBtn(){
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }


}// CartPage
