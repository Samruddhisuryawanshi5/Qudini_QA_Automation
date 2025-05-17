package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
    public static WebDriver driver = null;

    public WebDriver openBrowser(String name) {
        if (name.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (name.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Browser name does not exist");
        }
        driver.manage().window().maximize();
        return driver;

    }
}
