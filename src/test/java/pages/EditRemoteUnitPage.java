package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditRemoteUnitPage {

    public EditRemoteUnitPage(){
        PageFactory.initElements(Driver.getDriver() ,this);
    }
    @FindBy(xpath = "//li[@id='link6']")
    public WebElement RemoteUnitsBut;

    @FindBy(xpath = "//b[normalize-space()='US1204']")
   public WebElement selectedRemoteElement;

    @FindBy(xpath = "//button[normalize-space()='Edit Remote Unit']")
    public WebElement EditRemoteUnitBut;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement EditName;

    @FindBy(xpath = "//input[@role='combobox']")
    public WebElement DepartmentTypeDropdown;
    @FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[1]")
    public WebElement DeleteDepartmentType;

    @FindBy(xpath = "//div[contains(text(), 'Team')]")
    public WebElement DepartmentTypeTeam;


    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement SaveEdit;

    @FindBy(xpath = "//button[normalize-space()='Delete Department']")
    public WebElement DeleteDepartment;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    public WebElement ConfirmDelete;
    @FindBy(xpath = "//div[@class='toaster toast-container p-3 position-fixed top-0 end-0']")
    public WebElement SuccessMessage;
    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement FiledMessage;


}
