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
package com.learning.pom.api;

import com.learning.pom.utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	
	public static RequestSpecification getRequestSpec() {
		return new RequestSpecBuilder().
					//setBaseUri(Environment.getUrl()).
					setBaseUri(ConfigLoader.getInstance().getBaseUrl()).
					log(LogDetail.ALL).
					build();
	}
	
	public static ResponseSpecification getResponseSpec() {
		return new ResponseSpecBuilder().
//				log(LogDetail.METHOD).
//				log(LogDetail.URI).
//				log(LogDetail.PARAMS).
//				log(LogDetail.STATUS).
//				log(LogDetail.HEADERS).
//				log(LogDetail.COOKIES).
				log(LogDetail.ALL).
				build();
	}
}
