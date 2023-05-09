package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.AccountLoginPage;
import com.tutorialninja.pages.AccountRegisterPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.MyAccountPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(CustomListeners.class)
public class AccountRegisterPageTest extends BaseTest {

    HomePage homePage;
    AccountRegisterPage accountRegisterPage;
    MyAccountPage accountPage;
    AccountLoginPage accountLoginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        accountRegisterPage = new AccountRegisterPage();
        accountPage = new MyAccountPage();
        accountLoginPage = new AccountLoginPage();
    }
    @Test (groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Register");
        Assert.assertEquals(accountRegisterPage.getRegisterAccountText(),
                "Register Account", "Register page not displayed");
    }

    @Test (groups = {"smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Register");
        accountRegisterPage.enterFirstName("Prime" + getAlphaNumericString(4));
        accountRegisterPage.enterLastName("Testing" + getAlphaNumericString(4));
        accountRegisterPage.enterEmail("mvthakur" + getAlphaNumericString(4) + "@gmail.com");
        accountRegisterPage.enterTelephone("07988112233");
        accountRegisterPage.enterPassword("Mv123456");
        accountRegisterPage.enterConfirmPassword("Mv123456");
        accountRegisterPage.selectSubscription("Yes");
        accountRegisterPage.clickSubscribe();
        accountRegisterPage.clickOnPrivacyPolicyCheckBox();
        accountRegisterPage.clickOnContinueButton();
        Assert.assertEquals(accountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                "Account not created");
        accountPage.clickOnContinueButton();
        accountRegisterPage.clickOnMyAccountTab1();
        accountRegisterPage.clickOnLogoutLink();
        accountPage.verifyAccountLogoutText();
        accountPage.clickOnContinueButton1();
    }
}

