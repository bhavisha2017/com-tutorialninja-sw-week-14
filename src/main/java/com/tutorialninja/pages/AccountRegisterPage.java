package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.testng.Reporter;

import java.util.List;

public class AccountRegisterPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    //By registerAccountText = By.xpath("//h1[contains(text(),'Register Account')]");
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    // By firstNameField = By.id("input-firstname");
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    //By LastNameField = By.id("input-lastname");
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    //By emailField = By.id("input-email");
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    //By telephoneField = By.id("input-telephone");
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    //By passwordField = By.id("input-password");
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;
    //By passwordConfirmField = By.id("input-confirm");
    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement subscribe;
    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subscribeRadios;
    //By subscribeRadios = By.xpath("//fieldset[3]//input");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    //By privacyPolicyCheckBox = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;
    // By continueBtn = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;
    //By loginBtn = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab1;

    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    public void clickOnLogoutLink()
    {
        Reporter.log("Click on Logout Link");
        CustomListeners.test.log(Status.PASS, "Click on Logout Link");
        clickOnElement(logoutLink);
    }

    public void clickOnMyAccountTab1(){

    Reporter.log("Click on My Account Tab1");
        clickOnElement(myAccountTab1);
        CustomListeners.test.log(Status.PASS, "Click on My Account Tab1");
    }

    public String getRegisterAccountText() {
        Reporter.log("Get Register Account Text");
        CustomListeners.test.log(Status.PASS, "Get Register Account Text");
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {
        Reporter.log("Enter First Name");
        sendTextToElement(firstNameField, fName);
        CustomListeners.test.log(Status.PASS, "Enter First Name"+ fName);
    }

    public void enterLastName(String lName) {
        Reporter.log("Enter Last Name");
        sendTextToElement(lastNameField, lName);
        CustomListeners.test.log(Status.PASS, "Enter Last Name "+ lName);
    }

    public void enterEmail(String email) {
        Reporter.log("Enter Email ID");
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter Email ID " + email);
    }

    public void enterTelephone(String telephone) {
        Reporter.log("Enter Telephone No");
        sendTextToElement(telephoneField, telephone);
        CustomListeners.test.log(Status.PASS, "Enter Telephone No "+ telephone);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter Password");
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password "+ password);
    }

    public void enterConfirmPassword(String cPassword) {
        Reporter.log("Confirm Password");
        sendTextToElement(passwordConfirmField, cPassword);
        CustomListeners.test.log(Status.PASS, "Confirm Password "+ cPassword);
    }

    public void selectSubscription(String option) {

        Reporter.log("Select Subscription");
        CustomListeners.test.log(Status.PASS, "Select Subscription");
        List<WebElement> radioButtons = subscribeRadios;
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickSubscribe(){
        Reporter.log("Click on Subscribe Button");
        clickOnElement(subscribe);
        CustomListeners.test.log(Status.PASS, "Click on Subscribe Button ");
    }
    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log("Click on Privacy Policy Button");
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS, "Click on Privacy Policy Button ");
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on Continue Button");
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS, "Click on Continue Button ");
    }
}
