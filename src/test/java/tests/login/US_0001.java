package tests.login;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.WelcomePage;
import utilities.ConfigReader;
import utilities.Driver;


public class US_0001 {

    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();


    // Test 1 : Successful Login with valid Email and Password
    @Test(priority = 5)
    public void testLoginWithValidCredentials() {

        // Go to WelcomePage and click in login button
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();

        // assertion for the Sign in Page
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.SigninButton.isDisplayed());


        // Enter UserName and Password and Click in sign In button
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        //assertion for the title of the page after login
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("Account Management"));


    }


    // Test 2 : Login with Invalid Email Format (Missing "@")
    @Test(priority = 4)
    public void testLoginWithInvalidEmailFormat() {

        // Go to WelcomePage and click in login button
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();

        // Assert the field in the login Page
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.SigninButton.isDisplayed());


        // Enter UserName(Email Missing "@") and Password and Click in sign button
        loginPage.login("botestevolve.com", "s5G1hKe6O6YMpPQ");

        // assert the error message whine the username or password is invalid
        Assert.assertTrue(loginPage.errorMassage.isDisplayed());

        //  Verify the URL remains on the login page
        String expectedLoginPageUrl = "https://a3m-qa-gm3.quaspareparts.com/login?error=Invalid%20Credentials";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedLoginPageUrl, "URL remain on the login page after error");

    }


    // Test 3 : Login with Invalid Email Format (Missing ".")
    @Test(priority = 3)
    public void testLoginWithInvalidEmailFormat1() {

        // Go to WelcomePage and click in login button
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();

        // Assert the field in the login Page
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.SigninButton.isDisplayed());


        // Enter UserName(Email Missing ".") and Password and Click in sign button
        loginPage.login("bo@testevolvecom", "s5G1hKe6O6YMpPQ");

        // assert the error message whine the username or password is invalid
        Assert.assertTrue(loginPage.errorMassage.isDisplayed());

        //  Verify the URL remains on the login page
        String expectedLoginPageUrl = "https://a3m-qa-gm3.quaspareparts.com/login?error=Invalid%20Credentials";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedLoginPageUrl, "URL remain on the login page after error");

    }


    //Test 4 : Login with valid Email and Invalid password
    @Test(priority = 2)
    public void testLoginWithValidEmailAndInvalidPassword() {


        // Go to WelcomePage and click in login button
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();

        // Assert the field in the login Page
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.SigninButton.isDisplayed());


        // Enter UserName and Invalid Password and Click in sign button
        loginPage.login("bo@testevolve.com", "435gebhk");

        // assert the error message whine the username or password is invalid
        Assert.assertTrue(loginPage.errorMassage.isDisplayed());

        //  Verify the URL remains on the login page
        String expectedLoginPageUrl = "https://a3m-qa-gm3.quaspareparts.com/login?error=Invalid%20Credentials";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedLoginPageUrl, "URL remain on the login page after error");


    }


    //Test 5 : Verify Login with Empty Username and Password
    @Test(priority = 1)
    public void testLoginWithEmptyUsernameAndPassword() {

        // Go to WelcomePage and click in login button
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();

        // Assert the field in the login Page
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.SigninButton.isDisplayed());


        // Enter Empty(UserName and Password) and Click in sign button
        loginPage.login("", "");


        // assert the error message whine the username or password is invalid
        //Assert.assertTrue(loginPage.errorMassage.isDisplayed());


        //  Verify the URL remains on the login page
        String expectedLoginPageUrl = "https://a3m-qa-gm3.quaspareparts.com/login";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedLoginPageUrl, "URL remain on the login page after error");


    }


}
