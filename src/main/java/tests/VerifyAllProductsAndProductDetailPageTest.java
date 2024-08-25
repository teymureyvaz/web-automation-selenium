package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utils.ScrollUtils;
import pages.ProductDetailsPage;


public class VerifyAllProductsAndProductDetailPageTest extends BaseTest {

    @Test(priority = 8)
    public void testVerifyAllProductsAndProductDetailPage() {
        try {
            HomePage homePage = new HomePage(driver);
            ProductsPage productsPage = new ProductsPage(driver);
            ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
            homePage.clickProducts();

            Thread.sleep(3000);
            Assert.assertTrue(productsPage.isProductsVisible(), "All products is not visible");

            Assert.assertTrue(productsPage.isProductListDivVisible(), "Product list div is not visible");

            Thread.sleep(3000);

            ScrollUtils.scrollTo(driver,1000);
            productsPage.clickViewProduct("1");

            Assert.assertTrue(productDetailsPage.isProductNameVisible(), "Product list div is not visible");
            Assert.assertTrue(productDetailsPage.isProductCategoryVisible(), "Product list div is not visible");
            Assert.assertTrue(productDetailsPage.isProductPriceVisible(), "Product list div is not visible");
            Assert.assertTrue(productDetailsPage.isProductAvailabilityVisible(), "Product list div is not visible");
            Assert.assertTrue(productDetailsPage.isProductConditionVisible(), "Product list div is not visible");
            Assert.assertTrue(productDetailsPage.isProductBrandVisible(), "Product list div is not visible");

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

