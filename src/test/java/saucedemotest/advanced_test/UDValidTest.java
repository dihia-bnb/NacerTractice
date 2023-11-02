package saucedemotest.advanced_test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelReader;
import utility.Utility;

import java.io.File;

public class UDValidTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(UDValidTest.class.getName());
    String username = prop.getProperty("username");
    String password = prop.getProperty("password");
    ExcelReader excelReader = new ExcelReader(Utility.path+ File.separator+"data"+File.separator+"data.xlsx", "Data");

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // Enter a valid username and password
        loginPage.typeUsername(username);
        loginPage.typePassword(password);

        // Click the login button
        loginPage.clickOnLoginBtn();

        //Check if the login is successful
        String expectedHeader = excelReader.getCellValueForGivenKey("Home Page Header");
        String actualHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHeader, actualHeader);
        LOG.info("login to saucedemo app success");
    }

   /* @Test
    public void test1(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage  = new HomePage(getDriver());

        //Validate the title
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        LOG.info("navigate to saucedemo app success");

        //Enter  a valid data from POM
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");

        //Click login button NPOM
        clickOnNPOM("#login-button");


        //check if login is successful (verify that we are on the inventory page)
        String expectedHeader = "Products";
        String actualHeader =  getElementTextNPOM(".title");
        Assert.assertEquals(expectedHeader,actualHeader);
        LOG.info("login to saucedemo app succes");


    }

    public void testPOM(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage  = new HomePage(getDriver());
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        //Validate the title
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        LOG.info("navigate to saucedemo app success");

        //Enter  a valid data
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        //Click login button
        loginPage.clickOnLoginBtn();

        //check if login is successful (verify that we are on the inventory page)
        String expectedHeader = "Products";
        String actualHeader =  getElementTextNPOM(".title");
        Assert.assertEquals(expectedHeader,actualHeader);
        LOG.info("login to saucedemo app succes");

    }*/



}
