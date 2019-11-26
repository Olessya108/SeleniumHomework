package com.cbt.tests.LocatorsHomework1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
Test case 1
Go to ebay
enter search term
click on search button
print number of results
 */
public class LocatorsTestCase1 {


    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("Chrome");
       // driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBar.click();
        searchBar.sendKeys("Ferrari");

        WebElement searchbutton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchbutton.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[1]"));
        System.out.println(result.getText());

        driver.quit();

    }
}
