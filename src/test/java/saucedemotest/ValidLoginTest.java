package saucedemotest;

import base.SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLoginTest extends SetUp {
    @Test
    public  void test() {

        //validate the title
        String expectedTitle = "Swag Labs";
        String actualTitle =driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("navigate to saucedemo app success");
        //find web elements
        WebElement userfield = driver.findElement(By.id("user-name"));
        System.out.println("Username field found");
        WebElement passfield = driver.findElement(By.id("password"));
        System.out.println("Password field found");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-button']"));
        System.out.println("login button found");

        //Enter  a valid data
        userfield.sendKeys("standard_user");
        System.out.println("type Username  success");
        passfield.sendKeys("secret_sauce");
        System.out.println("type Password  success");
        //Click login button
        loginButton.click();
        System.out.println("click on the login button success");

        //check if login is successful (verify that we are on the inventory page)
        String expectedHeader = "Products";
        String actualHeader =driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(expectedHeader,actualHeader);
        System.out.println("login to saucedemo app success");


    }
}
