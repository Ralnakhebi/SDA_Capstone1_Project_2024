package tests.users;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserDetailPage;
import utilities.Driver;

import java.time.Duration;

public class US_0016 {
    UserDetailPage userDetailPage = new UserDetailPage();

    @Test
    public void TC01(){
        //The Default Role Tage name is not Button, therefor user cannot delete the default role
        //But We can change the default role to another role and delete the previous default role

    }
    @Test
    public void TC02(){
        //The Email field Tage name is not input, therefor user cannot type on it,
        //we can check if the tage name is label then it not editable
        Driver.getDriver().get("https://qa-gm3.quaspareparts.com/");
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();
        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@qualitron.com");
        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("cR2hHF0xq4L-m9h");
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Driver.getDriver().findElement(By.xpath("//a[@href='#/users']//*[name()='svg']")).click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='jemel55942@losvtn.com']")).click();
        userDetailPage.clickOnEditIconButton();
        String emailFieldTagName = userDetailPage.getEmailField().getTagName();
        //if the tag name is label not input then the Test Objective has been fulfilled
        Assert.assertTrue(emailFieldTagName.equals("label"));

    }

    @Test
    public void TC03() {

        Driver.getDriver().get("https://qa-gm3.quaspareparts.com/");
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();
        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@qualitron.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("cR2hHF0xq4L-m9h");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Driver.getDriver().findElement(By.xpath("//a[@href='#/users']//*[name()='svg']")).click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='jemel55942@losvtn.com']")).click();
        userDetailPage.clickOnEditIconButton();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //userDetailPage.getUsernameField().clear(); is not recommended because the website not tracking that the field is now empty
        //So I try a human behavior select all and backspace button in the keyboard
        userDetailPage.getUsernameField().sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE);
        //((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].value = 'isItWork';",userDetailPage.getUsernameField());
        Assert.assertTrue(userDetailPage.getErrorMessage().isDisplayed());
    }

    @Test
    public void TC04(){
        Driver.getDriver().get("https://qa-gm3.quaspareparts.com/");
        Driver.getDriver().findElement(By.xpath("//a[@class='login-button']")).click();
        Driver.getDriver().manage().window().maximize();

        WebElement username = Driver.getDriver().findElement(By.id("username"));
        username.sendKeys("bo@qualitron.com");

        WebElement password = Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("cR2hHF0xq4L-m9h");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Driver.getDriver().findElement(By.xpath("//a[@href='#/users']//*[name()='svg']")).click();
        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='jemel55942@losvtn..com']")).click();
        userDetailPage.clickOnEditIconButton();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        userDetailPage.getUsernameField().sendKeys(Keys.chord(Keys.CONTROL, "a"),"jemel55942@losvtn.com");
        userDetailPage.clickOnSaveButton();

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(userDetailPage.getUpdatedSuccessMessage()));
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].value = 'isItWork';",userDetailPage.getUsernameField());

        String messageText = String.valueOf(((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].innerHTML", userDetailPage.getUpdatedSuccessMessage()));
        System.out.println("messageText = " + messageText);
        //I can't locate the success message
        Assert.assertTrue(messageText.contains("User information updated successfully"));
        Assert.assertTrue(userDetailPage.getUpdatedSuccessMessage().isDisplayed());

    }
    @Test
    public void TC05(){

    }

    @Test
    public void TC06(){

    }

}
