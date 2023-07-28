package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {
    WebDriver driver;
	
    public Profile(WebDriver driver){
    	
    	this.driver = driver;
    	
    	PageFactory.initElements(driver,this);
    	    	
    }
    
    @FindBy(xpath="//span[@class='d-none d-md-inline-block']")
    WebElement profileName;
    
    public WebElement profileName() {
    	
    	return profileName;
    	
    }
}
