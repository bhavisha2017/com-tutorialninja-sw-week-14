package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.ComponentsPage;
import com.tutorialninja.pages.DesktopsPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopsAndNotebooksPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopsPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;


    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        desktopPage = new DesktopsPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show All Desktops");
        desktopPage.getDesktopsText();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        laptopsAndNotebooksPage.getLaptopsAndNotebooksText();
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponentsLinkAndClick();
        homePage.selectMenu("Show All Components");
        componentsPage.getComponentsText();
    }

}
