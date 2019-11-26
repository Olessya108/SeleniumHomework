package com.cbt.tests.LocatorsHomework1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

/*
Test case 2
go to amazon
Go to ebay
enter search term
click on search button
verify title contains search term
 */
public class LocatorsTestCase2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("Chrome");
        // driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
        driver.get("https://www.ebay.com/");


        WebElement searchBar = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBar.click();
        String productName = "Ferrari";
        searchBar.sendKeys(productName);

        WebElement searchbutton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchbutton.click();//click on search button

        String title = driver.getTitle();    //save title

       boolean verify = title.contains(productName);
        System.out.println(verify);


        driver.quit();

    }
}
