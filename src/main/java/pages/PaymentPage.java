package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {

    private final WebDriver driver;



    private final By yourOrderHasBeenConfirmedText =  By.xpath("//p[.='Congratulations! Your order has been confirmed!']");



    private final By nameOnCardField =  By.xpath("//input[@name='name_on_card']");
    private final By cardNumberField =  By.xpath("//input[@name='card_number']");
    private final By cvcField =  By.xpath("//input[@name='cvc']");
    private final By expiryMonthField =  By.xpath("//input[@name='expiry_month']");
    private final By expiryYearField =  By.xpath("//input[@name='expiry_year']");



    private final By payAndConfirmOrderButton =  By.xpath("//button[@id='submit']");


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isYourOrderHasBeenConfirmedTextVisible(){
        WebElement yourOrderHasBeenConfirmedVisibleText = driver.findElement(yourOrderHasBeenConfirmedText);
        return yourOrderHasBeenConfirmedVisibleText.isDisplayed();
    }



    public void enterNameOnCard(String message) {
        driver.findElement(nameOnCardField).sendKeys(message);
    }

    public void enterCardNumber(String message) {
        driver.findElement(cardNumberField).sendKeys(message);
    }

    public void enterCvc(String message) {
        driver.findElement(cvcField).sendKeys(message);
    }

    public void enterExpiryMonth(String message) {
        driver.findElement(expiryMonthField).sendKeys(message);
    }

    public void enterExpiryYear(String message) {
        driver.findElement(expiryYearField).sendKeys(message);
    }


    public void clickPayAndConfirmOrderButton(){
        driver.findElement(payAndConfirmOrderButton).click();
    }

}
