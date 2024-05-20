package tests.roles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

@Listeners(utilities.Listeners.class)
public class US_0019 {

    @Test(testName = "TC01", description = "roles are clickable")
    public void rolesTest(){
        RolesPage rolesPage = new RolesPage();
        RoleDetailPage roleDetailPage = new RoleDetailPage();
        WelcomePage welcomePage = new WelcomePage();
        LoginPage loginPage = new LoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();

        if (Driver.getDriver().getCurrentUrl().equals("https://a3m-qa-gm3.quaspareparts.com/login")) {
            loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));}


        rolesPage.rolesModule.click(); // click on roles module

        // for loop to click roles one by one
        for(int i=0; i<rolesPage.rolesList.size(); i++){
            rolesPage.rolesList.get(i).click();
            Assert.assertTrue(roleDetailPage.roleInfoTitle.isDisplayed());
            rolesPage.rolesModule.click(); // go back to roles page

        }

        Driver.closeDriver();
    }

    @Ignore("There is no list of permissions after last update")
    @Test(testName = "TC02", description = "permissions are listed")
    public void permissionsListedTest(){
        RolesPage rolesPage = new RolesPage();
        RoleDetailPage roleDetailPage = new RoleDetailPage();
        WelcomePage welcomePage = new WelcomePage();
        LoginPage loginPage = new LoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();

        if (Driver.getDriver().getCurrentUrl().equals("https://a3m-qa-gm3.quaspareparts.com/login")) {
            loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));}


        rolesPage.rolesModule.click(); // click on roles module

        // for loop to click roles one by one and verify permissiopns are listed
        for(int i=0; i<rolesPage.rolesList.size(); i++){
            rolesPage.rolesList.get(i).click();
            Assert.assertTrue(roleDetailPage.permissionsList.size()>0);
            rolesPage.rolesModule.click(); // go back to roles page

        }

        Driver.closeDriver();
    }
}
