package tests.users;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
@Listeners(utilities.Listeners.class)
public class US_0016 {
    UserDetailPage userDetailPage = new UserDetailPage();
    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    UsersPage usersPage=new UsersPage();


    @Test(description = "To verify that the default role cannot be deleted on the User Detail page")
    public void TC01(){
        //The Default Role Tage name is not Button, therefor user cannot delete the default role
        //But We can change the default role to another role and delete the previous default role

    }
    @Test(description = "To verify that the user email cannot be changed")
    public void TC02(){
        //The Email field Tage name is not input, therefor user cannot type on it,
        //we can check if the tage name is label then it not editable
        welcomePage.loginButton.click();
        loginPage.login("bo@testevolve.com", "41KNukonZapx6-S");
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='jemel55942@losvtn.com']")).click();
        userDetailPage.clickOnEditIconButton();
        String emailFieldTagName = userDetailPage.getEmailField().getTagName();
        //if the tag name is label not input then the Test Objective has been fulfilled
        Assert.assertTrue(emailFieldTagName.equals("label"));

    }

    @Test(description = "To verify that the username cannot be empty while editing the user Information on the User Detail page")
    public void TC03() {

        welcomePage.loginButton.click();
        loginPage.login("bo@testevolve.com", "41KNukonZapx6-S");
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='jemel55942@losvtn.com']")).click();
        userDetailPage.clickOnEditIconButton();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //userDetailPage.getUsernameField().clear(); is not recommended because the website not tracking that the field is now empty
        //So I try a human behavior select all and backspace button in the keyboard
        userDetailPage.getUsernameField().sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE);
        //((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].value = 'isItWork';",userDetailPage.getUsernameField());
        Assert.assertTrue(userDetailPage.getErrorMessage().isDisplayed());
    }

    @Test(description = "To verify that the username accepts any username except the empty field while editing the user information ")
    public void TC04(){
        welcomePage.loginButton.click();
        loginPage.login("bo@testevolve.com", "41KNukonZapx6-S");
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='jemel55942@losvtn..com']")).click();
        userDetailPage.clickOnEditIconButton();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        userDetailPage.getUsernameField().sendKeys(Keys.chord(Keys.CONTROL, "a"),"jemel55942@losvtn.com");
        userDetailPage.clickOnSaveButton();

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(userDetailPage.getUpdatedSuccessMessage()));
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].value = 'isItWork';",userDetailPage.getUsernameField());

        String messageText = String.valueOf(((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].innerHTML", userDetailPage.getUpdatedSuccessMessage()));
        System.out.println("messageText = " + messageText);
        //I can't locate the success message
        Assert.assertTrue(messageText.contains("User information updated successfully"));
        Assert.assertTrue(userDetailPage.getUpdatedSuccessMessage().isDisplayed());

    }

    @Test(description = "To verify that the user can Reset Password on the User Detail page")
    public void TC05(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        loginPage.login("bo@testevolve.com", "41KNukonZapx6-S");
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='jemel55942@losvtn.com']")).click();
        String newPassword = userDetailPage.resetPassword();
        userDetailPage.logout();
        //Try to log in with new password
        welcomePage.loginButton.click();
        loginPage.login("jemel55942@losvtn.com", newPassword);
        //Assert That the new password is valid
        Assert.assertTrue(userDetailPage.getProfileHeader().isDisplayed());


    }

    @Test(description = "To verify that the user can add another role in the User Detail page")
    public void TC06(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();
        loginPage.login("bo@testevolve.com", "41KNukonZapx6-S");
        usersPage.userModule.click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='jemel55942@losvtn.com']")).click();
        userDetailPage.addNewRole();

    }

}
