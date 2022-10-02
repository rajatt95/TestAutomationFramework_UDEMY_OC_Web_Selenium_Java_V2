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

package com.learning.Z_learningsFromStart;

import com.learning.pom.base.BaseTest;
import com.learning.pom.objects.BillingAddress;
import com.learning.pom.pages.CartPage;
import com.learning.pom.pages.CheckoutPage;
import com.learning.pom.pages.HomePage;
import com.learning.pom.pages.StorePage;
import com.learning.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;

// Remove Hard Coding - Test Data (Take it from JSON using Jackson DataBind dependency)
// Billing Address: De-serialize JSON
public class _03_Sec_10_04_DO_MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        StorePage storePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                searchProduct("Blue");

        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”",
                "Assertion for Heading that comes after click on Search button");

        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();

        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes",
                "Assertion for Product Name that comes after click on View Cart link");
        CheckoutPage checkoutPage = cartPage.checkout();

        // Billing Address - Parameterized Constructor
//        BillingAddress billingAddress = new BillingAddress("demo","user",
//                "San Francisco","San Francisco","94188","dummyUser875@gmail.com");

        // Billing Address: De-serialize JSON
        BillingAddress billingAddress = new BillingAddress();

        // InputStream -> This will automatically take the file path (src/test/resources)
            // Maven will resolve this (We don't need absolute/relative path)
        InputStream is = getClass().getClassLoader().getResourceAsStream("myBillingAddress.json");

        // Commented below line (Because, we made deSerializationJSON() method as Generic)
            // Refer _03_Sec_10_05_DO_MyFirstTestCase
        // billingAddress = JacksonUtils.deSerializationJSON(is, billingAddress);

        // Functional Page Object
        checkoutPage.
                setBillingAddress(billingAddress).
                placeOrder();

        Thread.sleep(5000);

        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.",
                "Assertion for Thank you Message that comes after order is placed");

    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {


        StorePage storePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                searchProduct("Blue");

        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”",
                "Assertion for Heading that comes after click on Search button");

        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();

        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes",
                "Assertion for Product Name that comes after click on View Cart link");

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.clickHereToLoginLink();
        Thread.sleep(3000);

        checkoutPage.
                login("dummyUser875@gmail.com","HidummyUser").
                enterFirstName("demo").
                enterLastName("user").
                enterAddressLineOne("San Francisco").
                enterCity("San Francisco").
                enterPostCode("94188").
                enterEmail("dummyUser875@gmail.com").
                placeOrder();

        Thread.sleep(5000);

        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.",
                "Assertion for Thank you Message that comes after order is placed");

    }


}// _03_Sec_10_01_DO_MyFirstTestCase
