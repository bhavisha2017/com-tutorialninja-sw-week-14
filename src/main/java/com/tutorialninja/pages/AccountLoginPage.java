package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;



public class AccountLoginPage extends Utility {



    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;
    //By returningCustomerText = By.xpath("//div[@id='content']/div/div[2]//h2");
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;
    //By newCustomerText = By.xpath("//div[@id='content']/div/div[1]//h2");
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;
    //By emailAddressField = By.id("input-email");
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    //By passwordField = By.id("input-password");
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;
    //By loginBtn = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public String getReturningCustomerText() {
        CustomListeners.test.log(Status.PASS, "Get Customer Name");
        return getTextFromElement(returningCustomerText);

    }

    public String getNewCustomerText() {
        CustomListeners.test.log(Status.PASS, "Get New Customer Name");
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) {
        sendTextToElement(emailAddressField, email);
        CustomListeners.test.log(Status.PASS,"Enter Email Id "+ email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password "+ password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS, "Click on Login Button");
    }

}
