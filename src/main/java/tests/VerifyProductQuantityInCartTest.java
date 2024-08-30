package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import utils.ScrollUtils;


public class VerifyProductQuantityInCartTest extends BaseTest {

    @Test(priority = 13)
    public void testVerifyProductQuantityInCartTest() {
        try {
            HomePage homePage = new HomePage(driver);
            ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
            CartPage cartPage = new CartPage(driver);

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
            ScrollUtils.scrollTo(driver, 600);

            homePage.clickViewProduct("2");
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://automationexercise.com/product_details/2", "Expected URL: " + "product_details/1" + " but got: " + currentUrl);

            productDetailsPage.enterQuantity("4");
            Thread.sleep(1000);

            productDetailsPage.clickAddToCartButton();
            Thread.sleep(2000);

            productDetailsPage.clickViewCartButton();
            Assert.assertTrue(cartPage.isProductInCart("Men Tshirt"), "Men Tshirt is not in the cart");

            // verify product details for "Men Tshirt"
            String nameTshirt = cartPage.getProductName("2");
            String priceTshirt = cartPage.getProductPrice("2");
            String quantityTshirt = cartPage.getProductQuantity("2");
            String totalTshirt = cartPage.getProductTotal("2");

            Assert.assertEquals(nameTshirt, "Men Tshirt", "Men Tshirt name is incorrect");
            Assert.assertEquals(priceTshirt, "Rs. 400", "Men Tshirt price is incorrect");
            Assert.assertEquals(quantityTshirt, "4", "Men Tshirt quantity is incorrect");
            Assert.assertEquals(totalTshirt, "Rs. 1600", "Men Tshirt total is incorrect");


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
