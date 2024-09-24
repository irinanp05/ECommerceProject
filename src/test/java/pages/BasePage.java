package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.BrowserFactory;
import utilities.ConfigDataProviders;
import utilities.ReadExcelFile;

import java.io.File;
import java.io.IOException;

public class BasePage {

    String fileName = System.getProperty("user.dir") + "\\TestData\\TestData.xlsx";

    public WebDriver driver;
    public ConfigDataProviders config;
    public ReadExcelFile excel;

    @BeforeSuite
    public void setUpSuite() {
        config = new ConfigDataProviders();
        excel = new ReadExcelFile();
    }

    protected LoginPage loginPage;
    protected String username = ReadExcelFile.getCellValue(fileName, "Login", 1, 0);
    protected String password = ReadExcelFile.getCellValue(fileName, "Login", 1, 1);

    @BeforeClass
    public void setup() {
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    public void captureScreenshot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);

        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File srcPath = new File("." + "//Screenshots//" + testName + ".png");

        FileUtils.copyFile(src, srcPath);
    }
}


