package com.nopcommerce.demo.testsuite;

import com.google.common.base.Verify;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "regression", "smoke"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        registerPage.clickOnRegisterLink(); //Click on Register Link
        //Verify "Register" text
        String expectedMessage = "Register";
        String actualMessage = registerPage.verifyRegisterTextDisplay();
        Assert.assertEquals(expectedMessage, actualMessage, "Register text not displayed!");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        registerPage.clickOnRegisterLink();  //Click on Register Link
        registerPage.clickOnRegisterbutton();   //Click on "REGISTER" button

        //Verify the error message "First name is required."
        String expectedMessage4 = "First name is required.";
        String actualMessage4 = registerPage.verifyFirstnameTextDisplay();
        Assert.assertEquals(expectedMessage4, actualMessage4, "Firstname Error message display");

        //Verify the error message Last name is required.
        String expectedMessage1 = "Last name is required.";
        String actualMessage1 = registerPage.verifylastnameTextDisplay();
        Assert.assertEquals(expectedMessage1, actualMessage1, "Last name Error message display");


        //Verify the error message "Email is required
        String expectedMessage2 = "Email is required.";
        String actualMessage2 = registerPage.verifyemailTextDisplay();
        Assert.assertEquals(expectedMessage2, actualMessage2, "Email Error message display");


        //Verify the error message "Password is required."
        String expectedMessage3 = "Password is required.";
        String actualMessage3 = registerPage.verifypasswordTextDisplay();
        Assert.assertEquals(expectedMessage3, actualMessage3, "Password Error message display");


    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        registerPage.clickOnRegisterLink();  //Click on Register Link
        registerPage.clickOnGender(); //Select gender "Female"
        registerPage.enterFirstName(); //Enter firstname
        registerPage.enterlastName(); //Enter lastname
        registerPage.enterDay("4"); // Select day
        registerPage.enterMonth("February");   // Select month
        registerPage.enterYear("1994");  // Select year
        registerPage.enteremail("yatri.hir8559@gmail.com"); //Enter email
        registerPage.enterpassword("Yatri@888"); //Enter password
        registerPage.entercpassword("Yatri@888"); //Enter Confirm Password
        registerPage.clickOnRegisterbutton(); //Click on "REGISTER" button
        //Verify message "Your registration completed"
        String expectedMessage4 = "Your registration completed";
        String actualMessage4 = registerPage.registercompleteTextDisplay();
        Assert.assertEquals(expectedMessage4, actualMessage4, "Your registration completed");


    }


}
