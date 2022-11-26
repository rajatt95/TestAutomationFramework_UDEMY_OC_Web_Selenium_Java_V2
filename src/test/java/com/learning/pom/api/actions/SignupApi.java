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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;

public class SignupApi {
    private Cookies cookies;
    public Cookies getCookies(){
        return cookies;
    }

    // Request URL: https://askomdch.com/account
    // Request Method: GET
    private Response getAccount(){
        Cookies cookies = new Cookies();
//        Response response = given().
//                // ConfigLoader.getInstance().getBaseUrl() -> https://askomdch.com/
//                baseUri(ConfigLoader.getInstance().getBaseUrl()).
//                cookies(cookies).
//                // log().all() -> To log the Request details
//                log().all().
//        when().
//            // Calling the API using GET as HTTP Method
//                    // https://askomdch.com/account
//            get("account").
//        then().
//                // log().all() -> To log the Response details
//                log().all().
//                extract().
//                response();

        Response response=ApiRequest.get("account", cookies);

        // Checking the Response Status Code
        if(response.getStatusCode()!=200){
            throw new RuntimeException("Failed to fetch the account , HTTP Status Code: "+response.getStatusCode());
        }
        return response;
    }

    // Parse and Fetch using Groovy GPath
    private String fetchRegisterNonceValueUsingGroovyGPath(){
        Response response = getAccount();
        // Response from getAccount()
            // <input type="hidden" id="woocommerce-register-nonce" name="woocommerce-register-nonce" value="d6cb3d6464"/>
            // We are trying to fetch this value --> d6cb3d6464
        // value -> Attribute key
        return response.htmlPath().getString("**.findAll { it.@name == 'woocommerce-register-nonce' }.@value");
    }

    // Parse and Fetch using JSoup
    private String fetchRegisterNonceValueUsingJSoup(){
        Response response = getAccount();
        // Response from getAccount()
            // <input type="hidden" id="woocommerce-register-nonce" name="woocommerce-register-nonce" value="d6cb3d6464"/>
            // We are trying to fetch this value --> d6cb3d6464

        Document doc = Jsoup.parse(response.body().prettyPrint());
        // #woocommerce-register-nonce -> CSS Locator to find the element
        Element element = doc.selectFirst("#woocommerce-register-nonce");
        // value -> Attribute key
        return element.attr("value");
    }

    // Request URL: https://askomdch.com/register
    // Request Method: POST
        // formParams.put("username",user.getUsername());
        // formParams.put("email",user.getEmail());
        // formParams.put("password",user.getPassword());
        // formParams.put("woocommerce-register-nonce",fetchRegisterNonceValueUsingJSoup());
        // formParams.put("register","Register");
    public Response registerUser(User user){
        Cookies cookies = new Cookies();

        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);

        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("username",user.getUsername());
        formParams.put("email",user.getEmail());
        formParams.put("password",user.getPassword());
        formParams.put("woocommerce-register-nonce",fetchRegisterNonceValueUsingJSoup());
        formParams.put("register","Register");

//        Response response = given().
//                    // ConfigLoader.getInstance().getBaseUrl() -> https://askomdch.com/
//                            baseUri(ConfigLoader.getInstance().getBaseUrl()).
//                    headers(headers).
//                    formParams(formParams).
//                    cookies(cookies).
//                    // log().all() -> To log the Request details
//                            log().all().
//                when().
//                    // Calling the API using POST as HTTP Method
//                    // https://askomdch.com/register
//                    post("register").
//                then().
//                    // log().all() -> To log the Response details
//                    log().all().
//                    extract().
//                    response();

        //Response response=ApiRequest.post(Endpoint.ACCOUNT.url, headers, formParams, cookies);
        Response response=ApiRequest.post("/account", headers, formParams, cookies);

        // Checking the Response Status Code
        if(response.getStatusCode()!=302){
            throw new RuntimeException("Failed to register the account , HTTP Status Code: "+response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }

    public static void main(String[] args) {
        // new SignupApi().getAccount();
        // System.out.println("new SignupApi().fetchRegisterNonceValueUsingGroovyGPath() = " +
                // new SignupApi().fetchRegisterNonceValueUsingGroovyGPath());
//        System.out.println("new SignupApi().fetchRegisterNonceValueUsingJSoup() = " +
//                new SignupApi().fetchRegisterNonceValueUsingJSoup());

        String username = "demoUser" + new FakerUtils().generateRandomNumber();
        String password = "demoPwd";
        String email = username + "@gmail.com";

        User user = new User().
                setUsername(username).
                setPassword(password).
                setEmail(email);

        System.out.println("=============================="+"new SignupApi().registerUser(user) = ");
        System.out.println(new SignupApi().registerUser(user));
        System.out.println("=============================="+"new SignupApi().getCookies() = " );
        System.out.println(new SignupApi().getCookies());

    }

}
