package stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArraysPage;
import pageObjects.LoginPage;
import pageObjects.TreePage;
import utlilties.ExcelReader;

public class TreePage_SD {
	
	//WebDriver driver;
	//LoginPage lp ;
	//TreePage tp ;
	
	/*@Before
	public void setup() {
		 driver = new ChromeDriver() ;
		  lp = new LoginPage(driver) ;
		  tp = new TreePage(driver) ;
	}
	
	@After
	public void tearDown() {
		
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}*/
	
	private TreePage tp = new TreePage(DriverFactory.getDriver());
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("The User is in the Tree Page")
	public void the_user_is_in_the_tree_page() {
		
		tp.driver.get("https://dsportalapp.herokuapp.com/tree/binary-trees/");
	    
	}

	@When("The User clicks \"\"Binary Trees\"\" button")
	public void the_user_clicks_binary_trees_button() {
		
		tp.clickbinaryTreelink();
	   
	}

	@Then("The User should be redirected to \"\"Binary Trees\"\" page")
	public void the_user_should_be_redirected_to_binary_trees_page() {
		
		tp.binarytreesPageTitle();
	    
	}

	@Then("The User clicks {string} button in \"\"Binary Trees\"\" page")
	public void the_user_clicks_button_in_binary_trees_page(String string) {
		
		tp.clicktryHerelink();
	    
	}

	@Then("The User should land in a Try Editor page")
	public void the_user_should_land_in_a_try_editor_page() throws InterruptedException {
		
		tp.verifyTryeditorPage();
	   
	}

	@Then("The User fills the tryEditor from given sheetname \"\"Treedata\"\" and rownumber {int}")
	public void the_user_fills_the_try_editor_from_given_sheetname_treedata_and_rownumber(Integer int1) throws InvalidFormatException, IOException, InterruptedException {
	    
		String SheetName = "Treedata" ;
		ExcelReader reader = new ExcelReader() ;
		List<Map<String,String>> testData = reader.getData("/Users/deetshana/eclipse-workspace/DS-Algo/src/test/resources/test-data/tree-test-data.xlsx", SheetName) ;
		String texteditor = testData.get(int1).get("Python Programs");
		
		System.out.println("Read data from Excel: "  + texteditor );
		
		tp.fillTexteditor(texteditor) ;
	}

	@Then("The User clicks on Run button under Tree Page")
	public void the_user_clicks_on_run_button_under_tree_page() {
		
		tp.clickrunBtn();
	    
	}

	@Then("The output should be displayed below the Run button under the Tree Page")
	public void the_output_should_be_displayed_below_the_run_button_under_the_tree_page() throws InterruptedException {
		
		tp.verifyOutput();
	    
	}

	@When("The User clicks \"\"Types of Binary Trees\"\" button")
	public void the_user_clicks_types_of_binary_trees_button() {
		
		tp.clicktypesofBinaryTreeslink();
	    
	}

	@Then("The User should be redirected to \"\"Types of Binary Trees\"\" page")
	public void the_user_should_be_redirected_to_types_of_binary_trees_page() {
		
		tp.typesofBinarytreesPageTitle();
	    
	}

	@Then("The User clicks {string} button in \"\"Types of Binary Trees\"\" page")
	public void the_user_clicks_button_in_types_of_binary_trees_page(String string) {
		
		tp.clicktryHerelink();
	   
	}

	@When("The User clicks \"\"Implementation in Python\"\" button")
	public void the_user_clicks_implementation_in_python_button() {
		
		tp.clickimplementationinPythonlink();
	    
	}

	@Then("The User should be redirected to \"\"Implementation in Python\"\" page")
	public void the_user_should_be_redirected_to_implementation_in_python_page() {
		
		tp.implinPythonPageTitle() ;
	    
	}

	@Then("The User clicks {string} button in \"\"Implementation in Python\"\" page")
	public void the_user_clicks_button_in_implementation_in_python_page(String string) {
		
		tp.clicktryHerelink();
	    
	}

	@When("The User clicks \"\"Binary Tree Traversals\"\" button")
	public void the_user_clicks_binary_tree_traversals_button() {
		
		tp.clickbinaryTreeTraversalslink();
	    
	}

	@Then("The User should be redirected to \"\"Binary Tree Traversals\"\" page")
	public void the_user_should_be_redirected_to_binary_tree_traversals_page() {
		
		tp.binarytreeTraversalsPageTitle();
	    
	}

	@Then("The User clicks {string} button in \"\"Binary Tree Traversals\"\" page")
	public void the_user_clicks_button_in_binary_tree_traversals_page(String string) {
		
		tp.clicktryHerelink();
	    
	}


}
