package com.cbt.tests.LocatorsHomework1;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;


public class NavigationTests {
    public static void main(String[] args) {

        WebDriver Chr = BrowserFactory.getDriver("Chrome");
        Navigation(Chr);
        WebDriver FFox= BrowserFactory.getDriver("Firefox");
        Navigation(FFox);
       WebDriver Edge = BrowserFactory.getDriver("edge");
       Navigation(Edge);
        }

public static void Navigation(WebDriver driver){

    driver.get("https://google.com");                                     //2.Go to website https://google.com
    String GoogPage = driver.getCurrentUrl();                                //3.Save the title in a string variable
    driver.get("https://etsy.com");                                     //4.Go to https://etsy.com
    String EtsPage = driver.getCurrentUrl();                          //5.Save the title in a string variable
    driver.navigate().back();                    //6.Navigate back to previous page
    String backNav = driver.getCurrentUrl();    //7.Verify that title is same in step 3
    StringUtility.verifyEquals(GoogPage, backNav);
    driver.navigate().forward();                // 8.Navigate forward to previous page
    String ForwNav = driver.getCurrentUrl();       //9.Verify that title is same is in step 5
    StringUtility.verifyEquals(EtsPage, ForwNav);
    driver.quit();
    }

}
