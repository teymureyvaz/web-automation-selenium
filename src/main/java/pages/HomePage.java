package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.SeleniumHelperUtils;

public class HomePage {

    private final WebDriver driver;
    private final By homePageLogo = By.xpath("//img[@alt='Website for automation practice']");
    private final By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By contactUsButton = By.xpath("//a[contains(text(),'Contact us')]");
    private final By testCasesButton = By.xpath("//a[contains(text(),'Test Cases')]");
    private final By continueShoppingButton = By.xpath("//button[contains(text(), 'Continue Shopping')]");

    private final By productsButton = By.xpath("//a[contains(text(),'Products')]");
    private final By cartButton = By.xpath("//a[contains(text(),'Cart')]");
    private final By subscriptionText = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By viewYourEmailAddress = By.xpath("//input[@id='susbscribe_email']");
    private final By emailField = By.xpath("//input[@id='susbscribe_email']");
    private final By viewArrowButton = By.xpath("//button[@id='subscribe']");

    private final By youHaveBeenSuccessfullySubscribedText = By.xpath("//div[@class='alert-success alert' and text()='You have been successfully subscribed!']");
    private final By viewUpwardArrowButton = By.xpath("//a[@id='scrollUp']");
    private final By fullFledgedPracticeWebsiteForAutomationEngineersText = By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }


    public boolean isHomePageVisible() {
        WebElement logo = driver.findElement(homePageLogo);
        return logo.isDisplayed();
    }

    public boolean isSubscriptionTextVisible() {
        WebElement subscriptionTextVisible = driver.findElement(subscriptionText);
        return subscriptionTextVisible.isDisplayed();
    }

    public boolean isYouHaveBeenSuccessfullySubscribedTextVisible() {
        WebElement youHaveBeenSuccessfullySubscribedTextVisible = driver.findElement(youHaveBeenSuccessfullySubscribedText);
        return youHaveBeenSuccessfullySubscribedTextVisible.isDisplayed();
    }

    public boolean isFullFledgedPracticeWebsiteForAutomationEngineersTextVisible() {
        WebElement fullFledgedPracticeWebsiteForAutomationEngineersTextVisible = driver.findElement(fullFledgedPracticeWebsiteForAutomationEngineersText);
        SeleniumHelperUtils.waitForElementToBeVisible(driver, fullFledgedPracticeWebsiteForAutomationEngineersTextVisible);
        return fullFledgedPracticeWebsiteForAutomationEngineersTextVisible.isDisplayed();
    }


    public void clickSignupLogin() {
        driver.findElement(signupLoginButton).click();
    }

    public void clickContactUs() {
        driver.findElement(contactUsButton).click();
    }

    public void clickTestCases() {
        driver.findElement(testCasesButton).click();
    }

    public void clickProducts() {
        driver.findElement(productsButton).click();
    }

    public void clickCart() {
        driver.findElement(cartButton).click();
    }

    public void clickViewProduct(String productId) {
        driver.findElement(By.xpath("//a[@href='/product_details/" + productId + "']")).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickYourEmailAddress() {
        driver.findElement(viewYourEmailAddress).click();

    }

    public void clickArrowButton() {
        driver.findElement(viewArrowButton).click();
    }

    public void clickUpwardArrowButton() {
        driver.findElement(viewUpwardArrowButton).click();
    }

    public void addProductToCard(String productIndex) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement productDivToHover = driver.findElement(By.xpath("//a[@data-product-id='" + productIndex + "']/parent::*/parent::*"));
        WebElement productAddToCartButton = driver.findElement(By.xpath("//div[contains(@class, 'product-overlay')]//a[@data-product-id='" + productIndex + "']"));
        actions.moveToElement(productDivToHover).perform();
        Thread.sleep(1000);
        productAddToCartButton.click();
    }


}


