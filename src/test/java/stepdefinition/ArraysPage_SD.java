package stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArraysPage;
import pageObjects.LoginPage;
import pageObjects.PortalPage;
import utlilties.ExcelReader;

public class ArraysPage_SD {
	
	//WebDriver driver;
	//LoginPage lp ;
	//ArraysPage ap  ;
	
	//WebDriver driver = new ChromeDriver() ;
	//LoginPage lp = new LoginPage(driver) ;
	//ArraysPage ap = new ArraysPage(driver) ; 
	
  /*	@Before
	public void setup() {
		 driver = new ChromeDriver() ;
		  lp = new LoginPage(driver) ;
		  ap = new ArraysPage(driver) ;
	}
	
	@After
	public void tearDown() {
		
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	} */
	
	private ArraysPage ap = new ArraysPage(DriverFactory.getDriver());
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("The User has already logged in to the application")
	public void the_user_has_already_logged_in_to_the_application(DataTable dataTable) {
		
		
		List<Map<String, String>> credList = dataTable.asMaps() ; 
		String username = credList.get(0).get("username") ;
		String password = credList.get(0).get("password") ;
		
		ap.driver.get("https://dsportalapp.herokuapp.com/login");
		lp.doLogin(username, password) ;
	    
	}

	@Given("The User is in the Array Page")
	public void the_user_is_in_the_array_page() {
	
		ap.driver.get("https://dsportalapp.herokuapp.com/array/");
	   
	}

	@When("The User clicks \"\"Arrays in Python\"\" button")
	public void the_user_clicks_arrays_in_python_button() {
		
		ap.clickArraysinPython();
	    
	}

	@Then("The User should be redirected to \"\"Arrays in Python\"\" page")
	public void the_user_should_be_redirected_to_arrays_in_python_page() throws InterruptedException {
		
		ap.verifyArraysinPython();
		
		
	}

	@Then("The User clicks {string} button in \"\"Arrays in Python\"\" page")
	public void the_user_clicks_button_in_arrays_in_python_page(String string) throws InterruptedException {
		
		ap.clickTryhereBtn1();
	    
	}

	@Then("The User should be redirected to a page having a tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_a_try_editor_with_a_run_button_to_test() throws InterruptedException {
		
		ap.verifyTryeditorPage();
	    
	}

	/* @Then("The User fills the tryEditor from given sheetname {string} and rownumber {int}")
	public void the_user_fills_the_try_editor_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader() ;
		List<Map<String,String>> testData = reader.getData("/src/test/resources/test-data/test-data.xlsx", sheetName) ;
		String texteditor = testData.get(rowNumber).get("Python Programs");
		
		ap.fillTexteditor(texteditor) ;
	    
	} */
	
	@Then("The User fills the tryEditor from given sheetname \"\"Sheet1\"\" and rownumber {int}")
	public void the_user_fills_the_try_editor_from_given_sheetname_sheet1_and_rownumber(Integer int1) throws InvalidFormatException, IOException, InterruptedException {
		
		String SheetName = "Sheet1" ;
		ExcelReader reader = new ExcelReader() ;
		List<Map<String,String>> testData = reader.getData("/Users/deetshana/eclipse-workspace/DS-Algo/src/test/resources/test-data/test-data.xlsx", SheetName) ;
		String texteditor = testData.get(int1).get("Python Programs");
		
		System.out.println("Read data from Excel: "  + texteditor );
		
		ap.fillTexteditor(texteditor) ;
	    
	}


	@Then("The User clicks on Run button")
	public void the_user_clicks_on_run_button() {
		
		ap.clickRunBtn();
	    
	}

	@Then("The output should be displayed below the Run button")
	public void the_output_should_be_displayed_below_the_run_button() throws InterruptedException {
		
		ap.verifyOutput();
	    
	}

	@Then("If there is an error in the program")
	public void if_there_is_an_error_in_the_program() {
		
		ap.isAlertPresent(ap.driver) ;
	   
	}

	@Then("The error message should be captured")
	public void the_error_message_should_be_captured() {
		
		ap.captureAlert();
	    
	}

	@When("The User clicks \"\"Arrays Using List\"\" button")
	public void the_user_clicks_arrays_using_list_button() {
		
		ap.clickArraysUsingList();
	   
	}

	@Then("The User should be redirected to \"\"Arrays Using List\"\" page")
	public void the_user_should_be_redirected_to_arrays_using_list_page() throws InterruptedException {
		
		ap.verifyArraysUsingList();
	    
	}

	@Then("The User clicks {string} button in \"\"Arrays Using List\"\" page")
	public void the_user_clicks_button_in_arrays_using_list_page(String string) {
		
		ap.clickTryhereBtn2();
	   
	}

	@When("The User clicks \"\"Basic Operations in Lists\"\" button")
	public void the_user_clicks_basic_operations_in_lists_button() throws InterruptedException {
		
		ap.clickBasicOperationsinList();
	    
	}

	@Then("The User should be redirected to \"\"Basic Operations in Lists\"\" page")
	public void the_user_should_be_redirected_to_basic_operations_in_lists_page() throws InterruptedException {
		
		ap.verifyBasicOperationsinList();
	   
	}

	@Then("The User clicks {string} button in \"\"Basic Operations in Lists\"\" page")
	public void the_user_clicks_button_in_basic_operations_in_lists_page(String string) {
		
		ap.clickTryhereBtn3();
	    
	}

	@When("The User clicks \"\"Applications of Array\"\" button")
	public void the_user_clicks_applications_of_array_button() throws InterruptedException {
		
		ap.clickApplicationsofArray();
	    
	}

	@Then("The User should be redirected to \"\"Applications of Array\"\" page")
	public void the_user_should_be_redirected_to_applications_of_array_page() throws InterruptedException {
		
		ap.verifyApplicationsofArray();
	   
	}

	@Then("The User clicks {string} button in \"\"Applications of Array\"\" page")
	public void the_user_clicks_button_in_applications_of_array_page(String string) {
		
		ap.clickTryhereBtn4();
	   
	}
	
	@Given("The User is in the Arrrays in Page under Arrays")
	public void the_user_is_in_the_arrrays_in_page_under_arrays() {
		
		ap.driver.get("https://dsportalapp.herokuapp.com/array/arrays-in-python/");
	    
	}

	@When("The User clicks on {string} link")
	public void the_user_clicks_on_link(String string) {
		
		ap.clickPracticeQuestions();
	   
	}

	@Then("The User should be redirected to practice page")
	public void the_user_should_be_redirected_to_practice_page() throws InterruptedException {
		
		ap.verifyPracticePage();
	   
	}

	@Then("The User clicks on \"\"Search the array\"\" link")
	public void the_user_clicks_on_search_the_array_link() {
		
		ap.clickSearchtheArray();
	    
	}
	

    @Then("The User should be redirected to a page having a textarea with a Submit button to test")
    public void the_user_should_be_redirected_to_a_page_having_a_textarea_with_a_submit_button_to_test() throws InterruptedException {
    	
    	ap.verifyTextareawithSubBtn();
    
}


	@Then("The User fills the tryEditor from the given \"\"Sheet1\"\" and rownumber {int}")
	public void the_user_fills_the_try_editor_from_the_given_sheet1_and_rownumber(Integer int1) throws InvalidFormatException, IOException, InterruptedException {
		
		String SheetName = "Sheet1" ;
		ExcelReader reader = new ExcelReader() ;
		List<Map<String,String>> testData = reader.getData("/Users/deetshana/eclipse-workspace/DS-Algo/src/test/resources/test-data/test-data.xlsx", SheetName) ;
		String texteditor = testData.get(int1).get("Python Programs");
		
		System.out.println("Read data from Excel: "  + texteditor );
		
		ap.fillTexteditor(texteditor) ;
	    
	}

	@Then("The User clicks on Submit button")
	public void the_user_clicks_on_submit_button() {
		
		ap.clickSubmitBtn();
	    
	}

	

	@Then("The User clicks on \"\"Max Consecutive Ones\"\" link")
	public void the_user_clicks_on_max_consecutive_ones_link() {
		
		ap.clickMaxConsecutiveOnes();
	    
	}

	@Then("The User clicks on \"\"Find Numbers with Even Number of Digits\"\" link")
	public void the_user_clicks_on_find_numbers_with_even_number_of_digits_link() {
		
		ap.clickFindNumberswithEvenDigits();
	    
	}

	@Then("The User clicks on \"\"Squares of a Sorted Array\"\" link")
	public void the_user_clicks_on_squares_of_a_sorted_array_link() {
		
		ap.clickSquaresofsortedArray();
	    
	}




}
