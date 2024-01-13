package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage {

	WebDriver driver ;
	
	@FindBy (xpath = "//input[@value='Register']") WebElement registerBtn ;
	//@FindBy (xpath = "//*[contains(text(), 'Please fill out this field.')]") WebElement errorMsg1 ;
	//@FindBy (xpath = "//input[@name='csrfmiddlewaretoken']") WebElement errorMsg1 ;
	@FindBy (xpath = "//input[@id='id_username']") WebElement userName ;
	@FindBy (xpath = "//input[@id = 'id_password1']") WebElement password ;
	@FindBy (xpath = "//input[@id='id_password2']") WebElement confirmPassword ;
	@FindBy (xpath = "//div[@class='alert alert-primary']") WebElement pwdMismatchError ;
	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		//driver.findElement(By.xpath("//input[@value='Register']")) ;
	}
	
	public void registerWithallfieldsEmpty() throws InterruptedException {
		registerBtn.click();
		Thread.sleep(3000);
	}
	
	public void errorWithallfieldsEmpty() throws InterruptedException {
		Thread.sleep(3000);
		
		String msg1 = userName.getAttribute("validationMessage") ;
		//System.out.println(msg1);
		Assert.assertEquals(msg1, "Please fill out this field.");
		
	}
	
	public void registerWithPwdfieldsEmpty() {
		
		userName.sendKeys("winterchamps");
		registerBtn.click();
		
	}
	
	public void errorWithPwdfieldsEmpty() {
		
		String msg = password.getAttribute("validationMessage") ;
		//System.out.println(msg);
		Assert.assertEquals(msg, "Please fill out this field.");
	}
	
	public void registerWithconfirmPwdEmpty() {
		userName.clear();
		userName.sendKeys("winterchamps");
		password.sendKeys("Testwinter1!");
		registerBtn.click();
	}
	
	public void errorWithconfirmPwdEmpty() {
		String msg = confirmPassword.getAttribute("validationMessage") ;
		//System.out.println(msg);
		Assert.assertEquals(msg, "Please fill out this field.");
	}
	
	public void registerWithDiffPwds() throws InterruptedException {
		userName.clear();
		userName.sendKeys("winterchamps");
		password.clear();
		password.sendKeys("Testwinter1");
		confirmPassword.sendKeys("Testwinter2");
		registerBtn.click();
		Thread.sleep(3000);
	}
	
	public void errorwithDiffPwds() throws InterruptedException {
		Thread.sleep(3000);
		String msg = pwdMismatchError.getText() ;
		//System.out.println(msg);
		Assert.assertEquals(msg, "password_mismatch:The two password fields didn’t match.");
			
		
	}
	
	public void registerWithPwdlessthanLimit() throws InterruptedException {
		userName.clear();
		userName.sendKeys("winterchamps");
		password.clear();
		password.sendKeys("Test");
		confirmPassword.clear();
		confirmPassword.sendKeys("Test");
		registerBtn.click();
		Thread.sleep(3000);
		
	}
	
	public void erroWithPwdlessthanLimit() {
		String msg = pwdMismatchError.getText() ;
		//System.out.println(msg);
		Assert.assertEquals(msg,"password_mismatch:The two password fields didn’t match.") ;
	}
	
	public void registerWithvalidCredentials() {
		userName.clear();
		userName.sendKeys("wintercham");
		password.clear();
		password.sendKeys("Testwinter12");
		confirmPassword.clear();
		confirmPassword.sendKeys("Testwinter12");
		registerBtn.click();
	}
	
		
	
	public void validateAccountCreation() {
		
		String msg = pwdMismatchError.getText() ;
		//System.out.println(msg);
		Assert.assertEquals(msg, "New Account Created. You are logged in as wintercham");
		
		
	}
	
	
	
}
