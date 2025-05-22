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
        util.login();
        queuePage queuePage = new queuePage(driver);
        queuePage.clickOnAddCustomer();
        queuePage.selectProduct("IPad");
        queuePage.enterDetailsInCustomerAddDialog("test", "123");
        queuePage.sucessMessage();
        queuePage.validateCustomerDetails("Test 123", "IPad");
        queuePage.clickOnCustomer("Test 123");
        queuePage.validateCustomerDetailsPopUp("Test 123");
        queuePage.selectAdvisor("BLRStore_Server");
        
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
