package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.AddBillNumber;
import pageobjects.LoginPage;
import pageobjects.Profile;
import resources.Base;

import java.io.IOException;

    public class ProfileUpdateTest extends Base {

    WebDriver driver;

    @Test(dataProvider="giveLoginData")
    public void profileUpdate(String email, String password) throws IOException {

    driver.get("https://oversight-dev.syntaxgenie.com/");

    LoginPage loginPage = new LoginPage(driver);

    loginPage.emailAddressTextField().sendKeys(email);
    loginPage.passwordField().sendKeys(password);
    loginPage.loginButton().click();

    AddBillNumber proIcon = new AddBillNumber(driver);

    JavascriptExecutor icon = (JavascriptExecutor) driver;
    icon.executeScript("arguments[0].click();", proIcon.ProfileIcon());

    Profile proUpdate = new Profile(driver);

    JavascriptExecutor editB = (JavascriptExecutor) driver;
    editB.executeScript("arguments[0].click();",  proUpdate.editButton());

    //proUpdate.firstName().sendKeys("Ama");

}

    @DataProvider
    public Object[][] giveLoginData() {

        Object[][] data = {{"Sanduni_Herath", "Sanduni1998#"}};

        return data;

    }

}
