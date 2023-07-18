package TestCase;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Filpkart_01 extends BaseTest {
	
	@Test(priority=0)
	public void popupVerification()
{
		if(FP.getPopup().isDisplayed()) {
			FP.getClosepopup().click();
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false,"pop up not closed");
		}
		
	}
	@Test(priority =2, dependsOnMethods = "popupVerification")
	public void flipkartLogo() {
		if(FP.getFlipkartlogo().isDisplayed())
		{
			Assert.assertTrue(true,"Flipkart logo is present");
			int logoLocation = FP.getFlipkartlogo().getLocation().getX();
			
			if(logoLocation<500)
			{
				Assert.assertTrue(true,"Logo is on left side");
			}
			else 
			{
				Assert.assertTrue(false,"Logo is not left side");
			}
		}
		
		else 
		{
			Assert.assertTrue(false,"Flipkart logo is not present");
		}
	}
	
	
	@Test(priority = 3, dependsOnMethods = "flipkartLogo")
	public void searchItem()
	{
		FP.getSearch().sendKeys("iphone 14");
		FP.getSearch().sendKeys(Keys.ENTER);
		System.out.println(FP.getProducts().size());
		String firstItem = FP.getFirst().getText();
		FP.getFirst().click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> li = handler.iterator();
		String ParentHandleId = li.next();
		String ChildHandleId = li.next();
		driver.switchTo().window(ChildHandleId);
		String selectedFirstItemTitle = driver.getTitle();
		
		if(driver.getPageSource().contains(firstItem)|| selectedFirstItemTitle.contains("APPLE iPhone 14 (Midnight, 128 GB)")) 
		{
			Assert.assertTrue(true,"Navigated to product page");
		}
		else 
		{
			Assert.assertTrue(false,"Not Navigated to product page");
		}
	}
	
}

