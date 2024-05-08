package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import utilities.Driver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listeners implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onStart(ITestContext context){

        System.out.println("-------------------");
        System.out.println("the moment test execution started..");
        System.out.println("Start time: "+context.getStartDate());
    }
    @Override
    public void onFinish(ITestContext context){
        System.out.println("-------------------");
        System.out.println("the moment test execution Ended..");
        System.out.println("End time: "+context.getEndDate());
    }
    @Override
    public void onTestStart(ITestResult result){

        System.out.println("-------------------");
        System.out.println("the moment test execution started..");
        System.out.println(result.getName()+"Test is executing .. ");
    }
    @Override
    public void onTestSkipped(ITestResult result){

        System.out.println("-------------------");
        System.out.println("the moment test execution started..");
        System.out.println(result.getName()+"Test is executing .. ");
    }
    @Override
    public void onTestSuccess(ITestResult result){

        System.out.println("-------------------");
        System.out.println("the moment test execution started..");
        System.out.println(result.getName()+"Test is executed Successfully .. ");
    }
    @Override
    public void onTestFailure(ITestResult result){

        System.out.println("-------------------");
        System.out.println("the moment test execution started..");
        System.out.println(result.getName()+"Test is Failed .. ");
        takeScreen(result);


    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        System.out.println(result.getName() + " test has failed with avarage below 80% ...");

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        //ITestListener.super.onTestFailedWithTimeout(result);
        System.out.println(result.getName() + " from "+ result.getTestClass() +" test has failed due to timeout..");
    }
    // Automatically retries failed test scenarios
    // IRetryAnalyzer Method Implemented
    // This method will be automatically called to RETRY FAILED TEST SCENARIOS
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // RETRY COUNT
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    // IAnnotationTransformer method added
    // This automatically retries failed test scenarios using testng xml files
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Listeners.class);
    }

    public void takeScreen(ITestResult result)  {
        if (!result.isSuccess()) {
            File imageFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new Date())
                    + ".png";
            File failureImageFile = new File(System.getProperty("user.dir")+"\\screenshots\\"+failureImageFileName);
            try {
                FileUtils.copyFile(imageFile, failureImageFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

