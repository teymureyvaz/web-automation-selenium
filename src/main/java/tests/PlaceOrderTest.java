package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ScrollUtils;

public class PlaceOrderTest extends BaseTest {

    @Test(priority = 14)
    public void testRegisterWhileCheckout() {
        try {
            HomePage homePage = new HomePage(getDriver());
            CartPage cartPage = new CartPage(getDriver());
            SignupPage signupPage = new SignupPage(getDriver());
            CheckoutPage checkoutPage = new CheckoutPage(getDriver());
            PaymentPage paymentPage = new PaymentPage(getDriver());

            ScrollUtils.scrollTo(getDriver(), 600);


            homePage.addProductToCard("1");
            Thread.sleep(2000);
            homePage.clickContinueShoppingButton();
            Thread.sleep(1000);
            homePage.addProductToCard("2");
            Thread.sleep(2000);
            homePage.clickContinueShoppingButton();

            Thread.sleep(3000);

            ScrollUtils.scrollToTop(getDriver());
            Thread.sleep(1000);
            homePage.clickCart();

            String currentUrl = getDriver().getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://automationexercise.com/view_cart", "Expected URL: " + "view_cart" + " but got: " + currentUrl);

            cartPage.clickProceedToCheckoutButton();
            Thread.sleep(1000);
            cartPage.clickRegisterLoginButton();


            Faker faker = new Faker();
            signupPage.enterNameAndEmail("John Doe", faker.internet().emailAddress());
            signupPage.clickSignup();
            Thread.sleep(2000);
            Assert.assertTrue(signupPage.isEnterAccountInformationVisible(), "Enter Account Information is not visible");


            signupPage.enterAccountInformation("1234567", "6", "5", "1996");
            ScrollUtils.scrollTo(getDriver(),500);
            signupPage.selectNewslettersAndOffers();
            signupPage.enterAddressDetails("Teymur", "Eyvzov", "ABB", "Rixard Zorge 12a", "", "Canada", "Baku", "Baku", "1000", "994775569147");
            ScrollUtils.scrollTo(getDriver(),200);
            signupPage.clickCreateAccount();
            Assert.assertTrue(signupPage.isAccountCreatedVisible(), "Account Created text is not visible");
            Thread.sleep(2000);
            signupPage.clickContinue();
            Thread.sleep(2000);

            Assert.assertTrue(signupPage.isLoggedInAsUserVisible(), "Logged in as user is not visible");
            Thread.sleep(1000);


            homePage.clickCart();
            cartPage.clickProceedToCheckoutButton();

            Thread.sleep(1000);

            Assert.assertTrue(checkoutPage.isAddressListContains("Rixard Zorge 12a"),"Address line 1 is not present");
            Assert.assertTrue(checkoutPage.isAddressListContains("Baku Baku 1000"),"Address line 2 is not present");
            Assert.assertTrue(checkoutPage.isAddressListContains("Canada"),"Address line 2 is not present");

            ScrollUtils.scrollTo(getDriver(), 700);
            Thread.sleep(1000);
            checkoutPage.enterMessage("Test");
            ScrollUtils.scrollTo(getDriver(),400);
            checkoutPage.clickPlaceOrderButton();
            Thread.sleep(1000);

            paymentPage.enterNameOnCard("Teymur Eyvazov");
            paymentPage.enterCardNumber("1234 1234 1234 1234");
            paymentPage.enterCvc("123");
            paymentPage.enterExpiryMonth("02");
            paymentPage.enterExpiryYear("2003");
            paymentPage.clickPayAndConfirmOrderButton();

            Assert.assertTrue(paymentPage.isYourOrderHasBeenConfirmedTextVisible(), "Your order has been confirmed is visible");

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
//        @Test(priority = 15)
//        public void testRegisterBeforeCheckout () {
//            // Test implementation
//        }
//
//        @Test(priority = 16)
//        public void testLoginBeforeCheckout () {
//            // Test implementation
//        }
    }
}
