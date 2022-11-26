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

package com.learning.pom.api.actions;

import com.learning.pom.api.ApiRequest;
import com.learning.pom.objects.User;
import com.learning.pom.utils.ConfigLoader;
import com.learning.pom.utils.FakerUtils;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.C;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class CartApi {

    private Cookies cookies;

    // This Default Constructor is for Guest User
    public CartApi() {
    }

    // This Default Constructor is for Logged-in User
    public CartApi(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    // Request URL: https://askomdch.com/?wc-ajax=add_to_cart
    // Request Method: POST
        // formParams.put("product_sku", "");
        // formParams.put("product_id", productID);
        // formParams.put("quantity", productQuantity);
    public Response addToCart(int productID, int productQuantity) {

        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);

        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productID);
        formParams.put("quantity", productQuantity);

        if (cookies == null) {
            // Creating Empty Cookies - For Guest User
            cookies = new Cookies();
        }

//        Response response = given().
//                // ConfigLoader.getInstance().getBaseUrl() -> https://askomdch.com/
//                        baseUri(ConfigLoader.getInstance().getBaseUrl()).
//                headers(headers).
//                formParams(formParams).
//                cookies(cookies).
//                // log().all() -> To log the Request details
//                        log().all().
//                when().
//                // Calling the API using POST as HTTP Method
//                // https://askomdch.com/?wc-ajax=add_to_cart
//                        post("?wc-ajax=add_to_cart").
//                then().
//                // log().all() -> To log the Response details
//                        log().all().
//                extract().
//                response();

        Response response= ApiRequest.post("/?wc-ajax=add_to_cart", headers, formParams, cookies);

        // Checking the Response Status Code
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to add the product " + productID + " to the Cart. " +
                    "HTTP Status Code: " + response.getStatusCode());
        }

        this.cookies = response.getDetailedCookies();
        return response;
    }

    // Guest User
    public static void main_GuestUser(String[] args) {
        // Guest User
        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215,1);
        System.out.println("cartApi.getCookies() = " + cartApi.getCookies());
    }

    // Logged-in User
    public static void main_LoggedInUser(String[] args) {
        // Logged-in User
        String username = "demoUser" + new FakerUtils().generateRandomNumber();
        String password = "demoPwd";
        String email = username + "@gmail.com";
        User user = new User().
                setUsername(username).
                setPassword(password).
                setEmail(email);

        SignupApi signupApi = new SignupApi();
        System.out.println(signupApi.registerUser(user));
        System.out.println("REGISTER COOKIES: "+signupApi.getCookies());
        CartApi cartApi = new CartApi(signupApi.getCookies());
        cartApi.addToCart(1215,1);
        System.out.println("CART COOKIES: " + cartApi.getCookies());
    }

}