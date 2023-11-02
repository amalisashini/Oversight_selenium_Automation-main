package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement emailAddressTextField;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;

	@FindBy(xpath="//div[@class='justify-content-center align-items-center g-2 row']")
	WebElement loginButton;

	@FindBy(xpath="//span[contains(text(),'Hello,')]")
	WebElement headerText;

	@FindBy(css="div[role='alert'] div:nth-child(2)")
	WebElement successToastMessage;

	@FindBy(xpath="//div[contains(text(),'Bad credentials')]")
	WebElement unSuccessToastMessage;

	@FindBy(xpath="//div[contains(text(),'Login Unsuccessful')]")
	WebElement adminUnSuccessToastMessage;

	@FindBy(xpath="//input[@name='username']/following::span[text()='Username or Email is required']")
	WebElement validationMessageOfUsername;

	@FindBy(xpath="//input[@name='password']/following::span[text()='Password is required']")
	WebElement getValidationMessageOfPassword;
	
	public WebElement emailAddressTextField() {
		
		return emailAddressTextField;
		
	}
	
	public WebElement passwordField() {
		
		return passwordField;
		
	}
	
	public WebElement loginButton() {
		
		return loginButton;
	}

	public WebElement headerText(){
		return headerText;
	}

	public WebElement successToastMessage(){
		return successToastMessage;
	}

	public WebElement unSuccessToastMessage(){
		return unSuccessToastMessage;
	}

	public WebElement adminUnSuccessToastMessage(){
		return adminUnSuccessToastMessage;
	}

	public WebElement validationMessageOfUsername(){
		return validationMessageOfUsername;
	}

	public WebElement getValidationMessageOfPassword(){
		return getValidationMessageOfPassword;
	}
}
