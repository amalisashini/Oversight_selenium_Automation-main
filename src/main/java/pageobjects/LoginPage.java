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
	
	public WebElement emailAddressTextField() {
		
		return emailAddressTextField;
		
	}
	
	public WebElement passwordField() {
		
		return passwordField;
		
	}
	
	public WebElement loginButton() {
		
		return loginButton;
	}
}
