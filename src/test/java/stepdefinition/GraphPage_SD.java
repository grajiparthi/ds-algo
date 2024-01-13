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
import pageObjects.GraphPage;
import pageObjects.LoginPage;
import utlilties.ExcelReader;
import MyHooks.DsAlgoHooks;

public class GraphPage_SD {
	
	//WebDriver driver = new ChromeDriver() ;
	//GraphPage gp = new GraphPage(driver) ;

	
	

	//WebDriver driver;
	//LoginPage lp ;
	//GraphPage gp ;
	
	//WebDriver driver = new ChromeDriver() ;
	
	
	
		
	
	//LoginPage lp = new LoginPage(driver) ;
	//ArraysPage ap = new ArraysPage(driver) ; 
	//GraphPage gp = new GraphPage(driver) ;
	
	
	
  	/*@Before
	public void setup() {
		 driver = new ChromeDriver() ;
		  lp = new LoginPage(driver) ;
		  gp = new GraphPage(driver) ;
	}
	
	@After
	public void tearDown() {
		
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	} */
	
	/*@Given("The User has already logged in to the application")
	public void the_user_has_already_logged_in_to_the_application(DataTable dataTable) {
		
		
		List<Map<String, String>> credList = dataTable.asMaps() ; 
		String username = credList.get(0).get("username") ;
		String password = credList.get(0).get("password") ;
		
		driver.get("https://dsportalapp.herokuapp.com/login");
		lp.doLogin(username, password) ;
	    
	}*/
	
	private GraphPage gp = new GraphPage(DriverFactory.getDriver());
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	
	@Given("The User is in the Graph Page")
	public void the_user_is_in_the_graph_page() {
		gp.driver.get("https://dsportalapp.herokuapp.com/graph/graph");
	}

	
	
	@When("The User clicks \"\"Graph\"\" button")
	public void the_user_clicks_graph_button() throws InterruptedException {
		
		gp.clickGraphlink();
	   
	}

	@Then("The User should be redirected to \"\"Graph\"\" page")
	public void the_user_should_be_redirected_to_graph_page() {
		
		gp.graphPageTitle() ;
	   
	}

	@Then("The User clicks {string} button in \"\"Graph\"\" page")
	public void the_user_clicks_button_in_graph_page(String string) {
		
		gp.clickTryhereBtn();
	    
	}
	
	@Then("The User should be redirected to an Editor page")
	public void the_user_should_be_redirected_to_an_editor_page() throws InterruptedException {
		
		gp.verifyTryeditorPage();
	    
	}

	@Then("The User fills the tryEditor from given sheetname \"\"Graphdata\"\" and rownumber {int}")
	public void the_user_fills_the_try_editor_from_given_sheetname_graphdata_and_rownumber(Integer int1) throws InterruptedException, InvalidFormatException, IOException {
		
		String SheetName = "Graphdata" ;
		ExcelReader reader = new ExcelReader() ;
		List<Map<String,String>> testData = reader.getData("/Users/deetshana/eclipse-workspace/DS-Algo/src/test/resources/test-data/graph-test-data.xlsx", SheetName) ;
		String texteditor = testData.get(int1).get("Python Programs");
		
		System.out.println("Read data from Excel: "  + texteditor );
		
		gp.fillTexteditor(texteditor) ;
	    
	}
	
	@Then("The User clicks on Run button under Graph Page")
	public void the_user_clicks_on_run_button_under_graph_page() {
		
		gp.clickrunBtn();
	    
	}

	@Then("The output should be displayed below the Run button under the Graph Page")
	public void the_output_should_be_displayed_below_the_run_button_under_the_graph_page() throws InterruptedException {
		
		gp.verifyOutput();
	   
	}


   @When("The User clicks \"\"Graph Representations\"\" button")
	public void the_user_clicks_graph_representations_button() {
		
		gp.clickGraphRepresentationslink();
	    
	}

	@Then("The User should be redirected to \"\"Graph Representations\"\" page")
	public void the_user_should_be_redirected_to_graph_representations_page() throws InterruptedException {
		
		gp.verifyGraphRepresentationsPage();
	    
	}

	@Then("The User clicks {string} button in \"\"Graph Representations\"\" page")
	public void the_user_clicks_button_in_graph_representations_page(String string) {
		
		gp.clickTryhereBtn();
	    
	}

	
}
	
	
	
	