package WallettHubTest;


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import WH.Test.MasterFramework.WHBaseObjects.WHBase;
import WalletHub.Pages.LoginPage;

public class LoginTest extends WHBase
{
	
  @Test
  @Parameters({ "browserName"})
  public void  givenIm_WHUser_WhenIGo_ToTheLoginPage_IClickLogin(@Optional("chrome")String browserName) 
  {	 
	  setup(browserName);
	  intiateWalletHubBrowser();
	  currentPage =  getInstance(LoginPage.class);
	  currentPage.As(LoginPage.class).loginWalletHubUser();	 
  }   
}
