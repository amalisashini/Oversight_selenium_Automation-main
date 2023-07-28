package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.Profile;
import resources.Base;

public class AdminLoginTest extends Base{
    WebDriver driver;

	 @BeforeMethod
	public void openApplication() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("adminurl"));
		
	}

	@Test(dataProvider="getLoginData")
	public void login(String email, String password, String expectedResult) throws IOException, InterruptedException {
	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();
		
		Profile profilePage = new Profile(driver);
		
		String actualResult = null;
		
		try {
			
			if(profilePage.profileName().isDisplayed()) {
			   actualResult = "Success";
			}
			
		} catch(Exception e) {
			
			actualResult = "Failure";
			
		}
		
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	@AfterMethod
	public void closure() {
		
		driver.close();
		
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"oversight_admin", "welCome1/", "Success"}, {"dummy@test.com", "1234", "Failure"}};
		
		return data;
		
	}
}
