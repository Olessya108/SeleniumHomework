package com.cbt.tests.LocatorsHomework1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
Test case 3
Go to wikipedia.org (Links to an external site.)
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)`
 */
public class LocatorsTestCase3 {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        // driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org");

       WebElement searchBar =  driver.findElement(By.id("searchInput"));
       searchBar.click();
       searchBar.sendKeys("selenium webdriver");

       WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
       searchButton.click();

       WebElement result = driver.findElement(By.xpath("//*[@id='mw-content-text']/div[3]/ul/li[1]/div[1]/a"));
       result.click();

       String verifyWord = "Selenium_(software)";
       String url = driver.getCurrentUrl();

       boolean verify = url.contains(verifyWord);
        System.out.println(verify);


       driver.quit();
    }

}
