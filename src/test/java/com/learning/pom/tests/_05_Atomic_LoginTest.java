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
import com.learning.pom.objects.Product;
import com.learning.pom.objects.User;
import com.learning.pom.pages.CheckoutPage;
import com.learning.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class _05_Atomic_LoginTest extends BaseTest {

    @Test
    public void loginDuringCheckout(){

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
            //  This is for Guest User
        CartApi cartApi = new CartApi();

        Product product = new Product(1215);

        cartApi.addToCart(product.getId(),1);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver()).load();

        injectCookiesIntoBrowser(cartApi.getCookies());

        // Setting the Application State using API - END

        checkoutPage.
                load().
                clickHereToLoginLink().
                login(user);

        Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()),
                "Assertion for Product Name on the Checkout Page " +
                        "that comes after login and Add Product to Cart.");

    }

}


