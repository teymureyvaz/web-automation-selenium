package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.AdUtils;
import utils.ScrollUtils;


public class VerifyUpWithArrowAndDownFunctionalityTest extends BaseTest {

    @Test(priority = 25)
    public void testVerifyUpWithArrowAndDownFunctionality() {
        try {
            HomePage homePage = new HomePage(getDriver());

            Thread.sleep(2000);
            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

            Thread.sleep(2000);
            ScrollUtils.scrollToFooter(getDriver());

            AdUtils.detectAndHideAds(getDriver());


            Thread.sleep(2000);
            Assert.assertTrue(homePage.isSubscriptionTextVisible(), "Subscription is not visible");

            Thread.sleep(2000);
            homePage.clickUpwardArrowButton();


            Assert.assertTrue(homePage.isFullFledgedPracticeWebsiteForAutomationEngineersTextVisible(), "Full-Fledged practice website for Automation Engineers");


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


