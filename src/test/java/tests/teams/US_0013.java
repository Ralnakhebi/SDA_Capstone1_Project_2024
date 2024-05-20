package tests.teams;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewTeamPage;
import pages.TeamsPage;
import pages.WelcomePage;
import utilities.ConfigReader;
import utilities.Driver;

@Listeners(utilities.Listeners.class)
public class US_0013 {
     NewTeamPage newTeam = new NewTeamPage();
     TeamsPage teamsPage = new TeamsPage();
    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        loginPage = new LoginPage();
        teamsPage = new TeamsPage();
        newTeam = new NewTeamPage();
        welcomePage = new WelcomePage();
        welcomePage.loginButton.click();
        loginPage.login("sda2024@gmail.com", "2JDTWt4UWdjGcNv");;
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
       // Driver.getDriver().close();
    }


    @Test(description = "This test checks the teams displayed correctly successfully in the Teams .")
    public void TC01() {

        boolean isTeamDisplayed = newTeam.TeamBtu.isDisplayed();
        boolean isClickable = teamsPage.isTeamClickable();

        Assert.assertTrue(isTeamDisplayed, "Team element is not displayed");
        Assert.assertTrue(isClickable, "Team element is not clickable");

    }


    @Test(description = "This test checks that can add a new team successfully in the Teams .")
    public void TC02() {

        newTeam.click_Team_But();
        teamsPage.AddNewTeamBut.click();
// Fill in the necessary details in the form, including the Department  name and Department Type.

        newTeam.TeamName.sendKeys("TeamSDA");
        newTeam.ShortName.sendKeys("SDA");


        // teamPage.DepartmentType.click();
        newTeam.clickDropdownDepartment();
        newTeam.Option();
        newTeam.Description.sendKeys("Our team is composed of dedicated professionals who bring diverse skills.");

        newTeam.choseTeamRoles();
        newTeam.productOwner();

         newTeam.SaveBut.click();

        Assert.assertTrue(newTeam.SuccessMessage.isDisplayed());
    }

    @Test(description = "This test checks that can add a new team successfully in the Teams without any data.")
    public void TC03() {

        newTeam.click_Team_But();

        teamsPage.AddNewTeamBut.click();

        newTeam.SaveBut.click(); ////Do not fill the Department  name and Department Type.
        String pageSource = Driver.getDriver().getPageSource();
        String expectedText = "Please enter a name for department";

        Assert.assertTrue(pageSource.contains(expectedText),"Text not found in page source");

    }

    }


