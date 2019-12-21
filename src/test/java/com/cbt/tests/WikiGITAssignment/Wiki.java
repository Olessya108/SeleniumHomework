package com.cbt.tests.WikiGITAssignment;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/*Wiki assignment
1. Go to https://www.wikipedia.org/
2. Enter redsox
3. Wait until all the search suggestions load
4. Verify that there are more that 1 search suggestions
5. Verify that first search suggestion starts with text Boston Red Sox
6. Create a summary that includes that show when the test started, ended and how long it took.
It can be printed in console or some external report. You can use any tools.
    */
public class Wiki {

    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    ExtentTest extentLogger;
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // initializing the classes
        report = new ExtentReports();
        // creating report path
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        // initializing the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);
        // attaching the html report to the report object
        report.attachReporter(htmlReporter);
        // set the title of the report
        htmlReporter.config().setReportName("Wiki Red Sox Report");
        // set environment information
        report.setSystemInfo("Environment", "https://www.wikipedia.org/");
        report.setSystemInfo("Browser", "Chrome");
        report.setSystemInfo("Reporter", "Olessya Foxborn");
        report.setSystemInfo("Date first created", "Dec 7, 2019");

    }

    @Test
    public void WikiTest() throws InterruptedException {

        extentLogger = report.createTest("Wikipedia test");
        extentLogger.info("Open browser");
        driver = BrowserFactory.getDriver("Chrome");
        extentLogger.info("Go to https://www.wikipedia.org/");
        driver.get(" https://www.wikipedia.org/");
        extentLogger.info("Enter redsox");
        driver.findElement(By.id("searchInput")).sendKeys("red sox");
        extentLogger.info("Wait until all the search suggestions load");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        List<WebElement> allResults = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#typeahead-suggestions p")));
        extentLogger.info("number of suggestions = " + allResults.size());
        WebElement firstResult = allResults.get(0);
        extentLogger.info("Verifying first suggestion:" + firstResult.getText());
        Assert.assertEquals(firstResult.getText(), "Boston");
        Assert.assertFalse(firstResult.getText().isEmpty());
        extentLogger.pass("PASSED");

        extentLogger.info("Verify that there are more that 1 search suggestions");
        Assert.assertTrue((driver.findElements(By.cssSelector("h3.suggestion-title")).size()) > 1);
        System.out.println(driver.findElements(By.cssSelector("h3.suggestion-title")).size());
        extentLogger.info("Verify that first search suggestion starts with text Boston Red");
        String actualFirstSuggestion = driver.findElement(By.cssSelector("h3.suggestion-title")).getText();
        Assert.assertEquals("Boston Red Sox", actualFirstSuggestion);
        System.out.println(actualFirstSuggestion);

        //closing browser
        driver.close();

    }

    @AfterTest
    public void tearDownTest() {

        report.flush();
    }


}
