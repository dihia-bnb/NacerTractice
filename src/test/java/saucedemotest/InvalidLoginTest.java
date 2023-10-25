package saucedemotest;

import base.SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends SetUp {


    @Test
    public void test1(){

        //Validate the title
        String expectedTitle = "Swag Labs";
        String actualTitle =driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("navigate to saucedemo app success");
        //find web elements
        WebElement userfield = driver.findElement(By.id("user-name"));
        System.out.println("username field found");
        WebElement passfield = driver.findElement(By.id("password"));
        System.out.println("password field found");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-button']"));
        System.out.println("login button found");

        //Enter  a valid data
        userfield.sendKeys("standard_user");
        System.out.println(" type username success");
        passfield.sendKeys("");
        System.out.println("type password success");
        //Click login button
        loginButton.click();
        System.out.println("click on login button success");

        //check if login is successful (verify that we are on the inventory page)
        String expectedError = "Epic sadface: Password is required";
        String actualError =driver.findElement(By.cssSelector(".error-message-container.error h3")).getText();
        Assert.assertEquals(expectedError,actualError);
        System.out.println("validate error massage success");




    }
    @Test
    public void test2(){
        //Validate the title
        String expectedTitle = "Swag Labs";
        String actualTitle =driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("navigate to saucedemo app success");
        //find web elements
        WebElement userfield = driver.findElement(By.id("user-name"));
        System.out.println("username field found");
        WebElement passfield = driver.findElement(By.id("password"));
        System.out.println("password field found");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-button']"));
        System.out.println("login button found");

        //Enter  a valid data
        userfield.sendKeys("");
        System.out.println(" type username success");
        passfield.sendKeys("secret_sauce");
        System.out.println("type password success");
        //Click login button
        loginButton.click();
        System.out.println("click on login button success");

        //check if login is successful (verify that we are on the inventory page)
        String expectedError = "Epic sadface: Username is required";
        String actualError =driver.findElement(By.cssSelector(".error-message-container.error h3")).getText();
        Assert.assertEquals(expectedError,actualError);
        System.out.println("validate error massage success");


    }
}
