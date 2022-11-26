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

package com.learning.pom.pages;

import com.learning.pom.base.BasePage;
import com.learning.pom.objects.BillingAddress;
import com.learning.pom.objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    private final By countryDropDown = By.id("billing_country");
    private final By alternateCountryDropDown = By.id("select2-billing_country-container");
    private final By alternateStateDropDown = By.id("select2-billing_state-container");

    private final By stateDropDown = By.id("billing_state");

    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");

    private final By productName = By.cssSelector("td[class='product-name']");


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
        WebElement webElement = waitForElementToBeVisible(lastNameFld);
        webElement.clear();
        webElement.sendKeys(lastName);
        return this;
    }

    public CheckoutPage selectCountry(String countryName){
//        Select select = new Select(driver.findElement(countryDropDown));
//        Select select = new Select(waitForElementToBeClickable(countryDropDown));
//        select.selectByVisibleText(countryName);

        waitForElementToBeClickable(alternateCountryDropDown).click();
        // Using Dynamic XPath to find the locator of Element
        WebElement element = waitForElementToBeClickable(By.xpath("//li[text()='" + countryName + "']"));
        // Using Javascript Executor Interface, Scrolling into the View
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        System.out.println("Country selected from Dropdown: " + countryName);
        return this;
}

    public CheckoutPage selectState(String stateName){
//        Select select = new Select(driver.findElement(stateDropDown));
//        select.selectByVisibleText(stateName);

        waitForElementToBeClickable(alternateStateDropDown).click();
        // Using Dynamic XPath to find the locator of Element
        WebElement element = waitForElementToBeClickable(By.xpath("//li[text()='" + stateName + "']"));
        // Using Javascript Executor Interface, Scrolling into the View
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        System.out.println("Country selected from Dropdown: " + stateName);
        return this;
    }

    public CheckoutPage enterAddressLineOne(String addressLineOne){
        WebElement webElement = waitForElementToBeVisible(addressLineOneFld);
        webElement.clear();
        webElement.sendKeys(addressLineOne);

        return this;
    }

    public CheckoutPage enterCity(String city){
        WebElement webElement = waitForElementToBeVisible(billingCityFld);
        webElement.clear();
        webElement.sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostCode(String postCode){
        WebElement webElement = waitForElementToBeVisible(billingPostCodeFld);
        webElement.clear();
        webElement.sendKeys(postCode);
        return this;
    }

    public CheckoutPage enterEmail(String email){
        WebElement webElement = waitForElementToBeVisible(billingEmailFld);
        webElement.clear();
        webElement.sendKeys(email);
        return this;
    }

    public CheckoutPage placeOrder(){
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
        WebElement webElement = waitForElementToBeVisible(usernameFld);
        webElement.clear();
        webElement.sendKeys(username);
        return this;
    }

    public CheckoutPage enterPassword(String password) {
        WebElement webElement = waitForElementToBeVisible(passwordFld);
        webElement.clear();
        webElement.sendKeys(password);
        return this;
    }

    public CheckoutPage clickLoginBtn() {
        waitForElementToBeClickable(loginBtn).click();
        return this;
    }


    private CheckoutPage waitForLoginBtnToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtn));
        return this;
    }

    public CheckoutPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
        waitForLoginBtnToDisappear();
        return this;
    }

    // Functional Page Object
    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountry()).
                enterAddressLineOne(billingAddress.getAddressLineOne()).
                enterCity(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                enterPostCode(billingAddress.getPostalCode()).
                enterEmail(billingAddress.getEmail());
    }

    public CheckoutPage login(User user) {
        enterUsername(user.getEmail());
        enterPassword(user.getPassword());
        clickLoginBtn();
        return this;
    }

    public CheckoutPage selectDirectBankTransfer(){
        WebElement webElement = waitForElementToBeVisible(directBankTransferRadioBtn);
        if(!webElement.isSelected()){
            webElement.click();
        }
        return this;
    }

    public String getProductName() {
        return waitForElementToBeVisible((productName)).getText();
    }


}// CheckoutPage
