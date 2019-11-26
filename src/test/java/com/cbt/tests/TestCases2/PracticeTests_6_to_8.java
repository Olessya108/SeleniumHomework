package com.cbt.tests.TestCases2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTests_6_to_8 {
    @Test
    public void test6(){
//open browser
        WebDriver  driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
//goto website
        driver.get("https://www.tempmailaddress.com/");
//save email
        String email =  driver.findElement(By.id("email")).getText();
//go to next website
        driver.get("https://practice-cybertekschool.herokuapp.com/");
//click on Sign Up For Mailing List
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
//enter name
        driver.findElement(By.xpath("//input[1]")).sendKeys("Mary Owens");
//enter email required
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
//click submit button
        driver.findElement(By.name("wooden_spoon")).click();
//verify message
       String actual = driver.findElement(By.className("subheader")).getText();
       String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(expected, actual);
//navigate back
        for (int i = 0; i < 3 ; i++) {
            driver.navigate().back();
        }
        driver.navigate().refresh();


//Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com"
  String ExpectedEmail = "do-not-reply@practice.cybertekschool.com";
  String actEmailXpath = "//tbody/tr/td[@class='from']";
  String ActualEmail = driver.findElement(By.xpath((actEmailXpath))).getText().trim();
  Assert.assertEquals(ExpectedEmail, ActualEmail);
 //Click on that email to open it
 driver.findElement(By.xpath((actEmailXpath))).click();
//Verify email is from “do-not-reply@practice.cybertekschool.com
  String actualEmail2 = driver.findElement(By.id("odesilatel")).getText();
Assert.assertEquals(ExpectedEmail, actualEmail2);
//Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
  String subject = "Thanks for subscribing to practice.cybertekschool.com!";
 String actualSubject = driver.findElement(By.id("predmet")).getText();
 Assert.assertEquals(actualSubject, subject);
 //       driver.quit();
    }
    @Test
    public void test7() throws InterruptedException {
//open browser
        WebDriver  driver = BrowserFactory.getDriver("chrome");
//goto website
        driver.get("https://practice-cybertekschool.herokuapp.com/");
//click file upload link
        driver.findElement(By.linkText("File Upload")).click();
        Thread.sleep(2000);
 //click on upload button and send a path to file
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\oless\\Desktop\\file.txt");
//click on submit button
        driver.findElement(By.id("file-submit")).click();

        String actual = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actual, "file.txt");

    }
    @Test
    public void test8(){
        //open browser
        WebDriver  driver = BrowserFactory.getDriver("chrome");
//go to website
        driver.get("https://practice-cybertekschool.herokuapp.com/");
//click on Sign Up For Mailing List
        driver.findElement(By.linkText("Autocomplete")).click();
//enter United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys(" United States of America");
//submit
        driver.findElement(By.xpath("//input[@type='button']")).click();
//verify text
      String expectedResult =   "You selected: United States of America";
      String actualResult =  driver.findElement(By.id("result")).getText();
      Assert.assertEquals(expectedResult, actualResult);
 //close browser
 driver.quit();
    }





}
