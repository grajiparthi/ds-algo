package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	
	
	public WebDriver driver ;

	@FindBy (linkText = "Data Structures") WebElement dataStructuresdropDwn ;
	@FindBy (linkText = "Sign in") WebElement signIn ;
	@FindBy (linkText = "Register") WebElement register ;
	//@FindBy (xpath = "/html/body/div[3]/div[1]/div/div/a") WebElement dataStructuresIntroBtn ;
	@FindBy (xpath = "//div[@class='dropdown-menu show']/a[1]") WebElement arrayBtn ;
	@FindBy (xpath = "//div[@class='dropdown-menu show']/a[2]") WebElement linkedListBtn ;
	@FindBy (xpath = "//div[@class='dropdown-menu show']/a[3]") WebElement stackBtn ;
	@FindBy (xpath = "//div[@class='dropdown-menu show']/a[4]") WebElement queueBtn ;
	@FindBy (xpath = "//div[@class='dropdown-menu show']/a[5]") WebElement treeBtn ;
	@FindBy (xpath = "//div[@class='dropdown-menu show']/a[6]") WebElement graphBtn ;
	
	ArrayList<String> errorlist = new ArrayList<String>() ;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this) ;
		
	}
	
	public void clickDatastructuresDropdown () throws InterruptedException {
		
		Thread.sleep(3000);
		
		dataStructuresdropDwn.click();
	}
		
	public void  verifyDatastructuresEntries()  throws InterruptedException {
		
		String expectedoptions [] = { "Arrays", "LinkedList",  "Stack",  "Queue",  "Tree",  "Graph" } ;
		int length = expectedoptions.length ; //expected options
		
		List <WebElement> options = driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a")) ;
		int size = options.size() ; //actual options
		
		Assert.assertEquals(size, length);
		System.out.println(" The actual options are " + size);
		
		
	}
	
	public void clickDatastructuresOptions () throws InterruptedException  {
		Thread.sleep(3000);
		//dataStructuresdropDwn.click();
		//Thread.sleep(3000);
		
		/*if(errorlist.size() > 0) {
			errorlist.clear();
		}*/
		for(int i= 1; i<=6; i++) {
			
			 dataStructuresdropDwn.click();
		     Thread.sleep(3000);
	         WebElement link = driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[" + i + "]")) ;
	         Thread.sleep(3000) ;
			 link.click();
	         Thread.sleep(3000) ;
				
				if (isErrordisplayed(driver)) {
					System.out.println("Error message 'You are not logged in' displayed after clicking Link " + i ) ;
				} else {
					System.out.println("No error message or incorrect error message displayed after clicking Link" + i);
				} 
				
				//driver.navigate().back();
	            
			  String alertMsg = driver.findElement(By.xpath("//div[@class='alert alert-primary']")).getText() ;
			  //ArrayList<String> errorlist = new ArrayList<String>() ;
			  errorlist.add(alertMsg) ;
			  System.out.println(alertMsg);
			  
			  driver.navigate().back();
			  
		}
			
	
			
	}	
		
	
	
		private  boolean isErrordisplayed(WebDriver driver) {
		
		try {
			 WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-primary']")) ;
			// errorlist.add("You are not logged in") ;
	            return errorMessage.isDisplayed();
		} catch (Exception e) {
			return false ;
		}
		
	}
		
		
		public void alertMsgCheck() {
			
			for(int i=0; i<=5; i++) {
				
				Assert.assertEquals(errorlist.get(i), "You are not logged in");
				System.out.println(errorlist.get(i));
				
			}
			
		}
	
	
				
			
		
	
	
	public void clickGetStartedBtn() throws InterruptedException {
		
		 for (int i = 1; i <= 7; i++) {
			 WebElement link = driver.findElement(By.xpath("(//a[contains(text(), 'Get Started')])[" + i + "]"));
	         link.click();
	         
	         Thread.sleep(3000) ;

	         if (isErrorMessageDisplayed(driver)) {
	                System.out.println("Error message 'You are not logged in' displayed after clicking Link " + i);
	            } else {
	                System.out.println("No error message or incorrect error message displayed after clicking Link " + i);
	            }
	         
	          String alertMsg = driver.findElement(By.xpath("//div[@class='alert alert-primary']")).getText() ;
			  errorlist.add(alertMsg) ;
			  System.out.println(alertMsg);
			  
			  driver.navigate().back();
			  
	         	

	        }
	}
	
	
	        
	private static boolean isErrorMessageDisplayed(WebDriver driver) {
        try {
            
            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-primary']")) ;
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false; // Element not found or not displayed
        }
	    
   
	
	
}
	
	public void signIn() throws InterruptedException {
		
		signIn.click();
	    Thread.sleep(3000);
		
		}
	
	public void register() throws InterruptedException {
		
		register.click();
		Thread.sleep(3000);
		
	}
	
	public void verifyloginPage() throws InterruptedException {
		signIn();
		String currenturl = driver.getCurrentUrl() ;
		Assert.assertEquals(currenturl, "https://dsportalapp.herokuapp.com/login") ;
		System.out.println(currenturl);
		//driver.navigate().back() ;
	}
	
	public void verifyRegisterPage() throws InterruptedException {
		register();
		String currenturl = driver.getCurrentUrl() ;
		Assert.assertEquals(currenturl, "https://dsportalapp.herokuapp.com/register");
		System.out.println(currenturl);
		//driver.navigate().back() ;
	}
	
	
}
		
