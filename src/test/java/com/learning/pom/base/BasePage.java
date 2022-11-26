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

package com.learning.pom.base;

import com.learning.pom.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        // Examples
//        this.waitLong = new WebDriverWait(driver,Duration.ofSeconds(25));
//        this.waitShort = new WebDriverWait(driver,Duration.ofSeconds(25));

    }

    public void load(String endPoint){
        // driver.get("https://askomdch.com/"+endPoint);
        driver.get(ConfigLoader.getInstance().getBaseUrl() +endPoint);
    }

    // Re-Usable method to handle Overlays
    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAYS SIZE: "+overlays.size());
        if(overlays.size() > 0){

            // Explicit Wait
//            new WebDriverWait(driver, Duration.ofSeconds(15)).until(
//                    ExpectedConditions.invisibilityOfAllElements(overlays)
//            );
            wait.until(
                    ExpectedConditions.invisibilityOfAllElements(overlays)
            );
            System.out.println("OVERLAY INVISIBLE");
        }else {
            System.out.println("OVERLAY NOT FOUND");
        }
    }

    public WebElement waitForElementToBeVisible(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public WebElement waitForElementToBeClickable(By element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement waitForElementToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}// BasePage





