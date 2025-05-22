package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver = null;

    public WebDriver openBrowser(String name) {
        boolean isHeadless=true;
        if (name.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            if(isHeadless){
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        } else if (name.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Browser name does not exist");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public void waitUntilElementIsVisible(By loctor){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loctor));
    }

    public boolean isPresent(By locator){
        if(driver.findElements(locator).size()>0){
            return true;
        }
        return false;
    }
}
