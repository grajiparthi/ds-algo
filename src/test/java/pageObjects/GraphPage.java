package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GraphPage {
	
	public WebDriver driver ;
	
	@FindBy (linkText = "Graph") WebElement graphLink ;
	@FindBy (linkText = "Try here>>>") WebElement tryhereLink ;
	@FindBy (xpath ="//div[@class='CodeMirror-scroll']") WebElement tryEditor ;
	@FindBy (xpath = "//button[@type='button']") WebElement runBtn ;
	@FindBy (linkText = "Graph Representations") WebElement graphRepresentationsLink ;
	//@FindBy (xpath = "//div[@class='col-sm']/strong/p") WebElement graphPage ;
	@FindBy (xpath = "//div[@class='col-sm']/strong/p") WebElement graphPage ;
	@FindBy (xpath = "//pre[@id='output']") WebElement output ;
	@FindBy (linkText = "Practice Questions") WebElement practiceQuestions ;
	@FindBy (xpath = "//body/div/div[7]/div/div/a") WebElement getStartedBtn ;
	//@FindBy (xpath = "//div[@class='col-sm']/strong/p") WebElement graphRepresentationsPage ;
	
	public GraphPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	public void clickGraphlink() throws InterruptedException {
		Thread.sleep(3000);
		graphLink.click();
	}
	
	public void clickTryhereBtn() {
		tryhereLink.click();
	}
	
	public void clickrunBtn() {
		runBtn.click();
	}
	
	/*public void verifyHomePage() throws InterruptedException {
		Thread.sleep(3000);
		String actualurl = driver.getCurrentUrl() ;
		String expectedurl = "https://dsportalapp.herokuapp.com/home" ;
		Assert.assertEquals(actualurl, expectedurl);
		System.out.println(actualurl);
	}*/
	
	public void clickGetstartedBtn() throws InterruptedException {
		Thread.sleep(3000);
		getStartedBtn.click();
		
	}
	
	public String graphPageTitle() {
		System.out.println("Graph Page title is :"+ driver.getTitle());
		return driver.getTitle();
	}
	
	public void verifyGraphPage() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("verifyGraphPage");
		String actualText = graphPage.getText() ;
		//Assert.assertEquals(actualText, "Graph");
		System.out.println(actualText);
	}
	
	public void verifyGraphRepresentationsPage() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("verifyGraphRepresentationsPage");
		String actualText = graphPage.getText() ;
		//Assert.assertEquals(actualText, "Graph Representations");
		System.out.println(actualText);
	}
	
    public void verifyTryeditorPage() throws InterruptedException {
		
		Thread.sleep(3000);
		System.out.println("verifyTryeditorPage");
		String actualurl = driver.getCurrentUrl() ;
		Thread.sleep(3000);
		String expectedurl = "https://dsportalapp.herokuapp.com/tryEditor" ;
	//	Assert.assertEquals(actualurl, expectedurl) ;
		System.out.println(actualurl) ;
    }
    

	public void fillTexteditor(String string) throws InterruptedException {
		
		/*tryEditor1.click();
		tryEditor1.sendKeys(codesnippet);
		Thread.sleep(3000);*/
		
		Actions actions = new Actions(driver);
		actions.moveToElement(tryEditor).click().sendKeys(string).build().perform();
		Thread.sleep(3000);
		
	}
	
   public void verifyOutput() throws InterruptedException {
		
		runBtn.click();
		Thread.sleep(3000);
		String outputElement = output.getText() ;
		System.out.println(outputElement);
		
	}
   
   public void captureAlert() {
		
		runBtn.click();
		if(isAlertPresent(driver)) {
			String alertMessage = getAlertMessage(driver) ;
			System.out.println("Alert Message :" + alertMessage);
			dismissAlert(driver) ;
		}
		
		
	}
	
	public boolean  isAlertPresent(WebDriver driver) {
		
		try {
			driver.switchTo().alert() ;
			return true ;
			
		} catch (Exception e) {
			return false ;
		}
		
		
	}
	
public String getAlertMessage(WebDriver driver) {
		
		Alert alert = driver.switchTo().alert() ;
		String alertMessage = alert.getText() ;
		return alertMessage ;
		
		
	}
	
	public void dismissAlert(WebDriver driver) {
		
		Alert alert = driver.switchTo().alert() ;
		alert.dismiss();
		
		
	}
	
	public void clickGraphRepresentationslink() {
		
		graphRepresentationsLink.click();
		
	}
	
	public void clickPracticeQuestionspage() {
		
		practiceQuestions.click();
		
	}
	
public void verifyPracticePage() throws InterruptedException {
		
		Thread.sleep(3000);
		String actualurl = driver.getCurrentUrl() ;
		Thread.sleep(3000);
		String expectedurl = "https://dsportalapp.herokuapp.com/graph/practice" ;
		Assert.assertEquals(actualurl, expectedurl) ;
		System.out.println(actualurl) ;
		
    }  


}
