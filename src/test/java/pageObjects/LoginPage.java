package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	public WebDriver driver ;
	
	@FindBy (xpath = "//input[@id='id_username']") WebElement userName ;
	@FindBy (xpath = "//input[@id='id_password']") WebElement passWord ; 
	@FindBy (xpath = "//input[@type='submit']") WebElement loginBtn ;
	@FindBy (xpath = "//div[@class='alert alert-primary']") WebElement loginSuccessMsg ;
	@FindBy (xpath = "//div[contains(text(), 'Invalid Username and Password')]") WebElement invalidLoginMsg ;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver,this);
		//driver.findElement(By.xpath("//input[@id='id_username']")) ;
		
	}
	
	public void enterUsername(String username) {
		userName.sendKeys(username);
		
	}
	
	public void enterPassword(String password) {
		passWord.sendKeys(password);
		
	}
	
	public void clickLoginbtn() {
		loginBtn.click();
	}
	
	public void verifySuccessfulLogin() {
		
		String msg = loginSuccessMsg.getText() ;
		Assert.assertEquals(msg, "You are logged in");
		
	}
	
	public boolean invalidLogin() {
		
		return invalidLoginMsg.isDisplayed() ;
	}
	
	public void doLogin(String un, String pwd) {
		System.out.println("login with : " + un + "and" + pwd );
		userName.sendKeys(un) ;
		passWord.sendKeys(pwd) ;
		loginBtn.click() ;
		String msg = loginSuccessMsg.getText() ;
		Assert.assertEquals(msg, "You are logged in");
		
	}
	
	

}
