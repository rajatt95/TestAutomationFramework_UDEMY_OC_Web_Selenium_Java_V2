///**
// # * @author Rajat Verma
// # * https://www.linkedin.com/in/rajat-v-3b0685128/
// # * https://github.com/rajatt95
// # * https://rajatt95.github.io/
// # *
// # * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
// # * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
//
// # * Code Repository: https://github.com/rajatt95/TestAutomationFramework_UDEMY_OC_Web_Selenium_Java_V2
// # * Document(s): https://github.com/rajatt95/Documents
// # * Learnings from Tutor other course(s): - https://github.com/stars/rajatt95/lists/udemy-omprakash-chavan
// # */
///***************************************************/
//
//package com.learning.Z_learningsFromStart;
//
//import com.learning.pom.base.BaseTest;
//import com.learning.pom.objects.BillingAddress;
//import com.learning.pom.objects.Product;
//import com.learning.pom.objects.User;
//import com.learning.pom.pages.CartPage;
//import com.learning.pom.pages.CheckoutPage;
//import com.learning.pom.pages.HomePage;
//import com.learning.pom.pages.StorePage;
//import com.learning.pom.utils.JacksonUtils;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//
//// Test case execution using Maven
//public class _06_Sec_16_01_Maven_MyFirstTC extends BaseTest {
//
//    @Test
//    public void guestCheckoutUsingDirectBankTransfer() {
//
//        String searchFor = "Blue";
//        StorePage storePage = new HomePage(driver).
//                load().
//                navigateToStoreUsingMenu().
//                // searchProduct("Blue");
//                 searchProduct(searchFor);
//
////        Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”",
////                "Assertion for Heading that comes after click on Search button");
//
//        Assert.assertTrue(storePage.getTitle().contains("Search results"),
//                "Assertion for Heading that comes after click on Search button");
//
//        // Products - Create JSON Array
//        Product product = new Product(1215);
//        storePage.clickAddToCartBtn(product.getName());
//        // Thread.sleep(5000);
//        CartPage cartPage = storePage.clickViewCart();
//
//        Assert.assertEquals(cartPage.getProductName(), product.getName(),
//                "Assertion for Product Name that comes after click on View Cart link");
//
//        CheckoutPage checkoutPage = cartPage.checkout();
//
//        // Reusable Method to De-serialize JSON (Generic Method)
//        BillingAddress billingAddress = JacksonUtils.deSerializationJSON(
//                "myBillingAddress.json",BillingAddress.class);
//
//        // Functional Page Object
////        checkoutPage.
////                setBillingAddress(billingAddress).
////                placeOrder();
//
//        // Remove Application State Dependency
//        checkoutPage.
//                setBillingAddress(billingAddress).
//                selectDirectBankTransfer().
//                placeOrder();
//
//        // Thread.sleep(5000);
//
//        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.",
//                "Assertion for Thank you Message that comes after order is placed");
//
//    }
//
//    @Test
//    public void loginAndCheckoutUsingDirectBankTransfer() {
//
//        String searchFor = "Blue";
//        StorePage storePage = new HomePage(driver).
//                load().
//                navigateToStoreUsingMenu().
//                // searchProduct("Blue");
//                 searchProduct(searchFor);
//
////        Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”",
////                "Assertion for Heading that comes after click on Search button");
//
//        Assert.assertTrue(storePage.getTitle().contains("Search results"),
//                "Assertion for Heading that comes after click on Search button");
//
//        // Products - Create JSON Array
//        Product product = new Product(1215);
//        storePage.clickAddToCartBtn(product.getName());
//        // Thread.sleep(5000);
//        CartPage cartPage = storePage.clickViewCart();
//
//        Assert.assertEquals(cartPage.getProductName(), product.getName(),
//                "Assertion for Product Name that comes after click on View Cart link");
//
//        CheckoutPage checkoutPage = cartPage.checkout();
//        checkoutPage.clickHereToLoginLink();
//        // Thread.sleep(3000);
//
//        // Reusable Method to De-serialize JSON (Generic Method)
//        BillingAddress billingAddress = JacksonUtils.deSerializationJSON(
//                "myBillingAddress.json",BillingAddress.class);
//
//        // User - Create Data Object [With Assignment]
//        User user = new User("dummyUser875@gmail.com","HidummyUser");
//
//        // Functional Page Object
////        checkoutPage.
////                login(user).
////                setBillingAddress(billingAddress).
////                placeOrder();
//
//        // Remove Application State Dependency
//        checkoutPage.
//                login(user).
//                setBillingAddress(billingAddress).
//                selectDirectBankTransfer().
//                placeOrder();
//
//        // Thread.sleep(5000);
//
//        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.",
//                "Assertion for Thank you Message that comes after order is placed");
//
//    }
//
//}// _06_Sec_16_01_Maven_MyFirstTC
