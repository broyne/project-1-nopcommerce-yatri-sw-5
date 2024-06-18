package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


//Register Text, male female radio, Firstname, lastname, Date of Birth drop
//down, email, Password, Confirm Password, Register Button, "First name is required.","Last name
//is required.", "Email is required.","Password is required.", "Password is required." error message,
//"Your registration completed" message, "CONTINUE" button
//Locators and it's actions

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerbutton;

    @CacheLookup
    @FindBy(xpath = "//span[@data-valmsg-for='FirstName']")
    WebElement firstNameError;

    @CacheLookup
    @FindBy(xpath = "//span[@data-valmsg-for='LastName']")
    WebElement lastNameError;

    @CacheLookup
    @FindBy(xpath = "//span[@data-valmsg-for='Email']")
    WebElement emailError;

    @CacheLookup
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement cpasswordError;

    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement gender;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastname;

    @CacheLookup
    @FindBy(name = "DateOfBirthDay")
    WebElement day;

    @CacheLookup
    @FindBy(name = "DateOfBirthMonth")
    WebElement month;

    @CacheLookup
    @FindBy(name = "DateOfBirthYear")
    WebElement year;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailtext;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement passwordtext;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmpasswordtext;

    @CacheLookup
    @FindBy(xpath = "//div[@class='result']")
    WebElement registercompletetext;

    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
        Reporter.log("Clicking on register Link " + registerLink.toString());
        CustomListeners.test.log(Status.PASS, "Clicking on Register Link");
    }

    public void clickOnRegisterbutton() {
        clickOnElement(registerbutton);
        Reporter.log("Clicking on register Link " + registerbutton.toString());
        CustomListeners.test.log(Status.PASS, "Clicking on Register Button");
    }

    public String verifyRegisterTextDisplay() {
        String message = getTextFromElement(registerText);
        Reporter.log("Register text" + registerText.toString());
        CustomListeners.test.log(Status.PASS, "Register text");
        return message;
    }

    public String verifyFirstnameTextDisplay() {
        String message = getTextFromElement(firstNameError);
        Reporter.log("firstNameError text" + firstNameError.toString());
        CustomListeners.test.log(Status.PASS, "firstNameError text");
        return message;
    }

    public String verifylastnameTextDisplay() {
        String message = getTextFromElement(lastNameError);
        Reporter.log("lastNameError text" + lastNameError.toString());
        CustomListeners.test.log(Status.PASS, "lastNameError text");
        return message;
    }

    public String verifyemailTextDisplay() {
        String message = getTextFromElement(emailError);
        Reporter.log("emailError text" + emailError.toString());
        CustomListeners.test.log(Status.PASS, "emailError text");
        return message;
    }

    public String verifypasswordTextDisplay() {
        String message = getTextFromElement(cpasswordError);
        Reporter.log("ConfirmPassword text" + cpasswordError.toString());
        CustomListeners.test.log(Status.PASS, "ConfirmPassword text");
        return message;
    }

    public void clickOnGender() {
        clickOnElement(gender);
        Reporter.log("Clicking on register Link " + gender.toString());
        CustomListeners.test.log(Status.PASS, "Clicking on Register Link");
    }

    public void enterFirstName() {
        sendTextToElement(firstName, "Sumit");
        Reporter.log("Enter Firstname " + firstName.toString());
        CustomListeners.test.log(Status.PASS, "Enter firstname");

    }

    public void enterlastName() {
        sendTextToElement(lastname, "Hirani");
        Reporter.log("Enter Lastname " + lastname.toString());
        CustomListeners.test.log(Status.PASS, "Enter Lastname");

    }

    public void enterDay(String date) {
        sendTextToElement(day, date);
        CustomListeners.test.log(Status.PASS, "Enter date " + date);
        Reporter.log("Enter date " + day.toString());

    }

    public void enterMonth(String month_) {
        sendTextToElement(month, month_);
        CustomListeners.test.log(Status.PASS, "Enter month" + month_);
        Reporter.log("Enter month " + month.toString());

    }

    public void enterYear(String year_) {
        sendTextToElement(year, year_);
        CustomListeners.test.log(Status.PASS, "Enter year " + year_);
        Reporter.log("Enter year " + year.toString());

    }

    public void enteremail(String emailid) {
        sendTextToElement(emailtext, emailid);
        CustomListeners.test.log(Status.PASS, "emailid");
        Reporter.log("Enter Email " + emailtext.toString());

    }

    public void enterpassword(String password) {
        sendTextToElement(passwordtext, password);
        CustomListeners.test.log(Status.PASS, "password");
        Reporter.log("Enter Password " + passwordtext.toString());

    }

    public void entercpassword(String cpassword) {
        sendTextToElement(confirmpasswordtext, cpassword);
        CustomListeners.test.log(Status.PASS, "cpassword");
        Reporter.log("Enter Confirm Password " + confirmpasswordtext.toString());

    }

    public String registercompleteTextDisplay() {
        String message = getTextFromElement(registercompletetext);
        Reporter.log("Register Completed" + registercompletetext.toString());
        CustomListeners.test.log(Status.PASS, "Register Completed");
        return message;
    }

}
