package com.cbt.tests.TestCases3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VyTrackCases  extends VyTrackLogin {

    private WebDriver driver;
    private WebDriverWait wait;

    /*Test case #1
     1.Go to “https://qa1.vytrack.com/"
     2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Verify that page subtitle "Options" is displayed

     */
    @Test
    public void test1(){

        // CHANGE MENU
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

        // Verify that page subtitle "Options" is displayed




    }
}
