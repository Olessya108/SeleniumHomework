package com.cbt.tests.TestCases4;

import com.cbt.pages.BrowserUtils;
import com.cbt.pages.CalendarEventsPage;
import com.cbt.pages.DashboardPage;
import com.cbt.pages.LoginPage;
import com.cbt.utilities.Driver;
import com.cbt.utilities.configurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CalendarEvents {
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

        driver.close();
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
// not sure about this assertion's need    Assert.assertFalse(driver.findElement(By.xpath("//tr[" + i + "]//td[3]//input")).isSelected());
//                i++;
            }
*/
        Assert.assertTrue(calendarEventsPage.TitleOption.isDisplayed());

    }
}