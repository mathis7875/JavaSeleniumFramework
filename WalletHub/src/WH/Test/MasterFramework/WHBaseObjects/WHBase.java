package WH.Test.MasterFramework.WHBaseObjects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class WHBase 
{
	public static WHBasePage currentPage;

	public static <T extends WHBasePage> T getInstance(Class<T> page) {

		Object obj = PageFactory.initElements(DriverContext.driver, page);
	    return page.cast(obj);	
	}	
	
	public void setup(String browserName)
	{
		System.setProperty("webdriver.chrome.driver","C://Projects//WalletHub//WalletHub//chromedriver_win32//chromedriver.exe");
		
		if(browserName.equals("ie"))
			DriverContext.driver = new InternetExplorerDriver();
		else if (browserName.equals("chrome"))
			DriverContext.driver = new ChromeDriver();
		else 
		    DriverContext.driver = new FirefoxDriver();
		
		    DriverContext.driver.manage().window().maximize();	
	}
	
	 public void intiateWalletHubBrowser()
     {	 
         DriverContext.driver.navigate().to("https://wallethub.com/join/login");
     }
	 
	 public void intiateFaceBookBrowser()
     {
         DriverContext.driver.navigate().to("https://www.facebook.com");
     }
	 
	 public void intiateInsuranceCompanyBrowser()
	 {
		 DriverContext.driver.navigate().
		 to("https://mrmathisyoung@gmail.com:Abcd123*@www.wallethub.com/profile/test_insurance_company/");
	 }
	 
	 @AfterTest
	 @AfterMethod
	 public void tearDown()
	 {       
	       DriverContext.driver.quit();
	 }
}


