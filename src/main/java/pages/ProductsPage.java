package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsPage {
    private final WebDriver driver;

    private final By productsListDiv = By.xpath("//div[@class='features_items']");
    private final By productsDiv = By.xpath("//h2[@class='title text-center']");

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

                private final By viewProductButton = By.xpath("//a[@href='/product_details/1']");

                public void clickViewProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(viewProductButton).click();
    }


}
