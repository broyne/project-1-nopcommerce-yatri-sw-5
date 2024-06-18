package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

//DesktopsPage - Desktops text, Sortby, Display, selectProductList Locators and it's actions
public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Desktops']")
    WebElement desktopslink;

    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement desktoptext;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement buildYourOwnComputer;

    public void clickOnDesktopLink() {
        clickOnElement(desktopslink);
        CustomListeners.test.log(Status.PASS, "Clicking on desktop link" + desktopslink);
        Reporter.log("Clicking on desktop link" + desktopslink.toString());
    }

    public String verifydektopText() {
        String message = getTextFromElement(desktoptext);
        CustomListeners.test.log(Status.PASS, "Verify Desktop title");
        return message;
    }

    public void clickOnBuildYourOwnComputer() {
        clickOnElement(buildYourOwnComputer);
        CustomListeners.test.log(Status.PASS, "Clicking on logOut link" + buildYourOwnComputer);
        Reporter.log("Clicking on logout link" + buildYourOwnComputer.toString());

    }
}
