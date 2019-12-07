package com.cbt.tests.assignment1VyTrack;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack_NegativeTestCase {
    public static void main(String[] args) {
        //open browser
        WebDriver driver = BrowserFactory.getDriver("chrome");
// go to login page https://qa2.vytrack.com/user/login
        driver.get("https://qa2.vytrack.com/user/login");

//enter username
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("storemanager66"); //send keys

//enter password other than "UserUser123"
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser"); //send keys

        WebElement loginButton = driver.findElement(By.id("_submit"));   // click to log in
        loginButton.click();

//        String expectedUrl = "https://qa2.vytrack.com/";
//        String actual = driver.getCurrentUrl();

        WebElement errMess = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div"));
String actual = errMess.getText();
String expected = "Invalid user name or password.";

        if (expected.equals(actual)){
            System.out.println("PASS");
        } else{
            System.out.println("FAIL");
        }
        //  close the browser
        driver.quit();
    }
}
