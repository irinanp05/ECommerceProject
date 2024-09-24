package testCases;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.SearchPage;


public class PaymentTest extends BasePage {

    @Test

    public void placeOrder() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPortal(username,password);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProduct();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.paymentFlow();
    }

}
