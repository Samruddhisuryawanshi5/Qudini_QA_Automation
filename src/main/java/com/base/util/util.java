package com.base.util;

import com.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class util extends TestBase {
    WebDriver driver;

    public util(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void login() {
        driver.get(getProperty("baseUrl"));
        driver.findElement(By.id("username")).sendKeys("BlrStore_con");
        driver.findElement(By.id("password")).sendKeys("Akshay@12");
        driver.findElement(By.xpath("//button[@data-testid='login-sign-in-credentials-button']")).click();
        waitUntilElementIsVisible(By.xpath("//div[@data-testid='react-navigation-bar-link-queues']"));
    }

    @FindBy(xpath = "//button[text()='CLOSE']")
    WebElement closePopUp;

    public void ClosePopUpAtSTart() {
        if (isPresent(By.xpath("//button[text()='CLOSE']"))) {
            closePopUp.click();
        }
    }


}
