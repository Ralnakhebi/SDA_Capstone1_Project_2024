package tests.teams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewTeamPage;
import pages.TeamsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0013 {
     NewTeamPage newTeam = new NewTeamPage();
     TeamsPage teamsPage = new TeamsPage();
@Test
    public void TC01() {

        Driver.getDriver().get("https://qa-gm3.quaspareparts.com/");
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();

        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("g8l262kCQMuRGVG");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //  Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        newTeam.click_Team_But();
        teamsPage.searchBox.sendKeys("TeamSDA");
        Assert.assertTrue(teamsPage.EditItem.isDisplayed());

    }
    @Test
            public void TC02() {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();
//        Driver.getDriver().get(ConfigReader.getProperty("bo@testevolve.com"));
//        Driver.getDriver().get(ConfigReader.getProperty("s5G1hKe6O6YMpPQ"));

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        // Find the password input field and enter the password
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("g8l262kCQMuRGVG");
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        newTeam.click_Team_But();
        // teamPage.TeamBtu.click();

        teamsPage.AddNewTeamBut.click();


        newTeam.TeamName.sendKeys("TeamSDA");
        newTeam.ShortName.sendKeys("SDA");
        // Thread.sleep(7000);

        // teamPage.DepartmentType.click();
        newTeam.clickDropdownDepartment();
        newTeam.Option();

        newTeam.choseTeamRoles();
        newTeam.productOwner();

         newTeam.SaveBut.click();

        Assert.assertTrue(newTeam.SuccessMessage.isDisplayed());

    }


    @Test
    public void TC03() {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();
        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        // Find the password input field and enter the password
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("g8l262kCQMuRGVG");
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        newTeam.click_Team_But();

        teamsPage.AddNewTeamBut.click();


        newTeam.SaveBut.click();
        String pageSource = Driver.getDriver().getPageSource();
        String expectedText = "Please enter a name for department";

        Assert.assertTrue(pageSource.contains(expectedText),"Text not found in page source");

    }

    }


