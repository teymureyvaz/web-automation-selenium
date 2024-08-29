package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import com.github.javafaker.Faker;
import utils.ScrollUtils;


public class VerifySubscriptionInHomePageTest extends BaseTest {

    @Test(priority = 10)
    public void testVerifySubscriptionInHomePage() {
        try {
            HomePage homePage = new HomePage(getDriver());

            Thread.sleep(2000);
            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

            Thread.sleep(2000);
            ScrollUtils.scrollToFooter(getDriver());

            Thread.sleep(2000);
            Assert.assertTrue(homePage.isSubscriptionTextVisible(), "Subscription is not visible");

            Thread.sleep(2000);
            homePage.clickYourEmailAddress();

            Thread.sleep(2000);
            Faker faker = new Faker();
            homePage.enterEmail(faker.internet().emailAddress());

            Thread.sleep(2000);
            homePage.clickArrowButton();


            Assert.assertTrue(homePage.isYouHaveBeenSuccessfullySubscribedTextVisible(), "You have been successfully subscribed!");
            Thread.sleep(2000);


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

