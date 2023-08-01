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

	 @FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/button[1]/div[1]/div[1]]")
	WebElement confirm;

	
	public WebElement solarBtn() {
		
		return solarBtn;
		
	}
	
	public WebElement createSolarBtn() {
		
		return createSolarBtn;
		
	}

	public WebElement solarName() {
		
		return solarName;
		
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

	public WebElement confirm() {
		
		return confirm;
		
	}

}