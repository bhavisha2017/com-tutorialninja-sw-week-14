package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenu;
    //By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement desktopLink;
    //By desktopLink = By.linkText("Desktops");

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooksLink;
    //By laptopsAndNotebooksLink = By.linkText("Laptops & Notebooks");


    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Components']")
    WebElement componentsLinks;
    //By componentsLinks = By.linkText("Components");

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;
    //By currencyTab = By.xpath("//span[contains(text(),'Currency')]");
    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList;
    //By currencyList = By.xpath("//ul[@class = 'dropdown-menu']/li");
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;
    //By myAccountTab = By.xpath("//span[contains(text(),'My Account')]");
    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountOptions;
    //By myAccountOptions = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");

//    @CacheLookup
//    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
//    List<WebElement> topMenu;
//    //By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");

    public void selectMenu(String menu) {

        Reporter.log("Select Menu");
        CustomListeners.test.log(Status.PASS, "Select Menu");
        List<WebElement> topMenuList = topMenu;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenu;
        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() {
        Reporter.log("Click On Desktops And Click");
        CustomListeners.test.log(Status.PASS, "Click On Desktops And Click");
        mouseHoverToElementAndClick(desktopLink);

    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        Reporter.log("Laptops And Notebooks Link Ans Click");
        CustomListeners.test.log(Status.PASS, "Laptops And Notebooks Link Ans Click");
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }
        public void mouseHoverOnComponentsLinkAndClick()
    {
            Reporter.log("Components Link And Click");
            CustomListeners.test.log(Status.PASS, "Components Link And Click");
            mouseHoverToElementAndClick(componentsLinks);
        }


    public void selectCurrency(String currency) {

        Reporter.log("Select Currency");
        CustomListeners.test.log(Status.PASS, "Select Currency");
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = currencyList;
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMyQAccountTab() {
        Reporter.log("Click On My Account Tab");
        CustomListeners.test.log(Status.PASS, "Click On My Account Tab");
        clickOnElement(myAccountTab);
    }

    public void selectMyAccountOptions(String option) {
        Reporter.log("Select My Account options");
        CustomListeners.test.log(Status.PASS, "Select My Account options");
        List<WebElement> myAccountList = myAccountOptions;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = myAccountOptions;
        }
    }
}
