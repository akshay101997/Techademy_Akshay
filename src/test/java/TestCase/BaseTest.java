package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import PageObject.PageElements;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    WebDriver driver;
    Actions action;
    JavascriptExecutor js;
    SoftAssert softAssert;
    PageElements FP;

    
	@BeforeClass
	public void setUp() 
	{
		//System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        PageElements FP = new PageElements(driver);        
	}
	
	   @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	
	
}

