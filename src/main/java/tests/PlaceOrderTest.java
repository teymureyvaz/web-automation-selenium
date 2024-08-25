package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.SignupPage;
import utils.ScrollUtils;

public class PlaceOrderTest extends BaseTest {

    @Test(priority = 14)
    public void testRegisterWhileCheckout() {
        try {
            HomePage homePage = new HomePage(driver);
            CartPage cartPage = new CartPage(driver);
            SignupPage signupPage = new SignupPage(driver);


            ScrollUtils.scrollTo(driver, 600);


            homePage.addProductToCard("1");
            Thread.sleep(1000);
            homePage.clickContinueShoppingButton();
            Thread.sleep(1000);
            homePage.addProductToCard("2");
            Thread.sleep(1000);
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

            Assert.assertTrue(signupPage.isLoggedInAsUserVisible(), "Logged in as user is not visible");
            Thread.sleep(1000);


            homePage.clickCart();
            cartPage.clickProceedToCheckoutButton();

            Thread.sleep(1000);

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
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
