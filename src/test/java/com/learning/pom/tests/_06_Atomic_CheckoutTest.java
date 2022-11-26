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

package com.learning.pom.tests;

import com.learning.pom.api.actions.CartApi;
import com.learning.pom.api.actions.SignupApi;
import com.learning.pom.base.BaseTest;
import com.learning.pom.objects.BillingAddress;
import com.learning.pom.objects.Product;
import com.learning.pom.objects.User;
import com.learning.pom.pages.CheckoutPage;
import com.learning.pom.utils.FakerUtils;
import com.learning.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class _06_Atomic_CheckoutTest extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer(){
        // Setting the Application State using API - START
        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();

        // CartApi has 2 Constructors
            //  This is for Guest User
        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215, 1);
        injectCookiesIntoBrowser(cartApi.getCookies());

        // Setting the Application State using API - END

        // Reusable Method to De-serialize JSON (Generic Method)
        BillingAddress billingAddress = JacksonUtils.deSerializationJSON(
                "myBillingAddress.json",BillingAddress.class);

        checkoutPage.
                load().
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();

        // Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.",
                "Assertion for Thank you Message that comes after order is placed");

    }// guestCheckoutUsingDirectBankTransfer


    @Test
    public void loginAndCheckoutUsingDirectBankTransfer(){
        // Setting the Application State using API - START
        // User State
        String username = "demoUser" + new FakerUtils().generateRandomNumber();
        String password = "demoPwd";
        String email = username + "@gmail.com";
        User user = new User().
                setUsername(username).
                setPassword(password).
                setEmail(email);

        SignupApi signupApi = new SignupApi();
        signupApi.registerUser(user);

        // Application State
        // CartApi has 2 Constructors
            //  This is for Logged-in User
        CartApi cartApi = new CartApi(signupApi.getCookies());

        Product product = new Product(1215);

        cartApi.addToCart(product.getId(),1);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();

        // injectCookiesIntoBrowser(cartApi.getCookies());

        // We want User to be logged in already (With APIs)
        injectCookiesIntoBrowser(signupApi.getCookies());

        // Setting the Application State using API - END

        // Reusable Method to De-serialize JSON (Generic Method)
        BillingAddress billingAddress = JacksonUtils.deSerializationJSON(
                "myBillingAddress.json",BillingAddress.class);

        checkoutPage.
                load().
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();

        // Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.",
                "Assertion for Thank you Message that comes after order is placed");

    }// loginAndCheckoutUsingDirectBankTransfer
}


