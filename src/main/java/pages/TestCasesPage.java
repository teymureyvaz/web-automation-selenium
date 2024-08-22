package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class TestCasesPage {

    private final WebDriver driver;

    private final By testCasesDiv = By.xpath("//h2[@class='title text-center']");

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTestCasesVisible(){
        WebElement testCasesDivElement = driver.findElement(testCasesDiv);
        return Objects.equals(testCasesDivElement.getText().trim(), "TEST CASES");
    }

}
