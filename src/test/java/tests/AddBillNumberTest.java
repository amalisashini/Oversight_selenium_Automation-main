package tests;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AddBillNumber;
import pageobjects.LoginPage;
import resources.Base;

public class AddBillNumberTest extends Base{
     WebDriver driver;    

    @Test(dataProvider="giveLoginData",priority = 1)
	public void login(String email, String password) throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("consumerurl"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailAddressTextField().sendKeys(email);
        loginPage.passwordField().sendKeys(password);
        loginPage.loginButton().click();

    }

        @Test(priority = 2)
        public void addBillNumber() throws InterruptedException {

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
            Thread.sleep(2000);

            Assert.assertTrue(addBill.addingSuccessToastMessage().isDisplayed());

            Thread.sleep(2000);

        }
        @Test(priority = 3)
        public void addBillNumberWithoutFillingFields() throws InterruptedException {

            AddBillNumber addBill = new AddBillNumber(driver);

            JavascriptExecutor addBillBtn = (JavascriptExecutor) driver;
            addBillBtn.executeScript("arguments[0].click();", addBill.addBillNumberBtn());

            String randomLabel = RandomStringUtils.randomAlphabetic(8);
            addBill.billingLabel().sendKeys("");

            String randomBillNumber = RandomStringUtils.randomNumeric(8);
            addBill.billNumber().sendKeys("");

            JavascriptExecutor addBillConfirmBtn = (JavascriptExecutor) driver;
            addBillConfirmBtn.executeScript("arguments[0].click();", addBill.confirmBtn());

            Thread.sleep(2000);

            Assert.assertTrue(addBill.labelValidation().isDisplayed());
            Assert.assertTrue(addBill.tariffDropValidation().isDisplayed());
            Assert.assertTrue(addBill.accountNumberValidation().isDisplayed());

            addBill.cancelButton().click();

            Thread.sleep(2000);

        }

    @Test(priority = 4)
    public void verifyAddExistBillLabel() throws InterruptedException {

        AddBillNumber addBill = new AddBillNumber(driver);

        JavascriptExecutor addBillBtn = (JavascriptExecutor) driver;
        addBillBtn.executeScript("arguments[0].click();", addBill.addBillNumberBtn());

        String randomLabel = RandomStringUtils.randomAlphabetic(8);
        addBill.billingLabel().sendKeys("label 2");

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

        Thread.sleep(3000);
        Assert.assertTrue(addBill.existBillLabelValidation().isDisplayed());
        addBill.cancelButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void verifyAddExistBillAccountNumber() throws InterruptedException {

        AddBillNumber addBill = new AddBillNumber(driver);

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
        addBill.billNumber().sendKeys("000000002");

        JavascriptExecutor addBillConfirmBtn = (JavascriptExecutor) driver;
        addBillConfirmBtn.executeScript("arguments[0].click();", addBill.confirmBtn());

        Thread.sleep(3000);
        Assert.assertTrue(addBill.existBillNumberValidation().isDisplayed());
        addBill.cancelButton().click();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void characterValidation() throws InterruptedException {

        AddBillNumber addBill = new AddBillNumber(driver);

        JavascriptExecutor addBillBtn = (JavascriptExecutor) driver;
        addBillBtn.executeScript("arguments[0].click();", addBill.addBillNumberBtn());

        addBill.billingLabel().sendKeys("876543*^(^(");

        WebElement dropdown = addBill.tariffDrop();

        Actions a=new Actions(driver);

        if (dropdown.isDisplayed() && dropdown.isEnabled()) {
            dropdown.click();
        }

        a.sendKeys(Keys.ENTER).perform();

        addBill.billNumber().sendKeys("number%^&^^");

        JavascriptExecutor addBillConfirmBtn = (JavascriptExecutor) driver;
        addBillConfirmBtn.executeScript("arguments[0].click();", addBill.confirmBtn());

        Thread.sleep(3000);
        Assert.assertTrue(addBill.characterValidationLabel().isDisplayed());
        Assert.assertTrue(addBill.characterValidationAccountNumber().isDisplayed());

    }



    @DataProvider
	public Object[][] giveLoginData() {
		
		Object[][] data = {{"Sanduni_Herath", "Sanduni1998#"}};
		
		return data;
		
	}



}