///**
// # * @author Rajat Verma
// # * https://www.linkedin.com/in/rajat-v-3b0685128/
// # * https://github.com/rajatt95
// # * https://rajatt95.github.io/
// # *
// # * Course: Selenium Java Test Framework & Best Practices - Masterclass (https://www.udemy.com/course/selenium-java-test-framework/)
// # * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
// # * Learnings from Other Courses - https://github.com/stars/rajatt95/lists/udemy-omprakash-chavan
// # */
///***************************************************/
//
//package com.learning.Z_learningsFromStart;
//
//import com.learning.pom.base.BaseTest;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class _02_Sec_09_01_POM_MyFirstTC extends BaseTest {
//
//    @Test
//    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
//
//        driver.get("https://askomdch.com/");
//
//        System.out.println("Clicking on Store");
//        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
//
//        System.out.println("Filling 'Blue' in search box");
//        driver.findElement(By.xpath("//input[@id='woocommerce-product-search-field-0']")).sendKeys("Blue");
//
//        System.out.println("Clicking on Search button");
//        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
//
//
//        System.out.println("Assertion for Heading that comes after click on Search button");
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
//                "Search results: “Blue”",
//                "Assertion for Heading that comes after click on Search button"
//        );
//
//        System.out.println("Clicking on Add To Cart button");
//        driver.findElement(By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']")).click();
//
//        System.out.println("Clicking on View Cart link");
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();
//
//        System.out.println("Assertion for Product Name that comes after click on View Cart link");
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
//                "Blue Shoes",
//                "Assertion for Product Name that comes after click on View Cart link"
//        );
//
//        System.out.println("Clicking on Proceed to Checkout button");
//        driver.findElement(By.xpath("//a[normalize-space()='Proceed to checkout']")).click();
//
//        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//        driver.findElement(By.id("billing_email")).sendKeys("dummyUser875@gmail.com");
//        driver.findElement(By.id("place_order")).click();
//
//        Thread.sleep(5000);
//        Assert.assertEquals(
//                driver.findElement(By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")).getText(),
//                "Thank you. Your order has been received.",
//                "Assertion for Thank you Message that comes after order is placed"
//        );
//
//    }
//
//    @Test
//    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
//
//        driver.get("https://askomdch.com/");
//
//        System.out.println("Clicking on Store");
//        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
//
//        System.out.println("Filling 'Blue' in search box");
//        driver.findElement(By.xpath("//input[@id='woocommerce-product-search-field-0']")).sendKeys("Blue");
//
//        System.out.println("Clicking on Search button");
//        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
//
//
//        System.out.println("Assertion for Heading that comes after click on Search button");
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
//                "Search results: “Blue”",
//                "Assertion for Heading that comes after click on Search button"
//        );
//
//        System.out.println("Clicking on Add To Cart button");
//        driver.findElement(By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']")).click();
//
//        System.out.println("Clicking on View Cart link");
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();
//
//        System.out.println("Assertion for Product Name that comes after click on View Cart link");
//        Assert.assertEquals(
//                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
//                "Blue Shoes",
//                "Assertion for Product Name that comes after click on View Cart link"
//        );
//
//        System.out.println("Clicking on Proceed to Checkout button");
//        driver.findElement(By.xpath("//a[normalize-space()='Proceed to checkout']")).click();
//
//        driver.findElement(By.cssSelector(".showlogin")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.id("username")).sendKeys("dummyUser875@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("HidummyUser");
//        driver.findElement(By.cssSelector("button[value='Login']")).click();
//
//
//        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//
//        driver.findElement(By.id("billing_email")).clear();
//        driver.findElement(By.id("billing_email")).sendKeys("dummyUser875@gmail.com");
//        driver.findElement(By.id("place_order")).click();
//
//        Thread.sleep(5000);
//        Assert.assertEquals(
//                driver.findElement(By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")).getText(),
//                "Thank you. Your order has been received.",
//                "Assertion for Thank you Message that comes after order is placed"
//        );
//
//    }
//
//
//}// _02_Sec_09_01_POM_MyFirstTC
