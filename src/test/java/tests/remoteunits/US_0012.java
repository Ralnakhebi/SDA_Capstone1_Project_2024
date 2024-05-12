package tests.remoteunits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.EditRemoteUnitPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0012 {
    EditRemoteUnitPage editRemoteUnitPage = new EditRemoteUnitPage();


    @Test
    public void TC01() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("41KNukonZapx6-S");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        editRemoteUnitPage.RemoteUnitsBut.click(); // Navigate to the Remote Unit module from the main menu.
        editRemoteUnitPage.selectedRemoteElement.click(); //Select a remote unit from the list by clicking on it.
        editRemoteUnitPage.EditRemoteUnitBut.click();//Click the 'Edit Remote Unit' button to open the remote unit details form.

        Thread.sleep(2000);
      // Change the details in one or more fields (e.g., department name, description).
        editRemoteUnitPage.DepartmentTypeDropdown.click();
        editRemoteUnitPage.DepartmentTypeTeam.click();
        // editRemoteUnitPage.DepartmentTypeDropdown.sendKeys(Keys.ENTER);

        editRemoteUnitPage.EditName.sendKeys((Keys.CONTROL + "a"));
        editRemoteUnitPage.EditName.sendKeys(Keys.DELETE);
        editRemoteUnitPage.EditName.sendKeys("edit");

      //  editRemoteUnitPage.SaveEdit.click(); //Click the 'Save' button to update the department details.

    }
    @Test
    public void TC02(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();

        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("41KNukonZapx6-S");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        editRemoteUnitPage.RemoteUnitsBut.click();
        editRemoteUnitPage.selectedRemoteElement.click();
        editRemoteUnitPage.EditRemoteUnitBut.click();
        editRemoteUnitPage.DeleteDepartment.click(); //Click the 'Delete' button.
        editRemoteUnitPage.ConfirmDelete.click(); //Confirm the deletion to complete the process.
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

        editRemoteUnitPage.RemoteUnitsBut.click();
        editRemoteUnitPage.selectedRemoteElement.click();
        editRemoteUnitPage.EditRemoteUnitBut.click();

        Thread.sleep(2000);

        editRemoteUnitPage.DepartmentTypeDropdown.click();//Change the details in  department type,only
        editRemoteUnitPage.DepartmentTypeTeam.click();
        // editRemoteUnitPage.DepartmentTypeDropdown.sendKeys(Keys.ENTER);
        editRemoteUnitPage.EditName.sendKeys((Keys.CONTROL + "a"));

        editRemoteUnitPage.EditName.sendKeys(Keys.DELETE);

        editRemoteUnitPage.SaveEdit.click();
    }

    @Test
    public void TC04() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();

        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@testevolve.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("41KNukonZapx6-S");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        editRemoteUnitPage.RemoteUnitsBut.click();
        editRemoteUnitPage.selectedRemoteElement.click();
        editRemoteUnitPage.EditRemoteUnitBut.click();

        Thread.sleep(2000);

        editRemoteUnitPage.DeleteDepartmentType.click();

        editRemoteUnitPage.EditName.sendKeys((Keys.CONTROL + "a"));//Change the details in  department name,only
        editRemoteUnitPage.EditName.sendKeys(Keys.DELETE);
        editRemoteUnitPage.EditName.sendKeys("edit");
        // editRemoteUnitPage.SaveEdit.click();

    }
    
}
