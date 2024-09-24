package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "search")
    WebElement searchButton;

    @FindBy(id = "search")
    WebElement searchInput;

    @FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/caesar-warm-up-pant.html']")
    WebElement productClick;

    @FindBy(id = "option-label-size-143-item-175")
    WebElement sizeClick;

    @FindBy(id = "option-label-color-93-item-49")
    WebElement colorClick;

    @FindBy(id = "qty")
    WebElement quantityClick;

    @FindBy(id = "product-addtocart-button")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/checkout/cart/']")
    WebElement cartButton;

    @FindBy(id = "top-cart-btn-checkout")
    WebElement checkoutButton;

    public void searchProduct() {
        searchButton.click();
        searchInput.sendKeys("pants");
        searchButton.sendKeys(Keys.ENTER);

        PageMethods pageMethods = new PageMethods(driver);
        pageMethods.scrollPage(0, 350);

        productClick.click();
        sizeClick.click();
        colorClick.click();
        quantityClick.click();
        quantityClick.sendKeys(Keys.BACK_SPACE);
        quantityClick.sendKeys("2");
        addToCartButton.click();

        cartButton.click();
        checkoutButton.click();
    }
}
