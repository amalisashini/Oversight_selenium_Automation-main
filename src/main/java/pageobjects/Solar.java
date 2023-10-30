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

    @FindBy(xpath="//span[contains(text(),'Solar')][1]")
	WebElement solarBtn;
	
	@FindBy(xpath="//button[@class='undefined undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-large__uIHei app-button_appIconButton__9mhgd']")
	WebElement createSolarBtn;

	//Solar name
	@FindBy(xpath="//input[@name='name']")
	WebElement solarName;

	//Dropdown
	@FindBy(css="div[class='d-block'] div[class='app-select_appSelectInput__9RUe8 undefined']")
	WebElement spaceDropdown;

	//Option
	@FindBy(xpath="//div[contains(text(),'Test 1')]")
	WebElement option;

	//wattage of panel
	@FindBy(xpath="//input[@placeholder='Wattage']")
	WebElement wattage;

	//Number of panels
	@FindBy(xpath="//input[@placeholder='Number of Panels']")
	WebElement numberOfPanels;

	//Number of panels
	@FindBy(xpath="//input[@placeholder='Inverter Capacity']")
	WebElement inverterCapacity;

	@FindBy(xpath="//input[@name='locationName']")
	WebElement locationName;

	@FindBy(css="div[class='d-block'] div[class='col-auto'] div[class='justify-content-center align-items-center g-2 row']")
	WebElement confirmButton;

	
	public WebElement solarBtn() {
		
		return solarBtn;
		
	}
	
	public WebElement createSolarBtn() {
		
		return createSolarBtn;
		
	}

	public WebElement solarName() {
		
		return solarName;
		
	}

	public WebElement spaceDropdown() {
		
		return spaceDropdown;
		
	}

	public WebElement option() {
		
		return option;
		
	}

	public WebElement wattage() {
		
		return wattage;
		
	}

	public WebElement numberOfPanels() {
		
		return numberOfPanels;
		
	}

	public WebElement inverterCapacity() {
		
		return inverterCapacity;
		
	}

	public WebElement locationName() {
		
		return locationName;
		
	}

	public WebElement confirmButton(){
		return confirmButton;
	}


}