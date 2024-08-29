package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private final WebDriver driver;
    private final By homePageLogo = By.xpath("//img[@alt='Website for automation practice']");
    private final By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By contactUsButton = By.xpath("//a[contains(text(),'Contact us')]");
    private final By testCasesButton = By.xpath("//a[contains(text(),'Test Cases')]");
    private final By continueShoppingButton = By.xpath("//button[contains(text(), 'Continue Shopping')]");

    private final By productsButton = By.xpath("//a[contains(text(),'Products')]");
    private final By cartButton = By.xpath("//a[contains(text(),'Cart')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageVisible() {
        WebElement logo = driver.findElement(homePageLogo);
        return logo.isDisplayed();
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginButton).click();
    }
    public void clickContactUs() {
        driver.findElement(contactUsButton).click();
    }
    public void clickTestCases() {driver.findElement(testCasesButton).click(); }
    public void clickProducts() {driver.findElement(productsButton).click(); }
    public void clickCart() {driver.findElement(cartButton).click(); }

    public void clickViewProduct(String productId) {
        driver.findElement(By.xpath("//a[@href='/product_details/"+ productId +"']")).click();
    }
    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
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


