package WalletHub.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import WH.Test.MasterFramework.WHBaseObjects.DriverContext;
import WH.Test.MasterFramework.WHBaseObjects.WHBasePage;
import WH.Test.MasterFramework.WHBaseObjects.WebControlExtensions;

public class WHInsuranceCompanyPage extends WHBasePage
{
	 public  WHInsuranceCompanyPage(WebDriver driver)
		{	
		 super(driver);
		 PageFactory.initElements(driver,this);
		}
	 
	 	@FindBy(how=How.XPATH,using="//*[@class='wh-rating-notes']")
		public WebElement submitYourRating;
	 	
	 	@FindBy(how=How.XPATH,using="//*/div[@class='wh-rating-choices']//a[1]")
		public WebElement starOne;
		
	 	@FindBy(how=How.XPATH,using="//*/div[@class='wh-rating-choices']//a[2]")
		public WebElement starTwo;
	 	
	 	@FindBy(how=How.XPATH,using="//*/div[@class='wh-rating-choices']//a[3]")
		public WebElement starThree;
	 	
	 	@FindBy(how=How.XPATH,using="//*/div[@class='wh-rating-choices']//a[4]")
		public WebElement starFour;
	 	
	 	@FindBy(how=How.XPATH,using="//*/div[@class='wh-rating-choices']//a[5]")
		public WebElement starFive;
	 	
		@FindBy(how=How.XPATH,using="//*/div[@class='wh-rating-choices']//a[5]")
		public WebElement starFiveHardPress;
	 	

		public void goToCompanyInsurancePage()
		{
		 try 
		 {
			Thread.sleep(3000);
			 DriverContext.driver.navigate().
			 to("Https://www.wallethub.com/profile/test_insurance_company/");
		 }
		 catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	 		 	
	 	public void validateStarsLightUp()
	 	{
	 		try 
	 		{
				Thread.sleep(1000);
				boolean result = starOne.isDisplayed()&&
		 				starTwo.isDisplayed()&&
		 				starThree.isDisplayed()&&
		 				starFour.isDisplayed()&&
		 				starFive.isDisplayed();
		 				Assert.assertTrue(result);
			} 
	 		catch (InterruptedException e) {
				e.printStackTrace();
			}	
	 	}
 	
	 	public void hoverOverSubmitRating()
	 	{   
	 		try 
	 	{
			Thread.sleep(1000);
			WebControlExtensions.hover(DriverContext.driver,submitYourRating);
		} 
	 	catch (InterruptedException e) {
			e.printStackTrace();
		}
	 		 		
	  }
	 	
	 	public void hoverAndClickFifthReviewStar()
 		{
			WebControlExtensions.hover(DriverContext.driver,submitYourRating);
			if(starFive.isEnabled())
			{  
				try {
				Thread.sleep(2000);
				WebControlExtensions.hover(DriverContext.driver, starFive);
				starFive.click();	
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}	
			} 
			else
			{
				WebControlExtensions.hover(DriverContext.driver, starFiveHardPress);
			    starFiveHardPress.click();	
	  		  }
			}
}
