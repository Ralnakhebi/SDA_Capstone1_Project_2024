package tests.teams;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
@Listeners(utilities.Listeners.class)
public class US_0014 {

    NewTeamPage newTeam = new NewTeamPage();
    TeamsPage teamsPage = new TeamsPage();
    EditTeamPage editTeam = new EditTeamPage();
    TeamDetailPage detailPage = new TeamDetailPage();
    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        detailPage = new TeamDetailPage();
        loginPage = new LoginPage();
        teamsPage = new TeamsPage();
        newTeam = new NewTeamPage();
        welcomePage = new WelcomePage();
        editTeam = new EditTeamPage();
        welcomePage.loginButton.click();
        loginPage.login("sda2024@gmail.com", "2JDTWt4UWdjGcNv");
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test(description = "This test checks that can leave department-type empty in the Teams .")
    public void TC01() throws InterruptedException {

        teamsPage.selectedTeamElement.click();
        teamsPage.searchBox.sendKeys("TeamSDA");
        teamsPage.EditItem.click();

        detailPage.EditTeamButton.click();

        Driver.getDriver().navigate().refresh();

        Thread.sleep(2000);


        editTeam.EditDepartmentType.sendKeys((Keys.CONTROL + "a"));

        editTeam.EditDepartmentType.sendKeys(Keys.DELETE);
        //Edit the Department type only
        Thread.sleep(2000);
        newTeam.SaveBut.click();
        Assert.assertTrue(editTeam.FiledMessage.isDisplayed());


    }

    @Test(description = "This test checks that can leave department-name empty in the Teams .")
    public void TC02() throws InterruptedException {

        teamsPage.selectedTeamElement.click();
        // newTeam.click_Team_But();
        teamsPage.searchBox.sendKeys("TeamSDA");
        teamsPage.EditItem.click();

        detailPage.EditTeamButton.click();

        Driver.getDriver().navigate().refresh();

        Thread.sleep(2000);

        editTeam.EditTeamName.sendKeys((Keys.CONTROL + "a")); //Edit the Department Name only.
        editTeam.EditTeamName.sendKeys(Keys.DELETE);

        newTeam.SaveBut.click();
        Assert.assertTrue(editTeam.FiledMessage.isDisplayed());


    }

    @Test(description = "This test checks that can edit necessary details, including the Department name and Department Type.")
    public void TC03() throws InterruptedException {

        teamsPage.selectedTeamElement.click();
        // newTeam.click_Team_But();
        //Edit the the necessary details in the form, including the Department  name and Department Type.
        teamsPage.searchBox.sendKeys("TeamSDA");
        teamsPage.EditItem.click();
        detailPage.EditTeamButton.click();

        Driver.getDriver().navigate().refresh();
        Thread.sleep(2000);

        editTeam.EditTeamName.sendKeys((Keys.CONTROL + "a"));
        editTeam.EditTeamName.sendKeys(Keys.DELETE);
        editTeam.EditTeamName.sendKeys("NewOne");

        Thread.sleep(2000);

        editTeam.EditDepartmentType.sendKeys((Keys.CONTROL + "a"));
        editTeam.EditDepartmentType.sendKeys(Keys.DELETE);
        editTeam.EditDepartmentType.sendKeys("Remote Unit");
        editTeam.EditDepartmentType.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        newTeam.SaveBut.click();
        Assert.assertTrue(newTeam.SuccessMessage.isDisplayed());


    }

    @Test(description = "This test checks that can delete team successfully in the Teams .")
    public void TC04() {
        String initialUrl = Driver.getDriver().getCurrentUrl(); // Store the initial URL

        teamsPage.selectedTeamElement.click();
        // newTeam.click_Team_But();
        teamsPage.searchBox.sendKeys("TeamSDA");
        teamsPage.EditItem.click();
        detailPage.EditTeamButton.click();

        Driver.getDriver().navigate().refresh();
        // Click the 'Delete' to delete Department.
        editTeam.DeleteDepartment.click();
        editTeam.ConfirmDelete.click();

        String newUrl = Driver.getDriver().getCurrentUrl(); // Get the new URL
        // Assert that the URL has changed
        Assert.assertNotEquals(newUrl, initialUrl, "Failed to delete.");
    }

}

