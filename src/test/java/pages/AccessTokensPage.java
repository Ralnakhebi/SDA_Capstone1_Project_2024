package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccessTokensPage {

    public AccessTokensPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "h4")
    public WebElement createTokenText;

    @FindBy(xpath = "//a[@href='#/tokens']")
    public WebElement accessTokensButton;

    @FindBy(id = "react-select-4-input")
    public WebElement scopesDropdown;

    @FindBy(xpath = "//button[contains(text(),'Create Token')]")
    public WebElement createTokenButton;

    @FindBy(xpath = "//div[@class = 'modal fade show']//h4")
//    @FindBy(xpath = "//div[@class = 'modal-body']")
    public WebElement tokenCreatedText;

    @FindBy(xpath = "//table[@role = 'table']//tbody//tr[1]//td[7]//*[@role = 'img']")
    public WebElement deleteTokenButton;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    public WebElement deleteConfirmButton;

    @FindBy(xpath = "//*[contains(text(),'Selected token successfully deleted')]")
    public WebElement deleteSuccessMessage;

    @FindBy(xpath = "//*[contains(text(),'Please select scopes')]")
    public WebElement createTokenErrorMessage;

}
