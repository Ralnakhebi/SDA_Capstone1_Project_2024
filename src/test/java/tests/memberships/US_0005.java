package tests.memberships;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyMembershipsPage;
import utilities.ConfigReader;
import utilities.Driver;
@Listeners(utilities.Listeners.class)
public class US_0005 {

    MyMembershipsPage myMembershipsPage;
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

//-------------------------TC_01------------------------------------
//Display "My Memberships" page and access membership information through Memberships module

   @Test(testName = "TC01", description = "Display 'My Memberships' page")
   public void membershipTest01 () throws InterruptedException {

   myMembershipsPage = new MyMembershipsPage();
   myMembershipsPage.displayMembershipFirstTC();
    }

//-------------------------TC_02------------------------------------
/* Display "My Memberships" page and access membership information
    through the drop-down menu under the username */
    @Test(testName = "TC02", description = "Display 'My Memberships' page")
    public void membershipTest02() throws InterruptedException {

    myMembershipsPage = new MyMembershipsPage();
    myMembershipsPage.displayMembershipSocTC();

        }
    }
