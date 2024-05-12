package tests.users;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UsersPage;
import utilities.Driver;

import java.time.Duration;

public class US_0015 {
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    UsersPage usersPage = new UsersPage();
    @Test(description = "To verify that the new user is appearing on the Users page")
    public void TC01(){
        usersPage.userModule.click();

        wait.until(ExpectedConditions.elementToBeClickable(usersPage.addNewUserButton));
        usersPage.addNewUserButton.click();

        usersPage.toSelectDepartment(); // select department
        usersPage.toSelectRole(); // select role
        usersPage.toEnterEmail("sda@test.com"); // enter valid email
        usersPage.registerButton.click(); // click on register button

        wait.until(ExpectedConditions.visibilityOf(usersPage.successMessage));
        Assert.assertTrue(usersPage.successMessage.isDisplayed()); // verify successful message

        usersPage.closeButton.click();

        try {
            usersPage.toRemoveUser(); // remove the user
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(description = "To confirm the new user email")
    public void TC02(){



    }
}
