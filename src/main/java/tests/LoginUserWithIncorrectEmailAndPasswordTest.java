package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;

public class LoginUserWithIncorrectEmailAndPasswordTest extends BaseTest {

    @Test(priority = 3)
    public void testLoginUserWithIncorrectEmailAndPassword() {
        try {
            HomePage homePage = new HomePage(getDriver());
            SignupPage signupPage = new SignupPage(getDriver());

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
            homePage.clickSignupLogin();

            Assert.assertTrue(signupPage.isLoginToYourAccountVisible(), "Login to your account is not visible");
            signupPage.enterEmailAndPassword("test.mail@hotmail.com", "1234567");
            signupPage.clickLogin();

            Assert.assertTrue(signupPage.isYourEmailOrPasswordIsIncorrectVisible(), "Your email or password is incorrect is not visible");

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            Assert.fail("Test failed due to NoSuchElementException: " + e.getMessage());

        } catch (TimeoutException e) {
            System.out.println("Operation timed out: " + e.getMessage());
            Assert.fail("Test failed due to TimeoutException: " + e.getMessage());

        }
    }
}
