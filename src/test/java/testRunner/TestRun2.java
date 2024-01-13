package testRunner;


	
	import org.testng.annotations.DataProvider;


	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	
	//@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/test/resources/features"},
			glue = {"stepdefinition", "MyHooks"},
			//tags ="@Smoke",
			plugin = {"pretty",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",	
					"timeline:test-output-thread/"
					}
					)

	public class TestRun2 extends AbstractTestNGCucumberTests{
		@Override
		@DataProvider(parallel = true)
		public Object[][] scenarios(){
			return super.scenarios();
		}
						
				}


