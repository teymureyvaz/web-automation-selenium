package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductsPage {
    private final WebDriver driver;


    private final By productsListDiv = By.xpath("//div[@class='features_items']");
    private final By productsDiv = By.xpath("//h2[@class='title text-center']");

    private final By continueShoppingButton = By.xpath("//button[contains(text(), 'Continue Shopping')]");
    private final By viewCartButton = By.xpath("//a[contains(., 'View Cart')]");
    private final By viewSearchProductButton = By.xpath("//input[@id='search_product']");
    private final By productNameField = By.id("search_product");
    private final By viewSearchButton = By.xpath("//button[@id='submit_search']");
    private final By searchProductsText = By.xpath("//h2[contains(text(),'Searched Products')]");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterProductName(String productName) {
        driver.findElement(productNameField).sendKeys(productName);
    }


    public boolean isProductsVisible() {
        WebElement productsDivElement = driver.findElement(productsDiv);
        return productsDivElement.isDisplayed();
    }

    public boolean isProductListDivVisible() {
        WebElement productListDiv = driver.findElement(productsListDiv);
        return productListDiv.isDisplayed();
    }

    public boolean isSearchProductsVisible() {
        WebElement searchProductsVisibleText = driver.findElement(searchProductsText);
        return searchProductsVisibleText.isDisplayed();
    }


    public void clickViewProduct(String productId) {
        driver.findElement(By.xpath("//a[@href='/product_details/" + productId + "']")).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickViewCartButton() {
        driver.findElement(viewCartButton).click();
    }

    public void clickSearchProductButton() {
        driver.findElement(viewSearchProductButton).click();
    }

    public void clickSearchButton() {
        driver.findElement(viewSearchButton).click();
    }


    public void addProductToCard(String productIndex) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement productDivToHover = driver.findElement(By.xpath("//a[@data-product-id='" + productIndex + "']/parent::*/parent::*"));
        WebElement productAddToCartButton = driver.findElement(By.xpath("//div[contains(@class, 'product-overlay')]//a[@data-product-id='" + productIndex + "']"));
        actions.moveToElement(productDivToHover).perform();
        Thread.sleep(1000);
        productAddToCartButton.click();
    }

    public boolean verifySearchResult(String searchKeyword) {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));

        boolean allProductsRelatedToKeywoed = true;
        for (WebElement product : products) {
            String productText = product.getText().toLowerCase();
            if (!productText.contains(searchKeyword)) {
                allProductsRelatedToKeywoed = false;
                break;
            }
        }
        return allProductsRelatedToKeywoed;
    }


}
