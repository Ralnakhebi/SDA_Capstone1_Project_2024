package tests.accesToken;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccessTokensPage;
import pages.LoginPage;
import pages.WelcomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class US_0021 {

    WelcomePage welcomePage;
    LoginPage loginPage;
    AccessTokensPage accessTokensPage;
    WebDriverWait wait;

    @Test
    public void TC01(){

        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        accessTokensPage = new AccessTokensPage();
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();


        // Enter UserName and Password and Click in sign In button
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        accessTokensPage.accessTokensButton.click();

        wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));


        wait.until(ExpectedConditions.visibilityOf(accessTokensPage.createTokenText));
        Assert.assertTrue(accessTokensPage.createTokenText.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(accessTokensPage.scopesDropdown));
        accessTokensPage.scopesDropdown.click();
        accessTokensPage.scopesDropdown.sendKeys("order:write" + Keys.ENTER + Keys.ESCAPE);

        accessTokensPage.createTokenButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(accessTokensPage.scopesDropdown));
//        System.out.println(accessTokensPage.tokenCreatedText.getText());
        Assert.assertTrue(accessTokensPage.tokenCreatedText.isDisplayed());
    }


    @Test
    public void TC02() {

        wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        accessTokensPage = new AccessTokensPage();
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();


        // Enter UserName and Password and Click in sign In button
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        accessTokensPage.accessTokensButton.click();

//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//
//        js.executeScript("arguments[0].click()",accessTokensPage.deleteTokenButton);
//
//        Actions actions = new Actions(Driver.getDriver());
//        actions.moveToElement(accessTokensPage.deleteTokenButton).click().perform();
        accessTokensPage.deleteTokenButton.click();
        accessTokensPage.deleteConfirmButton.click();

        wait.until(ExpectedConditions.visibilityOf(accessTokensPage.deleteSuccessMessage));
        Assert.assertTrue(accessTokensPage.deleteSuccessMessage.isDisplayed());
    }

    @Test
    public void TC03(){


        wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
        accessTokensPage = new AccessTokensPage();
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        welcomePage.loginButton.click();


        // Enter UserName and Password and Click in sign In button
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        accessTokensPage.accessTokensButton.click();

        accessTokensPage.createTokenButton.click();

        Assert.assertTrue(accessTokensPage.createTokenErrorMessage.isDisplayed());
    }
}
