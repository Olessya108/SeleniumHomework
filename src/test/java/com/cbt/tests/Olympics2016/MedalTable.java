package com.cbt.tests.Olympics2016;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MedalTable {

    WebDriver driver;
    List<Integer> rankList = new ArrayList<>();

    @Test
    public void test1() {
        //open browser
        driver = BrowserFactory.getDriver("chrome");
        //go to website
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        WebElement rows;
        //iterate through rows to get numbers only
        for (int i = 1; i < 12; i++) {
            rows = driver.findElement(By.xpath("//table[9]/tbody/tr[" + i + "]"));
            int num = Integer.parseInt(rows.getText().substring(0, 2).trim());
            rankList.add(num);
        }
        System.out.println(rankList);
        boolean sorted = true;
        for (int i = 1; i < rankList.size(); i++) {
            if (rankList.get(i - 1).compareTo(rankList.get(i)) > 0) {
                sorted = false;
            }
        }
        System.out.println(sorted);
        Assert.assertTrue(sorted);
//click on NOc
        driver.findElement(By.linkText("NOC")).click();


    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}