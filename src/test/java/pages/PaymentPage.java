package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class PaymentPage {
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr/td[1]/input")
    WebElement shippingRadioButton;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button/span")
    WebElement nextButton;

    @FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[2]/div/div[1]/label/span")
    WebElement billingRadio;

    public void paymentFlow() {
        shippingRadioButton.click();
        nextButton.click();

        billingRadio.click();
        billingRadio.click();

        PageMethods pageMethods = new PageMethods(driver);
        pageMethods.scrollPage(0, 500);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".actions-toolbar")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-mask")));

        Actions actions = new Actions(driver);
        WebElement placeOrderButton = driver.findElement(By.cssSelector("button.action.primary.checkout"));
        actions.moveToElement(placeOrderButton).click().perform();
    }

}
