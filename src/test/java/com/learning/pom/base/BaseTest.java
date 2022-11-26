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

package com.learning.pom.base;

import com.learning.pom.enums.BrowserType;
import com.learning.pom.factory.DriverManager;
import com.learning.pom.factory.DriverManagerFactory;
import com.learning.pom.utils.CookieUtils;
import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.List;

public class BaseTest {

    // protected WebDriver driver;
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Sets the current thread's copy of this thread-local variable to the specified value.
        // Most subclasses will have no need to override this method, relying solely on the initialValue method to set the values of thread-locals
    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    // Returns the value in the current thread's copy of this thread-local variable.
        // If the variable has no value for the current thread, it is first initialized to the value returned by an invocation of the initialValue method.
    protected WebDriver getDriver(){
        return this.driver.get();
    }


//    @BeforeMethod
//    public void startDriver(){
//        driver = new DriverManager().initializeDriver();
//    }

    // browser_testng - It is the name of the parameter in testng.xml file
    @Parameters("browser_testng")
    @BeforeMethod
    // public void startDriver(String browser_testng){
    // @Optional -> We can run the test case individually as well (Directly from Test class)
    // public void startDriver(@Optional String browser_testng){
    public synchronized void startDriver(@Optional String browser_testng){
        // Browser passed from TestNG.xml file will be taken by default
        // If Browser value is not passed from command line
        String browser = System.getProperty("browser",browser_testng);

        if(browser==null) {
            // browser = "CHROME";
            browser = BrowserType.CHROME.toString();
        }
        // driver = new DriverManager().initializeDriver(browser_testng);

        // setDriver(new DriverManager().initializeDriver(browser));
        setDriver(DriverManagerFactory.getManager(BrowserType.valueOf(browser)).createDriver());


        System.out.println("CURRENT THREAD (Thread.currentThread().getId()): "+Thread.currentThread().getId());
        System.out.println("DRIVER (getDriver()): "+getDriver());
    }

    @AfterMethod
    // public void quitDriver(){
    public synchronized void quitDriver(){
        // driver.quit();
        System.out.println("CURRENT THREAD (Thread.currentThread().getId()): "+Thread.currentThread().getId());
        System.out.println("DRIVER (getDriver()): "+getDriver());
        getDriver().quit();
    }

    public void injectCookiesIntoBrowser(Cookies restAssuredCookies){
        List<Cookie> seleniumCookies = new CookieUtils().
                convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);

        for(Cookie seleniumCookie: seleniumCookies){
            getDriver().manage().addCookie(seleniumCookie);
        }// for

    }// injectCookiesIntoBrowser

}// BaseTest














