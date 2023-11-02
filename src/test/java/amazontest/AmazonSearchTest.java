package amazontest;
import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AmazonSearchTest extends CommonAPI {

    @Test
    public  void test(){

        // driver is only 4.6 and dwon
        // System.setProperty("webdriver.chrome.driver","Pathdriver");

        //navigate to to wwww.amazon.com
        String currentTitle = driver.getTitle();
        Assert.assertEquals("Amazon.com. Spend less. Smile more.",currentTitle);
        System.out.println("amazon main page loaded successfully");
        //type "java book" in search field
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("java book");
        System.out.println("type java book on the search field successfully");

        //click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        String currentText = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]")).getText();
        System.out.println("text is: "+currentText);
        Assert.assertTrue(currentText.contains("results for"));
        System.out.println("search page loaded successfully");

      // Thread.sleep(6000);
        driver.navigate().back();

    }
    @Test
    public  void advancedTest(){
        //navigate to to wwww.amazon.com
        String currentTitle = getCurrentTitle();
        Assert.assertEquals("Amazon.com. Spend less. Smile more.",currentTitle);
        System.out.println("amazon main page loaded successfully");
        //type "java book" in search field
        typeNPOM("#twotabsearchtextbox", "java book");
        System.out.println("type java book on the search field successfully");
        //click on search button
        clickOnNPOM("#nav-search-submit-button");
        String currentText = getElementTextNPOM("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]");
        System.out.println("text is: "+currentText);
        Assert.assertTrue(currentText.contains("results for"));
        System.out.println("search page loaded successfully");

    }



}
