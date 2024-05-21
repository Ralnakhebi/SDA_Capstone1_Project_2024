package tests.users;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.WelcomePage;
import pages.UserDetailPage;
import pages.UsersPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
@Listeners(utilities.Listeners.class)
public class US_0016 {
    UserDetailPage userDetailPage = new UserDetailPage();
    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    UsersPage usersPage=new UsersPage();
    String userEmail = "jemel55942@losvtn.com";

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

    /************************************************
     *         User Email Cannot Be Changed         *
     ************************************************/
    @Test(description = "To verify that the user email cannot be changed")
    public void testCase02(){
        //The Email field Tage name is not input, therefor user cannot type on it,
        //we can check if the tage name is label then it not editable
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='"+userEmail+"']")).click();
        userDetailPage.clickOnEditIconButton();
        String emailFieldTagName = userDetailPage.getEmailField().getTagName();
        //if the tag name is label not input then the Test Objective has been fulfilled
        Assert.assertTrue(emailFieldTagName.equals("label"));

    }

    /************************************************
     *           Username Cannot Be Empty           *
     ************************************************/
    @Test(description = "To verify that the username cannot be empty while editing the user Information on the User Detail page")
    public void testCase03() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='"+userEmail+"']")).click();
        userDetailPage.clickOnEditIconButton();
        waitSecond();

        //userDetailPage.getUsernameField().clear(); is not recommended because the website not tracking that the field is now empty
        //So I try a human behavior select all and backspace button in the keyboard
        userDetailPage.getUsernameField().sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE);
        Assert.assertTrue(userDetailPage.getErrorMessage().isDisplayed());
    }
    /************************************************
     *           Username Is Changeable             *
     ************************************************/
    @Test(description = "To verify that the username accepts any username except the empty field while editing the user information")
    public void testCase04(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='"+userEmail+"']")).click();
        userDetailPage.clickOnEditIconButton();
        waitSecond();
        userDetailPage.getUsernameField().sendKeys(Keys.chord(Keys.CONTROL, "a"),userEmail+(int)(Math.random() * 100));
        userDetailPage.clickOnSaveButton();

        userDetailPage.clickOnEditIconButton();
        waitSecond();
        userDetailPage.getUsernameField().sendKeys(Keys.chord(Keys.CONTROL, "a"),userEmail);
        userDetailPage.clickOnSaveButton();
        waitSecond();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(userDetailPage.getUpdatedSuccessMessage()));

        String messageText = String.valueOf(((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].innerHTML", userDetailPage.getUpdatedSuccessMessage()));
        System.out.println("messageText = " + messageText);
        Assert.assertTrue(messageText.contains("User information updated successfully"));
        Assert.assertTrue(userDetailPage.getUpdatedSuccessMessage().isDisplayed());

    }

    /************************************************
     *           User Can Reset Password            *
     ************************************************/
    @Test(description = "To verify that the user can Reset Password on the User Detail page",priority = 1)
    public void testCase05(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='"+userEmail+"']")).click();
        String newPassword = userDetailPage.resetPassword();
        userDetailPage.logout();
        //Try to log in with new password
        welcomePage.loginButton.click();
        loginPage.login("jemel55942@losvtn.com", newPassword);
        //Assert That the new password is valid
        Assert.assertTrue(userDetailPage.getProfileHeader().isDisplayed());


    }

    /************************************************
     *           User Add Another Role              *
     ************************************************/
    @Test(description = "To verify that the user can add another role in the User Detail page")
    public void testCase06(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='"+userEmail+"']")).click();
        userDetailPage.addNewRole();
        waitSecond();


    }

    public void waitSecond(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
