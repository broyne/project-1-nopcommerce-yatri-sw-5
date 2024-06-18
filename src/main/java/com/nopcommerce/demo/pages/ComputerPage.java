package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


//Computers text, DesktopsLink, NotebooksLink, SoftwareLink Locators and create appropriate methods for it.

public class ComputerPage extends Utility {
    HomePage homePage = new HomePage();
    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")
    WebElement desktopLink;


    public String verifyComputerText() {
        String message = getTextFromElement(computerText);
        CustomListeners.test.log(Status.PASS, "Get login link");
        Reporter.log("Get login link" + computerText.toString());
        return message;
    }

    public void mouseOverToComputerAndClickOnDesktop() {
        mouseHoverToElement(homePage.computerLink);
        mouseHoverToElementAndClick(desktopLink);
        CustomListeners.test.log(Status.PASS, "Clicking on desktop link" + desktopLink);
        Reporter.log("Clicking on logout link" + desktopLink.toString());
    }


}
