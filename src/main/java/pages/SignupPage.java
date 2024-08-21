package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SignupPage {

    private final WebDriver driver;


    private final By newUserSignupText = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private final By loginToYourAccountText = By.xpath("//h2[contains(text(),'Login to your account')]");

    private final By enterAccountInformationText = By.xpath("//h2[.='Enter Account Information']");
    private final By accountCreatedText = By.xpath("//h2[.='Account Created!']");
    private final By accountDeletedText = By.xpath("//h2[.='Account Deleted!']");
    private final By loggedInAsUserText = By.xpath("//a[normalize-space(.)='Logged in as John Doe']");
    private final By yourEmailOrPasswordIsIncorrectText = By.xpath("//p[.='Your email or password is incorrect!']");
    private final By emailAddressAlreadyExistText = By.xpath("//p[.='Email Address already exist!']");

    private final By nameField = By.xpath("//input[@name='name']");
    private final By emailField = By.xpath("//input[@data-qa='signup-email']");

    private final By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordField = By.xpath("//input[@data-qa='login-password']");

    private final By signupButton = By.xpath("//button[contains(text(),'Signup')]");
    private final By loginButton = By.xpath("//button[contains(text(),'Login')]");


    private final By continueButton = By.xpath("//a[contains(text(),'Continue')]");
    private final By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
    private final By logoutButton = By.xpath("//a[contains(text(),'Logout')]");



    private final By titleMr = By.id("id_gender1");
    private final By passwordField = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");


    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By addressField = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipcodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");


    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isNewUserSignupVisible() {
        WebElement signupText = driver.findElement(newUserSignupText);
        return signupText.isDisplayed();
    }

    public boolean isEnterAccountInformationVisible(){
        WebElement enterAccountInfoVisibleText = driver.findElement(enterAccountInformationText);
        return enterAccountInfoVisibleText.isDisplayed();
    }

    public boolean isAccountCreatedVisible(){
        WebElement accountCreatedVisibleText = driver.findElement(accountCreatedText);
        return accountCreatedVisibleText.isDisplayed();
    }

    public boolean isAccountDeletedVisible(){
        WebElement accountDeletedVisibleText = driver.findElement(accountDeletedText);
        return accountDeletedVisibleText.isDisplayed();
    }

    public boolean isLoginToYourAccountVisible(){
        WebElement loginToYourAccountVisibleText = driver.findElement(loginToYourAccountText);
        return loginToYourAccountVisibleText.isDisplayed();
    }
    public boolean isLoggedInAsUserVisible(){
        WebElement loggedInAsUserVisibleText = driver.findElement(loggedInAsUserText);
        return loggedInAsUserVisibleText.isDisplayed();
    }
    public boolean isYourEmailOrPasswordIsIncorrectVisible(){
        WebElement yourEmailOrPasswordIsIncorrectVisibleText = driver.findElement(yourEmailOrPasswordIsIncorrectText);
        return yourEmailOrPasswordIsIncorrectVisibleText.isDisplayed();
    }

    public boolean isEmailAddressAlreadyExistVisible(){
        WebElement emailAddressAlreadyExistVisibleText = driver.findElement(emailAddressAlreadyExistText);
        return emailAddressAlreadyExistVisibleText.isDisplayed();
    }



    public void enterNameAndEmail(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterEmailAndPassword(String email, String password) {
        driver.findElement(loginEmailField).sendKeys(email);
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickContinue() { driver.findElement(continueButton).click(); }
    public void clickDeleteAccount() { driver.findElement(deleteAccountButton).click(); }
    public void clickLogout() { driver.findElement(logoutButton).click(); }


    public void enterAccountInformation(String password, String day, String month, String year) {
        driver.findElement(titleMr).click();
        driver.findElement(passwordField).sendKeys(password);

        Select daySelect = new Select(driver.findElement(dayDropdown));
        daySelect.selectByValue(day);

        Select monthSelect = new Select(driver.findElement(monthDropdown));
        monthSelect.selectByValue(month);

        Select yearSelect = new Select(driver.findElement(yearDropdown));
        yearSelect.selectByValue(year);
    }

    public void selectNewslettersAndOffers() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(offersCheckbox).click();
        driver.findElement(newsletterCheckbox).click();
    }


    public void enterAddressDetails(String firstName, String lastName, String company, String address, String address2,
                                    String country, String state, String city, String zipcode, String mobileNumber) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(address2Field).sendKeys(address2);

        Select countrySelect = new Select(driver.findElement(countryDropdown));
        countrySelect.selectByVisibleText(country);

        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void clickCreateAccount()  {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(createAccountButton).click();
    }
}
