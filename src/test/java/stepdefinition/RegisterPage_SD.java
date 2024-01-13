package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterPage;


public class RegisterPage_SD {
	
	WebDriver driver ;
	//RegisterPage rp ;
	
	private RegisterPage rp = new RegisterPage(DriverFactory.getDriver());

	
	@Given("The User opens the Register Page")
	public void the_user_opens_the_register_page() {
	   // driver = new ChromeDriver() ;
	   // rp = new RegisterPage(driver) ;
	    //driver.get("https://dsportalapp.herokuapp.com/register");
	    DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/register");
	}

	@When("The User clicks {string} button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty(String string) throws InterruptedException {
		rp.registerWithallfieldsEmpty();
	   
	}

	@Then("It should display an error {string} below Username textbox")
	public void it_should_display_an_error_below_username_textbox(String string) throws InterruptedException {
	    rp.errorWithallfieldsEmpty();
	}

	@When("The User clicks {string} button after entering Username with other fields empty")
	public void the_user_clicks_button_after_entering_username_with_other_fields_empty(String string) {
	    rp.registerWithPwdfieldsEmpty();
	}

	@Then("It should display an error {string} below Password textbox")
	public void it_should_display_an_error_below_password_textbox(String string) {
	    rp.errorWithPwdfieldsEmpty();
	}

	@When("The User clicks {string} button after entering Username and password with Password Confirmation field empty")
	public void the_user_clicks_button_after_entering_username_and_password_with_password_confirmation_field_empty(String string) {
	    rp.registerWithconfirmPwdEmpty();
	}

	@Then("It should display an error {string} Password Confirmation textbox")
	public void it_should_display_an_error_password_confirmation_textbox(String string) {
	    rp.errorWithconfirmPwdEmpty();
	}

	@When("The User clicks {string} button after entering different passwords in Password and Password Confirmation fields")
	public void the_user_clicks_button_after_entering_different_passwords_in_password_and_password_confirmation_fields(String string) throws InterruptedException {
	    rp.registerWithDiffPwds();
	}

	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String string) throws InterruptedException {
		rp.errorwithDiffPwds();
	    
	}

	@When("The User enters a Password with characters less than {int}")
	public void the_user_enters_a_password_with_characters_less_than(Integer int1) throws InterruptedException {
		rp.registerWithPwdlessthanLimit();
	    
	}

	@When("The User enters a valid username and matching passwords in Password and Password confirmations fields")
	public void the_user_enters_a_valid_username_and_matching_passwords_in_password_and_password_confirmations_fields() {
		rp.registerWithvalidCredentials();
		
	    
	}

	@Then("The user should be redirected to Homepage with the message {string}")
	public void the_user_should_be_redirected_to_homepage_with_the_message(String string) {
		rp.validateAccountCreation();
	    
	}



}
