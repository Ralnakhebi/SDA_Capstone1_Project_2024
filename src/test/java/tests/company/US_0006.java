package tests.company;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CompanyPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

@Listeners(utilities.Listeners.class)
public class US_0006{

    CompanyPage companyPage;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
        Driver.getDriver().findElement(By.xpath("//*[text()='Login']")).click();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
    }
    @AfterMethod
    public void tearDown(){
       Driver.closeDriver();
    }


    //-------------------------TC_01------------------------------------
    @Test(description = "Edit All Company Information Fields")
    public void companyTest01(){

        companyPage = new CompanyPage();
        companyPage.companyEditProcess(

                "My Company",
                "My Comp",
                "MyCompany@gmail.com",
                "www.mycompany.com",
                "966131313131313",
                "966131313131313",
                "Saudi Arabia",
                "Saudi Arabia",
                "active",
                "Saudi riyal");
    }

    //-------------------------TC_02------------------------------------
    @Test(description = "Edit Company Information Without Writing Name")
    public void companyTest02(){

        companyPage = new CompanyPage();
        companyPage.EditCompanyInformationWithoutName(

                "My Comp",
                "MyCompany@gmail.com",
                "www.mycompany.com",
                "966131313131313",
                "966131313131313",
                "Saudi Arabia",
                "Saudi Arabia",
                "active",
                "Saudi riyal");
}

    //-------------------------TC_03------------------------------------
    @Test(description = "Edit Company Information Without Writing E-Mail")
    public void companyTest03(){
        companyPage = new CompanyPage();
        companyPage.EditCompanyInformationWithoutEmail(

                "My Company",
                "My Comp",
                "www.mycompany.com",
                "966131313131313",
                "966131313131313",
                "Saudi Arabia",
                "Saudi Arabia",
                "active",
                "Saudi riyal");
    }
}
