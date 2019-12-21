package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//tbody/tr[4]/td[9]/div/div/a")
    public WebElement threeDots;

    @FindBy(css = ".fa-cog.hide-text")
    public WebElement grid;

    @FindBy(xpath = "//a[@href='/calendar/event/view/184']")
    public WebElement view;

    @FindBy(xpath = "//a[@href='/calendar/event/view/184']")
    public WebElement edit;

    @FindBy(xpath = "//body/ul/li/ul/li[3]/a/i")
    public WebElement delete;

    @FindBys({
            @FindBy(xpath = "//tr[2]//td[3]//input"),
            @FindBy(id = "//tr[3]//td[3]//input"),
            @FindBy(id = "//tr[4]//td[3]//input"),
            @FindBy(id = "//tr[5]//td[3]//input"),
            @FindBy(id = "//tr[6]//td[3]//input"),
            @FindBy(id = "//tr[7]//td[3]//input")
    })
    public List<WebElement> gridOptions;

    @FindBy(css = ".grid-header-cell__label")
    public WebElement TitleOption;


    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

}