package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;


public class SearchProductTest extends BaseTest {

    @Test(priority = 9)
    public void testSearchProduct() {
        try {
            HomePage homePage = new HomePage(getDriver());
            ProductsPage productsPage = new ProductsPage(getDriver());


            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
            homePage.clickProducts();

            Thread.sleep(2000);
            Assert.assertTrue(productsPage.isProductsVisible(), "All products is not visible");

            Thread.sleep(2000);
            productsPage.clickSearchProductButton();


            Thread.sleep(2000);

            String searchKeyword = "Women";
            productsPage.enterProductName(searchKeyword);


            Thread.sleep(2000);
            productsPage.clickSearchButton();


            Thread.sleep(2000);
            Assert.assertTrue(productsPage.isSearchProductsVisible(), "Searched Products is not visible");

            Thread.sleep(2000);
            productsPage.verifySearchResult(searchKeyword);
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

