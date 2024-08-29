package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;


public class VerifyTestCasesPageTest extends BaseTest {

    @Test(priority = 7)
    public void testVerifyTestCasesPage() {
        try {
            HomePage homePage = new HomePage(getDriver());
            TestCasesPage testCasesPage = new TestCasesPage(getDriver());

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
            homePage.clickTestCases();

            Thread.sleep(3000);
            Assert.assertTrue(testCasesPage.isTestCasesVisible(), "Test Cases is not visible");

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
