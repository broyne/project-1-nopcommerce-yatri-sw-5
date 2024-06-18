package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

//LoginPage - Email, password, Login Button and "Welcome, Please Sign In!" text Locators and create appropriate methods for it

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;


    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;


    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;


    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;


    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;


    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;


    public String getWelcomeText() {
        String message = getTextFromElement(welcomeText);
        CustomListeners.test.log(Status.PASS, "Get Welcome message");
        Reporter.log("Get Welcome message" + welcomeText.toString());
        return message;
    }

    public void enterEmailId(String email) {
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + email);

    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
        Reporter.log("Click on loginButton" + loginButton.toString());
    }

    public void clickOnLogoutButton() {
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
        Reporter.log("Click on loginButton" + loginButton.toString());
    }

    public String getErrorMessage() {
        String message = getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS, "Get errorMessage");
        return message;
    }


}
