package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class MyAccountPage extends Utility {

    public MyAccountPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement logoutText;
    //By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;
    //By accountCreatedText = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;
    //By continueBtn = By.xpath("//a[contains(text(),'Continue')]");

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueBtn1;


    public void clickOnContinueButton1()
    {   Reporter.log("Click On Continue Button1");
        CustomListeners.test.log(Status.PASS, "Click On Continue Button1");
        clickOnElement(continueBtn1);
    }

    public void verifyLogoutText() {
        Reporter.log("Verify Logout Text");
        String expectedMessage = "Logout";
        String actualMessage = getTextFromElement(logoutText);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Verify Logout Text");
    }

    public void verifyAccountLogoutText() {
        Reporter.log("Verify Account Logout Text");
        String expectedMessage = "Account Logout";
        String actualMessage = getTextFromElement(accountLogoutText);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Verify Account Logout Text");
    }

    public String getYourAccountHasBeenCreatedText()
    {   Reporter.log("Get Account Has Been Created Text");
        CustomListeners.test.log(Status.PASS, "Get Account Has Been Created Text");
        return getTextFromElement(accountCreatedText);

    }

    public void clickOnContinueButton()
    {   Reporter.log("Click On Continue Button");
        CustomListeners.test.log(Status.PASS, "Click On Continue Button");
        clickOnElement(continueBtn);
    }

    public void clickOnMyAccountTab()
    {   Reporter.log("Click On My Account Tab");
        CustomListeners.test.log(Status.PASS, "Click On My Account Tab");
        clickOnElement(myAccountTab);
    }
}
