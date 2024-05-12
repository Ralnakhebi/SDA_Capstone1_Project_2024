package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProfilePage;
import pages.WelcomePage;

public class US_0002 extends US_0001 {

    WelcomePage welcomePage = new WelcomePage();
    ProfilePage profilePage = new ProfilePage();

    //(dependsOnMethods = {"tests.Login.US_0001.testLoginWithValidCredentials"})
    // Test 1 : Verify Logo Functionality display and click
    @Test
    public void VerifyLogoFunctionality() throws InterruptedException {

        Assert.assertTrue(profilePage.logobutton.isDisplayed());

        Thread.sleep(2000);
        profilePage.logobutton.click();

        // click in login button in the WelcomePage
        welcomePage.loginButton.click();

    }


    // Test 2 : Verify Sidebar collapse display and click
    @Test
    public void SidebarExpand() throws InterruptedException {

        // click and verify ArrowCollapseButton
        Thread.sleep(1000);
        profilePage.ArrowCollapseButton.click();
        Assert.assertTrue(profilePage.ArrowCollapseButton.isDisplayed());
    }


    //(dependsOnMethods = {"tests.Login.US_0002.SidebarExpand"})
    // Test 3 : Verify Sidebar  Expand displayd and click
    @Test
    public void Sidebarcollapse() throws InterruptedException {


        // click and verify ArrowCollapseButton
        Thread.sleep(1000);
        profilePage.ArrowCollapseButton.click();
        Assert.assertTrue(profilePage.collapse.isDisplayed());
    }
}
