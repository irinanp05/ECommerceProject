package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utilities.ReadExcelFile;

import java.io.IOException;

public class LoginTest extends BasePage {
    String fileName = System.getProperty("user.dir") + "\\TestData\\TestData.xlsx";

    @Test(dataProvider = "loginDataProvider")

    public void verifyLogin(String username, String password) throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPortal(username,password);

        if(username.equals("admin@abc.com") && password.equals("admin123@*")) {
            System.out.println("Test passed");
            Assert.assertTrue(true);
            loginPage.logout();
        }
        else {
            captureScreenshot(driver, "verify");
            Assert.fail();
        }
    }

    @DataProvider
    public String[][] loginDataProvider() {
        int row = ReadExcelFile.getRowCount(fileName, "Login");
        int column = ReadExcelFile.getColumnCount(fileName, "Login");
        String [][] data = new String[row-1][column];

        for(int i = 1; i < row; i++) {
            for(int j = 0; j < column; j++) {
                data[i-1][j] = ReadExcelFile.getCellValue(fileName, "Login", i, j);
            }
        }
        return data;
    }


}
