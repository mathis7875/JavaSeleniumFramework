package WalletHub.Pages;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import WH.Test.MasterFramework.WHBaseObjects.DriverContext;
import WH.Test.MasterFramework.WHBaseObjects.WHBasePage;
import WH.Test.MasterFramework.WHBaseObjects.WebControlExtensions;

public class WHInsuranceCompanyReviewPage extends WHBasePage
{
	public  WHInsuranceCompanyReviewPage(WebDriver driver)
	{	
	 super(driver);
	 PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH,using="//*[@name='review']")
	public WebElement yourReview;
	
	@FindBy(how=How.XPATH,using="//*[@class='btn blue']")
	public WebElement submitBttn;
	
	@FindBy(how=How.XPATH,using="//*[@class='dropdown-title']")
	public WebElement dropDownBox;
	
	@FindBy(how=How.XPATH,using="//*[@data-target='Health']")
	public WebElement health;
	
	@FindBy(how=How.XPATH,using="//*[@data-target='Annuities']")
	public WebElement annuitiesDDL;
	
	@FindBy(how=How.XPATH,using="//*[@data-target='Life']")
	public WebElement lifeDDL;
	
	@FindBy(how=How.XPATH,using="//*[@data-target='overall-multiple-products']")
	public WebElement overallProductsDDL;
	
	@FindBy(how=How.XPATH,using="//*[@id='overallRating']/a[5]")
	public WebElement starFive;
	
	@FindBy(how=How.XPATH,using="//*/div[@class='wh-rating-choices']//a[5]")
	public WebElement starFiveHardPress;
	
	@FindBy(how=How.XPATH,using="//*[@class='wh-rating-notes']")
	public WebElement submitYourRating;
	
	public void goToReviewURL(String userName)
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
	
	public void selectFromDropDownMenu(WebDriver driver,String element,String value,String elementType)
	{
		WebControlExtensions.SelectDropDown(driver, element, value, elementType);
	}
	
	public void selectFromDropDownMenuByDDL(String value)
	{
		WebControlExtensions.SelectItemByValueFromDDL(dropDownBox,value);
	}
	
	public void hoverAndClickFifthReviewStar()
		{
			WebControlExtensions.hover(DriverContext.driver, starFive);
			starFive.click();		
		}

	public void jquerySearch()
	{
		
		JavascriptExecutor jse = (JavascriptExecutor)DriverContext.driver;
		URL jqueryUrl = Resources.getResource("jquery-1.8.2.min.js");
		String jqueryText;
		try 
		{  
			jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
			jse.executeScript(jqueryText);
			jse.executeScript("$('5').click();");
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}	
	}

	
	public void checkforSuccessPostMessage()
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
	
	public void enterReview() 
	{ 
		try 
		{
			Thread.sleep(3000);
			//Actions builder = new Actions(DriverContext.driver);
			//Action seriesOfActions = builder.moveToElement(yourReview)
			//.doubleClick(yourReview).build();
			//seriesOfActions.perform();
			yourReview.sendKeys(Keys.TAB);
			yourReview.clear();
			
		   yourReview.sendKeys("A very long string containing \n" +  
	                          "many many words and characters. \n" +
	                          "rrrtrtttrtrttrttttttttttttrttttt\n"+
	                          "A very long string containing \n" +  
	                          "many many words and characters. \n" +
	                          "rrrtrtttrtrttrttttttttttttrttttt\n"+
	                          "many many words and characters. \n" +
	                          "rrrtrtttrtrttrttttttttttttrttttt\n"+
	                          "A very long string containing \n" +  
	                          "many many words and characters. \n" +
	                          "rrrtrtttrtrttrttttttttttttrttttt\n"+
	                         " A very long string containing \n" +  
	                          "many many words and characters. \n" +
	                          "rrrtrtttrtrttrttttttttttttrttttt\n"+
	                          "A very long string containing \n" +  
	                          "many many words and characters. \n" +
	                          "rrrtrtttrtrttrttttttttttttrttttt\n"+
	                          "A very long string containing \n" +  
	                          "many many words and characters. \n" +
	                          "rrrtrtttrtrttrttttttttttttrttttt\n"+
	                          "A very long string containing \n" +  
	                          "many many words and characters. \n" +
	                          "rrrtrtttrtrttrttttttttttttrttttt\n"+
	                          "A very long string containing \n" +  
	                          "many many words and characters. \n" +
	                          "rrrtrtttrtrttrttttttttttttrttttt\n"
				   														);
		} 
		catch 
		(InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
