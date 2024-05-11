package tests.users;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.UsersPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

@Listeners(utilities.Listeners.class)
public class US_0017 {
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
    UsersPage usersPage = new UsersPage();
    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


    //_________________________TC_01_______________________________
    @Test(testName = "TC01" , description = "validate adding new user" , priority = 1)
    public void addNewUesrTest() throws InterruptedException {

        usersPage.userModule.click();

        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment(); // select department
        usersPage.toSelectRole(); // select role
        usersPage.toEnterEmail(usersPage.validEmail); // enter valid email
        usersPage.registerButton.click(); // click on register button

        wait.until(ExpectedConditions.visibilityOf(usersPage.successMessage));
        Assert.assertTrue(usersPage.successMessage.isDisplayed()); // verify successful message

        usersPage.closeButton.click();
        usersPage.toRemoveUser(); // remove the user

    }


    //_________________________TC_02_______________________________
    @Test(testName = "TC02" , description = "validate email is required to add new user" , priority = 2)
    public void emailIsRequiredTest(){

        usersPage.userModule.click();
        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment();
        usersPage.toSelectRole();
        usersPage.registerButton.click();

        wait.until(ExpectedConditions.visibilityOf(usersPage.requiredMessage));
        Assert.assertTrue(usersPage.requiredMessage.isDisplayed());
        Assert.assertEquals(usersPage.requiredMessage.getText(),"Please enter a valid email");
    }



    //_________________________TC_03_______________________________
    @Test(testName = "TC03" , description = "validate role is required to add new user" , priority = 3)
    public void roleIsRequiredTest(){

        usersPage.userModule.click();
        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment();
        usersPage.toEnterEmail(usersPage.validEmail);
        usersPage.registerButton.click();

        wait.until(ExpectedConditions.visibilityOf(usersPage.requiredMessage));
        Assert.assertTrue(usersPage.requiredMessage.isDisplayed());
        Assert.assertEquals(usersPage.requiredMessage.getText(),"Please select a role for the user you will add");
    }


    //_________________________TC_04_______________________________
    @Test(testName = "TC04" , description = "validate email should contain '@'" , priority = 4)
    public void emailIsInvalid01(){

        usersPage.userModule.click();
        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment();
        usersPage.toSelectRole();
        usersPage.toEnterEmail("test.com");
        usersPage.registerButton.click();

        wait.until(ExpectedConditions.visibilityOf(usersPage.requiredMessage));
        Assert.assertTrue(usersPage.requiredMessage.isDisplayed());
        Assert.assertEquals(usersPage.requiredMessage.getText(),"Please enter a valid email");
    }


    //_________________________TC_05_______________________________
    @Test(testName = "TC05" , description = "validate email should contain '.com'" , priority = 5)
    public void emailIsInvalid02(){

        usersPage.userModule.click();
        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment();
        usersPage.toSelectRole();
        usersPage.toEnterEmail("test@test");
        usersPage.registerButton.click();

        wait.until(ExpectedConditions.visibilityOf(usersPage.requiredMessage));
        Assert.assertTrue(usersPage.requiredMessage.isDisplayed());
        Assert.assertEquals(usersPage.requiredMessage.getText(),"Please enter a valid email");
    }
}
