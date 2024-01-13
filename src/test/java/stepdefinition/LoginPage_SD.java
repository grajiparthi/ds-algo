package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginPage_SD {
	
	/*WebDriver driver ;
	LoginPage lp ;
	
	@Before
	public void  setup() {
		driver = new ChromeDriver() ;
		lp = new LoginPage(driver) ;
	}
	
	@After
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	} */
	
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	
	@Given("The User is on the login page")
	public void the_user_is_on_the_login_page() {
		//driver = new ChromeDriver() ;
		//lp = new LoginPage(driver) ;
		lp.driver.get("https://dsportalapp.herokuapp.com/login");
	    
	}

	@When("The User enters a valid username and password")
	public void the_user_enters_a_valid_username_and_password() {
		lp.enterUsername("winterchamps");
		lp.enterPassword("Testwinter1!");

	}

	@When("The User clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		lp.clickLoginbtn();
	    
	}

	@Then("The User should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() {
		lp.verifySuccessfulLogin();
	   
	}

	@When("The User enters invalid {string} and {string}")
	public void the_user_enters_invalid_and(String username, String password) {
	    
		lp.enterUsername(username);
		lp.enterPassword(password);
	}

	@Then("The User should see an error message indicating {string}")
	public void the_user_should_see_an_error_message_indicating(String string) {
		
		Assert.assertEquals(lp.invalidLogin(), true);
	    
	}


}
