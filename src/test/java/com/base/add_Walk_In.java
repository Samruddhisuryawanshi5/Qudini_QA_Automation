package com.base;

import com.base.pageObject.queuePage;
import com.base.util.util;
import org.testng.Assert;
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
        extent.createTest("Add_customer_to_queue");
    }

    @Test
    public void Add_Customer_To_Queue() {
        double randomNumber = Math.random();
        String customerName = "Test "+String.valueOf(randomNumber);
        
        util.login();
        //Login to Qudini
        queuePage queuePage = new queuePage(driver);
        util.ClosePopUpAtSTart();
        queuePage.clickOnAddCustomer();

        //I Click on Add To Customer
        queuePage.selectProduct("IPad");
        //I Select Product
        queuePage.enterDetailsInCustomerAddDialog(customerName,"");
        queuePage.clickOnaddCustomerButton();

        queuePage.sucessMessage();
        //Success message should be displayed
        String product = queuePage.validateCustomerDetails(customerName, "IPad");
        Assert.assertEquals(product, "IPad");
        queuePage.clickOnCustomer(customerName);
        queuePage.validateCustomerDetailsPopUp(customerName);
        //Customer details should be displayed
        queuePage.selectAdvisor("BLRStore_Server");
        queuePage.quickCompleteButton();
        queuePage.selectCompleteVisitOptions("Complete Customer");
        queuePage.validateCustomerNotification("Customer has been added to the Queue");

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }




}
