package pages;

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

}