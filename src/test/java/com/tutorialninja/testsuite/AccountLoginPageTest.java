package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.AccountLoginPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.MyAccountPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class AccountLoginPageTest extends BaseTest {

    HomePage homePage;
    AccountLoginPage accountLoginPage;
    MyAccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        accountLoginPage = new AccountLoginPage();
        accountPage = new MyAccountPage();

    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(accountLoginPage.getReturningCustomerText(),
                "Returning Customer", "Login page not displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Login");
        accountLoginPage.enterEmailAddress("mvthakur2023@gmail.com");
        accountLoginPage.enterPassword("Mv123456");
        accountLoginPage.clickOnLoginButton();
        accountPage.clickOnMyAccountTab();
        homePage.selectMyAccountOptions("Logout");
        accountPage.verifyLogoutText();
    }

}
