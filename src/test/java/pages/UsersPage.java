package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import java.time.Duration;
import java.util.List;

public class UsersPage {
    public WebDriverWait wait;
    public UsersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    public String validEmail = "test@test.com";
    @FindBy(id = "link8")
    public WebElement userModule;
    @FindBy(xpath = "//button[text()='+ Add New Member']")
    public WebElement addNewUserButton;
    @FindBy(xpath = "//input[@id='react-select-2-input']")
    public WebElement selectDepartment;
    @FindBy(id = "react-select-2-option-1")
    public WebElement departmentOption;
    @FindBy(xpath = "(//*[@class='css-8mmkcg'])[3]")
    public WebElement dropDownIndicator;
    @FindBy(id = "react-select-3-input")
    public WebElement selectRole;
    @FindBy(id = "react-select-3-option-11")
    public WebElement roleOption;
    @FindBy(id = "email")
    public WebElement emailField;
    @FindBy(xpath = "//button[text()='Register']")
    public WebElement registerButton;
    @FindBy(xpath = "//button[text()='Close']")
    public WebElement closeButton;
    @FindBy(xpath = "//*[text()='New user registration successful']")
    public WebElement successMessage;
    @FindBy(xpath = "//table[@class='table table-hover table-sm ReactDataTable']//tbody//tr[contains(.,'test@test.com')]//td[7]//button")
    public WebElement threeDotsButton;
    @FindBy(xpath = "//tr[contains(.,'test@test.com')]//a[contains(.,'Remove')]//a")
    public WebElement removeButton;
    @FindBy(xpath = "//*[@class='text-danger']")
    public WebElement requiredMessage;
    @FindBy(xpath = "//table[@class='table table-hover table-sm ReactDataTable']//tbody//td[3]")
    public List<WebElement> usersList;

    public void toSelectDepartment(){
        wait.until(ExpectedConditions.elementToBeClickable(selectDepartment));
        selectDepartment.click();
        wait.until(ExpectedConditions.elementToBeClickable(departmentOption));
        departmentOption.click();
        dropDownIndicator.click();
    }
    public void toSelectRole(){
        wait.until(ExpectedConditions.elementToBeClickable(selectRole));
        selectRole.click();
        wait.until(ExpectedConditions.elementToBeClickable(roleOption));
        roleOption.click();
    }
    public void toEnterEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }
    public void toRemoveUser() throws InterruptedException {
        Thread.sleep(2000);
        threeDotsButton.click();
        Thread.sleep(2000);
        removeButton.click();
    }

}
