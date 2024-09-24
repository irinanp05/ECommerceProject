package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    WebElement loginButton;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="pass")
    WebElement pass;

    @FindBy(id="send2")
    WebElement submitForm;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    WebElement menuButton;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    WebElement logoutButton;

    public void loginPortal(String username, String password) {
        loginButton.click();
        email.sendKeys(username);
        pass.sendKeys(password);
        submitForm.click();
    }

    public void logout() {
        menuButton.click();
        logoutButton.click();
    }
}
