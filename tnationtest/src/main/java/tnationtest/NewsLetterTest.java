package tnationtest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewsLetterTest {

	////////////////////////////////
	// CONFIGURATION
	///////////////////////////////
	String chromeDriverLocation = "C:\\Users\\Razer\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe";
	String firefoxDriverLocation = "";
	String ieDriverLocation = "";
	String browserType = "Chrome";
	String webURL = "http://automationpractice.com/index.php";

	///////////////////////////////
	@Test
	public void IncorrectMailTest() {
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

		driver.findElement(By.id("newsletter-input")).sendKeys("incorrect.mail.format");

		driver.findElement(By.name("submitNewsletter")).click();
		String value = driver.findElement(By.xpath("//*[@id='columns']/p")).getText();
		assertEquals(value, "Newsletter : Invalid email address.");

		driver.close();
	}

}
