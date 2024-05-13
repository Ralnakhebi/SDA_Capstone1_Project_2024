package tests.users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProfilePage;
import pages.UsersPage;
import pages.WelcomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

@Listeners(utilities.Listeners.class)
public class US_0017 {
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    UsersPage usersPage = new UsersPage();
    LoginPage loginPage = new LoginPage();
    WelcomePage welcomePage = new WelcomePage();
    ProfilePage profilePage = new ProfilePage();

    @BeforeClass
    public void open() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterClass
    public void close() {Driver.closeDriver();}

    @BeforeMethod
    public void setUp() {
        welcomePage.loginButton.click();
        if (Driver.getDriver().getCurrentUrl().equals("https://a3m-qa-gm3.quaspareparts.com/login")) {
            loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
            usersPage.userModule.click();
        } else {
            usersPage.userModule.click();
        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        profilePage.usernameAndRole.click();
        wait.until(ExpectedConditions.elementToBeClickable(profilePage.logoutButton));
        profilePage.logoutButton.click();
    }

    //_________________________TC_01_______________________________
    @Test(testName = "TC01", description = "validate adding new user", priority = 1)
    public void addNewUesrTest() throws InterruptedException {

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
    @Test(testName = "TC02", description = "validate email is required to add new user", priority = 2)
    public void emailIsRequiredTest() {

        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment();
        usersPage.toSelectRole();
        usersPage.registerButton.click();

        wait.until(ExpectedConditions.visibilityOf(usersPage.requiredMessage));
        Assert.assertTrue(usersPage.requiredMessage.isDisplayed());
        Assert.assertEquals(usersPage.requiredMessage.getText(), "Please enter a valid email");

        usersPage.closeButton.click();
    }


    //_________________________TC_03_______________________________
    @Test(testName = "TC03", description = "validate role is required to add new user", priority = 3)
    public void roleIsRequiredTest() {

        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment();
        usersPage.toEnterEmail(usersPage.validEmail);
        usersPage.registerButton.click();

        wait.until(ExpectedConditions.visibilityOf(usersPage.requiredMessage));
        Assert.assertTrue(usersPage.requiredMessage.isDisplayed());
        Assert.assertEquals(usersPage.requiredMessage.getText(), "Please select a role for the user you will add");

        usersPage.closeButton.click();

    }


    //_________________________TC_04_______________________________
    @Test(testName = "TC04", description = "validate email should contain '@'", priority = 4)
    public void emailIsInvalid01() {

        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment();
        usersPage.toSelectRole();
        usersPage.toEnterEmail("test.com");
        usersPage.registerButton.click();

        wait.until(ExpectedConditions.visibilityOf(usersPage.requiredMessage));
        Assert.assertTrue(usersPage.requiredMessage.isDisplayed());
        Assert.assertEquals(usersPage.requiredMessage.getText(), "Please enter a valid email");

        usersPage.closeButton.click();

    }


    //_________________________TC_05_______________________________
    @Test(testName = "TC05", description = "validate email should contain '.com'", priority = 5)
    public void emailIsInvalid02() {

        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment();
        usersPage.toSelectRole();
        usersPage.toEnterEmail("test@test");
        usersPage.registerButton.click();

        wait.until(ExpectedConditions.visibilityOf(usersPage.requiredMessage));
        Assert.assertTrue(usersPage.requiredMessage.isDisplayed());
        Assert.assertEquals(usersPage.requiredMessage.getText(), "Please enter a valid email");

        usersPage.closeButton.click();
    }
}
