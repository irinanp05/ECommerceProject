package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public static WebDriver startApplication(WebDriver driver, String browser, String URL) {

        if(browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new ChromeDriver(options);

        }

        else if(browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else if(browser.equals("IE")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        else {
            System.out.println("This browser is not supported!");
        }

        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;

    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}
