package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AddBillingSpace;
import pageobjects.LoginPage;
import resources.Base;


public class AddBillingSpaceTest extends Base{
  
   WebDriver driver;    

    @Test(dataProvider="giveLoginData")
	public void login(String email, String password) throws IOException, InterruptedException {

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

        billSpace.spaceName().sendKeys("New Space");

        // JavascriptExecutor billNumDrop = (JavascriptExecutor) driver;
        // billNumDrop.executeScript("arguments[0].click();", billSpace.billNumberDropDown());

        // billSpace.billNumberDropDown().sendKeys("label2 - 22220000");

        // WebElement dropdown = billSpace.billNumberDropDown();
        // String optionTextToSelect = "Option text to select";
        // String script = String.format("for (const option of arguments[0].options) { if (option.text === '%s') { option.selected = true; break; } }", optionTextToSelect);
        // ((JavascriptExecutor) driver).executeScript(script, dropdown);

        JavascriptExecutor addBillconirmBtn = (JavascriptExecutor) driver;
        addBillconirmBtn.executeScript("arguments[0].click();", billSpace.confirmBtn());
		
	}

    @DataProvider
	public Object[][] giveLoginData() {
		
		Object[][] data = {{"oversight_user", "welCome1/"}};
		
		return data;
		
	}
    
}