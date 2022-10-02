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
import com.learning.pom.objects.BillingAddress;
import com.learning.pom.objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    private final By overlay = By.cssSelector(".blockUI.blockOverlay");


    public CheckoutPage enterFirstName(String firstName){
//      driver.findElement(firstNameFld).clear();
//      driver.findElement(firstNameFld).sendKeys(firstName);

//        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld));
//        webElement.clear();
//        webElement.sendKeys(firstName);

        WebElement webElement = waitForElementToBeVisible(firstNameFld);
        webElement.clear();
        webElement.sendKeys(firstName);

        return this;
    }

    public CheckoutPage enterLastName(String lastName){
//        driver.findElement(lastNameFld).clear();
//        driver.findElement(lastNameFld).sendKeys(lastName);

        WebElement webElement = waitForElementToBeVisible(lastNameFld);
        webElement.clear();
        webElement.sendKeys(lastName);

        return this;
    }

    public CheckoutPage enterAddressLineOne(String addressLineOne){
//        driver.findElement(addressLineOneFld).clear();
//        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);

        WebElement webElement = waitForElementToBeVisible(addressLineOneFld);
        webElement.clear();
        webElement.sendKeys(addressLineOne);

        return this;
    }

    public CheckoutPage enterCity(String city){
//        driver.findElement(billingCityFld).clear();
//        driver.findElement(billingCityFld).sendKeys(city);

        WebElement webElement = waitForElementToBeVisible(billingCityFld);
        webElement.clear();
        webElement.sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostCode(String postCode){
//        driver.findElement(billingPostCodeFld).clear();
//        driver.findElement(billingPostCodeFld).sendKeys(postCode);

        WebElement webElement = waitForElementToBeVisible(billingPostCodeFld);
        webElement.clear();
        webElement.sendKeys(postCode);
        return this;
    }

    public CheckoutPage enterEmail(String email){
//        driver.findElement(billingEmailFld).clear();
//        driver.findElement(billingEmailFld).sendKeys(email);

        WebElement webElement = waitForElementToBeVisible(billingEmailFld);
        webElement.clear();
        webElement.sendKeys(email);
        return this;
    }

    public CheckoutPage placeOrder(){
//        List<WebElement> overlays = driver.findElements(overlay);
//        if(overlays.size() > 0){
//            // Explicit Wait
//            new WebDriverWait(driver, Duration.ofSeconds(15)).until(
//                    ExpectedConditions.invisibilityOfAllElements(overlays)
//            );
//        }
        waitForOverlaysToDisappear(overlay);

        // driver.findElement(placeOrderBtn).click();
        waitForElementToBeClickable(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
        // return driver.findElement(successNotice).getText();
        return waitForElementToBeVisible(successNotice).getText();
    }

    public CheckoutPage clickHereToLoginLink() {
        // driver.findElement(clickHereToLoginLink).click();
        waitForElementToBeClickable(clickHereToLoginLink).click();
        return this;
    }

    public CheckoutPage enterUsername(String username) {
//        driver.findElement(usernameFld).clear();
//        driver.findElement(usernameFld).sendKeys(username);

        WebElement webElement = waitForElementToBeVisible(usernameFld);
        webElement.clear();
        webElement.sendKeys(username);
        return this;
    }

    public CheckoutPage enterPassword(String password) {
//        driver.findElement(passwordFld).clear();
//        driver.findElement(passwordFld).sendKeys(password);

        WebElement webElement = waitForElementToBeVisible(passwordFld);
        webElement.clear();
        webElement.sendKeys(password);
        return this;
    }

    public CheckoutPage clickLoginBtn() {
        // driver.findElement(loginBtn).click();
        waitForElementToBeClickable(loginBtn).click();
        return this;
    }

    public CheckoutPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
        return this;
    }

    public CheckoutPage login(User user) {
        enterUsername(user.getEmail());
        enterPassword(user.getPassword());
        clickLoginBtn();
        return this;
    }

    // Functional Page Object
    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterAddressLineOne(billingAddress.getAddressLineOne()).
                enterCity(billingAddress.getCity()).
                enterPostCode(billingAddress.getPostalCode()).
                enterEmail(billingAddress.getEmail());
    }

}// CheckoutPage
