package tests.departments;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;
import static utilities.Driver.getDriver;

public class US_0007 {
    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    DepartmentsPage departmentsPage = new DepartmentsPage();
    NewDepartmentPage newDepartmentPage = new NewDepartmentPage();


    @Test
    public void displayDepartment() throws InterruptedException {

        //click department icon
        profilePage.departmentTap.click();
        Thread.sleep(1500);

        //Scroll down until the added department appear on the page
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", departmentsPage.addDepartment(ConfigReader.getProperty("departmentName")));

        //Assert that the added Department is displayed on Departments page
        assertTrue(departmentsPage.addDepartment(ConfigReader.getProperty("departmentName")).isDisplayed());
    }
}
