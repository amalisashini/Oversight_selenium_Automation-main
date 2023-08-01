package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.Solar;
import resources.Base;

public class SolarTest extends Base{
    WebDriver driver;    

    @Test(dataProvider="giveLoginData")
	public void login(String email, String password) throws IOException, InterruptedException {

        driver = initializeDriver();
		driver.get(prop.getProperty("consumerurl"));
	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();

        Solar solarSpace = new Solar(driver);
           
        JavascriptExecutor newSolar = (JavascriptExecutor) driver;
        newSolar.executeScript("arguments[0].click();", solarSpace.solarBtn());

        JavascriptExecutor CreateSolar = (JavascriptExecutor) driver;
        CreateSolar.executeScript("arguments[0].click();", solarSpace.createSolarBtn());

        solarSpace.solarName().sendKeys("new solar new");

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='app-select_appSelectInput__9RUe8 undefined']"));
        dropdown.click();

        WebElement option = driver.findElement(By.xpath("//div[contains(text(),'Test 1')]"));
        option.click();

        solarSpace.wattage().sendKeys("2");

        solarSpace.numberOfPanels().sendKeys("3");

        solarSpace.inverterCapacity().sendKeys("20");

        solarSpace.locationName().sendKeys("Kandy");

        JavascriptExecutor addBillconirmBtn = (JavascriptExecutor) driver;
        addBillconirmBtn.executeScript("arguments[0].click();", solarSpace.confirm());

    }

    @DataProvider
	public Object[][] giveLoginData() {
		
		Object[][] data = {{"oversight_user", "welCome1/"}};
		
		return data;
		
	}
    
}
