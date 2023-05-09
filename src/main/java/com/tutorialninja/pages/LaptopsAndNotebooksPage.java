package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;
    //By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;
    //By productsPrices = By.xpath("//p[@class ='price']");
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;
    //By productsList = By.xpath("//h4/a");
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;
    //By sortBy = By.id("input-sort");

    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement getLaptopsAndNotebooksText;

    public void getLaptopsAndNotebooksText(){
        Reporter.log("Get All Laptops & Notebooks Text");
        String expectedMessage = "Show AllLaptops & Notebooks";
        String actualMessage = getTextFromElement(getLaptopsAndNotebooksText);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Get All Laptops & Notebooks Text");
    }

    public ArrayList<Double> getProductsPriceList() {
        Reporter.log("Get Products Price List");
        CustomListeners.test.log(Status.PASS, "Get Products Price List");
        List<WebElement> products = productsPrices;
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public void selectSortByOption(String option)
    {   Reporter.log("Select Sort By Option");
        CustomListeners.test.log(Status.PASS, "Select Sort By Option");
        selectByVisibleTextFromDropDown(sortBy, option);
    }

    public void selectProductByName(String product) {
        Reporter.log("Select Product By Name");
        CustomListeners.test.log(Status.PASS, "Select Product By Name");
        List<WebElement> products = productsList;
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }
}
