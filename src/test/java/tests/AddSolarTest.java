package tests;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.Solar;
import resources.Base;

public class AddSolarTest extends Base{
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
	public void addSolar() throws InterruptedException {

        Solar solarSpace = new Solar(driver);

        Thread.sleep(2000);
           
        JavascriptExecutor newSolar = (JavascriptExecutor) driver;
        newSolar.executeScript("arguments[0].click();", solarSpace.solarBtn());

        JavascriptExecutor CreateSolar = (JavascriptExecutor) driver;
        CreateSolar.executeScript("arguments[0].click();", solarSpace.createSolarBtn());

        Thread.sleep(2000);

        String randomSolarName = RandomStringUtils.randomAlphabetic(8);
        solarSpace.solarName().sendKeys(randomSolarName);

        WebElement spaceDrop = solarSpace.spaceDropdown();

        Actions a=new Actions(driver);
     
        if (spaceDrop.isDisplayed() && spaceDrop.isEnabled()) {
            spaceDrop.click();
        }

        a.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);

        solarSpace.wattage().sendKeys("2");

        solarSpace.numberOfPanels().sendKeys("3");

        solarSpace.inverterCapacity().sendKeys("20");

        solarSpace.locationName().sendKeys("Kandy");

        JavascriptExecutor confirm = (JavascriptExecutor) driver;
        confirm.executeScript("arguments[0].click();",  solarSpace.confirmButton());

        Thread.sleep(4000);

        Assert.assertTrue(solarSpace.solarAddingSuccessMessage().isDisplayed());

        Thread.sleep(4000);

    }

    @Test(priority = 3)
    public void addSolarWithoutFillingFields() throws InterruptedException {

        Solar solarSpace = new Solar(driver);

        JavascriptExecutor CreateSolar = (JavascriptExecutor) driver;
        CreateSolar.executeScript("arguments[0].click();", solarSpace.createSolarBtn());

        Thread.sleep(2000);

        String randomSolarName = RandomStringUtils.randomAlphabetic(8);
        solarSpace.solarName().sendKeys("");

        solarSpace.wattage().sendKeys("");

        solarSpace.numberOfPanels().sendKeys("");

        solarSpace.inverterCapacity().sendKeys("");

        solarSpace.locationName().sendKeys("");

        JavascriptExecutor confirm = (JavascriptExecutor) driver;
        confirm.executeScript("arguments[0].click();",  solarSpace.confirmButton());
        Thread.sleep(2000);

        Assert.assertTrue(solarSpace.solarNameValidation().isDisplayed());
        Assert.assertTrue(solarSpace.spaceDropdownValidation().isDisplayed());
        Assert.assertTrue(solarSpace.wattageValidation().isDisplayed());
        Assert.assertTrue(solarSpace.numberOfPanelsValidation().isDisplayed());
        Assert.assertTrue(solarSpace.inverterCapacityValidation().isDisplayed());
        Assert.assertTrue(solarSpace.locationValidation().isDisplayed());

        Thread.sleep(2000);

        solarSpace.cancelBtn().click();

    }

    @Test(priority = 4)
    public void addExistingSolarName() throws InterruptedException {

        Solar solarSpace = new Solar(driver);

        JavascriptExecutor CreateSolar = (JavascriptExecutor) driver;
        CreateSolar.executeScript("arguments[0].click();", solarSpace.createSolarBtn());

        Thread.sleep(2000);

        solarSpace.solarName().sendKeys("Test Solar 2");
        Thread.sleep(2000);

        WebElement spaceDrop = solarSpace.spaceDropdown();

        Actions a=new Actions(driver);

        if (spaceDrop.isDisplayed() && spaceDrop.isEnabled()) {
            spaceDrop.click();
        }

        a.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);

        solarSpace.wattage().sendKeys("100");

        solarSpace.numberOfPanels().sendKeys("2");

        solarSpace.inverterCapacity().sendKeys("200");

        solarSpace.locationName().sendKeys("Kandy");

        JavascriptExecutor confirm = (JavascriptExecutor) driver;
        confirm.executeScript("arguments[0].click();",  solarSpace.confirmButton());
        Thread.sleep(2000);

        Assert.assertTrue(solarSpace.existSolarNameToast().isDisplayed());

        Thread.sleep(2000);

        solarSpace.cancelBtn().click();

    }

    @DataProvider
	public Object[][] giveLoginData() {
		
		Object[][] data = {{"Sanduni_Herath", "Sanduni1998#"}};
		
		return data;
		
	}
    
}