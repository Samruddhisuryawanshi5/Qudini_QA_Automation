package com.base.pageObject;

import com.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class bookingPage extends TestBase {
    WebDriver driver;

    public bookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "button[id='add-booking-customer']")
    WebElement cutomerAppointmentButton;
    @FindBy(xpath = "//div[@id='wz-product']//button[@wz-next]")
    WebElement productPageNextButton;
    @FindBy(xpath ="//div[@id=\"wz-add-on\"]//span[text()='Next']" )
    WebElement clickOnNextButton;
    @FindBy(xpath = "//span[contains(text(),'6:10 PM - 6:40 PM')]")
    WebElement selectTime;
    @FindBy(xpath = "//div[@ng-include=\"'date-selection.html'\"]//span[text()='Next']")
    WebElement slotTimeNextButton;
    @FindBy(xpath = "( //h4[@class=\"panel-title\"])[3]")
    WebElement selectShift;
    @FindBy(css = "section[wz-title='Time'] button[wz-next]")
    WebElement clickOnNextButtonFromTimePage;
    @FindBy(id="input-last-name")
    WebElement bookingLastName;
    @FindBy(id="input-first-name")
    WebElement bookingFirstName;
    @FindBy(xpath = "//input[@type=\"tel\"]")
    WebElement bookingPageCustomerPhoneNo;
    @FindBy(id = "input-email")
    WebElement bookingPageEmailId;
    @FindBy(xpath = "//button[@ng-click=\"onDetailsComplete()\"]")
    WebElement clickNextButtonFromBookingPage;
    @FindBy(xpath = "//div[@id=\"wz-confirmation\"]//button[contains(text(),'Create Appointment')]")
    WebElement ClickOnBookAppintmentButton;


    public void clickOnBookingButton(){
        cutomerAppointmentButton.click();
    }

    public void clickOnNextButton() throws InterruptedException {

        Thread.sleep(1000);
        productPageNextButton.click();
       waitUntilElementIsVisible(By.xpath("//div[@id=\"wz-add-on\"]//span[text()='Next']"));
       clickOnNextButton.click();

    }
    public void selectDate(String number){
        driver.findElement(By.xpath("//span[@class=\"day-text ng-binding available-day\" and contains(text(),'"+ number+"')]")).click();
    }

    public void selectShift() throws InterruptedException {
        Thread.sleep(2000);
        selectShift.click();
    }

    public void selectBookingSlot() throws InterruptedException {
        Thread.sleep(1000);
        waitUntilElementIsVisible(By.xpath("//span[contains(text(),'6:10 PM - 6:40 PM')]"));
        selectTime.click();
    }

    public void setSlotTimeNextButton(){
        slotTimeNextButton.click();
    }

    public void enterBookingDetailsInCustomerAddDialog(String fName, String lName,String phoneNumber,String email) {
        if (fName != null) {
            bookingFirstName.sendKeys(fName);
        }
        if (lName != null) {
            bookingLastName.sendKeys(lName);
        }
        if(phoneNumber!=null){
            bookingPageCustomerPhoneNo.sendKeys(phoneNumber);
        }
        if(email!=null){
            bookingPageEmailId.sendKeys(email);
        }

        clickNextButtonFromBookingPage.click();

    }
    public void createAppointmentButton(){
        ClickOnBookAppintmentButton.click();
        waitUntilElementIsVisible(By.xpath("//div[@ng-bind-html=\"message\"]"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@ng-bind-html=\"message\"]")).getText(),"Booking created!");
    }


}
