package com.cbt.tests.LocatorsHomework2;

import com.cbt.utilities.BrowserFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
1. Open browser
2. Go to Vytrack login page
3. Login as any user
4. Click on your name on top right
5. Click on My Configuration
6. Verify that title start with the same name on top right
 */
public class VytrackTitleTest {
    public static void main(String[] args) throws InterruptedException {
        //open browser
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        //go to website
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        //log in
        driver.findElement(By.id("prependedInput")).sendKeys("user23");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        //Click on your name on top right
        driver.findElement(By.linkText("Marge Wehner")).click();
        //Click on My Configuration
        driver.findElement(By.linkText("My Configuration")).click();
        Thread.sleep(1000);
       //  Verify that title start with the same name on top right
String titleName = driver.findElement(By.className("user-name")).getText();
Assert.assertEquals("Configuration", titleName);

        driver.quit();
    }

}
