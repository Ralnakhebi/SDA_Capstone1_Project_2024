package tests.teams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
    @Test(description = "This test checks the teams displayed correctly successfully in the Teams .")
    public void TC01() {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));

        welcomePage.loginButton.click();
        loginPage.login("bo@testevolve.com", "41KNukonZapx6-S");

        boolean isTeamDisplayed = newTeam.TeamBtu.isDisplayed();
        boolean isClickable = teamsPage.isTeamClickable();

        Assert.assertTrue(isTeamDisplayed, "Team element is not displayed");
        Assert.assertTrue(isClickable, "Team element is not clickable");
        Driver.getDriver().close();
    }
    @Test(description = "This test checks that can add a new team successfully in the Teams .")
    public void TC02() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        loginPage.login("bo@testevolve.com", "41KNukonZapx6-S");;


        newTeam.click_Team_But();
        // teamPage.TeamBtu.click();

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
        Driver.getDriver().close();

    }

    @Test(description = "This test checks that can add a new team successfully in the Teams without any data.")
    public void TC03() {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        loginPage.login("bo@testevolve.com", "41KNukonZapx6-S");;

        newTeam.click_Team_But();

        teamsPage.AddNewTeamBut.click();

        newTeam.SaveBut.click(); ////Do not fill the Department  name and Department Type.
        String pageSource = Driver.getDriver().getPageSource();
        String expectedText = "Please enter a name for department";

        Assert.assertTrue(pageSource.contains(expectedText),"Text not found in page source");
        Driver.getDriver().close();

    }

    }


