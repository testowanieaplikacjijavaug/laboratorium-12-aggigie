package WebPages.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AddressBookLoginPage {

    private WebDriver driver;

    @FindBy(id = "session_email")
    WebElement emailElement;

    @FindBy(id = "session_password")
    WebElement passwordElement;

    @FindBy(name = "commit")
    WebElement loginBtn;

    public AddressBookLoginPage(WebDriver driver){
      this.driver = driver;
      driver.get("http://a.testaddressbook.com/sign_in");
      PageFactory.initElements(driver, this);
    }

    public void defaultLogin(){
        login("email@email.com", "zaqwsx");
    }

    public void login(String login, String password){
        emailElement.sendKeys(login);
        passwordElement.sendKeys(password);
        loginBtn.click();
    }
}
