package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {


        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("Chrome");

        driver.get(urls.get(0));     //fo to url
        String zero = driver.getTitle();    //save title
        String zeroUrl = driver.getCurrentUrl();

        driver.get(urls.get(1));
        String oneUrl = driver.getCurrentUrl();
        String one = driver.getTitle();

        driver.get(urls.get(2));
        String two = driver.getTitle();
        String twoUrl = driver.getCurrentUrl();

        boolean sameTitle = (zero.equals(one) && zero.equals(two)); //verify the same titles
        System.out.println(sameTitle+" title is the same");

String beginURL = "http://practice.cybertekschool.com";
boolean z = zeroUrl.startsWith(beginURL);
boolean o = oneUrl.startsWith(beginURL);
boolean t = twoUrl.startsWith(beginURL);
        System.out.println(z +" "+o+" "+t + "Urls start with the same string");

        driver.quit();
    }
}
