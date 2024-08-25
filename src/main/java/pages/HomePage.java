package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;
    private final By homePageLogo = By.xpath("//img[@alt='Website for automation practice']");
    private final By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By contactUsButton = By.xpath("//a[contains(text(),'Contact us')]");
    private final By testCasesButton = By.xpath("//a[contains(text(),'Test Cases')]");

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

    }


