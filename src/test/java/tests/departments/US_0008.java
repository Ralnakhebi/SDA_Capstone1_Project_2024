package tests.departments;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0008 {


    @Test
    public void addDepartment() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage();
        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();
        DepartmentsPage departmentsPage = new DepartmentsPage();
        NewDepartmentPage newDepartmentPage = new NewDepartmentPage();
        Driver.getDriver().get("https://qa-gm3.quaspareparts.com/a3m/");

        //click department icon
        profilePage.departmentTap.click();

        //click Add New Department button
        departmentsPage.AddNewDepartmentButton.click();

        //Set department name (SDA_Group1)
        newDepartmentPage.DepartmentNameField.sendKeys(ConfigReader.getProperty("departmentName"));

        //Set department type (Department)
        newDepartmentPage.DepartmentType.sendKeys("Department" + Keys.ENTER);

        //click on Save button
        newDepartmentPage.saveButton.click();
        Thread.sleep(1500);

        //Assert 'new department successfully created' message is displayed
        newDepartmentPage.successfulMsg.isDisplayed();

        Thread.sleep(1500);

    }

    @Test
    public void verifyDepartmentName() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage();
        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();
        DepartmentsPage departmentsPage = new DepartmentsPage();
        NewDepartmentPage newDepartmentPage = new NewDepartmentPage();
        Driver.getDriver().get("https://qa-gm3.quaspareparts.com/a3m/");

        //click department icon
        profilePage.departmentTap.click();

        //click Add New Department button
        departmentsPage.AddNewDepartmentButton.click();

        //No department name entered
        newDepartmentPage.DepartmentNameField.sendKeys("");

        //Set department type
        newDepartmentPage.DepartmentType.sendKeys("Department" + Keys.ENTER);
        Thread.sleep(1500);

        //click on Save button
        newDepartmentPage.saveButton.click();
        Thread.sleep(1500);

        //Assert the appearance of error message
        Assert.assertTrue(newDepartmentPage.errorMsgName.isDisplayed());

    }

    @Test
    public void verifyDepartmentType() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage();
        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();
        DepartmentsPage departmentsPage = new DepartmentsPage();
        NewDepartmentPage newDepartmentPage = new NewDepartmentPage();

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));

        //login
        welcomePage.loginButton.click();
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        Thread.sleep(2000);

        //click department icon
        profilePage.departmentTap.click();

        //click Add New Department button
        departmentsPage.AddNewDepartmentButton.click();

        //Enter department name
        newDepartmentPage.DepartmentNameField.sendKeys(ConfigReader.getProperty("departmentName"));

        //No department type selected
        newDepartmentPage.DepartmentType.sendKeys("" + Keys.ENTER);
        Thread.sleep(2000);
        //click on Save button
        newDepartmentPage.saveButton.click();
        Thread.sleep(1500);

        //Assert the appearance of error message
        Assert.assertTrue(newDepartmentPage.errorMsgType.isDisplayed());

    }

}
