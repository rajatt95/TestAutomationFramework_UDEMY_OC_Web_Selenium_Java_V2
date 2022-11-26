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

import com.learning.pom.base.BaseTest;
import com.learning.pom.objects.Product;
import com.learning.pom.pages.CartPage;
import com.learning.pom.pages.HomePage;
import com.learning.pom.pages.StorePage;
import com.learning.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;


public class _04_AddToCartTest extends BaseTest {

    @Test
    public void addToCartFromStorePage(){

        Product product = new Product(1215);

        CartPage cartPage = new StorePage(getDriver()).
                load().
                getProductThumbnail().
                clickAddToCartBtn(product.getName()).
                clickViewCart();

        Assert.assertEquals(cartPage.getProductName(), product.getName(),
                "Assertion for Product Name that comes after click on View Cart link.");

        // Intentionally, Failing this test case to check the screenshot
//        Assert.assertEquals(cartPage.getProductName(), product.getName()+"FAIL",
//                "Assertion for Product Name that comes after click on View Cart link.");
    }
}








