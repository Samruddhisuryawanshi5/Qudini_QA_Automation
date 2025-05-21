package com.base.pageObject;

import com.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class queuePage extends TestBase {
    WebDriver driver;

    public queuePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='CLOSE']")
    WebElement closePopUp;

    @FindBy(id = "add-customer")
    WebElement addCustomer;

    @FindBy(xpath = "//h6[text()='IPad']")
    WebElement selectProduct;

    @FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-surname")
    WebElement surname;

    @FindBy(id = "input-email")
    WebElement emailId;

    @FindBy(xpath = "//div[@id='wz-details']//button//span[text()='Add Customer']")
    WebElement addCustomerDialogueButton;

    @FindBy(xpath = "//h5[text()=\"Successful\"]")
    WebElement successMessage;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement closeButton;


    public void clickOnAddCustomer() {
             if(isPresent(By.xpath("//button[text()='CLOSE']"))){
                 closePopUp.click();
             }

        addCustomer.click();
    }

    public void selectProduct(String productName) {
        driver.findElement(By.xpath("//h6[text()='" + productName + "']")).click();
    }

    public void enterDetailsInCustomerAddDialog(String fName, String lName) {
        if (firstName != null) {
            firstName.sendKeys(fName);
        }
        if (lName != null) {
            surname.sendKeys(lName);
        }
        addCustomerDialogueButton.click();
    }
    public void sucessMessage(){
        Assert.assertTrue(successMessage.isDisplayed());
        closeButton.click();
    }
    public void validateCustomerDetails(String fullName, String productName){
        String product=driver.findElement(By.xpath("//li[@data-testid='"+fullName+"-queueCard']//h5[@data-testid='allQueuesV2-productName']")).getText();
        Assert.assertEquals(product,productName);
    }

}
