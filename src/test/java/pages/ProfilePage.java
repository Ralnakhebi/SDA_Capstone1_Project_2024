package pages;


import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
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


    // xpath for the My Subscriptions button in drob down manue
    @FindBy(xpath = "//*[text()='My Subscriptions' and @class='dropdown-item']")
    public WebElement MySubscriptionsbutton;


    // xpath for the My Memberships button in dropdown button
    @FindBy(xpath = "*[text()='My Memberships' and @class='dropdown-item']")
    public WebElement MyMembershipsbutton;


    // xpath for the logout button in the dropdown manue
    @FindBy(xpath = "//*[text()='Logout' and @class='dropdown-item']")
    public WebElement logoutButton;

    //[dropdown manue End]
/////////////////////////////////////////////////////////////////////////////////////
    @FindBy(id = "changePasswordButton")
    public WebElement changepassword;

    @FindBy(id = "newPassword")
    public WebElement newPassword1;

    @FindBy(id = "newPassword2")
    public WebElement newPassword2;

    @FindBy(xpath = "//button[@class='btn btn-dark text-white me-2']")
    public WebElement confirmButton;

    @FindBy(xpath = "//div[@class='btn btn-danger text-white me-2']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible fade show mt-1']")
    public WebElement textmessagepassword;

    @FindBy(xpath = "//*[@id=MainContent]/div[1]/div/div[2]/div[2]/div[1]/div[1]/span")
    public WebElement textmessageusername;

    @FindBy(xpath = "//button[@class='btn btn-ghost-dark rounded-circle']")
    public WebElement editbutton;

    @FindBy(id ="username")
    public WebElement editeusername;

    @FindBy(xpath = "//*[@class='icon']")
    public WebElement rightbutton;
    @FindBy(xpath = "//*[@id=MainContent]/div[1]/div/div[2]/div[2]/div[1]/div[2]/label[1]")
    public WebElement Email;
    public void Changepassword (String password1, String password2){
        newPassword1.clear();
        newPassword1.click();
        newPassword1.sendKeys(password1);
        newPassword2.click();
        newPassword2.clear();
        newPassword2.sendKeys(password2);
        confirmButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void Changeusername(String username){
        editbutton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        editeusername.clear();
        editeusername.sendKeys(username);
        //Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE
        rightbutton.click();

       // Thread.sleep(1000);
    }
    public void Changeemail(String email){
        editbutton.click();
        Email.click();

        //Assert.assertTrue();

    }

}
