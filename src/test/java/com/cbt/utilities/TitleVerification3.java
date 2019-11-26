package com.cbt.utilities;
import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/",
                "https://walmart.com/", "https://westelm.com/");

        WebDriver[] myDriver = {BrowserFactory.getDriver("chrome"), BrowserFactory.getDriver("Firefox"),
                BrowserFactory.getDriver("Edge")};

      //  BrowserFactory.getDriver("Safari")


        for (int j = 0; j < myDriver.length; j++ ) {    //take each browser one by one
            WebDriver currentDriver = null;
            currentDriver=myDriver[j];

            for (int i = 0; i < urls.size();   i++) {
                currentDriver.get(urls.get(i));
                String A = currentDriver.getCurrentUrl().toLowerCase().replaceAll(" ", "");
                String B = currentDriver.getTitle().toLowerCase().replaceAll(" ", "");
                boolean C = A.contains(B);
                System.out.println(myDriver[j]);
                System.out.println(urls.get(i) + " " + A + " " + B + " " + C);
            }
            currentDriver.quit();
        }

    }
}
