package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectLoginPage {

    @FindBy(id = "error-for-username")
    private WebElement errorUsername;

    private WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement awaitingEmail;

    @FindBy(id = "password")
    private WebElement awaitingPassword;

    @FindBy(xpath = "//button[text()='Zaloguj się']")
    private WebElement login;

    public PageObjectLoginPage(WebDriver driver, String urlAddress){
        driver.get(urlAddress);
        PageFactory.initElements(driver, this);
    }

    public void loggingIn(String username, String password) {
        awaitingEmail.sendKeys(username);
        awaitingPassword.sendKeys(password);
        login.click();
    }

    public String lookForErrorMsg() {
        return errorUsername.getText();
    }
}
