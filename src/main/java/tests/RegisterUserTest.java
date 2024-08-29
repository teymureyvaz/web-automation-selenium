package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;

import com.github.javafaker.Faker;
import utils.ScrollUtils;


public class RegisterUserTest extends BaseTest {

    @Test(priority = 1)

    public void testRegisterUser() {
        try {
            HomePage homePage = new HomePage(driver);
            SignupPage signupPage = new SignupPage(driver);

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
            homePage.clickSignupLogin();
            Thread.sleep(2000);
            Assert.assertTrue(signupPage.isNewUserSignupVisible(), "New User Signup is not visible");

            Faker faker = new Faker();
            signupPage.enterNameAndEmail("John Doe", faker.internet().emailAddress());
            signupPage.clickSignup();
            Thread.sleep(2000);
            Assert.assertTrue(signupPage.isEnterAccountInformationVisible(), "Enter Account Information is not visible");

            signupPage.enterAccountInformation("1234567", "6", "5", "1996");
            ScrollUtils.scrollTo(driver,500);
            signupPage.selectNewslettersAndOffers();
            signupPage.enterAddressDetails("Teymur", "Eyvzov", "ABB", "Rixard Zorge 12a", "", "Canada", "Baku", "Baku", "1000", "994775569147");
            ScrollUtils.scrollTo(driver,200);
            signupPage.clickCreateAccount();
            Assert.assertTrue(signupPage.isAccountCreatedVisible(), "Account Created text is not visible");
            Thread.sleep(2000);
            signupPage.clickContinue();
            Thread.sleep(2000);
            signupPage.clickDeleteAccount();
            Thread.sleep(2000);
            Assert.assertTrue(signupPage.isAccountDeletedVisible(), "Account Deleted text is not visible");

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            Assert.fail("Test failed due to NoSuchElementException: " + e.getMessage());

        } catch (TimeoutException e) {
            System.out.println("Operation timed out: " + e.getMessage());
            Assert.fail("Test failed due to TimeoutException: " + e.getMessage());

        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
            Assert.fail("Test failed due to InterruptedException: " + e.getMessage());

        }
    }
}
