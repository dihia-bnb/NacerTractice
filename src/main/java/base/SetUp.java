package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

public class SetUp {
  public   WebDriver driver ;
  @Parameters({"url", "browserName"})
    @BeforeMethod
    public void setUp(String url, String browserName) throws IOException {

        if (browserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
            System.out.println("chrome browser launched");
        } else   if (browserName.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
            System.out.println("firefox browser launched");
        }  else   if (browserName.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
            System.out.println("edge browser launched");
        }

        //maximise window
        driver.manage().window().maximize();
        System.out.println("window maximised");
        //set the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("implicit wait set up");

        //navigate to website
        driver.get(url);

        System.out.println("navigate to "+url+" ...");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
        System.out.println("browser close success");
    }



    /*  Properties prop = new Properties();
        FileInputStream inputStream = new FileInputStream("C:\\Users\\fwzna\\IdeaProjects\\SeleniumProject\\config.properties");
        prop.load(inputStream);
        inputStream.close();
        String browserName = System.getProperty("browser.name");*/
}
