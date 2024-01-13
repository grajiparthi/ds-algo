package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions
		(
				
			features = "src/test/resources/features" ,
			glue = {"stepdefinition" , "MyHooks" } ,
			dryRun = false ,
			monochrome = true ,
			//plugin = {"pretty" , "html:test-output"}
			//plugin = {"pretty" , "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
			 //plugin = {"json:target/cucumber/report.json", "html:target/cucumber/report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
			
			plugin = {"pretty", "json:target/cucumber/report.json", "html:target/cucumber/report.html" ,
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",	
					"timeline:test-output-thread/"
			}	
			
								
		)

public class TestRun  extends AbstractTestNGCucumberTests {

}
