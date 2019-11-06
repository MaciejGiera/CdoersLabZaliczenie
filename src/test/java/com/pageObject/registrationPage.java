package com.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Timestamp;

public class registrationPage {

    private WebDriver driver;

    //searching input fields
    @FindBy(id = "fos_user_registration_form_email")
    private WebElement emailInput;

    @FindBy(id = "fos_user_registration_form_name")
    private WebElement firstNameInput;

    @FindBy(id = "fos_user_registration_form_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "fos_user_registration_form_plainPassword_first")
    private WebElement passwordInput;

    @FindBy(id = "fos_user_registration_form_plainPassword_second")
    private WebElement passwordValidationInput;

    @FindBy(id = "form_city")
    private WebElement cityInput;

    @FindBy(id = "form_postal_code")
    private WebElement postalCodeInput;

    @FindBy(id = "form_street")
    private WebElement streetNameInput;

    @FindBy(id = "form_number")
    private WebElement houseNumberInput;

    @FindBy(xpath = "/html/body/div[1]/div/div/form/div[12]/input")
    private WebElement tosCheckbox;

    @FindBy(id = "register-submit-btn")
    private WebElement registerButton;

    public registrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //methods to use in test to fulfill the form
    public void setEmail(String email) {
        this.clearAndSendKeys(emailInput, email);
    }

    public void setFirstName(String firstName){
        this.clearAndSendKeys(firstNameInput, firstName);
    }

    public void setLastName(String lastName){
        this.clearAndSendKeys(lastNameInput, lastName);
    }

    public void setPassword(String password){
        this.clearAndSendKeys(passwordInput, password);
    }

    public void setPasswordValidation(String passwordValidation) {
        this.clearAndSendKeys(passwordValidationInput, passwordValidation);
    }

    public void setCity(String city){
        this.clearAndSendKeys(cityInput, city);
    }

    public void setPostalCode(String postalCode){
        this.clearAndSendKeys(postalCodeInput, postalCode);
    }

    public void setStreetName(String streetName){
        this.clearAndSendKeys(streetNameInput, streetName);
    }

    public void setHouseNumber(String houseNumber){
        this.clearAndSendKeys(houseNumberInput, houseNumber);
    }

    public void clickTosCheckbox(){
        this.tosCheckbox.click();
    }

    public void clickRegisterButton(){
        this.registerButton.click();
    }

    public String generateEmail(String firstName, String lastName){
        String email;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        email = firstName + "." + lastName + timestamp.getTime() + "@somemail.com";
        return email;
    }

    private void clearAndSendKeys(WebElement inputField, String text){
        inputField.clear();
        inputField.sendKeys(text);
    }

}
