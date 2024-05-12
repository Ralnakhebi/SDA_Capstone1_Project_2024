package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.WelcomePage;

public class US_0003 {

    // Test 1 :  Verify dropdown menu and display Username and role
    // --> you can Verify My Subscriptions button in drob down manue
    //and My Memberships button in dropdown button
    //and logout button in the dropdown manue


    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();


    //(dependsOnMethods = {"tests.Login.US_0001.testLoginWithValidCredentials"})
    //Verify dropdown menu and display Username and role
    @Test
    public void dropdownmenu() {

        // click and verify drobManue
        profilePage.drobManueButton.click();
        Assert.assertTrue(profilePage.drobManueButton.isDisplayed());

        // locate the username and the role an confarim ho ever login
        Assert.assertTrue(profilePage.usernameAndRole.isDisplayed());
        System.out.println(profilePage.usernameAndRole.getText());
    }


    @Test
    public void MySubscriptions() {


        // click and verify the MySubscriptions in drobdown Manue
        Assert.assertTrue(profilePage.MySubscriptionsbutton.isDisplayed());
        profilePage.MySubscriptionsbutton.click();

    }


    @Test
    public void MyMemberships() {

        // click and verify the MyMemberships in drobdown Manue
        profilePage.drobManueButton.click();

        Assert.assertTrue(profilePage.MyMembershipsbutton.getText().contains("Membersh"));
        profilePage.MyMembershipsbutton.click();
    }


    @Test
    public void logoutButton() throws InterruptedException {


        // locate the logout button and click
        profilePage.drobManueButton.click();
        profilePage.logoutButton.click();

        // verify i am in the WelcomePage
        Assert.assertTrue(welcomePage.homePageTitle.getText().contains("Welcome to QuaSpareparts.com"));


    }
}
