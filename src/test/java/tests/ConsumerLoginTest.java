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

	@Test(dataProvider="getLoginData",priority = 1)
	public void successLoginWithValidUsernameAndPassword(String email, String password) throws IOException, InterruptedException {
	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();

		Thread.sleep(6000);
		Assert.assertTrue(loginPage.successToastMessage().isDisplayed());
		
	}

	@Test(priority = 2)
	public void unSuccessLoginWithInvalidUsernameAndPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys("Sanduni_Herat");
		loginPage.passwordField().sendKeys("Sanduni1999#");
		loginPage.loginButton().click();

		Thread.sleep(6000);
		Assert.assertTrue(loginPage.unSuccessToastMessage().isDisplayed());

	}

	@Test(priority = 3)
	public void unSuccessLoginWithValidUsernameAndInvalidPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys("Sanduni_Herath");
		loginPage.passwordField().sendKeys("Sanduni1999#");
		loginPage.loginButton().click();

		Thread.sleep(6000);
		Assert.assertTrue(loginPage.unSuccessToastMessage().isDisplayed());

	}

	@Test(priority = 4)
	public void unSuccessLoginWithInvalidUsernameAndValidPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys("Sanduni_Herat");
		loginPage.passwordField().sendKeys("Sanduni1998#");
		loginPage.loginButton().click();

		Thread.sleep(6000);
		Assert.assertTrue(loginPage.unSuccessToastMessage().isDisplayed());

	}

	@Test(priority = 5)
	public void unSuccessLoginWithoutUsernameAndPassword() throws InterruptedException {

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
		
		Object[][] data = {{"Sanduni_Herath", "Sanduni1998#"}};
		
		return data;
		
	}

	@AfterMethod
	public void browserClose() {

		driver.close();

	}
}
