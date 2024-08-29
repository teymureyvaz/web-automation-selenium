package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

import utils.ScrollUtils;


public class AddProductInCartTest extends BaseTest {

    @Test(priority = 12)
    public void testAddProductInCart() {
        try {
            HomePage homePage = new HomePage(getDriver());
            ProductsPage productsPage = new ProductsPage(getDriver());
            CartPage cartPage = new CartPage(getDriver());

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

            ScrollUtils.scrollTo(getDriver(),500);

            Thread.sleep(1000);

            // adding first product
            productsPage.addProductToCard("1");
            Thread.sleep(1000);
            productsPage.clickContinueShoppingButton();

            // adding second product
            productsPage.addProductToCard("2");
            Thread.sleep(1000);
            productsPage.clickViewCartButton();

            Thread.sleep(1000);

            Assert.assertTrue(cartPage.isProductInCart("Men Tshirt"), "Men Tshirt is not in the cart");
            Assert.assertTrue(cartPage.isProductInCart("Blue Top"), "Blue Top is not in the cart");

            // verify product details for "Men Tshirt"
            String nameTshirt = cartPage.getProductName("2");
            String priceTshirt = cartPage.getProductPrice("2");
            String quantityTshirt = cartPage.getProductQuantity("2");
            String totalTshirt = cartPage.getProductTotal("2");

            Assert.assertEquals(nameTshirt, "Men Tshirt", "Men Tshirt name is incorrect");
            Assert.assertEquals(priceTshirt, "Rs. 400", "Men Tshirt price is incorrect");
            Assert.assertEquals(quantityTshirt, "1", "Men Tshirt quantity is incorrect");
            Assert.assertEquals(totalTshirt, "Rs. 400", "Men Tshirt total is incorrect");

            // verify product details for "Blue Top
            String nameTop = cartPage.getProductName("1");
            String priceTop = cartPage.getProductPrice("1");
            String quantityTop = cartPage.getProductQuantity("1");
            String totalTop = cartPage.getProductTotal("1");

            Assert.assertEquals(nameTop, "Blue Top", "Blue Top name is incorrect");
            Assert.assertEquals(priceTop, "Rs. 500", "Blue Top price is incorrect");
            Assert.assertEquals(quantityTop, "1", "Blue Top quantity is incorrect");
            Assert.assertEquals(totalTop, "Rs. 500", "Blue Top total is incorrect");


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
