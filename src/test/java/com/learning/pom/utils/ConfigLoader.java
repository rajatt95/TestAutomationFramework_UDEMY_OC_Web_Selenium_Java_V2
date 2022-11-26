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

import com.learning.pom.enums.EnvType;

import java.util.Properties;

public class ConfigLoader {

    private String path_resources_test = "src/test/resources/";
    private String file_properties_extension = ".properties";
    private String config_qa_FilePath = path_resources_test + "config-qa"+ file_properties_extension;
    private String config_stg_FilePath = path_resources_test + "config-stg"+ file_properties_extension;
    private String config_uat_FilePath = path_resources_test + "config-uat"+ file_properties_extension;


    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){

        // Setting QA as the default environment
            // This can be overridden by passing parameter using Maven Command Line
        String env = System.getProperty("env", EnvType.QA.toString());

        switch (EnvType.valueOf(env)){
            case QA:
                properties = PropertyUtils.propertyLoader(config_qa_FilePath);
                break;
            case STAGE:
                properties = PropertyUtils.propertyLoader(config_stg_FilePath);
                break;
            case UAT:
                properties = PropertyUtils.propertyLoader(config_uat_FilePath);
                break;
            default:
                throw new IllegalStateException("Invalid ENV type: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        // If configLoader == null,
            // It means no instance of this class has been created
        if (configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop !=null){
            return prop;
        }else {
            throw new RuntimeException("Property "+"\"baseUrl\""+" is not specified in the config file.");
        }
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop !=null){
            return prop;
        }else {
            throw new RuntimeException("Property "+"\"username\""+" is not specified in the config file.");
        }
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop !=null){
            return prop;
        }else {
            throw new RuntimeException("Property "+"\"password\""+" is not specified in the config file.");
        }
    }



}// ConfigLoader





