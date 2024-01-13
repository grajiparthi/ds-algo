package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Faketest {
	
	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new ChromeDriver() ;
	HomePage hp = new HomePage(driver) ;
	RegisterPage rp = new RegisterPage(driver) ;
	//driver.get("https://dsportalapp.herokuapp.com/home");
	driver.get("https://dsportalapp.herokuapp.com/register") ;
	//hp.clickDatastructuresDropdown();
	
	//hp.verifyDatastructuresEntries() ;
	
	//hp.clickGetStartedBtn() ;
	
	//hp.clickDatastructuresOptions() ;
	
	// hp.alertMsgCheck();
	
	//hp.signIn() ;
	//hp.verifyloginPage() ;
	
	//hp.register() ;
	//hp.verifyRegisterPage() ;
	
	rp.registerWithallfieldsEmpty() ;
	rp.errorWithallfieldsEmpty() ;
	rp.registerWithPwdfieldsEmpty() ;
	rp.errorWithPwdfieldsEmpty() ;
	rp.registerWithconfirmPwdEmpty() ;
	rp.errorWithconfirmPwdEmpty() ;
	rp.registerWithDiffPwds() ;
	rp.errorwithDiffPwds() ;
	rp.registerWithPwdlessthanLimit() ;
	rp.erroWithPwdlessthanLimit() ;
	rp.registerWithvalidCredentials() ;
	rp.validateAccountCreation() ;
	
	}
	
	
	
	
}
