package WalletHub.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import WH.Test.MasterFramework.WHBaseObjects.DriverContext;
import WH.Test.MasterFramework.WHBaseObjects.WHBasePage;
import WH.Test.MasterFramework.WHBaseObjects.WebControlExtensions;


public class WHProfileLightUserPage extends WHBasePage
{
	
	 public  WHProfileLightUserPage(WebDriver driver)
		{	
		 super(driver);
		 PageFactory.initElements(driver,this);
		}
	 
		@FindBy(how=How.XPATH,using="//*[@class='remove']")
		public WebElement removeReview;
		
		@FindBy(how=How.XPATH,using="//*[@href='/profile/mrmathisyoung/reviews/']")
		public WebElement reviewTab;
		
		@FindBy(how=How.XPATH,using="//*[@class='remove' and(contains(text(),'Remove'))]")
		public WebElement removeCompanyReview;
		
		
		//Menu Items 
		
		public void selectReviewTab()
		{
			JavascriptExecutor js = (JavascriptExecutor)DriverContext.driver;
	        js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",
	        DriverContext.driver.findElements(By.xpath("//*[@href='/profile/mrmathisyoung/reviews/']")));
		}
		public void selectMenuProfile()
		{
		  JavascriptExecutor js = (JavascriptExecutor)DriverContext.driver;
	        js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",
	        DriverContext.driver.findElements(By.xpath("//*[@class='remove']")));
	      
		}
		
		public static void selectMenuSettings()
		{
			
			JavascriptExecutor js = (JavascriptExecutor)DriverContext.driver;
	        js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",
	        DriverContext.driver.findElements(By.xpath("[//*[@href='/settings/']")));
			
		}
		
		
		public static void selectMenuLgout()
		{
			JavascriptExecutor js = (JavascriptExecutor)DriverContext.driver;
        js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",
        DriverContext.driver.findElements(By.xpath("//*[@href='/settings/']")));
			
		}

		//End Menu Items
		
		public static void goToReviewURL(String userName)
		{
		 try 
		 {
			Thread.sleep(3000);
			DriverContext.driver.navigate().to("https://wallethub.com/profile/"+userName+"/reviews/");			
		} 
		 catch (InterruptedException e) {
			e.printStackTrace();
		  }
		}
		
		public static void goToInfoURL(String userName)
		{  
			try 
			{
				Thread.sleep(3000);
				DriverContext.driver.navigate().to("https://wallethub.com/profile/"+userName+"/info/");			
			} 
			catch (InterruptedException e) {				
				e.printStackTrace();
			}			
		}
		
		public void removeReviewCleanUp()
		{
			try {
				Thread.sleep(3000);
				removeCompanyReview.click();
				WebDriverWait wait = new WebDriverWait(DriverContext.driver, 4);
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='remove' and(contains(text(),'Remove'))]")));
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
		public void validateReviewPost()
		{
			try 
			{
				Thread.sleep(4000);
				DriverContext.driver.getPageSource().contains("Awesome!");
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void validatePost()
		{
			try 
			{
				Thread.sleep(4000);

				JavascriptExecutor js = (JavascriptExecutor)DriverContext.driver;
		        js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",
		        DriverContext.driver.findElements(By.xpath("//*[@href='/profile/mrmathisyoung/reviews/']")));
				Assert.assertTrue(DriverContext.driver.getPageSource().contains("Test Insurance Company"));
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
}


