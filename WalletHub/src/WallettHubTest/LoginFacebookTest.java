package WallettHubTest;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import WH.Test.MasterFramework.WHBaseObjects.WHBase;
import WalletHub.Pages.FBHomePage;
import WalletHub.Pages.FBLoginPage;


public class LoginFacebookTest extends WHBase
{	
	  @Test
	  @Parameters({ "browserName"})
	  public void  givenIm_FBUser_WhenIGo_ToTheLoginPage_IClickLogin(@Optional("chrome")String browserName) 
	  {	 
		  setup(browserName);
		  intiateFaceBookBrowser();
		  currentPage =  getInstance(FBLoginPage.class);
		  currentPage.As(FBLoginPage.class).loginFBuser("mrmathisyoung@gmail.com","Algebra2");
		  currentPage = getInstance(FBHomePage.class);
		  currentPage.As(FBHomePage.class).validateLoginSucess();
	  }  
	
	  @Test
	  @Parameters({ "browserName"})
	  public void  givenIm_FBUser_WhenIGo_ToTheLoginPage_ILogin_And_MakePost(@Optional("chrome")String browserName) 
	  {	 
		  setup(browserName);
		  intiateFaceBookBrowser();
		  currentPage =  getInstance(FBLoginPage.class);
		  currentPage.As(FBLoginPage.class).loginFBuser("mrmathisyoung@gmail.com","Algebra2");
		  currentPage = getInstance(FBHomePage.class);
		  currentPage.As(FBHomePage.class).makeFaceBookPost();
	  }  
}
