package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ExtentReports extent;

    @BeforeSuite
    public void setupExtent() {
        if (extent == null) {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport_" + timeStamp + ".html");
            htmlReporter.config().setDocumentTitle("Automation Test Report");
            htmlReporter.config().setReportName("Test Report");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "localhost");
            extent.setSystemInfo("Environment", "Automation Testing");
            extent.setSystemInfo("User Name", "Your Name");
        }
    }

    @BeforeMethod
    public void setUp(ITestResult result) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.get("http://automationexercise.com");

        driver.set(webDriver);

        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

        test.get().log(Status.INFO, "Test setup completed");
    }


    protected WebDriver getDriver() {
        return driver.get();
    }

    protected ExtentTest getTest() {
        return test.get();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            getTest().log(Status.FAIL, "Test Failed: " + result.getName());
            getTest().log(Status.FAIL, "Reason: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            getTest().log(Status.PASS, "Test Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            getTest().log(Status.SKIP, "Test Skipped: " + result.getName());
        }

        if (getDriver() != null) {
            getDriver().quit();
            getTest().log(Status.INFO, "Browser closed");
            driver.remove();
        }

        test.remove();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownExtent() {
        if (extent != null) {
            extent.flush();  // Only flush the report once after all tests are completed
        }
    }
}
