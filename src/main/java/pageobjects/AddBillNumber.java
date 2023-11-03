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

	
    @FindBy(xpath="//div[@class='px-2 order-1 order-lg-2 col-auto']//a")
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

	@FindBy(xpath="//div[contains(text(),'Account Number Added Successfully')]")
	WebElement addingSuccessToastMessage;

	@FindBy(xpath="//div[@class='d-block']//div[@class='col-auto col'][normalize-space()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath="//input[@name='label']/following::span[text()='Label is required']")
	WebElement labelValidation;

	@FindBy(xpath="//input[@name='tariffCode']/following::span[text()='Please select a tariff code']")
	WebElement tariffDropValidation;

	@FindBy(xpath="//input[@name='accountNumber']/following::span[text()='Account number is required']")
	WebElement accountNumberValidation;

	@FindBy(xpath="//div[@id='root']//following::div[text()='Inserted billing label is already in use, please add a different one']")
	WebElement existBillLabelValidation;

	@FindBy(xpath="//div[@id='root']//following::div[text()='Account number can not be add or update using already added account number']")
	WebElement existBillNumberValidation;

	@FindBy(xpath="//span[contains(text(),\"Entered value can't start/end or contain only white spaces and can't contain special characters\")]")
	WebElement characterValidationLabel;

	@FindBy(xpath="//span[contains(text(),'Only numerics are allowed')]")
	WebElement characterValidationAccountNumber;

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

	public WebElement addingSuccessToastMessage(){
		return addingSuccessToastMessage;
	}

	public WebElement cancelButton(){
		return cancelButton;
	}

	public WebElement labelValidation(){
		return labelValidation;
	}

	public WebElement tariffDropValidation(){
		return tariffDropValidation;
	}

	public WebElement accountNumberValidation(){
		return accountNumberValidation;
	}

	public WebElement existBillLabelValidation(){
		return existBillLabelValidation;
	}

	public WebElement existBillNumberValidation(){
		return existBillNumberValidation;
	}

	public WebElement characterValidationLabel(){
		return characterValidationLabel;
	}

	public WebElement characterValidationAccountNumber(){
		return characterValidationAccountNumber;
	}

		
}


