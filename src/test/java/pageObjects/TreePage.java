package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TreePage {
	
	public WebDriver driver ;
	
	@FindBy (linkText = "Binary Trees") WebElement binaryTreelink ;
	@FindBy (linkText = "Types of Binary Trees") WebElement typesofBinaryTreeslink ;
	@FindBy (linkText = "Implementation in Python") WebElement implementationinPythonlink ;
	@FindBy (linkText = "Binary Tree Traversals") WebElement binaryTreeTraversalslink ;
	@FindBy (linkText = "Try here>>>") WebElement tryHereLink ;
	@FindBy (xpath = "//div[@class='CodeMirror-scroll']") WebElement tryHerepage ;
	@FindBy (xpath ="//button[@type='button']") WebElement runBtn ;
	@FindBy (xpath = "//pre[@id='output']") WebElement output ;
	@FindBy (xpath ="//div[@class='CodeMirror-scroll']") WebElement tryEditor ;
	
	public TreePage(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	public void clickbinaryTreelink() {
		
		binaryTreelink.click();
		
	}
	
	public void clicktypesofBinaryTreeslink() {
		
		typesofBinaryTreeslink.click();
	}
	
	public void clickimplementationinPythonlink() {
		
		implementationinPythonlink.click();
	}
	
	public void clickbinaryTreeTraversalslink() {
		
		binaryTreeTraversalslink.click();
	}
	
	public void clicktryHerelink() {
		
		tryHereLink.click();
		
	}
	
	public void clickrunBtn() {
		
		runBtn.click();
	}
	
	public String binarytreesPageTitle() {
		System.out.println("Binary Trees Page title is :"+ driver.getTitle());
		return driver.getTitle();
	}
	
	public String typesofBinarytreesPageTitle() {
		System.out.println("Types of Binary Trees Page title is :"+ driver.getTitle());
		return driver.getTitle();
	}
	
	public String implinPythonPageTitle() {
		System.out.println("Implementation in Python Page title is :"+ driver.getTitle());
		return driver.getTitle();
	}
	
	public String binarytreeTraversalsPageTitle() {
		System.out.println("Binary Tree Traversals Page title is :"+ driver.getTitle());
		return driver.getTitle();
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


}
