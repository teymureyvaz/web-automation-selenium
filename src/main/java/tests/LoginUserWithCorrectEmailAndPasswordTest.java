package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;


public class LoginUserWithCorrectEmailAndPasswordTest extends BaseTest {

    @Test(priority = 2)
    public void testLoginUserWithCorrectEmailAndPassword() {
        try {
            HomePage homePage = new HomePage(driver);
            SignupPage signupPage = new SignupPage(driver);

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
            homePage.clickSignupLogin();

            Assert.assertTrue(signupPage.isLoginToYourAccountVisible(), "Login to your account is not visible");
            signupPage.enterEmailAndPassword("tommie.brekke@hotmail.com", "1234567");
            signupPage.clickLogin();
            Thread.sleep(2000);
            Assert.assertTrue(signupPage.isLoggedInAsUserVisible(), "Logged in as user is not visible");

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            Assert.fail("Test failed due to NoSuchElementException: " + e.getMessage());

        } catch (TimeoutException e) {
            System.out.println("Operation timed out: " + e.getMessage());
            Assert.fail("Test failed due to TimeoutException: " + e.getMessage());

        }  catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
            Assert.fail("Test failed due to InterruptedException: " + e.getMessage());

        }
    }
}
