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

    @FindBy(xpath="(//span[contains(@class,'ms-2')][normalize-space()='Solar'])[1]")
	WebElement solarBtn;
	
	@FindBy(xpath="//button[@class='undefined undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-large__uIHei app-button_appIconButton__9mhgd']")
	WebElement createSolarBtn;

	//Solar name
	@FindBy(xpath="//div[@class='d-block']//input[@name='name']")
	WebElement solarName;

	//Dropdown
	@FindBy(xpath="//div[@class='d-block']//div[contains(@class,'css-19bb58m')]")
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

	@FindBy(xpath="//div[text()='Solar Device Added Successfully']")
	WebElement solarAddingSuccessMessage;

	@FindBy(xpath="//input[@name='name']/following::span[text()='Solar name is required']")
	WebElement solarNameValidation;

	@FindBy(xpath="//input[@name='spaceClusterId']/following::span[text()='Please select an affected space']")
	WebElement spaceDropdownValidation;

	@FindBy(xpath="//input[@placeholder='Wattage']/following::p[text()='Wattage must be required']")
	WebElement wattageValidation;

	@FindBy(xpath="//input[@placeholder='Number of Panels']/following::p[text()='Number of panels must be required']")
	WebElement numberOfPanelsValidation;

	@FindBy(xpath="//input[@placeholder='Inverter Capacity']/following::p[text()='Inverter capacity must be required']")
	WebElement inverterCapacityValidation;

	@FindBy(xpath="//input[@name='locationName']/following::span[text()='Location is required']")
	WebElement locationValidation;

	@FindBy(xpath="//div[contains(text(),'Input Generation')]")
	WebElement addSolarGeneration;

	@FindBy(xpath="//div[@class='d-block']//div[@class='col-auto col'][normalize-space()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath="//div[contains(text(),'This solar name is already in use')]")
	WebElement existSolarNameToast;

	
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

	public WebElement solarAddingSuccessMessage(){
		return solarAddingSuccessMessage;
	}

	public WebElement addSolarGeneration(){
		return addSolarGeneration;
	}

	public WebElement solarNameValidation(){
		return solarNameValidation;
	}

	public WebElement spaceDropdownValidation(){
		return spaceDropdownValidation;
	}

	public WebElement wattageValidation(){
		return wattageValidation;
	}

	public WebElement numberOfPanelsValidation(){
		return numberOfPanelsValidation;
	}

	public WebElement inverterCapacityValidation(){
		return inverterCapacityValidation;
	}

	public WebElement locationValidation(){
		return locationValidation;
	}

	public WebElement cancelBtn(){
		return cancelBtn;
	}

	public WebElement existSolarNameToast(){
		return existSolarNameToast;
	}
}