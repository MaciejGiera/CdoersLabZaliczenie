package com.zadanie;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pageObject.RegistrationPage;

public class CodersGuruRegistration {
    WebDriver driver;



    @Given("^an open browser with (.*)$")
    public void anOpenBrowserWithHttpsTesterCodersguruPl(String mainPage) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        //open new browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //gp to specified page
        driver.get(mainPage);
        
    }

    @When("^go to registration page$")
    public void goToRegistrationPage() {
        //go to registration page
        driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]")).click();
        
    }

    @And("^user enter valid data \\((.*), (.*), (.*), (.*), (.*), (.*), (.*)\\)$")
    public void enterValidDataFirstNameLastNamePasswordCityPostalCodeStreetHouseNumber(
            String firstName,  String lastName, String password, String city, String postalCode, String street, String houseNumber) {

        RegistrationPage POBCodersGuru = new RegistrationPage(driver);

//        String firstName = "John";
//        String lastName = "Doe";
//        String password = "password";
//        String city = "Warsaw";
//        String postalCode = "00-000";
//        String street = "Uliczna";
//        String houseNumber = "3";
        //generating email address
        String email = POBCodersGuru.generateEmail(firstName,lastName);

        //fulfill  form with given data
        POBCodersGuru.setEmail(email);
        POBCodersGuru.setFirstName(firstName);
        POBCodersGuru.setLastName(lastName);
        POBCodersGuru.setPassword(password);
        POBCodersGuru.setPasswordValidation(password);
        POBCodersGuru.setCity(city);
        POBCodersGuru.setPostalCode(postalCode);
        POBCodersGuru.setStreetName(street);
        POBCodersGuru.setHouseNumber(houseNumber);
        POBCodersGuru.clickTosCheckbox();
        POBCodersGuru.clickRegisterButton();
    }

    @Then("^check if registration was successful$")
    public void checkIfRegistrationWasSuccessful() {
        //check if registration was successful
        Assert.assertEquals("https://tester.codersguru.pl/register/confirmed", driver.getCurrentUrl());
    }


}
