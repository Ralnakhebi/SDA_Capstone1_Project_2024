package tests.remoteunits;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
@Listeners(utilities.Listeners.class)
public class US_0012 {
    EditRemoteUnitPage editRemoteUnitPage = new EditRemoteUnitPage();
    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        editRemoteUnitPage = new EditRemoteUnitPage();
        loginPage = new LoginPage();
        welcomePage = new WelcomePage();
        welcomePage.loginButton.click();
        loginPage.login("sda2024@gmail.com", "2JDTWt4UWdjGcNv");;
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


    @Test(description = "This test checks that can edit Remote units successfully details in the Remote Unit .")
    public void TC01() throws InterruptedException {

        editRemoteUnitPage.RemoteUnitsBut.click();
        editRemoteUnitPage.selectedRemoteElement.click();
        editRemoteUnitPage.EditRemoteUnitBut.click();


      // Change the details in one or more fields (e.g., department name, description).
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);
        editRemoteUnitPage.DepartmentTypeDropdown.click();
        editRemoteUnitPage.DepartmentTypeTeam.click();
        // editRemoteUnitPage.DepartmentTypeDropdown.sendKeys(Keys.ENTER);

        editRemoteUnitPage.EditName.sendKeys((Keys.CONTROL + "a"));
        editRemoteUnitPage.EditName.sendKeys(Keys.DELETE);
        editRemoteUnitPage.EditName.sendKeys("edit");

        editRemoteUnitPage.SaveEdit.click();

      Assert.assertTrue(editRemoteUnitPage.SuccessMessage.isDisplayed());


    }
    @Test(description = "This test checks that can successfully delete a Remote Unit .")
    public void TC02(){
        String initialUrl = Driver.getDriver().getCurrentUrl(); // Store the initial URL

        editRemoteUnitPage.RemoteUnitsBut.click();
        editRemoteUnitPage.selectedRemoteElement.click();
        editRemoteUnitPage.EditRemoteUnitBut.click();
        Driver.getDriver().navigate().refresh();
        editRemoteUnitPage.DeleteDepartment.click();
        editRemoteUnitPage.ConfirmDelete.click();
        String newUrl = Driver.getDriver().getCurrentUrl(); // Get the new URL
        // Assert that the URL has changed
        Assert.assertNotEquals(newUrl, initialUrl, "Failed to delete.");

    }

    @Test(description = "This test checks that can leave department-name empty in the Remote Unit.")
    public void TC03() throws InterruptedException {

        editRemoteUnitPage.RemoteUnitsBut.click();
        editRemoteUnitPage.selectedRemoteElement.click();
        editRemoteUnitPage.EditRemoteUnitBut.click();
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);

        editRemoteUnitPage.DepartmentTypeDropdown.click();//Change the details in  department type,only
        editRemoteUnitPage.DepartmentTypeTeam.click();
        // editRemoteUnitPage.DepartmentTypeDropdown.sendKeys(Keys.ENTER);
        editRemoteUnitPage.EditName.sendKeys((Keys.CONTROL + "a"));

        editRemoteUnitPage.EditName.sendKeys(Keys.DELETE);

        editRemoteUnitPage.SaveEdit.click();
        Assert.assertTrue(editRemoteUnitPage.FiledMessage.isDisplayed());
    }

    @Test(description = "This test checks that can leave department-type empty in the Remote Unit.")
    public void TC04() throws InterruptedException {

        editRemoteUnitPage.RemoteUnitsBut.click();
        editRemoteUnitPage.selectedRemoteElement.click();
        editRemoteUnitPage.EditRemoteUnitBut.click();
        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);

        editRemoteUnitPage.DeleteDepartmentType.click();

        editRemoteUnitPage.EditName.sendKeys((Keys.CONTROL + "a"));//Change the details in  department name,only
        editRemoteUnitPage.EditName.sendKeys(Keys.DELETE);
        editRemoteUnitPage.EditName.sendKeys("edit");
         editRemoteUnitPage.SaveEdit.click();
        Assert.assertTrue(editRemoteUnitPage.FiledMessage.isDisplayed());

    }
    
}
