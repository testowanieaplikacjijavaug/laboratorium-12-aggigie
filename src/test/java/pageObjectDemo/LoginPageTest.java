package pageObjectDemo;

import WebPages.PageObjectInfUgHomePage;
import io.github.bonigarcia.seljup.Options;
import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.seljup.SeleniumExtension;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SeleniumExtension.class)
public class LoginPageTest {

    @Options
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    {
        firefoxOptions.setHeadless(true);
        firefoxOptions.addPreference("intl.accept_languages", "en");
    }
	@AfterEach
	public void tearDown(FirefoxDriver driver) throws Exception {
		driver.quit();
	}

	@Test
	public void getAmountOfLinks(FirefoxDriver driver){
		PageObjectInfUgHomePage infPO = new PageObjectInfUgHomePage(driver);
		List<WebElement> links = infPO.getLinks();
		System.out.println("Found " + links.size() + " links on https://inf.ug.edu.pl/");
		assertFalse(links.isEmpty());
	}

	@Test
	public void getAmountOfImages(FirefoxDriver driver){

		PageObjectInfUgHomePage infPO = new PageObjectInfUgHomePage(driver);
		List<WebElement> images = infPO.getImages();
		System.out.println("Found "+images.size()+" images on https://inf.ug.edu.pl/");
		assertFalse(images.isEmpty());
	}
	@Test
	public void getAllLinksEnterEachOfThemAndReturn(FirefoxDriver driver){
		PageObjectInfUgHomePage infPO = new PageObjectInfUgHomePage(driver);
		String startTitle = driver.getTitle();
		for (String href :
				infPO.getLinksWithoutMailsAndFiles().stream().map(x->x.getAttribute("href")).collect(Collectors.toList())) {
			driver.get(href);
			driver.navigate().back();
		}
		assertEquals(startTitle, driver.getTitle());
	}
}
