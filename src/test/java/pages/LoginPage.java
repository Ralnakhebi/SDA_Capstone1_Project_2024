package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // xpath for usernameField
    @FindBy(id = "username")
    public WebElement usernameField;

    // xpath for passwordField
    @FindBy(id = "password")
    public WebElement passwordField;


    //xpath for SigninButton
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement SigninButton;

    //xpath for error massage
    @FindBy(xpath = "//*[.='Invalid Credentials']")
    public WebElement errorMassage;



    public void defaultLogin() {

        String url = "https://a3m-qa-gm3.quaspareparts.com/login";
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.loginButton.click();

        LoginPage lg = new LoginPage();
        lg.usernameField.sendKeys(ConfigReader.getProperty("username1"));
        lg.passwordField.sendKeys(ConfigReader.getProperty("password1"));
        lg.SigninButton.click();
    }

    public void editProfileLogin() {

        String url = "https://a3m-qa-gm3.quaspareparts.com/login";
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.loginButton.click();

        LoginPage lg = new LoginPage();
        lg.usernameField.sendKeys(ConfigReader.getProperty("username"));
        lg.passwordField.sendKeys(ConfigReader.getProperty("password"));
        lg.SigninButton.click();
    }

    public void login(String Username, String password) {
        usernameField.sendKeys(Username);
        passwordField.sendKeys(password);
        SigninButton.click();
    }
}

