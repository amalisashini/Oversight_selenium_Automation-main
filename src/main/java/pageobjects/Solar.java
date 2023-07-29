package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Solar {

    WebDriver driver;
	
	public Solar(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
    
}

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]")
	WebElement solarBtn;
	
	@FindBy(xpath="//button[@class='undefined undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-large__uIHei app-button_appIconButton__9mhgd']")
	WebElement createSolarBtn;

	//Space name
	@FindBy(xpath="//input[@name='spaceClusterLabel']")
	WebElement spaceName;

	//Billing number dropdown
	@FindBy(xpath="//div[@class='app-select_appSelectInput__9RUe8 undefined']")
	WebElement billNumberDropDown;

	@FindBy(xpath="//div[contains(text(),'label2 - 22220000')]")
	WebElement selectOption;

	 @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/button[1]/div[1]/div[1]]")
	WebElement confirmBtn;

	
	public WebElement solarBtn() {
		
		return solarBtn;
		
	}
	
	public WebElement createSolarBtn() {
		
		return createSolarBtn;
		
	}

	public WebElement spaceName() {
		
		return spaceName;
		
	}

	public WebElement billNumberDropDown() {
		
		return billNumberDropDown;
		
	}

	public WebElement selectOption() {
		
		return selectOption;
		
	}

	public WebElement confirmBtn() {
		
		return confirmBtn;
		
	}

}