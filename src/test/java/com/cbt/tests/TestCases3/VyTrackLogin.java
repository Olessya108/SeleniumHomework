package com.cbt.tests.TestCases3;

import com.cbt.utilities.BrowserFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VyTrackLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void login() {
        //  OPEN BROWSER
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        // LOGIN
        driver.get("https://qa2.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager66");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        // CHANGE MENU
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        waitForLoader();
        //wait
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));

        activitiesElement.click();
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        waitForLoader();

    }

    void waitForLoader() {
        if (driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size() > 0) {
            WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }
    }

    @Test
    public void test1() {
// Verify that page subtitle "Options" is displayed
        WebElement options = driver.findElement(By.xpath("//div[2]/div/div/div[1]/div/div/div/div[2]/div"));
        Assert.assertEquals("Options", options.getText());
    }

    @Test
    public void test2() {
        //Verify that page number is equals to "1"
  String pageNum = driver.findElement(By.xpath("//input[@value='1']")).getAttribute("value");
  System.out.println(pageNum);
  Assert.assertEquals("1", pageNum);
   //Assert.assertTrue( driver.findElement(By.cssSelector("input[type='number'][value='1']")).isDisplayed());
    }

    @Test
    public void test3() {
        //Verify that view per page number is equals to "25"
        WebElement number25 = driver.findElement(By.cssSelector("button[data-toggle='dropdown'][class='btn dropdown-toggle ']"));
        System.out.println(number25.getText());
        Assert.assertEquals("25", number25.getText());
    }
@Test
    public void test4(){
  //Verify that number of calendar events (rows in the table) is equals to number of records
    List <WebElement> tableSize = driver.findElements(By.xpath("//table//tbody/tr")); // number f rows excluding header
    int num = tableSize.size(); //number of rows
    System.out.println(num);
    String numString =  String.valueOf(num); //converting to string for assertion
    String numOfRecords = driver.findElement(By.xpath("//label[3]")).getText() ;  //Total Of 2 Records
    System.out.println(numOfRecords);
    Assert.assertTrue(numOfRecords.contains(numString));
    }
@Test
    public void test5(){
   //Click on the top checkbox to select all
    // Verify that all calendar events were selected
   driver.findElement(By.xpath("//button//input[@type='checkbox']")).click(); // click on checkcbox in top row

    //finding total number of columns excluding header
    List <WebElement> columns = driver.findElements(By.xpath("//tbody//td[@data-column-label=\"Selected Rows\"]"));
    System.out.println("number of columns: = " + columns.size());

    //setting webelements for each checkbox
  WebElement one =  driver.findElement(By.xpath("//tr[1]/td[1]/input"));
  WebElement two = driver.findElement(By.xpath("//tr[2]/td[1]/input"));

  Assert.assertTrue(one.isSelected());
  Assert.assertTrue(two.isSelected());

    }

    public void test6(){
//Select “Testers meeting”
// Verify that following data is displayed:


    }
 @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}