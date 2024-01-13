package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArraysPage {
	
	public WebDriver driver;
	
	@FindBy (linkText = "Arrays in Python") WebElement arraysFirstLink ;
	@FindBy (linkText = "Try here>>>") WebElement tryhereLink1 ;
	@FindBy (xpath = "//button[@type='button']") WebElement runBtn ;
	@FindBy (xpath = "//div[@class='col-sm']/strong/p") WebElement arraysInPython ;
	@FindBy (xpath = "//div[@class='CodeMirror-scroll']") WebElement tryEditor1 ;
	//@FindBy (xpath = " //div[@class='CodeMirror-lines']") WebElement tryEditor1 ;
	@FindBy (xpath = "//pre[@id='output']") WebElement output ;
	@FindBy (xpath = "//div[@class='CodeMirror-scroll']") WebElement tryEditortextArea ;
	@FindBy (linkText = "Arrays Using List") WebElement arraysSecondLink ;
	@FindBy (xpath = "//div[@class ='col-sm']/strong/p") WebElement arraysUsingList ;
	//@FindBy (xpath = "//a[@class ='btn btn-info']") WebElement tryhereLink2 ;
	@FindBy (linkText = "Basic Operations in Lists") WebElement arraysThirdLink ;
	@FindBy (xpath = "//div[@class='col-sm']/strong/p") WebElement basicOperationsinLists ;
	@FindBy (linkText = "Applications of Array") WebElement arraysFourthLink ;
	@FindBy (xpath = "//div[@class='col-sm']/strong/p") WebElement applicationsofArray ;
	@FindBy (linkText = "Practice Questions") WebElement practiceQuestions ;
	@FindBy (linkText = "Search the array") WebElement searchtheArray ;
	@FindBy (linkText = "Max Consecutive Ones") WebElement maxConsecutiveOnes ;
	@FindBy (linkText = "Find Numbers with Even Number of Digits") WebElement findNumberswithEvennumberofDigits ;
	@FindBy (linkText = "Squares of a Sorted Array") WebElement squaresofaSortedArray ;
	@FindBy (xpath = "//input[@type='submit']") WebElement submitBtn ;
	
	 
	
	public ArraysPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickArraysinPython() {
		arraysFirstLink.click();
	}
	
	public void clickTryHereLink() {
		tryhereLink1.click();
	}
	
	public void clickRunBtn() {
		runBtn.click();
	}
	
	public void verifyArraysinPython() throws InterruptedException {
		Thread.sleep(3000);
		String actualText = arraysInPython.getText() ;
		Assert.assertEquals(actualText, "Arrays in Python");
		System.out.println(actualText);
	}
	
	public void clickTryhereBtn1() throws InterruptedException {
		tryhereLink1.click();
		Thread.sleep(3000);
	}
	
	public void verifyTryeditorPage() throws InterruptedException {
		
		Thread.sleep(3000);
		String actualurl = driver.getCurrentUrl() ;
		Thread.sleep(3000);
		String expectedurl = "https://dsportalapp.herokuapp.com/tryEditor" ;
		Assert.assertEquals(actualurl, expectedurl) ;
		System.out.println(actualurl) ;
		
		/*boolean t = tryEditortextArea.isDisplayed() ;
		Thread.sleep(3000);
		if (t) {
			System.out.println("TryEditor text area is displayed ");
		} else {
			System.out.println("The page does not land in TryEditor text area ");
		} */
		
	}
	
	public void fillTexteditor(String codesnippet) throws InterruptedException {
		
		/*tryEditor1.click();
		tryEditor1.sendKeys(codesnippet);
		Thread.sleep(3000);*/
		
		Actions actions = new Actions(driver);
		actions.moveToElement(tryEditor1).click().sendKeys(codesnippet).build().perform();
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
	
	public void clickArraysUsingList() {
		
		arraysSecondLink.click();
	}
	
	public void verifyArraysUsingList() throws InterruptedException {
		Thread.sleep(3000);
		String actualText = arraysUsingList.getText() ;
		Assert.assertEquals(actualText, "Arrays Using List");
		System.out.println(actualText);
	}
	
	public void clickTryhereBtn2() {
		tryhereLink1.click();
	}
	
	public void clickBasicOperationsinList() throws InterruptedException {
		Thread.sleep(3000);
		arraysThirdLink .click();
	}
	
	public void verifyBasicOperationsinList() throws InterruptedException {
		Thread.sleep(3000);
		String actualText = basicOperationsinLists.getText() ;
		Assert.assertEquals(actualText, "Basic Operations in Lists");
		System.out.println(actualText);
	}
	
	public void clickTryhereBtn3() {
		tryhereLink1.click();
	}
	
	public void clickApplicationsofArray() throws InterruptedException {
		Thread.sleep(3000);
		arraysFourthLink.click();
		
	}
	
	public void verifyApplicationsofArray() throws InterruptedException {
		Thread.sleep(3000);
		String actualText = applicationsofArray.getText() ;
		Assert.assertEquals(actualText, "Applications of Array");
		System.out.println(actualText);
	}
	
	public void clickTryhereBtn4() {
		tryhereLink1.click();
	}
	
	public void clickPracticeQuestions() {
		practiceQuestions.click();
	}
	
    public void verifyPracticePage() throws InterruptedException {
		
		Thread.sleep(3000);
		String actualurl = driver.getCurrentUrl() ;
		Thread.sleep(3000);
		String expectedurl = "https://dsportalapp.herokuapp.com/array/practice" ;
		Assert.assertEquals(actualurl, expectedurl) ;
		System.out.println(actualurl) ;
		
    }  
    
    public void clickSearchtheArray() {
    	searchtheArray.click();
    	
    }
    
    public void clickMaxConsecutiveOnes() {
    	maxConsecutiveOnes.click();
    	
    }
    
    public void clickFindNumberswithEvenDigits() {
    	findNumberswithEvennumberofDigits.click();
    	
    }
    
    public void clickSquaresofsortedArray() {
    	squaresofaSortedArray.click();
    	
    }
    
    public void clickSubmitBtn() {
    	submitBtn.click();
    	
    }
    
public void verifyTextareawithSubBtn() throws InterruptedException {
		
		Thread.sleep(3000);
		String actualtitle = driver.getTitle() ;
		Thread.sleep(3000);
		String expectedtitle = "Assessment" ;
		Assert.assertEquals(actualtitle, expectedtitle) ;
		System.out.println(actualtitle) ;

	
}

}
