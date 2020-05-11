package pages.books;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressBookNewAddressPage {

    private WebDriver driver;

    @FindBy(id = "address_first_name")
    WebElement firstNameInput;

    @FindBy(id = "address_last_name")
    WebElement lastNameInput;
    @FindBy(id = "address_street_address")
    WebElement addressInput;

    @FindBy(id = "address_secondary_address")
    WebElement address2Input;

    @FindBy(id = "address_city")
    WebElement cityInput;

    @FindBy(id = "address_state")
    WebElement stateInput;

    @FindBy(id = "address_zip_code")
    WebElement zipCodeInput;

    @FindBy(id = "address_country_us")
    WebElement usRadioInput;
    //

    @FindBy(id = "address_country_canada")
    WebElement canadaRadioInput;

    @FindBy(id = "address_birthday")
    WebElement birthdayInput;

    @FindBy(name = "commit")
    WebElement submitBtn;

    public AddressBookNewAddressPage(WebDriver driver){
      this.driver = driver;
      driver.get("http://a.testaddressbook.com/addresses/new");
      PageFactory.initElements(driver, this);
    }
    public void fillFromDefault(){
        fillForm("Adam", "Kowalski", "Address", "address", "Gdansk", "Alaska", "93");
    }
    public void fillForm(String firstName, String lastName, String address,
                    String address2, String city, String state, String zipCode){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        address2Input.sendKeys(address2);
        cityInput.sendKeys(city);
        Select stateSelect = new Select(stateInput);
        stateSelect.selectByVisibleText(state);
        zipCodeInput.sendKeys(zipCode);
    }
    public void submitForm(){
        submitBtn.click();
    }

}
