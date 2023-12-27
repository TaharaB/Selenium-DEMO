import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class QACheckBoxDemo {
	private static By homedropdown = By.xpath("//button[@aria-label='Toggle']");
	private static By desktop = By.xpath("(//button[@aria-label='Toggle'])[2]");
	private static By document = By.xpath("(//button[@aria-label='Toggle'])[3]");
	private static By download = By.xpath("(//button[@aria-label='Toggle'])[4]");

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// URL launch
		driver.navigate().to("https://demoqa.com/checkbox");
		// Maximizes
		driver.manage().window().maximize();

		// verify URL
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("https://demoqa.com/checkbox"));
		System.out.println("Element URL verification: " + currentUrl);

		// scrolls down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 200)");

		// Find Home
		WebElement hdd = driver.findElement(homedropdown);
		hdd.click();
		System.out.println("Home Selected .");
		Thread.sleep(1000);

		WebElement deskFolder = driver.findElement(desktop);
		deskFolder.click();
		System.out.println("Desktop Selected .");

		WebElement doc = driver.findElement(document);
		doc.click();
		System.out.println("Document Selected .");

		WebElement down = driver.findElement(download);

		if (down.isDisplayed()) {
			down.click();
			System.out.println("Download Selected .");
		}

		Thread.sleep(1000);
		driver.quit();

	}

}
