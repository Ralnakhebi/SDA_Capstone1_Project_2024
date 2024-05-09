package tests.teams;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.EditTeamPage;
import pages.NewTeamPage;
import pages.TeamsPage;
import utilities.Driver;

import java.time.Duration;

public class US_0014 {

    NewTeamPage newTeam = new NewTeamPage();
    TeamsPage teamsPage = new TeamsPage();
    EditTeamPage editTeam = new EditTeamPage();
    @Test
    public void TC02(){

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
        teamsPage.EditItem.click();
        editTeam.EditTeamButton.click();

         Driver.getDriver().navigate().refresh();



        // newTeam.TeamName.clear();
       // editTeam.EditTeamName.sendKeys(Keys.chord((Keys.CONTROL+"a")+ Keys.BACK_SPACE));

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(editTeam.EditTeamName));
//        editTeam.EditTeamName.click();


       // Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // editTeam.EditTeamName.clear();

        Actions builder = new Actions(Driver.getDriver());
        Action EditTeamName= builder
                .click(editTeam.EditTeamName)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.DELETE)
                .keyUp(Keys.DELETE)
                .sendKeys(editTeam.EditTeamName,"One")
                .build();
        EditTeamName.perform();
        newTeam.SaveBut.click();

        // editTeam.EditTeamName.sendKeys("newOne");

//        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
//        js.executeScript("arguments[0].value = 'newOne' ;",editTeam.EditTeamName);

    }

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
        teamsPage.EditItem.click();
        editTeam.EditTeamButton.click();

        Driver.getDriver().navigate().refresh();
//        newTeam.DepartmentType.click();


      // editTeam.dep.sendKeys("Remote Unit");
//        newTeam.DepartmentType.sendKeys("Remote Unit");

//        newTeam.SaveBut.click();


////
//        Actions builder2 = new Actions(Driver.getDriver());
//        Action EditTeamName2= builder2
//                .click(editTeam.dep)
//
//                .keyDown(Keys.CONTROL)
//                .sendKeys("a")
//                .keyUp(Keys.CONTROL)
//                .keyDown(Keys.DELETE)
//                .keyUp(Keys.DELETE)
//
//                .sendKeys(editTeam.dep,"Remote Unit")
//                .sendKeys(Keys.ENTER)
//
//                .build();
//        EditTeamName2.perform();

        Actions actions = new Actions(Driver.getDriver());
          Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Clear the text, then send new text and press Enter
        actions.moveToElement(editTeam.dep)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a") // Select all text
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE) // Delete the selected text
                .sendKeys("Remote Unit") // Send new text
                .sendKeys(Keys.ENTER) // Press Enter
                .perform(); // Perform all actions


        newTeam.SaveBut.click();



      // newTeam.DepartmentType.sendKeys("Remote Unit" + Keys.ENTER);
//




    }
}
