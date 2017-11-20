package WalletHub.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import WH.Test.MasterFramework.WHBaseObjects.DriverContext;
import WH.Test.MasterFramework.WHBaseObjects.WHBasePage;

public class FBHomePage extends WHBasePage
{
	 public  FBHomePage (WebDriver driver)
		{	
			 super(driver);
		 PageFactory.initElements(driver,this);
		}

	 @FindBy(how=How.XPATH,using="//*[@name='xhpc_message']")
	 public WebElement makePost;
	
	 
	 @FindBy(how=How.XPATH,using="//*/button[contains(.,'Post')]")
	 public WebElement postBttn;
	 
	 @FindBy(how=How.XPATH,using="//div[@id='userNavigationLabel']")
	 public WebElement userAdminMenu;
 
	 @FindBy(how=How.XPATH,using="//*[@id='u_k_3']")
	 public WebElement logOutMenu;
	 

	 public void logOutAccount()
	 {  
		 try 
		 {
			Thread.sleep(3000);
			 userAdminMenu.click();
			 JavascriptExecutor js = (JavascriptExecutor)DriverContext.driver;
			js.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)",DriverContext.driver.findElements(By.xpath("//a[contains(@data-gt,'menu_logout')]")));
		} 
		 catch (InterruptedException e) {
			e.printStackTrace();
		}	
	 }	
	 
	 public void makeFaceBookPost()
	 {
		 try 
		 {
			Thread.sleep(5000);
			 //makePost.click();
			 makePost.sendKeys(Keys.TAB);
			 makePost.sendKeys("Hello World");
			 postBttn.click();
		 } 
		 catch (InterruptedException e) {
			e.printStackTrace();
		}		 
	 }
	 
	 public void validateLoginSucess()
	 {
		 DriverContext.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 Assert.assertTrue(DriverContext.driver.getPageSource().contains("Matt Smith"));		 	 
   }
}


