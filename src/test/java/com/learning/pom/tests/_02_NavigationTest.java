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
import com.learning.pom.pages.HomePage;
import com.learning.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;





public class _02_NavigationTest extends BaseTest {

    @Test
    public void navigateFromHomeToStoreUsingMainMenu(){

        StorePage storePage = new HomePage(getDriver()).
                load().
                getMyHeader().navigateToStoreUsingMenu();

        Assert.assertTrue(storePage.getTitle().contains("Store"),
                "Assertion for Heading that comes after landing on Store Page.");

    }
}








