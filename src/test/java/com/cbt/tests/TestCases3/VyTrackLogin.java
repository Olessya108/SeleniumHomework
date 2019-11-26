package com.cbt.tests.TestCases3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrackLogin {
    private WebDriver driver;
    private WebDriverWait wait;
    @Test
    public void test(){
        // TODO OPEN BROWSER
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();


        // TODO LOGIN
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);


        // TODO CHANGE MENU
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));

//        waitForLoader();

        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));


        activitiesElement.click();
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        waitForLoader();
        // do other things
    }

    private void waitForLoader() {
        if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size()>0) {
            WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }
    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}