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
    public void clickTestCases() {
        driver.findElement(testCasesButton).click();
    }

}
