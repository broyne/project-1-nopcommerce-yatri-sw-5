package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression", "smoke"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        homePage.clickOnLoginLink(); //Click on login link
        //verify that "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed!");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        homePage.clickOnLoginLink(); //Click on login link
        loginPage.enterEmailId("yhirani@gmail.com"); //Enter EmailId
        loginPage.enterPassword("yhirani"); //Enter Password
        loginPage.clickOnLoginButton(); //Click on Login Button
        //Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.clickOnLoginLink(); //Click on login link
        loginPage.enterEmailId("yhirani7@gmail.com"); //Enter EmailId
        loginPage.enterPassword("yhirani"); //Enter Password
        loginPage.clickOnLoginButton(); //Click on Login Button
        //Verify that LogOut link is display
        String expectedErrorMessage = "Log out";
        String actualErrorMessage = homePage.getErrorLogoutMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Logout text not displayed");
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLogOutSuccessFully() {
        homePage.clickOnLoginLink(); //Click on login link
        loginPage.enterEmailId("yhirani7@gmail.com"); //Enter EmailId
        loginPage.enterPassword("yhirani"); //Enter Password
        loginPage.clickOnLoginButton(); //Click on Login Button
        homePage.clickOnLogOutButton(); //Click on LogOut Link
        //Verify that LogIn Link Display
        String expectedErrorMessage = "Log in";
        String actualErrorMessage = homePage.verifyLogInLinkDisplay();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Login Link not display");

    }


}
