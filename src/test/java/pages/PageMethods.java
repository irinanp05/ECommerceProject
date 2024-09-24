package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageMethods {
    public WebDriver driver;

    public PageMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollPage(Integer x, Integer y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+", "+y+")", "");
    }
}
