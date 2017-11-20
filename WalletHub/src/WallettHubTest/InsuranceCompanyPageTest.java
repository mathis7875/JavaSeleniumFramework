package WallettHubTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import WH.Test.MasterFramework.WHBaseObjects.WHBase;
import WalletHub.Pages.LoginPage;
import WalletHub.Pages.WHInsuranceCompanyPage;
import WalletHub.Pages.WHInsuranceCompanyReviewPage;
import WalletHub.Pages.WHProfileLightUserPage;


public class InsuranceCompanyPageTest extends WHBase
{
	
	  @Test
	  @Parameters({ "browserName"})
	  public void  givenIm_WHLightUser_WhenIGo_ToInsurancePage_IHoverOverRatiingStars(@Optional("chrome")String browserName) 
	  {	 
		  setup(browserName);
		  intiateInsuranceCompanyBrowser();
		  currentPage =  getInstance(WHInsuranceCompanyPage.class);
		  currentPage.As(WHInsuranceCompanyPage.class).hoverOverSubmitRating();
		  currentPage.As(WHInsuranceCompanyPage.class).validateStarsLightUp();
	  }  
	  
	  @Test
	  @Parameters({ "browserName"})
	  public void givenIm_WHLightUser_ILogin_And_MakeAReview_ThenValidateItPosted(@Optional("chrome")String browserName)
	  {
		  setup(browserName);
		  intiateWalletHubBrowser();
		  currentPage =  getInstance(LoginPage.class);
		  currentPage.As(LoginPage.class).lightUserAccount();
		  currentPage =  getInstance(WHInsuranceCompanyPage.class);
		  currentPage.As(WHInsuranceCompanyPage.class).goToCompanyInsurancePage();
		  currentPage.As(WHInsuranceCompanyPage.class).hoverAndClickFifthReviewStar();
		  currentPage = getInstance(WHInsuranceCompanyReviewPage.class);
		  currentPage.As(WHInsuranceCompanyReviewPage.class).dropDownBox.click();
		  currentPage.As(WHInsuranceCompanyReviewPage.class).health.click();
		  currentPage.As(WHInsuranceCompanyReviewPage.class).hoverAndClickFifthReviewStar();
		  currentPage.As(WHInsuranceCompanyReviewPage.class).yourReview.sendKeys(Keys.TAB);
		  currentPage.As(WHInsuranceCompanyReviewPage.class).enterReview();
		  currentPage.As(WHInsuranceCompanyReviewPage.class).submitBttn.click();
		  currentPage.As(WHInsuranceCompanyReviewPage.class).checkforSuccessPostMessage();
		  currentPage =getInstance(WHProfileLightUserPage.class);
		  currentPage.As(WHProfileLightUserPage.class).selectMenuProfile();
		  currentPage.As(WHProfileLightUserPage.class).selectReviewTab();
		  currentPage.As(WHProfileLightUserPage.class).validateReviewPost();
		  currentPage.As(WHProfileLightUserPage.class).validatePost();
		  
	  }   
}
