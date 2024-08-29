package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {

    private final WebDriver driver;

    private final By productName = By.xpath("//div[@class='product-information']/h2");
    private final By productCategory = By.xpath("//div[@class='product-information']/p[contains(text(),'Category')]");
    private final By productPrice = By.xpath("//div[@class='product-information']/span/span[contains(text(),'Rs.')]");
    private final By productAvailability = By.xpath("//div[@class='product-information']/p/b[contains(text(),'Availability')]");
    private final By productCondition = By.xpath("//div[@class='product-information']/p/b[contains(text(),'Condition')]");
    private final By productBrand = By.xpath("//div[@class='product-information']/p/b[contains(text(),'Brand')]");


    private final By quantityField = By.xpath("//input[@id='quantity']");
    private final By viewCartButton = By.xpath("//a[contains(., 'View Cart')]");

    private final By addToCartButton = By.xpath("//button[contains(., 'Add to cart')]");


    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isProductNameVisible() {
        WebElement productNameField = driver.findElement(productName);
        return productNameField.isDisplayed();
    }

    public boolean isProductCategoryVisible() {
        WebElement productCategoryField = driver.findElement(productCategory);
        return productCategoryField.isDisplayed();
    }

    public boolean isProductPriceVisible() {
        WebElement productPriceField = driver.findElement(productPrice);
        return productPriceField.isDisplayed();
    }

    public boolean isProductAvailabilityVisible() {
        WebElement productAvailabilityField = driver.findElement(productAvailability);
        return productAvailabilityField.isDisplayed();
    }

    public boolean isProductConditionVisible() {
        WebElement productConditionField = driver.findElement(productCondition);
        return productConditionField.isDisplayed();
    }

    public boolean isProductBrandVisible() {
        WebElement productBrandField = driver.findElement(productBrand);
        return productBrandField.isDisplayed();
    }

    public void enterQuantity(String quantity){
        WebElement quantityFieldUpdate = driver.findElement(quantityField);
        quantityFieldUpdate.clear();
        quantityFieldUpdate.sendKeys(quantity);
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public void clickViewCartButton() {
        driver.findElement(viewCartButton).click();
    }


}

