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

	
    @FindBy(xpath="//span[@style='display: table-cell; vertical-align: middle; white-space: nowrap;']")
	WebElement ProfileIcon;

	@FindBy(xpath="//button[@class='me-2 d-none d-sm-block undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-medium__WWpFr false']")
	WebElement addBillNumberBtn;

	@FindBy(xpath="//input[@name='label']")
	WebElement billingLabel;

	@FindBy(css="div[class='d-block'] div[class='app-select_appSelectInput__9RUe8 undefined']")
	WebElement tariffDrop;

	@FindBy(xpath="//div[contains(text(),'D1 - DOMESTIC')]")
	WebElement optionDrop;

    @FindBy(xpath="//input[@name='accountNumber']")
	WebElement billNumber;

     @FindBy(xpath="//div[contains(text(),'Confirm')]")
	WebElement confirmBtn;

	 @FindBy(xpath="(//td[@class='text-light font-size-12 font-weight-400'])[5]")
	 WebElement editBillNumberIcon;
	
	public WebElement ProfileIcon() {
		
		return ProfileIcon;
		
	}
	
	public WebElement addBillNumberBtn() {
		
		return addBillNumberBtn;
		
	}

	public WebElement billingLabel() {

		return billingLabel;
	}

	public WebElement tariffDrop(){
		return tariffDrop;
	}

	public WebElement optionDrop(){
		return optionDrop;
	}


	public WebElement billNumber() {
		
		return billNumber;
		
	}

    public WebElement confirmBtn() {
		
		return confirmBtn;
		
	}

	public WebElement editBillNumberIcon(){
		return editBillNumberIcon;
	}
		
}


