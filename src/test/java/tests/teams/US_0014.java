package tests.teams;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0014 {

    NewTeamPage newTeam = new NewTeamPage();
    TeamsPage teamsPage = new TeamsPage();
    EditTeamPage editTeam = new EditTeamPage();
    TeamDetailPage detailPage = new TeamDetailPage();

    @Test
    public void TC01() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();

        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("41KNukonZapx6-S");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        teamsPage.selectedTeamElement.click();
        teamsPage.searchBox.sendKeys("TeamSDA");
        teamsPage.EditItem.click();

        detailPage.EditTeamButton.click();

        Driver.getDriver().navigate().refresh();

        Thread.sleep(5000);

        newTeam.DepartmentType.sendKeys(Keys.DELETE); //Edit the Department type only

        newTeam.SaveBut.click();
        Assert.assertTrue(editTeam.FiledMessage.isDisplayed());
        Driver.getDriver().quit();

    }

    @Test
    public void TC02() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();

        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("41KNukonZapx6-S");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();


        teamsPage.selectedTeamElement.click();
        // newTeam.click_Team_But();
        teamsPage.searchBox.sendKeys("TeamSDA");
        teamsPage.EditItem.click();

        detailPage.EditTeamButton.click();

        Driver.getDriver().navigate().refresh();

        Thread.sleep(4000);

        editTeam.EditTeamName.sendKeys((Keys.CONTROL + "a")); //Edit the Department Name only.
        editTeam.EditTeamName.sendKeys(Keys.DELETE);


        newTeam.SaveBut.click();
        Assert.assertTrue(editTeam.FiledMessage.isDisplayed());
        // Driver.getDriver().quit();

    }

    @Test
    public void TC03() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();

        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("41KNukonZapx6-S");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();


        teamsPage.selectedTeamElement.click();
        // newTeam.click_Team_But();
        //Edit the the necessary details in the form, including the Department  name and Department Type.
        teamsPage.searchBox.sendKeys("TeamSDA");
        teamsPage.EditItem.click();
        detailPage.EditTeamButton.click();

        Driver.getDriver().navigate().refresh();
        Thread.sleep(5000);

        editTeam.EditTeamName.sendKeys((Keys.CONTROL + "a"));
        editTeam.EditTeamName.sendKeys(Keys.DELETE);
        editTeam.EditTeamName.sendKeys("NewOne");

        Thread.sleep(5000);

        editTeam.EditDepartmentType.sendKeys((Keys.CONTROL + "a"));
        editTeam.EditDepartmentType.sendKeys(Keys.DELETE);
        editTeam.EditDepartmentType.sendKeys("Remote Unit");
        editTeam.EditDepartmentType.sendKeys(Keys.ENTER);
        Thread.sleep(3000);


        newTeam.SaveBut.click();
        Assert.assertTrue(newTeam.SuccessMessage.isDisplayed());
        Driver.getDriver().quit();

    }

    @Test
    public void TC04() {
        String initialUrl = Driver.getDriver().getCurrentUrl(); // Store the initial URL
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();

        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("41KNukonZapx6-S");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();


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

