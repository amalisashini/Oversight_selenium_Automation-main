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

public class ConsumerLoginTest extends Base {

   WebDriver driver;

   @BeforeMethod
	public void openApplication() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("consumerurl"));
		
	}

	@Test(dataProvider="getLoginData")
	public void login(String email, String password) throws IOException {
	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();

		
		String actualHeader= "Hello,";
		String expectedHeader = loginPage.headerText().getText();
		Assert.assertEquals(actualHeader, expectedHeader);
		
	}
	
	@AfterMethod
	public void closure() {
		
		driver.close();
		
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"oversight_user", "welCome1/"}};
		
		return data;
		
	}

}
