package tests.profile;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import utilities.Driver;

import java.time.Duration;

public class US0004 {

    LoginPage loginPage;
    ProfilePage profilePage;

    @Test(testName = "TC01")
    public void test1() throws InterruptedException{

        loginPage = new LoginPage();
        profilePage = new ProfilePage();

        loginPage.editProfileLogin();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        profilePage.changepassword.click();
        profilePage.Changepassword("*****", "*****");
        Assert.assertTrue(profilePage.textmessagepassword.isDisplayed());
        Thread.sleep(3000);
    }

    @Test (dependsOnMethods = "test1", testName = "TC02")
    public void test2()   {

        profilePage.Changepassword("Qwer@_8", "Qwer@_8");
        Assert.assertTrue(profilePage.textmessagepassword.isDisplayed());
    }

    @Test(dependsOnMethods = "test1",testName = "TC03")
    public void test3() throws InterruptedException{

        profilePage.Changepassword(" qwertyuiop@_8", " qwertyuiop@_8");
        Assert.assertTrue(profilePage.textmessagepassword.isDisplayed());

    }

    @Test(dependsOnMethods = "test1", testName = "TC04")
    public void test4() throws InterruptedException{


        profilePage.Changepassword("QWERTYUIOP@_8", "QWERTYUIOP@_8");
        Assert.assertTrue(profilePage.textmessagepassword.isDisplayed());

    }

    @Test(dependsOnMethods = "test1", testName = "TC05")
    public void test5() throws InterruptedException {

        profilePage.Changepassword("Qwertyuiop@_", "Qwertyuiop@_");
        Assert.assertTrue(profilePage.textmessagepassword.isDisplayed());

        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = "test1", testName = "TC06")
    public void test6() throws InterruptedException{
        profilePage.Changepassword("Qwertyaqz123", "Qwertyaqz123");
        Assert.assertTrue(profilePage.textmessagepassword.isDisplayed());
        profilePage.cancelButton.click();

        Thread.sleep(1000);
    }

 //   @Test
  //  public void test7() {
  //      profilePage.Changepassword("FarahAl_huz@1234", "FarahAl_huz@1234");
   //     Assert.assertTrue(profilePage.textmessagepassword.isDisplayed());

  //  }

    @Test(testName = "TC8", priority = 1)
    public void test08() throws InterruptedException {
        //loginPage = new LoginPage();
        //profilePage = new ProfilePage();
        //loginPage.editProfileLogin();
        profilePage.Changeusername("1farah");

        Assert.assertTrue(profilePage.textmessageusername.isDisplayed());
        Thread.sleep(4000);
        profilePage.closebutton.click();
    }

    @Test(testName = "TC09", priority = 1)
    public void test09() throws InterruptedException{
        //loginPage = new LoginPage();
        //profilePage = new ProfilePage();
        //loginPage.editProfileLogin();

        profilePage.Changeusername("farah._");
        Assert.assertTrue(profilePage.textmessageusername.isDisplayed());
        Thread.sleep(4000);
        profilePage.closebutton.click();
    }

    @Test(testName = "TC10", priority = 1)
    public void test10() throws InterruptedException{
       // loginPage = new LoginPage();
        //profilePage = new ProfilePage();
        //loginPage.editProfileLogin();
        profilePage.Changeusername("farah@1");
        Assert.assertTrue(profilePage.textmessageusername.isDisplayed());
        Thread.sleep(4000);
        //profilePage.closebutton.click();

    }

    @Test(testName = "TC11", priority = 1)
    public void test11() throws InterruptedException{
       // loginPage = new LoginPage();
        //profilePage = new ProfilePage();
        //loginPage.editProfileLogin();
        //profilePage.editbutton.click();
      //  try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
          //  throw new RuntimeException(e);
        //}
        profilePage.editeusername.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
        Assert.assertTrue(profilePage.textmessageusername.isDisplayed());
        Thread.sleep(1000);
        profilePage.closebutton.click();
    }
    @Test(testName = "TC12", priority = 1)
    public void test12() throws InterruptedException {

        profilePage.Changeusername("Farah_Alhuz1");
        profilePage.rightbutton.click();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(profilePage.successmessageusername));
        Assert.assertTrue(profilePage.successmessageusername.isDisplayed());
        Thread.sleep(4000);

    }
}