package testCases;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchTest extends BasePage {

    @Test
    public void searchProduct() {
        loginPage = new LoginPage(driver);
        loginPage.loginPortal(username, password);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProduct();
    }
}
