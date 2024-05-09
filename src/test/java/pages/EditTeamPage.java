package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class EditTeamPage {
    public WebDriverWait wait;
    public EditTeamPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        //this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    }

    @FindBy(xpath = "//button[normalize-space()='Edit Team']")
    public WebElement EditTeamButton;
    @FindBy(id = "name")
    public WebElement EditTeamName;

  @FindBy(xpath = "(//div[contains(@class,'css-19bb58m')])[1]")

  public WebElement dep;

    @FindBy(xpath = "(//*[contains(@id,'react-select-3-option-1')])")
    public WebElement TeamOption2;
    ////











}
