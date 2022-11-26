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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
        // PageFactory is a class that has a method initElements()
            // initElements() method is used to initialize the Page Elements.
        PageFactory.initElements(driver, this);
    }

//    private final By productName = By.cssSelector("td[class='product-name'] a");
//    private final By checkoutBtn = By.xpath("//a[normalize-space()='Proceed to checkout']");

    @FindBy(how = How.CSS, using = "td[class='product-name'] a")
    private WebElement productName;

    @FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
    @CacheLookup
    private WebElement checkoutBtn;

    public String getProductName() {
        // return driver.findElement(productName).getText();
        // return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
        return waitForElementToBeVisible(productName).getText();
    }

    public CheckoutPage checkout(){
//        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
//        driver.findElement(checkoutBtn).click();

        // wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        waitForElementToBeClickable(checkoutBtn).click();
        return new CheckoutPage(driver);
    }

}// CartPage
