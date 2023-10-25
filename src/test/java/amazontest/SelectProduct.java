package amazontest;

import base.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectProduct  extends SetUp {

    @Test
    public void test1() throws InterruptedException {
        WebElement dropdown =driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Baby");
        System.out.println("baby department is selected");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("crib");
        System.out.println("type crib on the search field successfully");
        Thread.sleep(600);

    }
}
