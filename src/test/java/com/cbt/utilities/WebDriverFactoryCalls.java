package com.cbt.utilities;


import org.openqa.selenium.WebDriver;

public class WebDriverFactoryCalls {
    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        WebDriver driver2 = BrowserFactory.getDriver("firefox");

    }

}
