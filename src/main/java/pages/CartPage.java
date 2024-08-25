package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class CartPage {

    private final WebDriver driver;
    private final By subscriptionText = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By successfullySubscribedText = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");

    private final By emailField = By.id("susbscribe_email");

    private final By subscribeButton = By.xpath("//button[@id='subscribe']");


    public boolean isProductInCart(String productName) {
        return !driver.findElements(By.xpath("//a[text()='" + productName + "']")).isEmpty();
    }

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSubscriptionTextVisible() {
        WebElement subscriptionVisibleText = driver.findElement(subscriptionText);
        return subscriptionVisibleText.isDisplayed();
    }


    private By productNameLocator(String productId) {
        return By.xpath("//tr[@id='product-" + productId + "']//td[@class='cart_description']//h4/a");
    }

    private By productPriceLocator(String productId) {
        return By.xpath("//tr[@id='product-" + productId + "']//td[@class='cart_price']/p");
    }

    private By productQuantityLocator(String productId) {
        return By.xpath("//tr[@id='product-" + productId + "']//td[@class='cart_quantity']//button");
    }

    private By productTotalLocator(String productId) {
        return By.xpath("//tr[@id='product-" + productId + "']//td[@class='cart_total']//p[@class='cart_total_price']");
    }


    public String getProductName(String productId) {
        WebElement element = driver.findElement(productNameLocator(productId));
        return element.getText();
    }

    public String getProductPrice(String productId) {
        WebElement element = driver.findElement(productPriceLocator(productId));
        return element.getText();
    }

    public String getProductQuantity(String productId) {
        WebElement element = driver.findElement(productQuantityLocator(productId));
        return element.getText();
    }

    public String getProductTotal(String productId) {
        WebElement element = driver.findElement(productTotalLocator(productId));
        return element.getText();
    }

    public boolean isSuccessfullySubscribedTextVisible() {
        WebElement successfullySubscribedVisibleText = driver.findElement(successfullySubscribedText);
        return successfullySubscribedVisibleText.isDisplayed();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSubscribe(){
        driver.findElement(subscribeButton).click();
    }

}
