package WalletHub.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import WH.Test.MasterFramework.WHBaseObjects.WHBasePage;


public class FBLoginPage extends WHBasePage
{
	 public  FBLoginPage (WebDriver driver)
	{	
		 super(driver);
	 PageFactory.initElements(driver,this);
	}
     
	@FindBy(how=How.XPATH,using="//*[@id='email']")
	public WebElement userNameFB;
	
	@FindBy(how=How.XPATH,using="//*[@id='pass']")
	public WebElement userPasswordFB;
    
	@FindBy(how=How.XPATH,using="//*[@class='uiButton uiButtonConfirm']")
	public WebElement loginBttnFB;
	
	

	public void loginFBuser(String username, String password)
	{
		try 
		{
			Thread.sleep(5000);
			userNameFB.sendKeys(username);
			userPasswordFB.sendKeys(password);
			loginBttnFB.click();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}


