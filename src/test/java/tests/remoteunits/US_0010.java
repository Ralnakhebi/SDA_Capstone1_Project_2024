package tests.remoteunits;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.EditDepartment;
import pages.RemoteUnit;
import utilities.ConfigReader;
import utilities.Driver;

@Listeners(utilities.Listeners.class)
public class US_0010 {

//    @BeforeMethod
//    public void setUp() throws InterruptedException {
//        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
//        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
//        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
//        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
//        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
//    }
//    @AfterMethod
//    public void tearDown(){
//        Driver.closeDriver();
//    }

    @Test
    public void US_010_TC01() {

        // Test is pass
        //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC01_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

// log in
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
        //*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
        RemoteUnit remoteUnitPage = new RemoteUnit();
        remoteUnitPage.clickOnRemoteunit();
        remoteUnitPage.clickOnRemoteunitbody();
        // Assertion
        Assert.assertTrue(remoteUnitPage.RemoteunitBody.isDisplayed());
        //_*_*_*_*_*_*_*_*__*_*_*End_of_TC01_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
        Driver.closeDriver();


    }

}
