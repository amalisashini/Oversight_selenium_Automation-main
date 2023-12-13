package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AddBillingSpace;
import pageobjects.LoginPage;
import resources.Base;


public class AddBillingSpaceTest extends Base{
  
   WebDriver driver;


    @Test(dataProvider="giveLoginData")
	public void login(String email, String password) throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("consumerurl"));
	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();

        AddBillingSpace billSpace = new AddBillingSpace(driver);
           
        JavascriptExecutor newspace = (JavascriptExecutor) driver;
        newspace.executeScript("arguments[0].click();", billSpace.deviceBtn());

        JavascriptExecutor billSpaceBtn = (JavascriptExecutor) driver;
        billSpaceBtn.executeScript("arguments[0].click();", billSpace.createBillingSpaceBtn());

        String randomSpaceName = RandomStringUtils.randomAlphabetic(8);
        billSpace.spaceName().sendKeys(randomSpaceName);

        WebElement dropdown = billSpace.billNumberDropDown();

        Actions a=new Actions(driver);
     
        if (dropdown.isDisplayed() && dropdown.isEnabled()) {
         dropdown.click();
        }

        a.sendKeys(Keys.ENTER).perform();

        billSpace.confirmBtn().click();

      
	}

    @DataProvider
	public Object[][] giveLoginData() {
		
		Object[][] data = {{"Sanduni_Herath", "Saduni1998#"}};
		
		return data;
		
	}
    
}
