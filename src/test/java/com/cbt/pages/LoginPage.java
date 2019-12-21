package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {
    //Page object model VS Page Factory
    //POM - page object model - design pattern in Selenium, organization of pacjages and classes
    // Page factory = is class in selenium using which we create POModel

    // when we create page object class - we create public constructor. in its body we call the InitElements static method form factory

//initialize constructor
    /*  below or other version
             Webdriver driver;
        public LoginPage(){
           PageFactory.initElements(driver, LoginPage.class);
         */

    @FindBy(id = "prependedInput") // -->> annotation from selenium used to provide locators
    public WebElement userName;
    //findBy (type of locator = value of locator)

    //    @FindBys(
//            @FindBy(id = "prependedInput"),
//            @FindBy (id = "prependedInput2",
//             @FindBy (name = "_submit"));
    @FindBy(id = "prependedInput2")
    public WebElement password;
    @FindBy(name = "_submit")
    public WebElement submit;

    public LoginPage() {  //without parameter
        PageFactory.initElements(Driver.get(), this);   //is very important5 -- Driver is the singleton

//takes two parameters : Driver object  ,   instance of class = 'this'
//Driver.get() same as Webdriver driver = new Driver.get();
    }

    @Test
    public void login(String usernameString, String passwordString) {
        userName.sendKeys(usernameString);
        password.sendKeys(passwordString);
        submit.click();
    }


}
