package tests.permissions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PermissionsPage;
import pages.ProfilePage;
import pages.WelcomePage;
import utilities.ConfigReader;
import utilities.Driver;


public class US_0020 {

    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

    PermissionsPage permissionsPage = new PermissionsPage();

    @Test
    public void PermissionsDisplay() throws InterruptedException {

        // Go to WelcomePage and click in login button
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();


        // Enter UserName and Password and Click in sign In button
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        // click and verify ArrowCollapseButton
        profilePage.ArrowCollapseButton.click();
        Assert.assertTrue(profilePage.collapse.isDisplayed());

        // click in Permissions Button
        profilePage.PermissionsButton.click();

        // display all element in permissions and print and verify
        for (WebElement p : permissionsPage.permissions) {
            System.out.println(p.getText());
            Assert.assertTrue(p.isDisplayed());
        }
        System.out.println("-----------------------------------------------------------------");

        // Assert that the number of permissions equal to 94
        int numOfPer = permissionsPage.permissions.size();
        System.out.println("number Of Permissions = " + numOfPer);
        Assert.assertEquals(numOfPer, 94);
    }
}
