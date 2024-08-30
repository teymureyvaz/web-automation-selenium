package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.AdUtils;
import utils.ScrollUtils;

public class PlaceOrderTest extends BaseTest {

    @Test(priority = 14)
    public void testRegisterWhileCheckout() {
        try {
            HomePage homePage = new HomePage(driver);
            CartPage cartPage = new CartPage(driver);
            SignupPage signupPage = new SignupPage(driver);
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            PaymentPage paymentPage = new PaymentPage(driver);

            ScrollUtils.scrollTo(driver, 600);


            homePage.addProductToCard("1");
            Thread.sleep(2000);
            homePage.clickContinueShoppingButton();
            Thread.sleep(1000);
            homePage.addProductToCard("2");
            Thread.sleep(2000);
            homePage.clickContinueShoppingButton();

            Thread.sleep(3000);

            ScrollUtils.scrollToTop(driver);
            Thread.sleep(1000);
            homePage.clickCart();

            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://automationexercise.com/view_cart", "Expected URL: " + "view_cart" + " but got: " + currentUrl);

            cartPage.clickProceedToCheckoutButton();
            Thread.sleep(1000);
            cartPage.clickRegisterLoginButton();


            Faker faker = new Faker();
            signupPage.enterNameAndEmail("Walter White", faker.internet().emailAddress());
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

            Assert.assertTrue(signupPage.isLoggedInAsUserVisible(), "Logged in as user is not visible");
            Thread.sleep(1000);


            homePage.clickCart();
            cartPage.clickProceedToCheckoutButton();

            Thread.sleep(1000);

            Assert.assertTrue(checkoutPage.isAddressListContains("Rixard Zorge 12a"), "Address line 1 is not present");
            Assert.assertTrue(checkoutPage.isAddressListContains("Baku Baku 1000"), "Address line 2 is not present");
            Assert.assertTrue(checkoutPage.isAddressListContains("Canada"), "Address line 2 is not present");

            ScrollUtils.scrollTo(getDriver(), 700);
            Thread.sleep(1000);
            checkoutPage.enterMessage("Test");
            ScrollUtils.scrollTo(getDriver(), 400);
            checkoutPage.clickPlaceOrderButton();
            Thread.sleep(1000);

            paymentPage.enterNameOnCard("Teymur Eyvazov");
            paymentPage.enterCardNumber("1234 1234 1234 1234");
            paymentPage.enterCvc("123");
            paymentPage.enterExpiryMonth("02");
            paymentPage.enterExpiryYear("2003");
            paymentPage.clickPayAndConfirmOrderButton();

            Assert.assertTrue(paymentPage.isYourOrderHasBeenConfirmedTextVisible(), "Your order has been confirmed is visible");

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

    @Test(priority = 15)
    public void testRegisterBeforeCheckout() {
        try {
            HomePage homePage = new HomePage(getDriver());
            CartPage cartPage = new CartPage(getDriver());
            SignupPage signupPage = new SignupPage(getDriver());
            CheckoutPage checkoutPage = new CheckoutPage(getDriver());
            PaymentPage paymentPage = new PaymentPage(getDriver());


            Thread.sleep(2000);
            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

            Thread.sleep(2000);
            homePage.clickSignupLogin();

            Thread.sleep(2000);

            Faker faker = new Faker();
            signupPage.enterNameAndEmail("John Doe", faker.internet().emailAddress());
            signupPage.clickSignup();
            Thread.sleep(2000);
            Assert.assertTrue(signupPage.isEnterAccountInformationVisible(), "Enter Account Information is not visible");


            signupPage.enterAccountInformation("1234567", "6", "5", "1996");
            ScrollUtils.scrollTo(getDriver(), 500);
            signupPage.selectNewslettersAndOffers();
            signupPage.enterAddressDetails("Teymur", "Eyvzov", "ABB", "Rixard Zorge 12a", "", "Canada", "Baku", "Baku", "1000", "994775569147");
            ScrollUtils.scrollTo(getDriver(), 200);
            signupPage.clickCreateAccount();
            Assert.assertTrue(signupPage.isAccountCreatedVisible(), "Account Created text is not visible");
            Thread.sleep(2000);
            signupPage.clickContinue();

            Assert.assertTrue(signupPage.isLoggedInAsUserVisible(), "Logged in as user is not visible");
            Thread.sleep(1000);


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

            Thread.sleep(1000);

            Assert.assertTrue(checkoutPage.isAddressListContains("Rixard Zorge 12a"), "Address line 1 is not present");
            Assert.assertTrue(checkoutPage.isAddressListContains("Baku Baku 1000"), "Address line 2 is not present");
            Assert.assertTrue(checkoutPage.isAddressListContains("Canada"), "Address line 2 is not present");

            ScrollUtils.scrollTo(driver, 700);
            Thread.sleep(1000);
            checkoutPage.enterMessage("Test");

            ScrollUtils.scrollTo(driver,400);

            checkoutPage.clickPlaceOrderButton();
            Thread.sleep(1000);

            paymentPage.enterNameOnCard("Teymur Eyvazov");
            paymentPage.enterCardNumber("1234 1234 1234 1234");
            paymentPage.enterCvc("123");
            paymentPage.enterExpiryMonth("02");
            paymentPage.enterExpiryYear("2003");

            AdUtils.detectAndHideAds(getDriver());
            paymentPage.clickPayAndConfirmOrderButton();
            Assert.assertTrue(paymentPage.isYourOrderHasBeenConfirmedTextVisible(), "Your order has been confirmed is visible");

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

    @Test(priority = 15)
    public void testLoginBeforeCheckout() {

        try {
            HomePage homePage = new HomePage(getDriver());
            CartPage cartPage = new CartPage(getDriver());
            SignupPage signupPage = new SignupPage(getDriver());
            CheckoutPage checkoutPage = new CheckoutPage(getDriver());
            PaymentPage paymentPage = new PaymentPage(getDriver());


            Thread.sleep(2000);
            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

            Thread.sleep(2000);
            homePage.clickSignupLogin();

            Assert.assertTrue(signupPage.isLoginToYourAccountVisible(), "Login to your account is not visible");
            signupPage.enterEmailAndPassword("walterwhite@gmail.com", "12345678");
            signupPage.clickLogin();
            Thread.sleep(2000);
            Assert.assertTrue(signupPage.isLoggedInAsUserVisible(), "Logged in as user is not visible");


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

            Thread.sleep(1000);

            Assert.assertTrue(checkoutPage.isAddressListContains("Baku"), "Address line 1 is not present");
            Assert.assertTrue(checkoutPage.isAddressListContains("Baku"), "Address line 2 is not present");
            Assert.assertTrue(checkoutPage.isAddressListContains("United States"), "Address line 2 is not present");

            ScrollUtils.scrollTo(getDriver(), 700);
            Thread.sleep(1000);
            checkoutPage.enterMessage("Test");
            ScrollUtils.scrollTo(getDriver(), 400);
            checkoutPage.clickPlaceOrderButton();
            Thread.sleep(1000);

            paymentPage.enterNameOnCard("Teymur Eyvazov");
            paymentPage.enterCardNumber("1234 1234 1234 1234");
            paymentPage.enterCvc("123");
            paymentPage.enterExpiryMonth("02");
            paymentPage.enterExpiryYear("2003");

            AdUtils.detectAndHideAds(getDriver());
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


    }
}
