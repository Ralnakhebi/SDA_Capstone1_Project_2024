package tests.roles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RolesPage;
import pages.WelcomePage;
import utilities.ConfigReader;
import utilities.Driver;
@Listeners(utilities.Listeners.class)
public class US_0018 {

    @Test(testName = "TC01")
    public void rolesListedTest(){
        RolesPage rolesPage = new RolesPage();
        WelcomePage welcomePage = new WelcomePage();
        LoginPage loginPage = new LoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();

        if (Driver.getDriver().getCurrentUrl().equals("https://a3m-qa-gm3.quaspareparts.com/login")) {
            loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));}

        rolesPage.rolesModule.click();

        for(WebElement role : rolesPage.rolesList){
            System.out.println(role.getText());
            Assert.assertTrue(role.isDisplayed());
        }
        Assert.assertEquals(rolesPage.rolesList.size(),14);
        Driver.closeDriver();
    }
}
