package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.reactivex.rxjava3.functions.Action;
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

        billSpace.spaceName().sendKeys("space space space");

        // JavascriptExecutor billNumberDropDown = (JavascriptExecutor) driver;
        // billNumberDropDown.executeScript("arguments[0].click();", billSpace.billNumberDropDown());

        // JavascriptExecutor option = (JavascriptExecutor) driver;
        // option.executeScript("arguments[0].click();", billSpace.selectOption());

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='app-select_appSelectInput__9RUe8 undefined']"));
 Actions a=new Actions(driver);
     
        if (dropdown.isDisplayed() && dropdown.isEnabled()) {
         dropdown.click();
        }


        a.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);
        billSpace.confirmBtn().click();

        // JavascriptExecutor confirm = (JavascriptExecutor) driver;
        // confirm.executeScript("arguments[0].click();", billSpace.confirmBtn());
      
	}

    @DataProvider
	public Object[][] giveLoginData() {
		
		Object[][] data = {{"oversight_user", "welCome1/"}};
		
		return data;
		
	}
    
}
