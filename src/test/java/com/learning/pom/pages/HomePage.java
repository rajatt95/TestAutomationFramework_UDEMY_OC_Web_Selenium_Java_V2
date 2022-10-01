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

public class HomePage extends BasePage {

    // storeMenuLink is marked as private
        // This variable will be available inside this class only
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public HomePage(WebDriver driver){
        super(driver);
    }

//    public void clickStoreMenuLink(){
//        driver.findElement(storeMenuLink).click();
//    }
    public StorePage clickStoreMenuLink(){
        driver.findElement(storeMenuLink).click();

        // This is the example of Fluent Interface
            // After clicking on a Store Menu link, User is navigated to Store Page
        return new StorePage(driver);
    }

}// HomePage
