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

package com.learning.pom.base;

import com.learning.pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void load(String endPoint){
        driver.get("https://askomdch.com/"+endPoint);
    }
}// BasePage
