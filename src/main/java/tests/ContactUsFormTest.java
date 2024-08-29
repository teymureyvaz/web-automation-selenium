package tests;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.ScrollUtils;

import java.io.File;


public class ContactUsFormTest extends BaseTest {

    @Test(priority = 6)
    public void testContactUsForm() {
        try {
            HomePage homePage = new HomePage(getDriver());
            ContactUsPage contactUsPage = new ContactUsPage(getDriver());

            Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
            homePage.clickContactUs();

            Thread.sleep(1000);
            Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "Get in touch is not visible");
            Thread.sleep(1000);

            contactUsPage.enterNameAndEmail("Teymur", "teymureyvazov@outlook.com");
            contactUsPage.enterSubjectAndMessage("Recommendations", "Test message");

            File file = new File("src/main/resources/test-files/test-txt-for-upload.txt");
            contactUsPage.uploadFile(file.getAbsolutePath());

            ScrollUtils.scrollTo(getDriver(),200);
            contactUsPage.clickSubmit();

            getDriver().switchTo().alert().accept();
            Thread.sleep(1000);
            Assert.assertTrue(contactUsPage.isSuccessfullySubmittedVisible(), "Successfully submitted is not visible");

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
