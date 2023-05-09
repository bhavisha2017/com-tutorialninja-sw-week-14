package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class ComponentsPage extends Utility {


    @CacheLookup
    @FindBy(linkText = "Show AllComponents")
    WebElement componentsText;
    //By componentsText = By.xpath("//h2[contains(text(),'Components')]");

    public void getComponentsText() {
        Reporter.log("Get All Components Text");
        String expectedMessage = "Show AllComponents";
        String actualMessage = getTextFromElement(componentsText);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Get All Components Text");
    }

    }

