package com.cbt.tests.LocatorsHomework2;

import com.cbt.utilities.BrowserFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
1. Open browser
2. Go to Vytrack login page
3. Login as a sales manager
4. Verify Dashboard page is open
5. Click on Shortcuts icon
6. Click on link See full list
7. Click on link Opportunities
8. Verify Open opportunities page is open
9. Click on Shortcuts icon
10. Click on link See full list
11. Click on link Vehicle Service Logs
12. Verify error message text is You do not have permission to perform this action.
13. Verify Shortcut Actions List page is still open
 */
public class VytrackShortcutFunctionality {
    public static void main(String[] args) throws InterruptedException {
 //open browser
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();

//go to website
        String initialUrl = driver.getCurrentUrl();
//input username
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager123");
//input password
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
//click submit button
        driver.findElement(By.id("_submit")).click();
//verify you are in dashboard page
        String dashboard = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals("Dashboard", dashboard);
//Click on Shortcuts icon
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[1]/div/div[2]/div/a")).click();
 //Click on link See full lis
        driver.findElement(By.linkText("See full list")).click();
// Click on link Opportunities
        Thread.sleep(5000);
         driver.findElement(By.xpath("//table/tbody/tr[21]/td[1]/a")).click();
         Thread.sleep(3000);
//  Verify Open opportunities page is open
        String OpOpPage = driver.findElement(By.xpath("//h1[@class=\"oro-subtitle\"]")).getText();
        Assert.assertEquals("Open Opportunities", OpOpPage);
//  Click on Shortcuts icon
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[1]/div/div[2]/div/a")).click();
//  Click on link See full list
        driver.findElement(By.linkText("See full list")).click();
//  Click on link Vehicle Service Logs
        Thread.sleep(3000);
        driver.findElement(By.linkText("Vehicle Services Logs")).click();
// Verify error message text is You do not have permission to perform this action.
        Thread.sleep(3000);
        String expError = "You do not have permission to perform this action.";
        String actError = driver.findElement(By.xpath("//div[@class=\"message\"]")).getText();
        Assert.assertEquals(expError, actError);
//Verify Shortcut Actions List page is still open
        String actualPaage = driver.findElement(By.xpath("//div/div/h3")).getText();
        Assert.assertEquals("Shortcut Actions List", actualPaage);

        //close
        driver.quit();
    }
}
