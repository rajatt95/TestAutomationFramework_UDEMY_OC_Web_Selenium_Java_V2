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
 # * Learnings from Tutor other course(s): - https://github.com/stars/rajatt95/lists/udemy-omprakash-chavan
 # */
/***************************************************/

package com.learning.pom.pages;

import com.learning.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    // storeMenuLink is marked as private
        // This variable will be available inside this class only
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage load(){
        load("");

        // Explicit Wait - Implement more Strategies
        // Title
        wait.until(ExpectedConditions.titleIs("AskOmDch – Become a Selenium automation expert!"));
        wait.until(ExpectedConditions.titleContains("OmDch"));

        // URL
        wait.until(ExpectedConditions.urlContains("askomdch.com"));

        return this;
    }

//    public void clickStoreMenuLink(){
//        driver.findElement(storeMenuLink).click();
//    }
    public StorePage navigateToStoreUsingMenu(){
        // driver.findElement(storeMenuLink).click();
        waitForElementToBeClickable(storeMenuLink).click();

        // This is the example of Fluent Interface
            // After clicking on a Store Menu link, User is navigated to Store Page
        return new StorePage(driver);
    }

}// HomePage
