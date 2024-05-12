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
    RolesPage rolesPage = new RolesPage();
    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        loginPage.login(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    @Test(testName = "TC01")
    public void rolesListedTest(){
        rolesPage.rolesModule.click();

        for(WebElement role : rolesPage.rolesList){
            System.out.println(role.getText());
            Assert.assertTrue(role.isDisplayed());
        }
        Assert.assertEquals(rolesPage.rolesList.size(),16);
    }
}
