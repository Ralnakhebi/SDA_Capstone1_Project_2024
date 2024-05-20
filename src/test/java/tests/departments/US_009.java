package tests.departments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.EditDepartment;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
@Listeners(utilities.Listeners.class)

public class US_009 {

    @Test(priority = 3)
    public void test_Tc_001() throws InterruptedException {

        // Test  is passed //
        //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC01_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();



        EditDepartment editDepartment = new EditDepartment();
        editDepartment.clickOnDepartment();
        //_*_*_*_*_*_*_*_*__*_**_*_*_*_*_*__*_*_**_**
        //  Used JavascriptExecutor  to click on US_0009dep Department and Edit
        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", editDepartment.clikonUS_0009dep);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", editDepartment.clickOnEditebuttn);
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", editDepartment.nameFeild);
        Thread.sleep(5000);

        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        // Send "Ctrl + A" to select all text, then "Delete" to clear it

        editDepartment.nameFeild.sendKeys((Keys.CONTROL + "a"));
        editDepartment.nameFeild.sendKeys((Keys.DELETE));
        // Send new text and press ENTER
        editDepartment.nameFeild.sendKeys("US_0009TC1");
        editDepartment.CancelTheDpartmentType.click();
        //_____________________________//
        //     calling method
        //----------------------------//
        editDepartment.clickOnDepartmentType();
        Thread.sleep(2000);

        editDepartment.Savebutton.click();

        Thread.sleep(2000);

        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
        Driver.closeDriver();

        //_*_*_*_*_*_*_*_*_*_*_*_*End_of_TC01_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

    }


    @Test(priority = 4)
    public void test_TC_002() throws InterruptedException {

        // Test  is passed //

        // Delete Department

        //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC02_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();

        EditDepartment editDepartment = new EditDepartment();
        //_____________________________//
        //    calling methods
        //----------------------------//
        editDepartment.clickOnDepartment();
        sleep(1000);
        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        // Click on the department named "US_0009TC1 Using JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        sleep(2000);
        jse.executeScript("arguments[0].click()", editDepartment.clikonUS_0009TC1);
        sleep(2000);
        // click on the "Edite" Button
        //_*_*_*_*_*_*_*_*_*_*_*_*There_is_a_Bug_in_the_Editebutton_we_have_to_refresh_*_*_*_*__*_*
        jse.executeScript("arguments[0].click()", editDepartment.clickOnEditebuttn);
        Driver.getDriver().navigate().refresh();
        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*__*_*_*__*_*_*__*_*_
        //    Delete the department & Confirm the deletion by caking the method
        sleep(5000);
        editDepartment.clickOnDelButton();

        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*__*_*_*__*_*_*__*_*_*_
        Driver.closeDriver();

        //_*_*_*_*_*_*_*_*_*_*_*_*End_of_TC02_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*__*_*_*__*_*_*_


    }

    @Test(priority =1)
    public void test_TC_003() throws InterruptedException {

        // Test  is passed //
        //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC03_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_


        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();

        EditDepartment editDepartment = new EditDepartment();
        editDepartment.clickOnDepartment();
        //_*_*_*_*_*_*_*_*__*_**_*_*_*_*_*__*_*_**_**
        //  Used JavascriptExecutor  to click on US_0009dep Department and Edit
        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
        sleep(1000);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", editDepartment.clikonUS_0009dep);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", editDepartment.clickOnEditebuttn);
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", editDepartment.nameFeild);
        Thread.sleep(1000);

        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        //______________________________________________________________________________________//
        // Send "Ctrl + A" to select all text, then "Delete" to clear it
        editDepartment.nameFeild.sendKeys((Keys.CONTROL + "a"));
        editDepartment.nameFeild.sendKeys((Keys.DELETE));
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //______________________________________________________________________________________//

        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*Save_button_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
        editDepartment.Savebutton.click();
        //__________________________________Assertion____________________________________________________//
        Assert.assertTrue(editDepartment.DepartmentNameError.isDisplayed(), "Please enter a name for department.");
        Driver.closeDriver();

    }


    @Test(priority =2)
    public void test_TC_004() throws InterruptedException {

        //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC04_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();


        EditDepartment editDepartment = new EditDepartment();
        editDepartment.department.click();
        sleep(2000);

        //_*_*_*_*_*_*_*_*__*_**_*_*_*_*_*__*_*_**_**
        //  Used JavascriptExecutor  to click on US_0009dep Department and Edit
        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", editDepartment.clikonUS_0009dep);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].click()", editDepartment.clickOnEditebuttn);
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        sleep(2000);

        editDepartment.CancelTheDpartmentType.click();
//        editDepartment.CancelTheDpartmentTypetocancel();
//        editDepartment.CancelTheDpartmentType.clear();

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//
//        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
////
//        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*Save_button_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
        editDepartment.Savebutton.click();
//        //__________________________________Assertion____________________________________________________//
        Assert.assertTrue(editDepartment.DepartmentTypeError.isDisplayed(), "Please select a type for department.");

        Driver.closeDriver();

    }
}
////
////    @BeforeMethod
////    public void setUp() throws InterruptedException {
////        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
////        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
////        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
////        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
////        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
////    }
////    @AfterMethod
////    public void tearDown() throws InterruptedException {
////        Driver.closeDriver();
////    }
//
//
//    //IMPORTANT  NOTE
//    //  that this department need to be created manually named as US_0009dep
//        @Test(dependsOnMethods = {"test_TC_004"})
//        public void test_TC_001() throws InterruptedException {
//        // log in
//            Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
//            Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
//            Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
//            Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
//            Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
//
//            // Test  is passed //
//            //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC01_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//            EditDepartment editDepartment = new EditDepartment();
//            editDepartment.clickOnDepartment();
//            //_*_*_*_*_*_*_*_*__*_**_*_*_*_*_*__*_*_**_**
//            //  Used JavascriptExecutor  to click on US_0009dep Department and Edit
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
//            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            jse.executeScript("arguments[0].click()", editDepartment.clikonUS_0009dep);
//            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            jse.executeScript("arguments[0].click()", editDepartment.clickOnEditebuttn);
//            Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            jse.executeScript("arguments[0].click()", editDepartment.nameFeild);
//            Thread.sleep(500);
//
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//            // Send "Ctrl + A" to select all text, then "Delete" to clear it
//
//            editDepartment.nameFeild.sendKeys((Keys.CONTROL + "a"));
//            editDepartment.nameFeild.sendKeys((Keys.DELETE));
//            // Send new text and press ENTER
//            editDepartment.nameFeild.sendKeys("US_0009TC1");
//            Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            editDepartment.CancelTheDpartmentType.click();
//            //_____________________________//
//            //     calling method
//            //----------------------------//
//            editDepartment.clickOnDepartmentType();
//            Thread.sleep(2000);
//            editDepartment.Savebutton.click();
//
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//            Driver.closeDriver();
//
//            //_*_*_*_*_*_*_*_*_*_*_*_*End_of_TC01_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//        }
//
//
//    @Test(dependsOnMethods ={"test_TC_001"} )
//        public void test_TC_002() throws InterruptedException {
//
//            // Test  is passed //
//            // Delete Department
//            //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC02_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//        // log in
//        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
//        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
//        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
//        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
//        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
//
//
//        EditDepartment editDepartment = new EditDepartment();
//            //_____________________________//
//            //    calling methods
//            //----------------------------//
//            editDepartment.clickOnDepartment();
//            sleep(1000);
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//            // Click on the department named "US_0009TC1 Using JavascriptExecutor
//            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
//            sleep(2000);
//            jse.executeScript("arguments[0].click()", editDepartment.clikonUS_0009TC1);
//            sleep(2000);
//            // click on the "Edite" Button
//            //_*_*_*_*_*_*_*_*_*_*_*_*There_is_a_Bug_in_the_Editebutton_we_have_to_refresh_*_*_*_*__*_*
//            jse.executeScript("arguments[0].click()", editDepartment.clickOnEditebuttn);
//            Driver.getDriver().navigate().refresh();
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*__*_*_*__*_*_*__*_*_
//            //    Delete the department & Confirm the deletion by caking the method
//            sleep(5000);
//            editDepartment.clickOnDelButton();
//
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*__*_*_*__*_*_*__*_*_*_
//        Driver.closeDriver();
//
//            //_*_*_*_*_*_*_*_*_*_*_*_*End_of_TC02_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*__*_*_*__*_*_*_
//
//
//        }
//
//        @Test()
//        public void test_TC_003 () throws InterruptedException {
//
//            // Test  is passed //
//            //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC03_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//            // log in
//            Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
//            Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
//            Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
//            Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
//            Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
//
//
//            EditDepartment editDepartment = new EditDepartment();
//            editDepartment.clickOnDepartment();
//            //_*_*_*_*_*_*_*_*__*_**_*_*_*_*_*__*_*_**_**
//            //  Used JavascriptExecutor  to click on US_0009dep Department and Edit
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
//            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            jse.executeScript("arguments[0].click()", editDepartment.clikonUS_0009dep);
//            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            jse.executeScript("arguments[0].click()", editDepartment.clickOnEditebuttn);
//            Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            jse.executeScript("arguments[0].click()", editDepartment.nameFeild);
//            Thread.sleep(500);
//
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//            //______________________________________________________________________________________//
//            // Send "Ctrl + A" to select all text, then "Delete" to clear it
//            editDepartment.nameFeild.sendKeys((Keys.CONTROL + "a"));
//            editDepartment.nameFeild.sendKeys((Keys.DELETE));
//            Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            //______________________________________________________________________________________//
//
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*Save_button_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//            editDepartment.Savebutton.click();
//            //__________________________________Assertion____________________________________________________//
//            Assert.assertTrue(editDepartment.DepartmentNameError.isDisplayed(), "Please enter a name for department.");
//            Driver.closeDriver();
//
//        }
//
//        @Test(dependsOnMethods ={"test_TC_003"} )
//        public void test_TC_004 () throws InterruptedException {
//
//            //_*_*_*_*_*_*_*_*_*_*_*_*Start_of_TC04_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//           // log in
//            Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
//            Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
//            Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
//            Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
//            Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
//
//            EditDepartment editDepartment = new EditDepartment();
//            editDepartment.department.click();
//            sleep(2000);
//
//            //_*_*_*_*_*_*_*_*__*_**_*_*_*_*_*__*_*_**_**
//            //  Used JavascriptExecutor  to click on US_0009dep Department and Edit
//            //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//
//            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
//            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            jse.executeScript("arguments[0].click()", editDepartment.clikonUS_0009dep);
//            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            jse.executeScript("arguments[0].click()", editDepartment.clickOnEditebuttn);
//            Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            sleep(2000);
//
//            editDepartment.CancelTheDpartmentType.click();
////        editDepartment.CancelTheDpartmentTypetocancel();
////        editDepartment.CancelTheDpartmentType.clear();
//
//            Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//
//        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//        //_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*Save_button_*__*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
//            editDepartment.Savebutton.click();
//        //__________________________________Assertion____________________________________________________//
//            Assert.assertTrue(editDepartment.DepartmentTypeError.isDisplayed(), "Please select a type for department.");
//
//            Driver.closeDriver();
//
//        }
//    }
//

