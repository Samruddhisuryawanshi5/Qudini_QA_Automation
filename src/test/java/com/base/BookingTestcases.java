package com.base;

import com.base.pageObject.bookingPage;
import com.base.pageObject.queuePage;
import com.base.util.util;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTestcases extends TestBase {
    util util;

    @BeforeClass
    public void beforeClass() {
        driver = openBrowser("chrome");
        util = new util(driver);
        extent.createTest("Add_customer_to_queue");
    }

    @Test
    public void create_Appointment() throws InterruptedException {
    bookingPage booking=new bookingPage(driver);
    queuePage queuePage=new queuePage(driver);

    util.login();
    util.ClosePopUpAtSTart();
    booking.clickOnBookingButton();
    queuePage.selectProduct("IPhone 16");
    booking.clickOnNextButton();
    booking.selectDate("29");
    booking.selectShift();
    booking.selectBookingSlot();
    booking.setSlotTimeNextButton();
    booking.enterBookingDetailsInCustomerAddDialog("java","test","1234567890","test@gmail.com");
    booking.createAppointmentButton();

    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }

}
