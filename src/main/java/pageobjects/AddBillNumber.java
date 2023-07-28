package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBillNumber {
     WebDriver driver;
	
	public AddBillNumber(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	
	}
	
	// @FindBy(xpath="//div[@class='px-2 order-1 order-lg-2 col-auto']")
	// WebElement ProfileIcon;
	
    @FindBy(xpath="//span[@style='display: table-cell; vertical-align: middle; white-space: nowrap;']")
	WebElement ProfileIcon;

	@FindBy(xpath="//button[@class='me-2 d-none d-sm-block undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-medium__WWpFr false']")
	WebElement addBillNumberBtn;

	//Space name
	@FindBy(xpath="//input[@name='label']")
	WebElement billingLabel;

    @FindBy(xpath="//input[@name='accountNumber']")
	WebElement billNumber;

     @FindBy(xpath="//div[contains(text(),'Confirm')]")
	WebElement confirmBtn;
	
	public WebElement ProfileIcon() {
		
		return ProfileIcon;
		
	}
	
	public WebElement addBillNumberBtn() {
		
		return addBillNumberBtn;
		
	}

	public WebElement billingLabel() {
		
		return billingLabel;
		
	}

    public WebElement billNumber() {
		
		return billNumber;
		
	}

    public WebElement confirmBtn() {
		
		return confirmBtn;
		
	}
		
}


