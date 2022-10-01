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
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public CheckoutPage load(){
        load("checkout");
        return this;
    }

    private final By firstNameFld = By.id("billing_first_name");
    private final By lastNameFld = By.id("billing_last_name");
    private final By addressLineOneFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.id("billing_email");
    private final By placeOrderBtn = By.xpath("//button[normalize-space()='Place order']");
    private final By successNotice = By.xpath("//p[contains(@class,'woocommerce-thankyou-order-received')]");

    private final By clickHereToLoginLink = By.xpath("//a[@class='showlogin']");
    private final By usernameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.xpath("//button[@name='login']");


    public CheckoutPage enterFirstName(String firstName){
        driver.findElement(firstNameFld).clear();
        driver.findElement(firstNameFld).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName){
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressLineOne(String addressLineOne){
        driver.findElement(addressLineOneFld).clear();
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckoutPage enterCity(String city){
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostCode(String postCode){
        driver.findElement(billingPostCodeFld).clear();
        driver.findElement(billingPostCodeFld).sendKeys(postCode);
        return this;
    }

    public CheckoutPage enterEmail(String email){
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }

    public CheckoutPage placeOrder(){
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
        return driver.findElement(successNotice).getText();
    }

    public CheckoutPage clickHereToLoginLink() {
        driver.findElement(clickHereToLoginLink).click();
        return this;
    }

    public CheckoutPage enterUsername(String username) {
        driver.findElement(usernameFld).clear();
        driver.findElement(usernameFld).sendKeys(username);
        return this;
    }

    public CheckoutPage enterPassword(String password) {
        driver.findElement(passwordFld).clear();
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public CheckoutPage clickLoginBtn() {
        driver.findElement(loginBtn).click();
        return this;
    }

    public CheckoutPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
        return this;
    }

}// CheckoutPage
