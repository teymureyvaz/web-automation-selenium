
package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import utils.ScrollUtils;


public class VerifySubscriptionInCartPageTest extends BaseTest {

    @Test(priority = 11)
    public void testVerifySubscriptionInCartPage() {
        try {
            HomePage homePage = new HomePage(driver);
            CartPage cartPage = new CartPage(driver);

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

            homePage.clickCart();

            ScrollUtils.scrollToFooter(driver);
            Assert.assertTrue(cartPage.isSubscriptionTextVisible(), "Subscription text is not visible");

            cartPage.enterEmail("test@mail.com");
            cartPage.clickSubscribe();
            Thread.sleep(1000);

            Assert.assertTrue(cartPage.isSuccessfullySubscribedTextVisible(),"Successfully subscribed text is not visible");

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
