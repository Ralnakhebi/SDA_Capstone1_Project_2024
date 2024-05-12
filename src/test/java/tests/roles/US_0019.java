package tests.roles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

@Listeners(utilities.Listeners.class)
public class US_0019 {
    RolesPage rolesPage = new RolesPage();
    RoleDetailPage roleDetailPage = new RoleDetailPage();
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
    @Test(testName = "TC01", description = "roles are clickable and permissions are listed")
    public void rolesAndPermissionsTest(){

        rolesPage.rolesModule.click(); // click on roles module

        // for loop to click roles one by one and verify permissions are listed
        for(int i=0; i<rolesPage.rolesList.size(); i++){
            rolesPage.rolesList.get(i).click();
            Assert.assertTrue(roleDetailPage.roleInfoTitle.isDisplayed());
            Assert.assertTrue(roleDetailPage.permissionsList.size()>0);
            rolesPage.rolesModule.click(); // go back to roles page
        }

    }
}
