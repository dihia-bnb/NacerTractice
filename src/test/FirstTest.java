package test;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;


public class FirstTest {

    public static void main(String[] args) throws InterruptedException {

        // driver is only 4.6 and dwon
       // System.setProperty("webdriver.chrome.driver","C:\\Users\\fwzna\\IdeaProjects\\SeleniumProject\\driver\\chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver","C:\\Users\\fwzna\\IdeaProjects\\SeleniumProject\\driver\\geckodriver.exe");
        //launch the Firefox browser


       // WebDriver driver = new FirefoxDriver();
       // WebDriver driver = new EdgeDriver();
        WebDriver driver = new ChromeDriver();
        System.out.println("chrome browser launch successfully");
        driver.manage().window().maximize();

        //navigate to to wwww.amazon.com
        driver.get("https://www.amazon.com/");

        String currentTitle = driver.getTitle();
        Assert.assertEquals("Amazon.com. Spend less. Smile more.",currentTitle);
        System.out.println("amazon main page loaded successfully");

        //type "java book" in search field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
        System.out.println("type java book on the search field successfully");

        //click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        String currentText = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]")).getText();
        System.out.println("text is: "+currentText);
        assertTrue(currentText.contains("results for"));
        System.out.println("search page loaded successfully");


        Thread.sleep(6000);
        driver.navigate().back();
        driver.close();


    }
}
