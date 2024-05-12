package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.security.cert.X509Certificate;

public class UserDetailPage {

    public UserDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "changePasswordButton")
    WebElement resetPasswordButton;
    @FindBy(xpath = "//*[contains(@class,'btn-dark')]")
    WebElement confirmButton;
    @FindBy(xpath = "//*[contains(@class,'btn-ghost-dark')]")
    WebElement editIconButton;
    public WebElement getUsernameField() {
        return usernameField;
    }
    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(xpath = "//*[contains(@class,'btn-ghost-primary')]")
    WebElement saveButton;
    @FindBy(xpath = "//*[starts-with(@class,'ms-2')and contains(@class,'cursor-pointer')]")
    WebElement addNewRoleButton;
    @FindBy(xpath = "//div[contains(@class,'css-13cymwt-control')]")
    WebElement dropDownRoles;
    @FindBy(xpath = "//div[starts-with(text(),'Quality') and contains(text(),'Manager')]")
    WebElement storeQualityRoleButton;
    @FindBy(xpath = "//button[contains(@class,'text-white')]")
    WebElement saveRoleButton;
    @FindBy(id = "name")
    WebElement nameField;
    public WebElement getEmailField() {
        return emailField;
    }

    @FindBy(id = "email")
    WebElement emailField;

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @FindBy(xpath = "//span[@class='text-danger']")
    WebElement errorMessage;

    public WebElement getUpdatedSuccessMessage() {
        return updatedSuccessMessage;
    }

    @FindBy (xpath = "//div[@class='toast-body']")
    WebElement updatedSuccessMessage;
    @FindBy(xpath = "//button[contains(@class,'btn-transparent') and contains(@class, 'rounded border-0')]")
    public WebElement accountMenu;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//*[contains(@class,'bg-success')]")
    WebElement ResetPasswordSuccess;

    @FindBy(xpath = "//button[normalize-space()='Close']")
    WebElement closeButton;

    @FindBy(id = "code")
    WebElement newResetPassword;

    public WebElement getProfileHeader() {
        return profileHeader;
    }

    @FindBy(tagName = "h4")
    WebElement profileHeader;
    public String resetPassword(){
        resetPasswordButton.click();
        confirmButton.click();
        String newPassword =  newResetPassword.getText();
        Assert.assertTrue(ResetPasswordSuccess.isDisplayed());
        closeButton.click();
        return newPassword;
    }
    public void logout(){
        accountMenu.click();
        logoutButton.click();
    }


    public void clickOnEditIconButton() {
        editIconButton.click();
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void addNewRole(){
        addNewRoleButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dropDownRoles.click();
        storeQualityRoleButton.click();
        saveRoleButton.click();
        WebElement roleAdded = Driver.getDriver()
                .findElement(By.xpath("//span[contains(text(),'Quality') and contains(text(),'Manager')]"));
        Assert.assertTrue(roleAdded.isDisplayed());
    }


    //This method suppose to be in UsersPage
    public void getFakeEmail(){
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().get("https://temp-mail.org/en");
        String fakeEmailWindowHandle = Driver.getDriver().getWindowHandle();
        WebElement copyButton=Driver.getDriver().findElement(By.id("click-to-copy"));
        copyButton.click();
        Driver.getDriver().switchTo().window(mainWindowHandle);
        //Then create a new member with that email

    }
    public void verifyFakeEmail(){

    }


}