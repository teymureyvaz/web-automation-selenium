package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {

    private final WebDriver driver;
    private final By getInTouchText = By.xpath("//h2[contains(text(),'Get In Touch')]");
    private final By successfullySubmittedText = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");


    private final By nameField = By.xpath("//input[@data-qa='name']");
    private final By emailField = By.xpath("//input[@data-qa='email']");
    private final By subjectField = By.xpath("//input[@data-qa='subject']");
    private final By messageField = By.xpath("//textarea[@data-qa='message']");
    private final By fileField = By.xpath("//input[@name='upload_file']");


    private final By submitButton = By.xpath("//input[@data-qa='submit-button']");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterNameAndEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterSubjectAndMessage(String subject, String message) {
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    public void uploadFile(String path){
        driver.findElement(fileField).sendKeys(path);
    }



    public boolean isGetInTouchVisible(){
        WebElement getInTouchVisibleText = driver.findElement(getInTouchText);
        return  getInTouchVisibleText.isDisplayed();
    }

    public boolean isSuccessfullySubmittedVisible(){
        WebElement successfullySubmittedVisibleText = driver.findElement(successfullySubmittedText);
        return  successfullySubmittedVisibleText.isDisplayed();
    }

    public void clickSubmit(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(submitButton).click();
    }

}
