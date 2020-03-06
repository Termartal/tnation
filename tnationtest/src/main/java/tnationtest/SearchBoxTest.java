package tnationtest;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchBoxTest {
////////////////////////////////
// CONFIGURATION
///////////////////////////////
	String chromeDriverLocation = "C:\\Users\\Razer\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe";
	String firefoxDriverLocation = "";
	String ieDriverLocation = "";
	String browserType = "Chrome";
	String webURL = "http://automationpractice.com/index.php";
	String pDressUrl = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=printed+dress&submit_search=";

///////////////////////////////
	@Test
	public void searchbox() throws InterruptedException {
		WebDriver driver = null;

		if (browserType == "Chrome") {
			System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
			driver = new ChromeDriver();
		} else if (browserType == "Firefox") {

		} else if (browserType == "IE") {

		} else {
			System.out.println("Invalid browser");
		}

		// Navigating to URL and correct URL verification
		driver.get(webURL);

		String correctURL = driver.getCurrentUrl();
		assertEquals(correctURL, webURL);

		driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("printed dress");
		driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();

		String searchResultUrl = driver.getCurrentUrl();
		assertEquals(searchResultUrl, pDressUrl);

		// Sleep for 4 seconds in order for element to load
		Thread.sleep(4000);

		String searchInput = driver.findElement(By.xpath("//*[@id=\'center_column\']/h1/span[1]")).getText();
		assertEquals(searchInput.toLowerCase(), "\"printed dress\"");
		String searchResult = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[2]")).getText();
		assertTrue(searchResult.contains("results have been found."));

		driver.close();
	}
}
