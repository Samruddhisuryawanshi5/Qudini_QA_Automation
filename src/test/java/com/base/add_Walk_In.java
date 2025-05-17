package com.base;

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
    public void login() {
        util.login();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
