package saucedemotest.advanced_test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utility.ExcelReader;
import utility.Utility;

import java.io.File;

public class UDInvalidTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(UDInvalidTest.class.getName());
    String username = prop.getProperty("username");
    String password = prop.getProperty("password");
    LoginPage loginPage = new LoginPage(getDriver());
    ExcelReader excelReader = new ExcelReader(Utility.path+ File.separator+"data"+File.separator+"data.xlsx", "Data");
    @Test
    public void dataReadertest(){
        LoginPage loginPage = new LoginPage(getDriver());

        String expectedTitle = excelReader.getCellValueForGivenKey("Login Page Title");
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        LOG.info("navigate to saucedemo app success");

        // Enter a valid username and password
        loginPage.typeUsername(username);
        loginPage.typePassword("");

        // Click the login button
        loginPage.clickOnLoginBtn();

        // Check if the login is successful (verify that we are on the inventory page)
        String expectedError = excelReader.getCellValueForGivenKey("Missing Password Error");
        String actualError =  loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
        LOG.info("validate error message success");
    }
    @Test
    public void loginWithInvalidUsernameAndValidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        LOG.info("navigate to saucedemo app success");

        // Enter a valid username and password
        loginPage.typeUsername("");
        loginPage.typePassword(password);

        // Click the login button
        loginPage.clickOnLoginBtn();

        // Check if the login is successful (verify that we are on the inventory page)
        String expectedError = excelReader.getCellValueForGivenKey("Missing Username Error");
        String actualError =  loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
        LOG.info("validate error message success");
    }



    /* @Test
    public void test1(){

        //Validate the title
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        LOG.info("navigate to saucedemo app success");
       //Enter  a valid data  for POM
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("");

        //Click login button
        loginPage.clickOnLoginBtn();


        //check if login is successful (verify that we are on the inventory page)
        String expectedError = "Epic sadface: Password is required";
        String actualError = getElementTextNPOM(".error-message-container.error h3");
        Assert.assertEquals(expectedError,actualError);
        LOG.info("validate error massage success");

    }

    @Test
    public void test1NPOM(){

        //Validate the title
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        LOG.info("navigate to saucedemo app success");

        //Enter  a valid data from prop
        loginPage.typeUsername(username);
        loginPage.typePassword("");
        //Click login button
        loginPage.clickOnLoginBtn();

        //check if login is successful (verify that we are on the inventory page)
        String expectedError = "Epic sadface: Password is required";
        String actualError = getElementTextNPOM(".error-message-container.error h3");
        Assert.assertEquals(expectedError,actualError);
        LOG.info("validate error massage success");

    }




    @Test
    public void test2(){

        //Validate the title
        String expectedTitle = "Swag Labs";
        String actualTitle =driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        LOG.info("navigate to saucedemo app success");

        //Enter  a valid data from POM
        loginPage.typeUsername("");
        loginPage.typePassword("secret_sauce");

        //Click login button
        loginPage.clickOnLoginBtn();

        //check if login is successful (verify that we are on the inventory page)
        String expectedError = "Epic sadface: Username is required";
        String actualError = getElementTextNPOM(".error-message-container.error h3");
        Assert.assertEquals(expectedError,actualError);
        LOG.info("validate error massage success");

    }

    @Test
    public void test2Prop(){
        //Validate the title
        String expectedTitle = "Swag Labs";
        String actualTitle =driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        LOG.info("navigate to saucedemo app success");


        //Enter  a valid data from prop
        loginPage.typeUsername("");
        loginPage.typePassword(password);

        //Click login button
        loginPage.clickOnLoginBtn();

        //check if login is successful (verify that we are on the inventory page)
        String expectedError = "Epic sadface: Username is required";
        String actualError = getElementTextNPOM(".error-message-container.error h3");
        Assert.assertEquals(expectedError,actualError);
        LOG.info("validate error massage success");
    }*/


}
