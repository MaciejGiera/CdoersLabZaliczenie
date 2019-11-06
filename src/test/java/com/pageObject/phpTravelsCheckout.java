package com.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class phpTravelsCheckout {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"title\"]")
    private WebElement titleSelect;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"surname\"]")
    private WebElement surnameInput;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email2Input;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"birthday\"]")
    private WebElement birthdayInput;

    @FindBy(xpath = "//*[@id=\"cardno\"]")
    private WebElement passportInput;

    @FindBy(xpath = "//*[@id=\"expiration\"]")
    private WebElement expirationDateInput;

    @FindBy(xpath = "//*[@id=\"s2id_nationality\"]/a")
    private WebElement nationalityInput;

    @FindBy(xpath = "//*[@id=\"cardtype\"]")
    private WebElement cardTypeSelect;

    @FindBy(xpath = "//*[@id=\"card-number\"]")
    private WebElement ccNumberInput;

    @FindBy(xpath = "//*[@id=\"expiry-month\"]")
    private WebElement monthExpirationSelect;

    @FindBy(xpath = "//*[@id=\"expiry-year\"]")
    private WebElement yearExpirationSelect;

    @FindBy(xpath = "//*[@id=\"cvv\"]")
    private WebElement ccvInput;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/form/div[5]/label")
    private WebElement agreementButton;

    @FindBy(xpath = "//*[@id=\"confirmBooking\"]")
    private WebElement availabilityCheckingButton;


    public phpTravelsCheckout(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email){
        this.emailInput.sendKeys(email);
    }

    public void setPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void setTitle(String title){
        Select titleSelection =new Select(titleSelect);
        titleSelection.selectByIndex(0);

    }

    public void setName(String name){
        this.nameInput.sendKeys(name);
    }

    public void setSurname(String surname){
        this.surnameInput.sendKeys(surname);
    }

    public void  setEmail2(String email2){
        this.email2Input.sendKeys(email2);
    }

    public void setPhoneInput(String phone){
        this.phoneInput.sendKeys(phone);
    }

    public void setBirthday(String birthday){
        this.birthdayInput.sendKeys(birthday);
    }

    public void setPassport(String passport){
        this.passportInput.sendKeys(passport);
    }

    public void setExpirationDate(String expirationDate){
        this.expirationDateInput.sendKeys(expirationDate);
    }

    public void setNationality(String nationality){
        this.nationalityInput.click();
        this.nationalityInput.sendKeys(nationality);
        this.nationalityInput.sendKeys(Keys.ENTER);
//        Select selectNationality = new Select(nationalityInput);
//        selectNationality.
    }

    public void selectCardType(int cardType){
        Select cardTypeList = new Select(cardTypeSelect);
        cardTypeList.selectByIndex(cardType);

    }

    public void setCCNumber(String ccNumber){
        this.ccNumberInput.sendKeys(ccNumber);
    }

    public void selectMonthExpiration(int monthExpiration){
        Select monthExpire = new Select(monthExpirationSelect);
        monthExpire.selectByIndex(monthExpiration);
    }

    public void selectYearExpiration(int yearExpiration){
        Select yearExpire = new Select(yearExpirationSelect);
        yearExpire.selectByIndex(yearExpiration);
    }

    public void setCCV(String ccv){
        this.ccvInput.sendKeys(ccv);
    }

    public void clickAgreement(){
//        this.agreementButton.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", agreementButton);
    }

    public void clickAvailabilityChecking(){
        this.availabilityCheckingButton.click();
    }

}
