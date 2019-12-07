package com.cbt.tests.assignment1VyTrack;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack {
    public static void main(String[] args) {
        //open browser
WebDriver driver = BrowserFactory.getDriver("chrome");
// go to login page https://qa2.vytrack.com/user/login
driver.get("https://qa2.vytrack.com/user/login");


        WebElement username = driver.findElement(By.name("_username")); //enter username
        username.sendKeys("storemanager66"); //send keys

        WebElement password = driver.findElement(By.name("_password"));//enter password
        password.sendKeys("UserUser123"); //send keys

        WebElement loginButton = driver.findElement(By.id("_submit"));   // click to log in
        loginButton.click();

        String expectedUrl = "https://qa2.vytrack.com/";
        String actual = driver.getCurrentUrl();

        if (expectedUrl.equals(actual)){
            System.out.println("PASS");
        } else{
            System.out.println("FAIL");
        }
      //  close the browser
          driver.quit();
    }


}
