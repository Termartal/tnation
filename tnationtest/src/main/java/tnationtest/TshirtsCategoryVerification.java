package tnationtest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TshirtsCategoryVerification {

	////////////////////////////////
	// CONFIGURATION
	///////////////////////////////
	String chromeDriverLocation = "C:\\Users\\Razer\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe";
	String firefoxDriverLocation = "";
	String ieDriverLocation = "";
	String browserType = "Chrome";
	String webURL = "http://automationpractice.com/index.php";
	String tShirtUrl = "http://automationpractice.com/index.php?id_category=5&controller=category";

	///////////////////////////////
	@Test
	public void tShirtsPage() throws InterruptedException {
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

		// Navigating to T-shirts menu
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();

		correctURL = driver.getCurrentUrl();
		assertEquals(correctURL, tShirtUrl);

		// Sleep for 4 seconds in order for element to load
		Thread.sleep(4000);

		// Verification of Title and Description of category
		String description = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div/div/span")).getText();
		assertEquals(description, "T-shirts");

		String descSentence1 = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/div/div/div/p[1]"))
				.getText();

		assertEquals(descSentence1, "The must have of your wardrobe, take a look at our different colors,");

		String descSentence2 = driver.findElement(By.xpath("//*[@id=\'center_column\']/div[1]/div/div/div/p[2]"))
				.getText();

		assertEquals(descSentence2, "shapes and style of our collection!");

		driver.close();
	}

}
