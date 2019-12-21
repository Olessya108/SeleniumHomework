package com.cbt.pages;
//instead of creating constructor, ill extend BasePage
////*[contains(text(), "demo.O@maildemo.com")][@data-column-label='Email']

import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage {

//    // this only finds one email, it does nnot help in finding others. we cannot use this
//    @FindBy(xpath = "//*[contains(text(), ‘mbrackstone9@example.com') and @data-column-label='Email']")
//    WebElement email;


    public WebElement getContactEmail(String email) {
        String xpath = "//*[contains(text(), '" + email + "') and @data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }
    // GO TO BREAK OK


}