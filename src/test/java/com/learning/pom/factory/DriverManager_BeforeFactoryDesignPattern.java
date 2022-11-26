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

package com.learning.pom.factory;

import com.learning.pom.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager_BeforeFactoryDesignPattern {

//    public WebDriver initializeDriver(String browser){
    public WebDriver initializeDriver(String browser){

        // System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");
        // System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_incompatible");
        // WebDriverManager.chromedriver().setup();
        // WebDriverManager.chromedriver().cachePath("Drivers/Downloaded_By_WDM").setup();

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new ChromeDriver();

//        WebDriver driver;
//        String browser = System.getProperty("browser");
//        switch (browser){
//            case "Chrome":
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            case "Firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            default:
//                throw new IllegalStateException("Invalid Browser name: "+browser);
//        }// switch

        WebDriver driver;
        // This is done to take value of the Browser from Command Line
            // mvn clean test -Dbrowser=CHROME
            // mvn clean test -Dbrowser=FIREFOX
        // String browser = System.getProperty("browser");

        // If we do not pass any value using command line,
            // Then, Chrome Browser will be taken by default
            // mvn clean test
                // We can execute the test cases individually as well
        // String browser = System.getProperty("browser","CHROME");

        switch (BrowserType.valueOf(browser.toUpperCase())){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Invalid Browser name: "+browser);
        }// switch

        driver.manage().window().maximize();

        // As long as the Driver Session is active,
            // This wait will be applied to the Driver Session
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }
}// DriverManager
