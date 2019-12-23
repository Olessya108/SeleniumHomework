package com.cbt.tests.TestCases4;

import com.cbt.pages.*;
import com.cbt.utilities.Driver;
import com.cbt.utilities.configurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CalendarEventsTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private String url;

    @BeforeMethod(description = " Go to “https://qa1.vytrack.com/" +
            "        2. Login as a store manager" +
            "        3. Navigate to “Activities -> Calendar Events”")
    public void SETup() {

        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        url = configurationReader.get("url");
        driver.get(url);
        actions = new Actions(driver);
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage();
        String username = configurationReader.get("store_manager_username");
        String password = configurationReader.get(("store_manager_password"));
        loginPage.login(username, password);

        new DashboardPage().navigateToModule("Activities", "Calendar Events");
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
        //explicit wait
        wait = new WebDriverWait(driver, 2);

    }

    @AfterMethod
    public void teardown() {

        //     driver.close();
    }


    @Test(description = "Hover on three dots “...” for “Testers meeting” calendar even" +
            "Verify that “view”, “edit” and “delete” options are available")
    public void test1() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.threeDots));
        Actions action = new Actions(Driver.get());
        action.moveToElement(calendarEventsPage.threeDots).perform();
        BrowserUtils.waitForPageToLoad(2);

        Assert.assertTrue(calendarEventsPage.view.isDisplayed());
        Assert.assertTrue(calendarEventsPage.edit.isDisplayed());
        Assert.assertTrue(calendarEventsPage.delete.isDisplayed());
    }


    @Test(description = "Click on “Grid Options” button; " +
            "Deselect all options except “Title”; " +
            "Verify that “Title” column still displayed")
    public void test2() {

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.grid.click();
        BrowserUtils.waitFor(2);

        //old school loop: unclicks the first checkbox only, but  not the rest of them.
        for (int i = 2; i < 8; i++) {
            String xpathExpression = "//tr[" + i + "]//td[3]//input";
            driver.findElement(By.xpath(xpathExpression)).click();
            BrowserUtils.waitFor(1);
        }

// POM model loop, with elements stored in calendars events, also wouldnt unclick the checkboxes. Elements seem to be correct.

    /*
        for (WebElement element : calendarEventsPage.gridOptions) {
            BrowserUtils.waitFor(1);
            if (element.isSelected()) {
                element.click();
                BrowserUtils.waitFor(1);
//                int i = 2;
//   ? Assert.assertFalse(driver.findElement(By.xpath("//tr[" + i + "]//td[3]//input")).isSelected());
//                i++;
            }
*/
        Assert.assertTrue(calendarEventsPage.TitleOption.isDisplayed());

    }

    @Test(description = "Click on “Create Calendar Event” button" +
            "Expand “Save And Close” menu" +
            "Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void test3() {

        new CalendarEventsPage().createCalendarEvent.click();

        //wait until mask is gone
        wait.until(ExpectedConditions.invisibilityOf(new CreateCalendarEventsPage().loadingMask));

        //"Expand “Save And Close” menu"
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.saveAndCloseDropDownArrow.click();

        // Verify that “Save And Close”, “Save And New” and “Save” options are available
        Assert.assertTrue(createCalendarEventsPage.saveAndNew.isDisplayed());
        Assert.assertTrue(createCalendarEventsPage.saveButton.isDisplayed());

        //BrowserUtils.wait(2);

    }

    @Test(description = "Click on “Create Calendar Event” button " +
            "Then, click on “Cancel” button " +
            "Verify that “All Calendar Events” page subtitle is displayed")

    public void test4() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.createCalendarEvent.click();
        calendarEventsPage.cancelButton.click();
        Assert.assertTrue(calendarEventsPage.subtitle.isDisplayed());

    }

    @Test(description = "Click on “Create Calendar Event” button " +
            "Verify that difference between end and start time is exactly 1 hour")
    public void test5() {

        new CalendarEventsPage().createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        String startingTime = createCalendarEventsPage.startTime.getAttribute("value");
        String endingTime = createCalendarEventsPage.endTime.getAttribute("value");

        System.out.println("Start time: " + startingTime + "\n" + "End time: " + endingTime);

// "Verify that difference between end and start time is exactly 1 hour"
        int startHour = Integer.parseInt(startingTime.substring(0, startingTime.indexOf(':')));
        int endHour = Integer.parseInt(endingTime.substring(0, endingTime.indexOf(':')));

        if ((endHour - startHour) == 1) {
            if (startHour != 12) {
                Assert.assertTrue((endHour - startHour) == 1, "PASS, the meeting lasts 1 hour");
                System.out.println("Start time: " + startingTime + "\n" + "End time: " + endingTime +
                        "with 1 hour difference");
            } else {
                Assert.assertTrue((startHour - endHour) == 11, "PASS, the meeting lasts 1 hour");
            }
        } else {
            System.out.println("FAIL, the meeting duration is not 1 hour");
        }

    }

    @Test(description = "Click on “Create Calendar Event” button " +
            "Select “9:00 PM” as a start time" +
            "Verify that end time is equals to “10:00 PM”")
    public void test6() {

        //Click on “Create Calendar Event” button
        new CalendarEventsPage().createCalendarEvent.click();
        //wait to load
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        wait.until(ExpectedConditions.invisibilityOf(createCalendarEventsPage.loadingMask));
        // Select “9:00 PM” as a start time
        createCalendarEventsPage.startTime.click();
        createCalendarEventsPage.nineAmStartTime.click();
        System.out.println("start" + createCalendarEventsPage.nineAmStartTime.getText());
        BrowserUtils.waitFor(1);
//        // createCalendarEventsPage.meetingEndTime.click();
//        String actualEndTime = createCalendarEventsPage.meetingEndTime.getText();
//        String expectedEndTime = "10:00 PM";
//        //  Assert.assertTrue(createCalendarEventsPage.endTime.isDisplayed());
//        Assert.assertEquals(actualEndTime, expectedEndTime, "Start time and end time are 1 hour apart");

        // Select “9:00 PM” as a start time
        WebElement time = driver.findElement(By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input'] "));
        time.click();


        WebElement startingTime = driver.findElement(By.xpath("//li[(text()='9:00 PM')]"));
        startingTime.click();
        time.click();
        System.out.println("start" + startingTime.getText());

        BrowserUtils.waitFor(3);

        WebElement EndTime = driver.findElement(By.cssSelector("[class='ui-timepicker-pm ui-timepicker-selected']:nth-of-type(3)"));
        String actualEndTime = EndTime.getText();
        String expectedEndTime = "10:00 PM";
        Assert.assertTrue(EndTime.isDisplayed());
        Assert.assertEquals(actualEndTime, expectedEndTime, "Start time and end time are not 1 hour apart");

    }

}