package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CheckoutPage {

    private final WebDriver driver;
    private final By addressList =  By.id("address_delivery");
    private final By messageField =  By.xpath("//textarea[@name='message']");

    private final By placeOrderButton =  By.xpath("//a[contains(text(),'Place Order')]");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isAddressListContains(String address) {
        WebElement addressListContains = driver.findElement(addressList);
        return addressListContains.getText().contains(address);
    }


    public void enterMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
    }


}
