package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdUtils {

    public static void detectAndHideAds(WebDriver driver) {

        List<WebElement> allInsTags = driver.findElements(By.tagName("ins"));

        if (!allInsTags.isEmpty()) {


            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(
                    "var elems = document.getElementsByTagName('ins'); " +
                            "for(var i = 0; i < elems.length; i++) { " +
                            "    elems[i].style.display = 'none'; " +
                            "}");

            System.out.println("Total Ads: " + allInsTags.size());
        } else {
            System.out.println("No <ins> tags found");
        }
    }
}

