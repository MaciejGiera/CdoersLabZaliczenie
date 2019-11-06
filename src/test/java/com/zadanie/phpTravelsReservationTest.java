package com.zadanie;

import com.pageObject.phpTravelsHomePage;
import com.pageObject.phpTravelsCheckout;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class phpTravelsReservationTest {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testing(){
        phpTravelsHomePage phpTravelsHomePage = new phpTravelsHomePage(driver);

        phpTravelsHomePage.selectFlightSection();
        phpTravelsHomePage.selectRoundTrip();
        phpTravelsHomePage.selectFrom("WAW");
        phpTravelsHomePage.selectTo("JFK");
        phpTravelsHomePage.setDepartDate("2020-01-24");
        phpTravelsHomePage.setReturnDate("2020-01-31");
//        phpTravelsHomePage.setAdultsNumber("1");
//        phpTravelsHomePage.setChildNumber("0");
//        phpTravelsHomePage.setInfantNumber("0");
        phpTravelsHomePage.searchFlights();

        WebElement firstFlight = driver.findElement(By.xpath("//*[@id=\"LIST\"]/li[1]/div/div[1]/div[2]/form[1]/div[2]/div/button"));
        firstFlight.click();

        phpTravelsCheckout phpTravelsCheckout = new phpTravelsCheckout(driver);

        phpTravelsCheckout.setEmail("aaa@aa.aa");
        phpTravelsCheckout.setPassword("password");
        phpTravelsCheckout.setTitle("Mr.");
        phpTravelsCheckout.setName("Aaa");
        phpTravelsCheckout.setSurname("Aaa");
        phpTravelsCheckout.setEmail2("aaa@aa.aa");
        phpTravelsCheckout.setPhoneInput("444444444");
        phpTravelsCheckout.setBirthday("1990-01-01");
        phpTravelsCheckout.setPassport("321321321");
        phpTravelsCheckout.setExpirationDate("2020-01-01");
        phpTravelsCheckout.setNationality("poland");
        phpTravelsCheckout.selectCardType(3);
        phpTravelsCheckout.setCCNumber("6496846519684");
        phpTravelsCheckout.selectMonthExpiration(4);
        phpTravelsCheckout.selectYearExpiration(2);
        phpTravelsCheckout.setCCV("321");
        phpTravelsCheckout.clickAgreement();

    }
}
