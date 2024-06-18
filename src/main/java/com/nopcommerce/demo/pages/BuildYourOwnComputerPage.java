package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

//Build your own computer Text, Processor Drop Down, Ram drop down,
// HDD radios, os radio, software check boxes, Add To Card button, "The product has been added to your shopping cart" message

public class BuildYourOwnComputerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[text()='Build your own computer']")
    WebElement buildYourOwnComputerText;

    @CacheLookup
    @FindBy(css = "#product_attribute_1")
    WebElement processor;

    @CacheLookup
    @FindBy(css = "#product_attribute_2")
    WebElement ram;

    @CacheLookup
    @FindBy(name = "product_attribute_3")
    List<WebElement> hddRadio;

    @CacheLookup
    @FindBy(name = "product_attribute_4")
    List<WebElement> osRadio;

    @CacheLookup
    @FindBy(name = "product_attribute_5")
    List<WebElement> selectCheckBox;

    @CacheLookup
    @FindBy(css = "#add-to-cart-button-1")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement productAddToCartSuccessText;


    public void selectProcessor(String processorName) {
        selectByVisibleTextFromDropDown(processor, processorName);
        CustomListeners.test.log(Status.PASS, "select processor" + processorName);
        Reporter.log("select processor" + processor.toString());
    }

    public void selectRam(String ramName) {
        selectByVisibleTextFromDropDown(ram, ramName);
        CustomListeners.test.log(Status.PASS, "select ram" + ramName);
        Reporter.log("select ram" + ram.toString());
    }

    public void selectHDD(String radio) {
        List<WebElement> hddRadios = hddRadio;

        String val = "320 GB";
        String val1 = "400 GB [+$100.00]";

        if (val.equalsIgnoreCase(radio)) {
            hddRadios.get(0).click();
        } else if (val1.equalsIgnoreCase(radio)) {
            hddRadios.get(1).click();
        }
        CustomListeners.test.log(Status.PASS, "select hdd" + radio);
        Reporter.log("select hdd" + hddRadio.toString());
    }

    public void selectOS(String radio) {
        List<WebElement> osRadios = osRadio;

        String val = "Vista Home [+$50.00]";
        String val1 = "Vista Premium [+$60.00]";

        if (val.equalsIgnoreCase(radio)) {
            osRadios.get(0).click();
        } else if (val1.equalsIgnoreCase(radio)) {
            osRadios.get(1).click();
        }
        CustomListeners.test.log(Status.PASS, "select os" + radio);
        Reporter.log("select os" + osRadio.toString());
    }

    public void selectCheckBox(String checkBox) {
        List<WebElement> selectCheckBoxList = selectCheckBox;

        String val = "Microsoft Office [+$50.00]";
        String val1 = "Acrobat Reader [+$10.00]";
        String val2 = "Total Commander [+$5.00]";

        if (val.equalsIgnoreCase(checkBox)) {
            selectCheckBoxList.get(0).click();
        } else if (val1.equalsIgnoreCase(checkBox)) {
            selectCheckBoxList.get(1).click();
        } else if (val2.equalsIgnoreCase(checkBox)) {
            selectCheckBoxList.get(2).click();

        }
        CustomListeners.test.log(Status.PASS, "select checkBox" + checkBox);
        Reporter.log("select checkBox" + selectCheckBox.toString());
    }

    public void clickOnAddToCArtButton() {
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS, "Clicking on logOut link" + addToCartButton);
        Reporter.log("Clicking on logout link" + addToCartButton.toString());

    }

    public String verifyProductAddToCartSuccessfully() {
        String message = getTextFromElement(productAddToCartSuccessText);
        CustomListeners.test.log(Status.PASS, "Get product successfully added text");
        Reporter.log("Get product successfully added text" + productAddToCartSuccessText.toString());
        return message;

    }
}
