package com.cbt.tests.LocatorsHomework2;

import com.cbt.utilities.BrowserFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultsTitle {

@Test
public void testCase1() throws InterruptedException {


        //open browser
       WebDriver driver = BrowserFactory.getDriver("Chrome");
       //go to https://google.com
       driver.get("https://google.com");
       //find input field
       WebElement input = driver.findElement(By.cssSelector("input[type='text']"));


String expected;
String actual;

        List <String> searchStrs = Arrays.asList("JUnit", "java", "selenium" );
//iterating through an array
        for (String each : searchStrs) {
               input.click();               //click searcbar input field
              Thread.sleep(1000);
               input.sendKeys(each+ Keys.ENTER);     // input data and click Enter
                Thread.sleep(1000);             //wait for the results

 if (each.equalsIgnoreCase("JUnit")) {
         driver.findElement(By.className("TbwUpd")).click();
        expected = "https://junit.org/junit5/";
         actual = driver.getCurrentUrl();
         Assert.assertEquals(expected, actual);
         driver.navigate().back();
         input = driver.findElement(By.cssSelector("input[type='text']"));
      //   input.click();
         input.clear();
         Thread.sleep(3000);
 }
 else if (each.equalsIgnoreCase("Java")){
         Thread.sleep(1000);
         driver.findElement(By.className("iUh30")).click();
         expected = "https://www.java.com/en/"; //https://www.java.com/en/  -- actual
         actual = driver.getCurrentUrl();
         Assert.assertEquals(expected, actual);
         driver.navigate().back();
     driver.navigate().back();
         input = driver.findElement(By.cssSelector("input[type='text']")); //input searchbar
         input.clear();
         Thread.sleep(3000);

 }
 else if (each.equalsIgnoreCase("selenium")){
     Thread.sleep(1000);
     driver.findElement(By.className("TbwUpd")).click();
     expected = "https://selenium.dev/";
     actual = driver.getCurrentUrl();
     Assert.assertEquals(expected, actual);
     driver.navigate().back();
     driver.navigate().back();
     input = driver.findElement(By.cssSelector("input[type='text']")); //input searchbar
     input.clear();
     Thread.sleep(3000);

 }
        }

        driver.quit();

    }
}
