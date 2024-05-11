package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserDetailPage {

    public UserDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "changePasswordButton")
    WebElement resetPasswordButton;

    @FindBy(xpath = "//*[contains(@class,'btn-dark')]")
    WebElement confirmButton;

    @FindBy(xpath = "//*[contains(@class,'bg-success')]")
    WebElement resetPasswordSuccess;
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
    @FindBy(xpath = "//div[contains(@class,'css-t3ipsp-control')]")
    WebElement dropDownRoles;
    @FindBy(xpath = "//div[starts-with(text(),'Store') and contains(text(),'Manager')]")
    WebElement storeMangerRoleButton;

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

    @FindBy (xpath = "//*[contains(text(),'User information updated successfully']")
    WebElement updatedSuccessMessage;
    public void clickOnResetPasswordButton() {
        resetPasswordButton.click();
    }

    public void clickOnConfirmButton() {
        confirmButton.click();
    }

    public void clickOnEditIconButton() {
        editIconButton.click();
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickOnAddNewRoleButton() {
        addNewRoleButton.click();
    }

    public void selectStoreMangerRole() {
        dropDownRoles.click();
        storeMangerRoleButton.click();
    }
    public void clickSaveRoleButton(){
        saveRoleButton.click();
    }
    public void enterName(String name){
        nameField.sendKeys(name);
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