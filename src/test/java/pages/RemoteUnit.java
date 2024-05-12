package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import static java.lang.Thread.sleep;

public class RemoteUnit {
    public RemoteUnit() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='#/departments/remote']")
    public WebElement clickRemoteUnitPage;
    @FindBy(id="MainContent")
    public WebElement RemoteunitBody;





    public void clickOnRemoteunit() {
        clickRemoteUnitPage.click();
    }
    public void clickOnRemoteunitbody() {
        RemoteunitBody.isDisplayed();
    }


}
