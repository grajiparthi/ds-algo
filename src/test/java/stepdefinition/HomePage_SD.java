package stepdefinition;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomePage_SD {
	
	/*WebDriver driver ;
	HomePage hp ;
	
	@Before
	public void  setup() {
		driver = new ChromeDriver() ;
	}
	
	@After
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	} */
	
	private HomePage hp = new HomePage(Factory.DriverFactory.getDriver()) ;
	//Factory.DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/home");
	
	/*@Given("The User launch Chrome browser")
	public void the_user_launch_chrome_browser() {
	  // driver = new ChromeDriver() ;
	    hp = new HomePage(driver) ;
	}*/
	


	@When("The User opens URL {string}")
	public void the_user_opens_url(String url) {
		//WebDriver driver = null;
		hp.driver.get(url);
	   
	}

	@When("The User clicks {string} drop down")
	public void the_user_clicks_drop_down(String string) throws InterruptedException {
		hp.clickDatastructuresDropdown();
	    
	}

	@Then("The User should see {int} different data structure entries in that dropdown")
	public void the_user_should_see_different_data_structure_entries_in_that_dropdown(Integer int1) throws InterruptedException {
	    hp.verifyDatastructuresEntries();
	}

	@When("The User clicks any of the {string} buttons below the data structures")
	public void the_user_clicks_any_of_the_buttons_below_the_data_structures(String string) throws InterruptedException {
		hp.clickGetStartedBtn();
	    
	}

	@Then("It should alert the user with a message {string}")
	public void it_should_alert_the_user_with_a_message(String string) {
	    hp.alertMsgCheck();
	}

	@When("The User selects any data structures item from the drop down without Sign in")
	public void the_user_selects_any_data_structures_item_from_the_drop_down_without_sign_in() throws InterruptedException {
	    hp.clickDatastructuresOptions();
	}

	@When("The User clicks {string}")
	public void the_user_clicks(String string) throws InterruptedException {
		hp.signIn();
		hp.register();
	    
	}

	@Then("The User should be redirected to Sign in page")
	public void the_user_should_be_redirected_to_sign_in_page() throws InterruptedException {
		hp.verifyloginPage();
	   
	}

	@Then("The User should be redirected to Register form")
	public void the_user_should_be_redirected_to_register_form() throws InterruptedException {
		hp.verifyRegisterPage();
	    
	}



}
