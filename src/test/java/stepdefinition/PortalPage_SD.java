package stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.PortalPage;

public class PortalPage_SD {
	
	//WebDriver driver ;
	//PortalPage Pp ;
	
	private PortalPage Pp = new PortalPage(DriverFactory.getDriver());
	

	
	/*@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		driver = new ChromeDriver() ;
	    Pp = new PortalPage(driver) ;
	    
	}*/

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		
		Pp.driver.get(url) ;
	}

	@When("click on {string} button")
	public void click_on_button(String string) {
		
		Pp.clickGetstartedBtn();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		
		Assert.assertEquals(title, Pp.driver.getTitle());
	    
	   
	}



}
