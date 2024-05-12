package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProfilePage {


    public ProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // xpath for logo
    @FindBy(xpath = "//*[@alt='Logo']")
    public WebElement logobutton;

    // xpath for the Collapse button
    @FindBy(xpath = "//*[@alt='Collapse']")
    public WebElement ArrowCollapseButton;


///////////////////////////////////////////////////////////////////////////////
    // [dropdown Manue start]

    // xpath for drobdown manue
    @FindBy(xpath = "//button[@tabindex='0']")
    public WebElement drobManueButton;

    // xpath for the username and role in dropdown manue
    @FindBy(xpath = "//*[@class='fw-bold'] [1]")
    public WebElement usernameAndRole;

    // xpath for the My Subscriptions button in dropdown manue
    @FindBy(xpath = "//*[text()='My Subscriptions']")
    public WebElement MySubscriptionsbutton;


    // xpath for the My Memberships button in dropdown button
    @FindBy(xpath = "//*[text()='My Memberships']")
    public WebElement MyMembershipsbutton;


    // xpath for the logout button in the dropdown manue
    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logoutButton;

    //[dropdown manue End]
/////////////////////////////////////////////////////////////////////////////////////

    // xpath for collapse Arrow Button
    @FindBy(xpath = "//*[@alt='Collapse']")
    public WebElement collapse;


}

