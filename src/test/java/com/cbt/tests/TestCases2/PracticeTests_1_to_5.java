package com.cbt.tests.TestCases2;

import com.cbt.utilities.BrowserFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTests_1_to_5 {
    //creating new variable
    WebDriver driver;

    @BeforeMethod
    public void StartUp() throws InterruptedException {
        //open browser
        driver = BrowserFactory.getDriver("chrome");
        //got to website
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(1000);
        //Click on “Registration Form”
        driver.findElement(By.linkText("Registration Form")).click();
        Thread.sleep(1000);
    }
@AfterMethod
public void CloseUp() throws InterruptedException {
Thread.sleep(2000);
driver.quit();
}

@Test
public void TestCase1() throws InterruptedException {
//Verify that warning message is displayed: “The date of birth is not valid”

 String expectedResult ="The date of birth is not valid";
 driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
 Thread.sleep(3000);
   WebElement BD = driver.findElement(By.cssSelector("small.help-block"));
   Assert.assertTrue(BD.isDisplayed());

       }
@Test
public void TestCase2() {
//Verify that following options for programming languages are displayed: c++, java, JavaScript
    //iterating through element locators
    for (int i = 0; i < 3; i++) {
        String path = "inlineCheckbox" + (i + 1);
        Assert.assertTrue(driver.findElement(By.id(path)).isDisplayed());
    }
}

@Test
 public void TestCase3(){
//Enter only one alphabetic character into first name input box.
WebElement firstNameInput = driver.findElement(By.name("firstname"));
firstNameInput.sendKeys("O");
//Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
Assert.assertTrue(driver.findElement(By.cssSelector("small[data-bv-validator=\"stringLength\"][data-bv-for=\"firstname\"]")).isDisplayed());
    }

  @Test
public void test4(){
       //  Enter only one alphabetic character into last name input box.
  driver.findElement(By.name("lastname")).sendKeys("F");
      // Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
 Assert.assertTrue(driver.findElement(By.cssSelector("small[data-bv-validator=\"stringLength\"][data-bv-for=\"lastname\"]")).isDisplayed());
}
@Test
public void test5() throws InterruptedException {
/*Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is displayed: “You've successfully completed registration!”
 */

                     String expectedResultOne ="You've successfully completed registration!";
// Enter any valid first name.
    driver.findElement(By.name("firstname")).sendKeys("Olessya");
  //Enter last name
    driver.findElement(By.name("lastname")).sendKeys("Fxbrn");
//Enter user name
    driver.findElement(By.name("username")).sendKeys("OlessyaFxbrn");
// Enter email
    driver.findElement(By.name("email")).sendKeys("olessyafoxborn@gmail.net");
// Enter password
    driver.findElement(By.name("password")).sendKeys("555three555");
 // Enter any valid phone number
    driver.findElement(By.name("phone")).sendKeys("240-555-1111");
 //  Select gender.
    driver.findElement(By.xpath("//input[@value=\"female\"]")).click();
 // Enter birthdate
    driver.findElement(By.name("birthday")).sendKeys("01/02/2003");
// Select department
Select department = new Select(driver.findElement(By.name("department")));
department.selectByVisibleText("Department of Engineering");
 // Select job title
   Select jobTitle = new Select(driver.findElement(By.name("job_title")));
   jobTitle.selectByIndex(8);
   //Select java
    driver.findElement(By.id("inlineCheckbox2")).click();
    // Sign up button click
    driver.findElement(By.id("wooden_spoon")).click();
//verify message
    Assert.assertTrue(driver.findElement(By.xpath("//html//div//div//div//div//div//p")).isDisplayed());
    System.out.println(driver.findElement(By.xpath("//html//div//div//div//div//div//p")).getText());
}
}