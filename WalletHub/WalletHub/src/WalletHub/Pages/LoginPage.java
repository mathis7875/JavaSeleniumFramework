package WalletHub.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import WH.Test.MasterFramework.WHBaseObjects.WHBasePage;


public class LoginPage extends WHBasePage
{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
        PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='join-login']/form/div[1]/input")
	public WebElement userName;
	
	@FindBy(how=How.XPATH,using="//*[@id='join-login']/form/div[2]/input")
	public WebElement userPassword;
    
	@FindBy(how=How.XPATH,using="//*[@id='join-login']/form/div[4]/button[2]")
	public WebElement loginBttn;
	
	public void loginWalletHubUser() 
	{
		try 
		{
			Thread.sleep(5000);
			userName.clear();
			userName.sendKeys("mrmathisyoung@gmail.com");
			userPassword.sendKeys("Algebra2");
			loginBttn.click();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}	
	
	public void lightUserAccount() 
	{
		try 
		{
			Thread.sleep(5000);
			userName.sendKeys("mrmathisyoung@gmail.com");
			userPassword.sendKeys("Abcd123*");
			loginBttn.click();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
