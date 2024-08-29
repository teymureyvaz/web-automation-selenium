package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;



public class RegisterUserWithExistingEmailTest extends BaseTest {

    @Test(priority = 5)
    public void testRegisterWithExistingEmail() {
        try {
            HomePage homePage = new HomePage(driver);
            SignupPage signupPage = new SignupPage(driver);

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
            homePage.clickSignupLogin();
            Thread.sleep(2000);
            Assert.assertTrue(signupPage.isNewUserSignupVisible(), "New User Signup is not visible");


            signupPage.enterNameAndEmail("Test Name", "tommie.brekke@hotmail.com");
            signupPage.clickSignup();
            Assert.assertTrue(signupPage.isEmailAddressAlreadyExistVisible(), "Email address already exist is not visible");


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
