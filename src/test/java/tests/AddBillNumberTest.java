package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AddBillNumber;
import pageobjects.LoginPage;
import resources.Base;

public class AddBillNumberTest extends Base{
     WebDriver driver;    

    @Test(dataProvider="giveLoginData")
	public void login(String email, String password) throws IOException, InterruptedException {

        driver = initializeDriver();
		driver.get(prop.getProperty("consumerurl"));
	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();

        AddBillNumber addBill = new AddBillNumber(driver);

        JavascriptExecutor proIcon = (JavascriptExecutor) driver;
        proIcon.executeScript("arguments[0].click();", addBill.ProfileIcon());

        JavascriptExecutor addBillBtn = (JavascriptExecutor) driver;
        addBillBtn.executeScript("arguments[0].click();", addBill.addBillNumberBtn());

        addBill.billingLabel().sendKeys("Label new 1");

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='app-select_appSelectInput__9RUe8 undefined']"));
        dropdown.click();

         WebElement option = driver.findElement(By.xpath("//div[contains(text(),'D1 - DOMESTIC')]"));
        option.click();

        addBill.billNumber().sendKeys("00009876");

        JavascriptExecutor addBillconirmBtn = (JavascriptExecutor) driver;
        addBillconirmBtn.executeScript("arguments[0].click();", addBill.confirmBtn());

}

    @DataProvider
	public Object[][] giveLoginData() {
		
		Object[][] data = {{"oversight_user", "welCome1/"}};
		
		return data;
		
	}

}