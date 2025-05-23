package com.base;

import com.base.pageObject.queuePage;
import com.base.util.util;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class add_Walk_In extends TestBase {
    util util;

    @BeforeClass
    public void beforeClass() {
        driver = openBrowser("chrome");
        util = new util(driver);
    }

    @Test
    public void Add_Customer_To_Queue() {
        double randomNumber = Math.random();
        String customerName = "Test "+String.valueOf(randomNumber);
        
        util.login();
        queuePage queuePage = new queuePage(driver);
        queuePage.clickOnAddCustomer();
        queuePage.selectProduct("IPad");
        queuePage.enterDetailsInCustomerAddDialog(customerName,"");
        queuePage.sucessMessage();
        queuePage.validateCustomerDetails(customerName, "IPad");
        queuePage.clickOnCustomer(customerName);
        queuePage.validateCustomerDetailsPopUp(customerName);
        queuePage.selectAdvisor("BLRStore_Server");
        queuePage.quickCompleteButton();
        queuePage.selectCompleteVisitOptions("Complete Customer");
        queuePage.validateCustomerNotification("Customer has been added to the Queue");

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
