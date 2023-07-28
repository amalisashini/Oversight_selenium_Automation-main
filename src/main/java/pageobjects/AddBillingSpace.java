package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBillingSpace {
     WebDriver driver;
	
	public AddBillingSpace(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]")
	WebElement deviceBtn;
	
	@FindBy(xpath="//div[contains(text(),'Create Billing Space')]")
	WebElement createBillingSpaceBtn;

	//Space name
	@FindBy(xpath="//input[@name='spaceClusterLabel']")
	WebElement spaceName;

	//Billing number dropdown
	@FindBy(xpath="//div[@class='app-select_appSelectInput__9RUe8 undefined']")
	WebElement billNumberDropDown;

	 @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/button[1]/div[1]/div[1]]")
	WebElement confirmBtn;

	
	public WebElement deviceBtn() {
		
		return deviceBtn;
		
	}
	
	public WebElement createBillingSpaceBtn() {
		
		return createBillingSpaceBtn;
		
	}

	public WebElement spaceName() {
		
		return spaceName;
		
	}

	public WebElement billNumberDropDown() {
		
		return billNumberDropDown;
		
	}

	public WebElement confirmBtn() {
		
		return confirmBtn;
		
	}
		
}
