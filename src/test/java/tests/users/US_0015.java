package tests.users;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UsersPage;
import utilities.Driver;

import java.time.Duration;
@Listeners(utilities.Listeners.class)
public class US_0015 {
    LoginPage loginPage = new LoginPage();
    UsersPage usersPage = new UsersPage();

    /************************************************
     *       New User Appear On The User Page       *
     ************************************************/
    @Test(description = "To verify that the new user is appearing on the Users page")
    public void testCase01(){
        loginPage.editProfileLogin();
        usersPage.userModule.click();
        //User Creating
        addUserByEmail("sda@test.com");
        //Is the new user appearing on the Users page
        boolean isDisplayed = usersPage.toCheckTheUserAppearing("sda@test.com");
        Assert.assertTrue(isDisplayed);
        waitSecond();

    }


    public void addUserByEmail(String email){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();
        usersPage.toSelectDepartment(); // select department
        usersPage.toSelectRole(); // select role
        usersPage.toEnterEmail(email); // enter valid email
        usersPage.registerButton.click(); // click on register button
        wait.until(ExpectedConditions.visibilityOf(usersPage.successMessage));
        Assert.assertTrue(usersPage.successMessage.isDisplayed()); // verify successful message
        usersPage.closeButton.click();
    }
    public void waitSecond(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
