package com.cbt.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cbt.pages.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected String url;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;
    Actions actions;

    @BeforeTest
    public void setUpTest() {
        report = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Regression tests");
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", configurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @AfterTest
    public void tearDownTest() {
        report.flush();
    }

    @BeforeMethod
    @Parameters("env")
    public void setupMethod(@Optional String env) {  // same string name we use in smoketests with multiple environmets
        System.out.println("env = " + env);
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        url = configurationReader.get("url");
        driver.get(url);
        actions = new Actions(driver);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(ITestResult result) throws InterruptedException, IOException {
        // IF FAILED TAKE SCREENSHOT
        if (result.getStatus() == ITestResult.FAILURE) {
            // record the name of the failed testcase
            extentLogger.fail(result.getName());
            // take screenshot and return location of the screenshot
            String screenshot = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshot);
            // capture the exception
            extentLogger.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            // sometime tests are skipped, this is how we log skipped tests
            extentLogger.skip("Test Skipped: " + result.getName());
        }

        // CLOSE BROWSER
        Thread.sleep(1000);
        Driver.closeDriver();
    }


}