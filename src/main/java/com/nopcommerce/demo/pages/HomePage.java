package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

//HomePage - All Menu (Seven menu), LoginLink, registerLink, nopcommerce logo, My account link and LogOut link locators and create appropriate methods for it
public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement logInLink;

    @CacheLookup
    @FindBy(linkText = "Log out")
    WebElement logOutButton;

    @CacheLookup
    @FindBy(linkText = "Log out")
    WebElement logOutText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement errorLogoutMessage;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(text(), 'Computers ')]")
    WebElement computerLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")
    WebElement desktopslink;


    public void clickOnLoginLink() {
        clickOnElement(loginLink);
        Reporter.log("Clicking on Login Link " + loginLink.toString());
        CustomListeners.test.log(Status.PASS, "Clicking on Login Link");
    }


    public String verifyLogoutLinkDisplay() {
        String message = getTextFromElement(logOutText);
        CustomListeners.test.log(Status.PASS, "Get logout link");
        Reporter.log("Get logout link" + logOutText.toString());
        return message;
    }

    public void clickOnLogOutButton() {
        clickOnElement(logOutButton);
        CustomListeners.test.log(Status.PASS, "Clicking on logOut link" + logOutButton);
        Reporter.log("Clicking on logout link" + logOutButton.toString());

    }

    public String getErrorLogoutMessage() {
        String message = getTextFromElement(errorLogoutMessage);
        CustomListeners.test.log(Status.PASS, "Verify Logout message");
        return message;
    }

    public String verifyLogInLinkDisplay() {
        String message = getTextFromElement(logInLink);
        CustomListeners.test.log(Status.PASS, "Get login link");
        Reporter.log("Get login link" + logInLink.toString());
        return message;
    }

    public void clickOnComputerTabLink() {
        clickOnElement(computerLink);
        CustomListeners.test.log(Status.PASS, "Clicking on computer link");
        Reporter.log("Clicking on computer link" + computerLink.toString());
    }


}
