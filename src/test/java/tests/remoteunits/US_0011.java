package tests.remoteunits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.NewRemoteUnitPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
@Listeners(utilities.Listeners.class)

public class US_0011 {

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
    public void testTC_01() throws InterruptedException {

        //Test pass
        //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC01_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        //Login
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();



        NewRemoteUnitPage remoteUnit = new NewRemoteUnitPage();
        remoteUnit.clickOnRemoteunit();
        //______________________________________________________________________________________//

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", remoteUnit.clickOnaddNewRemoteUnit);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", remoteUnit.editeRemoteUnitType);
        //______________________________________________________________________________________//

        sleep(2000);
        remoteUnit.editeRemoteUnitType.click();
        sleep(2000);
        remoteUnit.editeRemoteUnitType.clear();
        Actions actions = new Actions(Driver.getDriver());

        // Send keys to the dropdown element to navigate options
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        remoteUnit.Savebutton.click();
        sleep(2000);
        Assert.assertTrue(remoteUnit.RemoteNameError.isDisplayed(), "Please enter a name for department.");
        Driver.closeDriver();


    }
    //_*_*_*_*_*_*_*_*_*_*_*_*End_of_TC01_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_


    @Test
    public void testTC_02() throws InterruptedException {

        // Test is passed
        //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC02_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        //Login
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
//*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
        NewRemoteUnitPage remoteUnit = new NewRemoteUnitPage();

        remoteUnit.clickOnRemoteunit();
        //______________________________________________________________________________________//

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", remoteUnit.clickOnaddNewRemoteUnit);
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", remoteUnit.nameFeild);
        remoteUnit.nameFeild.sendKeys("RUTest1" + Keys.ENTER);
        //______________________________________________________________________________________//

        // click on save Button
        remoteUnit.Savebutton.click();
        sleep(2000);
        Assert.assertTrue(remoteUnit.RemoteTypeError.isDisplayed(), "Please select a type for department.");
        Driver.closeDriver();

        //_*_*_*_*_*_*_*_*_*_*_*_*End_of_TC02_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_


    }

    @Test
    public void testTC_03() throws InterruptedException {

        // Test is passed
        //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC03_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        //Login
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
//*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*

        NewRemoteUnitPage remoteUnit = new NewRemoteUnitPage();

        remoteUnit.clickOnRemoteunit();
        //______________________________________________________________________________________//

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", remoteUnit.clickOnaddNewRemoteUnit);
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", remoteUnit.nameFeild);
        remoteUnit.nameFeild.sendKeys("RemoutUtest01" + Keys.ENTER);
        //______________________________________________________________________________________//
        jse.executeScript("arguments[0].click()", remoteUnit.editeRemoteUnitType);
        //______________________________________________________________________________________//

        sleep(2000);
        remoteUnit.editeRemoteUnitType.click();
        sleep(2000);
        remoteUnit.editeRemoteUnitType.clear();
        Actions actions = new Actions(Driver.getDriver());

        // Send keys to the dropdown element to navigate options
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        // click on save Button
        remoteUnit.Savebutton.click();
        sleep(2000);

        Driver.closeDriver();

        //_*_*_*_*_*_*_*_*_*_*_*_*End_of_TC03_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_


    }

}


