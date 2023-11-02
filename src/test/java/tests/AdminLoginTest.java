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

	@Test(dataProvider="getLoginData",priority = 1)
	public void successAdminLoginWithValidUsernameAndPassword(String email, String password) throws IOException, InterruptedException {
	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();

		Thread.sleep(6000);
		Assert.assertTrue(loginPage.successToastMessage().isDisplayed());

	}

	@Test(priority = 2)
	public void unSuccessAdminLoginWithInvalidUsernameAndPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys("oversight_admi");
		loginPage.passwordField().sendKeys("welCome1");
		loginPage.loginButton().click();

		Thread.sleep(6000);
		Assert.assertTrue(loginPage.adminUnSuccessToastMessage().isDisplayed());

	}

	@Test(priority = 3)
	public void unSuccessAdminLoginWithValidUsernameAndInvalidPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys("oversight_admin");
		loginPage.passwordField().sendKeys("welCome1");
		loginPage.loginButton().click();

		Thread.sleep(6000);
		Assert.assertTrue(loginPage.adminUnSuccessToastMessage().isDisplayed());

	}

	@Test(priority = 4)
	public void unSuccessAdminLoginWithInvalidUsernameAndValidPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys("oversight_admi");
		loginPage.passwordField().sendKeys("welCome1/");
		loginPage.loginButton().click();

		Thread.sleep(6000);
		Assert.assertTrue(loginPage.adminUnSuccessToastMessage().isDisplayed());

	}

	@Test(priority = 5)
	public void unSuccessAdminLoginWithoutUsernameAndPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys("");
		loginPage.passwordField().sendKeys("");
		loginPage.loginButton().click();

		Thread.sleep(6000);
		Assert.assertTrue(loginPage.validationMessageOfUsername().isDisplayed());
		Assert.assertTrue(loginPage.getValidationMessageOfPassword().isDisplayed());

	}
	

	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"oversight_admin", "welCome1/"}};
		
		return data;
		
	}

	@AfterMethod
	public void browserClose() {

		driver.close();

	}
}
