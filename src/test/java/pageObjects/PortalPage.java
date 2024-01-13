package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class PortalPage {
	
	public WebDriver driver ;
	@FindBy (xpath = "//button[@class='btn']") WebElement getStartedBtn ;
	
    public PortalPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this) ;
		
	}
	
	public void clickGetstartedBtn() {
		getStartedBtn.click() ;
	}
	

}
