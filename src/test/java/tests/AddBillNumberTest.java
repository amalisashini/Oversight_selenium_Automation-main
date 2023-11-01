package tests;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AddBillNumber;
import pageobjects.LoginPage;
import resources.Base;

public class AddBillNumberTest extends Base{
     WebDriver driver;    

    @Test(dataProvider="giveLoginData",priority = 1)
	public void login(String email, String password) throws IOException, InterruptedException {

        driver = initializeDriver();
        driver.get(prop.getProperty("consumerurl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailAddressTextField().sendKeys(email);
        loginPage.passwordField().sendKeys(password);
        loginPage.loginButton().click();

    }

        @Test(priority = 2)
        public void addBillNumber(){

            AddBillNumber addBill = new AddBillNumber(driver);

            JavascriptExecutor proIcon = (JavascriptExecutor) driver;
            proIcon.executeScript("arguments[0].click();", addBill.ProfileIcon());

            JavascriptExecutor addBillBtn = (JavascriptExecutor) driver;
            addBillBtn.executeScript("arguments[0].click();", addBill.addBillNumberBtn());

            String randomLabel = RandomStringUtils.randomAlphabetic(8);
            addBill.billingLabel().sendKeys(randomLabel);

            WebElement dropdown = addBill.tariffDrop();

            Actions a=new Actions(driver);

            if (dropdown.isDisplayed() && dropdown.isEnabled()) {
                dropdown.click();
            }

            a.sendKeys(Keys.ENTER).perform();

            String randomBillNumber = RandomStringUtils.randomNumeric(8);
            addBill.billNumber().sendKeys(randomBillNumber);

            JavascriptExecutor addBillConfirmBtn = (JavascriptExecutor) driver;
            addBillConfirmBtn.executeScript("arguments[0].click();", addBill.confirmBtn());

        }

        @Test(priority = 3)
        public void editBillNumber(){

            AddBillNumber edit = new AddBillNumber(driver);

            JavascriptExecutor editI = (JavascriptExecutor) driver;
            editI.executeScript("arguments[0].click();",  edit.editBillNumberIcon());

            edit.billingLabel().clear();
            edit.billingLabel().sendKeys("randomLabel");


        }



    @DataProvider
	public Object[][] giveLoginData() {
		
		Object[][] data = {{"Sanduni_Herath", "Sanduni1998#"}};
		
		return data;
		
	}

}