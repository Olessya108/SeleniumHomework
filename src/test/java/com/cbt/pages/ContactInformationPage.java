package com.cbt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformationPage extends BasePage {  //this page is a template for all the contacts, we are finding the field
    // not the value. souldnt find by text

    @FindBy(css = "h1.user-name")
    public WebElement contactFullName;

    @FindBy(css = "a.phone")
    public WebElement contactPhone;

    @FindBy(css = "a.email")
    public WebElement contactEmail;


}
