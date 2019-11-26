package com.cbt.tests.LocatorsHomework2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
1. Open browser
2. Go to https://ebay.com
3. Search for wooden spoon
4. Save the total number of results
5. Click on link All
6. Verify that number of results is bigger than the number in step 4
7. Navigate back to previous research results page
8. Verify that wooden spoon is displayed in the search box
9. Navigate back to home page
10. Verify that search box is blank
 */
public class EtsySearchTest {

    public static void main(String[] args) {
       //opening web browser
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        //got to etsy
        driver.get("https://www.etsy.com");
        //finding input search bar
        WebElement searchBar = driver.findElement(By.id("global-enhancements-search-query"));
        //activate input
        searchBar.click();
        //paste search item
        searchBar.sendKeys("wooden spoon");
        //finding searchbutton
        WebElement searchbutton = driver.findElement(By.cssSelector("span.etsy-icon.wt-nudge-b-1"));
        //activate
        searchbutton.click();
//finding the number of results
        WebElement result = driver.findElement(By.cssSelector("span.wt-text-caption.wt-text-link-no-underline"));
        //print results
        System.out.println(result.getText());
//quit
        driver.quit();

    }
}
