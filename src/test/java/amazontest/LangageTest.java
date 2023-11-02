package amazontest;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LangageTest extends CommonAPI {
    @Test
    public void test() throws InterruptedException {
        Actions actions=new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
        actions.moveToElement(element).build().perform();
        Thread.sleep(600);
    }

    @Test
    public void testAdvanced(){
        hoverOverNPOM("//span[text()='Hello, sign in']");
    }
}
