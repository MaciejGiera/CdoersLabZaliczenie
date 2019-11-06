package com.pageObject;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class phpTravelsHomePage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/nav/ul/li[2]/a")
    private WebElement flightSection;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/form/div/div[1]/div[1]/div[2]/label")
    private WebElement roundTripRadio;

    @FindBy(xpath = "//*[@id=\"s2id_location_from\"]/a")
    private WebElement fromInput;

    @FindBy(xpath = "//*[@id=\"s2id_location_to\"]/a")
    private  WebElement toInput;

    @FindBy(xpath = "//*[@id=\"FlightsDateStart\"]")
    private WebElement departDateInput;

    @FindBy(xpath = "//*[@id=\"FlightsDateEnd\"]")
    private WebElement returnDateInput;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/form/div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/input")
    private  WebElement adultsInput;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/form/div/div[2]/div[3]/div/div/div[2]/div/div[2]/div/input")
    private WebElement childInput;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/form/div/div[2]/div[3]/div/div/div[3]/div/div[2]/div/input")
    private WebElement infantInput;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/form/div/div[2]/div[4]/button")
    private WebElement searchButton;

    public phpTravelsHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFlightSection(){
        this.flightSection.click();
    }

    public void selectRoundTrip(){
        this.roundTripRadio.click();
    }

    public void selectFrom(String from){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.fromInput.click();
        this.fromInput.sendKeys(from);
        WebElement thirdOption = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[3]/div"));
        wait.until(ExpectedConditions.visibilityOf(thirdOption));
        this.fromInput.sendKeys(Keys.ENTER);


    }

    public void selectTo(String to){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.toInput.click();
        this.toInput.sendKeys(to);
        WebElement thirdOption = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div"));
        wait.until(ExpectedConditions.visibilityOf(thirdOption));
        this.toInput.sendKeys(Keys.ENTER);
    }

    public void setDepartDate(String departDate) {
        this.departDateInput.click();
        this.driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/nav/div[2]")).click();
        this.driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/nav/div[2]")).click();
        this.driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/div/div[3]/div/div[12]")).click();
        this.driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/div/div[2]/div/div[1]")).click();
        this.driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[7]/div/div[1]/div[2]/div[27]")).click();
    }

    public void setReturnDate(String returnDate){
        this.returnDateInput.sendKeys(returnDate);

        this.driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[8]/div/div/div[2]/div[34]")).click();
    }

//    public void setAdultsNumber(String adultsNumber){
//        this.adultsInput.sendKeys(adultsNumber);
//    }
//
//    public void setChildNumber(String childNumber){
//        this.childInput.sendKeys(childNumber);
//    }
//
//    public void setInfantNumber(String infantNumber){
//        this.infantInput.sendKeys(infantNumber);
//    }

    public void searchFlights(){
        this.searchButton.click();
    }

}
