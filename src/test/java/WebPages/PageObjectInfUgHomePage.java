package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PageObjectInfUgHomePage {

    //Nie uzywamy FindByElement !!!
    @FindBy(how= How.XPATH ,using="//img[@src and string-length(@src)!=0]")
    private List<WebElement> images;

    private WebDriver driver;
    @FindBy(how= How.XPATH ,using="//a[@href and string-length(@href)!=0]")
    private List<WebElement> links;

    public PageObjectInfUgHomePage(WebDriver driver){
      this.driver = driver;
      driver.get("https://inf.ug.edu.pl/");
      PageFactory.initElements(driver, this);
    }
    public List<WebElement> getImages(){
        return images;
    }

    public List<WebElement> getLinks(){
        return links;
    }

    public List<WebElement> getLinksWithoutMailsAndFiles(){
        return links.stream()
                .filter(x-> !x.getAttribute("href").endsWith("xml"))
                .filter(x -> !x.getAttribute("href").startsWith("mailto")).collect(Collectors.toList());
    }
}
