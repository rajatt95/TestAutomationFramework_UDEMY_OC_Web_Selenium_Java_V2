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

package com.learning.pom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

	// Billing Address: De-serialize JSON
//	public static BillingAddress deSerializationJSON(InputStream is, BillingAddress billingAddress){
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			return objectMapper.readValue(is, billingAddress.getClass());
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}

	// Reusable Method to De-serialize JSON
		// Generic method -. can be used for any class
	public static <T> T deSerializationJSON(String fileName, Class <T> T){
		InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(is, T);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}// JacksonUtils