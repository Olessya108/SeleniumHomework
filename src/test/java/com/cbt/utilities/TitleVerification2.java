package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/",
                "https://walmart.com/" ,"https://westelm.com/");

        WebDriver myDriver = BrowserFactory.getDriver("chrome");


        for (int i = 0; i < urls.size(); i++) {
            myDriver.get(urls.get(i));
            String A = myDriver.getCurrentUrl().toLowerCase().replaceAll(" ", "");
            String B = myDriver.getTitle().toLowerCase().replaceAll(" ", "");
            boolean C = A.contains(B);
            System.out.println(urls.get(i)+" "+A+" "+B+" "+C);
        }
        myDriver.quit();




    }
}
