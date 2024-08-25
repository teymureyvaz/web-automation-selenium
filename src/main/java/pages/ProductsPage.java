package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

public class ProductsPage {
    private final WebDriver driver;


    private final By productsListDiv = By.xpath("//div[@class='features_items']");
    private final By productsDiv = By.xpath("//h2[@class='title text-center']");

    private final By continueShoppingButton = By.xpath("//button[contains(text(), 'Continue Shopping')]");
    private final By viewCartButton = By.xpath("//a[contains(., 'View Cart')]");



    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isProductsVisible() {
        WebElement productsDivElement = driver.findElement(productsDiv);
        return productsDivElement.isDisplayed();
    }

    public boolean isProductListDivVisible() {
        WebElement productListDiv = driver.findElement(productsListDiv);
        return productListDiv.isDisplayed();
    }


    public void clickViewProduct(String productId) {
        driver.findElement(By.xpath("//a[@href='/product_details/"+ productId +"']")).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickViewCartButton() {
        driver.findElement(viewCartButton).click();
    }


    public void addProductToCard(String productIndex) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement productDivToHover = driver.findElement(By.xpath("//a[@data-product-id='"+ productIndex +"']/parent::*/parent::*"));
        WebElement productAddToCartButton = driver.findElement(By.xpath("//div[contains(@class, 'product-overlay')]//a[@data-product-id='"+ productIndex +"']"));
        actions.moveToElement(productDivToHover).perform();
        Thread.sleep(1000);
        productAddToCartButton.click();
    }

}
