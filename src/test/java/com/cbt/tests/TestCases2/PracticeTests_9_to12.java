package com.cbt.tests.TestCases2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTests_9_to12 {

        WebDriver driver;

        @BeforeMethod
   void StartUp() throws InterruptedException {
            this.driver = BrowserFactory.getDriver("chrome");
            this.driver.get("https://practice-cybertekschool.herokuapp.com/");
            Thread.sleep(1000L);
            this.driver.findElement(By.linkText("Status Codes")).click();
            Thread.sleep(1000L);
        }

        @AfterMethod
        public void CloseUp() throws InterruptedException {
            Thread.sleep(2000L);
            this.driver.quit();
        }

        @Test
        public void test9() {
            this.driver.findElement(By.linkText("200")).click();
            String exp = "This page returned a 200 status code.";
            String act = this.driver.findElement(By.xpath("//p")).getText();
            Assert.assertTrue(exp.contains(act));
        }

        @Test
        public void test_10_through_12() throws InterruptedException {
            String[] inputs = new String[]{"301", "404", "500"};

            for(int i = 0; i < 3; ++i) {
                this.driver.findElement(By.linkText(inputs[i])).click();
                String exp = "This page returned a " + inputs[i] + " status code.";
                String act = this.driver.findElement(By.xpath("//p[1]")).getText();
                Assert.assertTrue(act.contains(exp));
                this.driver.navigate().back();
                Thread.sleep(1000L);
            }

            this.driver.quit();
        }
    }


