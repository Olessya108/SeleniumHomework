package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage extends BasePage {

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;
    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;
    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;
    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;
    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;
    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;
    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;
    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;
    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;
    @FindBy(css = "a[class='btn-success btn dropdown-toggle']")
    public WebElement saveAndCloseDropDownArrow;
    @FindBy(css = "//li//button[normalize-space()='Save and Close']")
    public WebElement saveAndCloseButton;
    @FindBy(xpath = "//li//button[normalize-space()='Save and New']")
    public WebElement saveAndNew;
    @FindBy(xpath = "//li//button[normalize-space()='Save']")
    public WebElement saveButton;
    @FindBy(css = "div[class='loading-bar']")
    public WebElement loadingMask;
    @FindBy(xpath = "//li[(text()='9:00 AM')]")
    public WebElement nineAmStartTime;
    @FindBy(xpath = "time_selector_oro_calendar_event_form_end-uid-5e00010ecc3f1")
    public WebElement meetingEndTime;


    public CreateCalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public Select repeatOptionsList() {
        //select class in html
        return new Select(repeatOptions);
    }

}